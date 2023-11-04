package infrastructure

import (
	"context"
	"database/sql"
	config "erp/config"
	"erp/models"
	"fmt"
	"log"
	"os"

	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"go.uber.org/zap"
	"gorm.io/driver/mysql"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

type Database struct {
	RDBMS   *gorm.DB
	NoSQLDB *mongo.Database
	logger  *zap.Logger
}

func NewDatabase(config *config.Config, logger *zap.Logger) *Database {
	var err error
	var sqlDB *sql.DB

	logger.Info("Connecting to database...")
	rdbms, nosql, err := getDatabaseInstance(config)
	if err != nil {
		for i := 0; i < 5; i++ {
			rdbms, nosql, err = getDatabaseInstance(config)
			if err == nil {
				break
			}
		}
	}

	if err != nil {
		logger.Fatal("Database connection error", zap.Error(err))
	} else {
		logger.Info("Database connected")
	}

	db := &Database{rdbms, nosql, logger}

	if config.Database.Driver == "mysql" || config.Database.Driver == "postgres" {
		db.RegisterTables()

		if err != nil {
			logger.Fatal("Database connection error", zap.Error(err))
		}
		sqlDB, err = db.RDBMS.DB()
		if err != nil {
			logger.Fatal("sqlDB connection error", zap.Error(err))
		}

		sqlDB.SetMaxIdleConns(10)
		sqlDB.SetMaxOpenConns(100)
	}
	return db
}

func getDatabaseInstance(config *config.Config) (rdbms *gorm.DB, nosql *mongo.Database, err error) {
	switch config.Database.Driver {
	case "mysql":
		dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True&loc=Local",
			config.Database.Username,
			config.Database.Password,
			config.Database.Host,
			config.Database.Port,
			config.Database.Name,
		)
		rdbms, err = gorm.Open(mysql.Open(dsn), &gorm.Config{})
		if err != nil {
			return nil, nil, fmt.Errorf("failed to connect database: %w", err)
		}
	case "postgres":
		dsn := fmt.Sprintf("host=%s user=%s password=%s dbname=%s port=%d sslmode=%s TimeZone=%s",
			config.Database.Host, config.Database.Username, config.Database.Password, config.Database.Name,
			config.Database.Port, config.Database.SSLMode, config.Database.TimeZone)
		rdbms, err = gorm.Open(postgres.Open(dsn), &gorm.Config{})

		if err != nil {
			return nil, nil, fmt.Errorf("failed to connect database: %w", err)
		}

		rdbms.Exec("CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\";")

	case "mongodb":
		ctx := context.TODO()
		uri := fmt.Sprintf("mongodb://%s:%s@%s:%d", config.Database.Username, config.Database.Password, config.Database.Host, config.Database.Port)
		clientOptions := options.Client().ApplyURI(uri)
		client, err := mongo.Connect(ctx, clientOptions)
		if err != nil {
			log.Fatal(err)
		}

		err = client.Ping(ctx, nil)
		if err != nil {
			log.Fatal(err)
		}

		nosql = client.Database(config.Database.Name)
	}

	return rdbms, nosql, nil
}

func (d Database) RegisterTables() {
	err := d.RDBMS.AutoMigrate(
		models.User{},
	)

	if err != nil {
		d.logger.Fatal("Database migration error", zap.Error(err))
		os.Exit(0)
	}
	d.logger.Info("Database migration success")
}

package mongorepository

import (
	"context"
	"erp/api_errors"
	"erp/domain"
	"erp/infrastructure"
	"erp/models"
	"erp/utils"
	"errors"

	"go.mongodb.org/mongo-driver/mongo"
)

type userRepositoryImpl struct {
	*infrastructure.Database
	collection *mongo.Collection
}

func (u *userRepositoryImpl) Create(ctx context.Context, user *models.User) (res *models.User, err error) {
	_, err = u.collection.InsertOne(ctx, user)
	if err != nil {
		return nil, err
	}

	return user, nil
}

func (u *userRepositoryImpl) GetByEmail(ctx context.Context, email string) (res *models.User, err error) {
	err = u.collection.FindOne(ctx, map[string]string{"email": email}).Decode(&res)
	if err != nil {
		if utils.ErrNoRows(err) {
			return nil, errors.New(api_errors.ErrUserNotFound)
		}
		return nil, err
	}

	return res, nil
}

func (u *userRepositoryImpl) GetByID(ctx context.Context, id string) (res *models.User, err error) {
	err = u.collection.FindOne(ctx, map[string]string{"id": id}).Decode(&res)
	if err != nil {
		return nil, err
	}

	return res, nil
}

func NewMongoUserRepository(db *infrastructure.Database) domain.UserRepository {
	utils.MustHaveDb(db)
	collection := db.NoSQLDB.Collection("users")
	return &userRepositoryImpl{db, collection}
}

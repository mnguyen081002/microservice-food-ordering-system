package models

import (
	"time"

	uuid "github.com/satori/go.uuid"
	"go.mongodb.org/mongo-driver/bson/primitive"
)

type BaseModel struct {
	ID        primitive.ObjectID `json:"id" bson:"_id"`
	UUID      string             `json:"uuid" bson:"id"`
	UpdaterID uuid.UUID          `json:"updater_id"`
	CreatedAt time.Time          `gorm:"column:created_at;type:timestamp;default:now();not null" json:"created_at" bson:"created_at"`
	UpdatedAt time.Time          `gorm:"column:updated_at;type:timestamp;default:now();not null" json:"updated_at" bson:"updated_at"`
	DeletedAt time.Time          `gorm:"column:deleted_at;type:timestamp" json:"deleted_at" bson:"deleted_at"`
}

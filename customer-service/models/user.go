package models

import (
	"erp/constants"
)

type User struct {
	BaseModel `bson:",inline"`
	FirstName string         `json:"first_name" gorm:"column:first_name;type:varchar(50);not null" bson:"first_name"`
	LastName  string         `json:"last_name" gorm:"column:last_name;type:varchar(50);not null" bson:"last_name"`
	Email     string         `json:"email" gorm:"column:email;type:varchar(100);not null" bson:"email"`
	Password  string         `json:"password" gorm:"column:password;type:varchar(255);not null" bson:"password"`
	Social    string         `json:"social" bson:"social"`
	SocialID  string         `json:"social_id" bson:"social_id"`
	Role      constants.Role `json:"role" gorm:"column:role;type:varchar(50);not null" bson:"role"`
}

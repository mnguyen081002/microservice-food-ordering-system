package repository

import (
	"context"
	api_errors "erp/api_errors"
	"erp/domain"
	infrastructure "erp/infrastructure"
	models "erp/models"
	"erp/utils"

	"github.com/pkg/errors"
)

type UserRepositoryImpl struct {
	*infrastructure.Database
}

func NewUserRepository(db *infrastructure.Database) domain.UserRepository {
	utils.MustHaveDb(db)
	return &UserRepositoryImpl{db}
}

func (u *UserRepositoryImpl) Create(ctx context.Context, user *models.User) (res *models.User, err error) {
	err = u.DB.Create(&user).Error

	return user, err
}

func (u *UserRepositoryImpl) GetByID(ctx context.Context, id string) (res *models.User, err error) {
	err = u.WithContext(ctx).Where("id = ?", id).First(&res).Error
	if err != nil {
		if utils.ErrNoRows(err) {
			return res, errors.New(api_errors.ErrUserNotFound)
		}
		return nil, err
	}
	return
}

func (u *UserRepositoryImpl) GetByEmail(ctx context.Context, email string) (res *models.User, err error) {
	err = u.WithContext(ctx).Where("email = ?", email).First(&res).Error
	if err != nil {
		if utils.ErrNoRows(err) {
			return nil, errors.New(api_errors.ErrUserNotFound)
		}
		return nil, err
	}
	return
}

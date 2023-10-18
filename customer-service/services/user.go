package service

import (
	"context"
	config "erp/config"
	"erp/domain"
	models "erp/models"
)

type (
	UserServiceImpl struct {
		userRepo domain.UserRepository
		config   *config.Config
	}
)

func NewUserService(userRepo domain.UserRepository, config *config.Config) domain.UserService {
	return &UserServiceImpl{
		userRepo: userRepo,
		config:   config,
	}
}

func (s *UserServiceImpl) GetByID(ctx context.Context, id string) (user *models.User, err error) {
	user, err = s.userRepo.GetByID(ctx, id)
	return
}

func (u *UserServiceImpl) GetByEmail(ctx context.Context, email string) (*models.User, error) {
	user, err := u.userRepo.GetByEmail(ctx, email)
	return user, err
}

func (u *UserServiceImpl) Create(ctx context.Context, user *models.User) (*models.User, error) {
	user, err := u.userRepo.Create(ctx, user)
	return user, err
}

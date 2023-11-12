package controller

import (
	"erp/domain"

	"go.uber.org/zap"
)

type UserController struct {
	userService domain.UserService
	logger      *zap.Logger
}

func NewUserController(userService domain.UserService, logger *zap.Logger) *UserController {
	controller := &UserController{
		userService: userService,
		logger:      logger,
	}
	return controller
}

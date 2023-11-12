package repository

import (
	mongorepository "erp/repository/mongo"

	"go.uber.org/fx"
)

var Module = fx.Provide(
	// NewUserRepository,
	mongorepository.NewMongoUserRepository,
)

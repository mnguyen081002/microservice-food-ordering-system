package domain

import (
	"context"
	"erp/constants"
	"erp/models"

	"github.com/golang-jwt/jwt"
)

type JwtClaims struct {
	jwt.StandardClaims
	// RoleID    string              `json:"role_id"`
	TokenType string `json:"token_type"`
}

type RegisterRequest struct {
	Email    string `json:"email" binding:"required" validate:"email"`
	Password string `json:"password" binding:"required" validate:"min=6,max=20"`
}

type LoginInput struct {
	Email    string `json:"email" binding:"required" validate:"email"`
	Password string `json:"password" binding:"required" validate:"min=6,max=20"`
}

type LoginUserResult struct {
	Email string `json:"email"`
}

type LoginResult struct {
	User         *LoginUserResult `json:"user"`
	AccessToken  string           `json:"access_token"`
	RefreshToken string           `json:"refresh_token"`
}

type AuthService interface {
	Register(ctx context.Context, req RegisterRequest) (user *models.User, err error)
	Login(ctx context.Context, req LoginInput) (result *LoginResult, err error)
}

type JwtService interface {
	GenerateToken(userID string, kid string, tokenType constants.TokenType, expiresIn int64) (string, error)
	ValidateToken(token string, tokenType constants.TokenType) (*string, error)
	GenerateAuthTokens(userID string) (string, string, error)
}

package service

import (
	"bytes"
	"context"
	"encoding/json"
	"erp/api_errors"
	config "erp/config"
	"erp/domain"
	models "erp/models"
	"net/http"

	"github.com/pkg/errors"
	"golang.org/x/crypto/bcrypt"
)

type authService struct {
	userService domain.UserService
	jwtService  domain.JwtService
	config      *config.Config
}

func NewAuthService(userService domain.UserService, jwtService domain.JwtService, config *config.Config) domain.AuthService {
	return &authService{
		userService: userService,
		jwtService:  jwtService,
		config:      config,
	}
}

func (a *authService) Login(ctx context.Context, req domain.LoginInput) (result *domain.LoginResult, err error) {
	user, err := a.userService.GetByEmail(ctx, req.Email)
	if err != nil {
		return nil, err
	}

	if err := bcrypt.CompareHashAndPassword([]byte(user.Password), []byte(req.Password)); err != nil {
		return nil, errors.New(api_errors.ErrInvalidPassword)
	}

	access_token, refresh_token, err := a.jwtService.GenerateAuthTokens(user.ID.String())
	if err != nil {
		return nil, err
	}

	return &domain.LoginResult{
		User: &domain.LoginUserResult{
			Email: user.Email,
		},
		AccessToken:  access_token,
		RefreshToken: refresh_token,
	}, nil
}

func (a *authService) Register(ctx context.Context, req domain.RegisterRequest) (user *models.User, err error) {
	user, err = a.userService.GetByEmail(ctx, req.Email)
	if err != nil {
		if err.Error() != api_errors.ErrUserNotFound {
			return nil, err
		}
	}
	if user != nil {
		return nil, errors.New(api_errors.ErrEmailAlreadyExist)
	}

	encryptedPassword, err := bcrypt.GenerateFromPassword(
		[]byte(req.Password),
		bcrypt.DefaultCost,
	)
	if err != nil {
		return nil, errors.Wrap(err, "failed to encrypt password")
	}

	req.Password = string(encryptedPassword)
	user, err = a.userService.Create(ctx, &models.User{
		Email:    req.Email,
		Password: req.Password,
	})

	httpClient := http.Client{}

	body := map[string]interface{}{
		"customerId": user.ID,
		"amount":     10000.00,
	}

	bodyJson, _ := json.Marshal(body)

	bodyToSend := bytes.NewBuffer(bodyJson)

	res, err := httpClient.Post("http://payment-service/payments/add-credit-entry", "application/json", bodyToSend)
	if err != nil {
		return nil, err
	}

	defer res.Body.Close()

	return user, err
}

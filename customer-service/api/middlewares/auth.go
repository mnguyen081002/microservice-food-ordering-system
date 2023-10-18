package middlewares

import (
	"erp/api/response"
	"erp/api_errors"
	"net/http"

	"github.com/gin-gonic/gin"
)

func (e *GinMiddleware) Auth(authorization bool) gin.HandlerFunc {
	return func(c *gin.Context) {
		x_user_id := c.Request.Header.Get("x-user-id")

		if x_user_id == "" {
			c.AbortWithStatusJSON(http.StatusUnauthorized, response.ResponseError{
				Message: "Unauthorized",
				Code:    api_errors.ErrUnauthorizedAccess,
			})
			return
		}

		if !authorization {
			c.Next()
			return
		}

		c.Next()
	}
}

package utils

import (
	"context"
	"erp/api/request"
	"erp/infrastructure"
	"fmt"

	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"gorm.io/gorm"
)

func ErrNoRows(err error) bool {
	return err == gorm.ErrRecordNotFound || err == mongo.ErrNoDocuments
}

func MustHaveDb(db *infrastructure.Database) {
	if db == nil {
		panic("Database engine is null")
	}
}

type QueryPaginationBuilder[E any] struct {
	db *infrastructure.Database
}

func QueryPagination[E any](db *infrastructure.Database, o request.PageOptions, data *[]*E) *QueryPaginationBuilder[E] {
	MustHaveDb(db)
	copyDB := &infrastructure.Database{}
	*copyDB = *db
	q := &QueryPaginationBuilder[E]{
		db: copyDB,
	}
	if o.Page == 0 {
		o.Page = 1
	}
	if o.Limit == 0 {
		o.Limit = 10
	}
	offset := (o.Page - 1) * o.Limit

	q.db.RDBMS = q.db.RDBMS.Debug().Offset(int(offset)).Limit(int(o.Limit)).Find(&data)

	fmt.Println(data)
	return q
}

func (q *QueryPaginationBuilder[E]) Count(total *int64) *QueryPaginationBuilder[E] {
	q.db.RDBMS.Count(total)
	return q
}

func (q *QueryPaginationBuilder[E]) Error() error {
	return q.db.RDBMS.Error
}

type NoSQLQueryPaginationBuilder[E any] struct {
	collection *mongo.Collection
	filter     interface{}
	err        error
}

func NoSQLQueryPagination[E any](collection *mongo.Collection, filter interface{}, o request.PageOptions, data *[]*E) *NoSQLQueryPaginationBuilder[E] {
	q := &NoSQLQueryPaginationBuilder[E]{
		collection: collection,
		filter:     filter,
	}
	if o.Page == 0 {
		o.Page = 1
	}
	if o.Limit == 0 {
		o.Limit = 10
	}
	offset := (o.Page - 1) * o.Limit
	c, err := q.collection.Find(context.Background(), filter, &options.FindOptions{
		Limit: &o.Limit,
		Skip:  &offset,
	})

	if err != nil {
		q.err = err
		return q
	}

	err = c.All(context.Background(), &data)

	if err != nil {
		q.err = err
	}

	return q
}

func (q *NoSQLQueryPaginationBuilder[E]) Count(total *int64) *NoSQLQueryPaginationBuilder[E] {
	if q.err != nil {
		return q
	}
	t, err := q.collection.CountDocuments(context.Background(), q.filter, &options.CountOptions{})
	if err != nil {
		q.err = err
	}

	*total = t
	return q
}

INSERT INTO restaurant.restaurants(id, name, active)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'restaurant_1', TRUE);

INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Beef Burger', 25.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2022/12/image-18-180x180.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'BBQ Chicken', 50.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2022/12/image-29-180x180.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'Brief Barger', 20.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2023/06/Image-5.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb50', 'Bone Steak', 45.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2022/12/image-7-180x180.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb51', 'Chicken Barger', 40.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2023/06/Image-6.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb52', 'Cacciatore Pasta', 55.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2022/12/image-14-180x180.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb53', 'Italian Pasta', 55.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2022/12/image-35-180x180.png');
INSERT INTO restaurant.products(id, name, price, available, image_url)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb54', 'Hamburger', 55.00, TRUE,
        'https://themeholy.com/wordpress/pizzan/wp-content/uploads/2023/06/Image-7-180x180.png');

INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb51', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb47');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb52', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb48');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb53', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb49');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb54', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb50');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb55', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb51');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb56', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb52');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb57', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb53');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb58', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45',
        'd215b5f8-0249-4dc5-89a3-51fd148cfb54');

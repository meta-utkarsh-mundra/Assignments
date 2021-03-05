use store_front;

INSERT INTO shopper(shopper_id, shopper_name) VALUES (1, 'umesh');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (2, 'utkarsh');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (3, 'yash');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (4, 'ajay');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (5, 'sankalp');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (6, 'mayank');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (7, 'aakanksha');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (8, 'ishita');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (9, 'dipanshu');
INSERT INTO shopper(shopper_id, shopper_name) VALUES (10, 'vaishali');

select* from shopper;

INSERT INTO shipping_address(shopper_id, address) VALUES (1, 'jaipur');
INSERT INTO shipping_address(shopper_id, address) VALUES (2, 'Delhi');
INSERT INTO shipping_address(shopper_id, address) VALUES (3, 'Mumbai');
INSERT INTO shipping_address(shopper_id, address) VALUES (4, 'kolkata');
INSERT INTO shipping_address(shopper_id, address) VALUES (5, 'chennai');
INSERT INTO shipping_address(shopper_id, address) VALUES (6, 'pune');
INSERT INTO shipping_address(shopper_id, address) VALUES (7, 'ahmedabad');
INSERT INTO shipping_address(shopper_id, address) VALUES (8, 'bhopal');
INSERT INTO shipping_address(shopper_id, address) VALUES (9, 'bangalore');
INSERT INTO shipping_address(shopper_id, address) VALUES (10, 'hyderabad');

select* from shipping_address;

INSERT INTO category(name, isParent, parent, category_id) VALUES ('large', true, null, 1);
INSERT INTO category(name, isParent, parent, category_id) VALUES ('medium', true, null, 2);
INSERT INTO category(name, isParent, parent, category_id) VALUES ('small', true, null, 3);
INSERT INTO category(name, isParent, parent, category_id) VALUES ('furniture', false, 'large', 4);
INSERT INTO category(name, isParent, parent, category_id) VALUES ('electrical', false, 'medium', 5);
INSERT INTO category(name, isParent, parent, category_id) VALUES ('kitchen', false, 'medium', 6);

select* from category;

INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (1, 'sofa', 4, 10000.00, 10);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (2, 'tubelight', 5, 300.00, 30);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (3, 'dining', 1, 40000.00, 10);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (4, 'cooler', 5, 5000.00, 15);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (5, 'gas stove', 6, 2000.00, 20);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (6, 'mixer', 6, 2000.00, 10);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (7, 'tv', 5, 30000.00, 12);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (8, 'ac', 5, 35000.00, 5);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (9, 'almirah', 4, 10000.00, 10);
INSERT INTO product(product_id, name, category_id, price, quantity) VALUES (10, 'microwave', 6, 14000.00, 8);

select* from product;

INSERT INTO image(product_id, image_name) VALUES (1, 'sofa1');
INSERT INTO image(product_id, image_name) VALUES (1, 'sofa2');
INSERT INTO image(product_id, image_name) VALUES (2, 'light');
INSERT INTO image(product_id, image_name) VALUES (3, 'table');
INSERT INTO image(product_id, image_name) VALUES (4, 'cooler');
INSERT INTO image(product_id, image_name) VALUES (5, 'stove');
INSERT INTO image(product_id, image_name) VALUES (6, 'mixer');
INSERT INTO image(product_id, image_name) VALUES (7, 'television');
INSERT INTO image(product_id, image_name) VALUES (8, 'air conditioner');
INSERT INTO image(product_id, image_name) VALUES (9, 'dressing');
INSERT INTO image(product_id, image_name) VALUES (10, 'micro');

select* from image;

INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (1, 'jaipur', 1);
INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (2, 'bangalore', 9);
INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (3, 'Mumbai', 3);
INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (4, 'Delhi', 2);
INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (5, 'kolkata', 4);
INSERT INTO orders(order_id, delivery_address, shopper_id) VALUES (6, 'jaipur', 1);

select* from orders;

INSERT INTO products_in_order(order_id, product_id, status) VALUES (1, 1, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (1, 3, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (1, 5, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (2, 6, 'order placed');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (3, 4, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (3, 10, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (4, 2, 'order placed');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (4, 1, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (5, 1, 'shipped');
INSERT INTO products_in_order(order_id, product_id, status) VALUES (6, 8, 'delivered');

select* from products_in_order;
CREATE DATABASE store_front;

use store_front;
CREATE TABLE shopper (
    shopper_id INT PRIMARY KEY,
    shopper_name VARCHAR(100) NULL
);

CREATE TABLE shipping_address (
    shopper_id INT NOT NULL,
    address VARCHAR(100),
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
);

CREATE TABLE category (
    name VARCHAR(100) not null,
    isParent boolean,
    parent VARCHAR(100),
    category_id INT PRIMARY KEY
); 
  
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    name VARCHAR(50),
    category_id INT,
    price FLOAT(10, 2),
    quantity INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);     

CREATE TABLE image (
	product_id INT NOT NULL,
    image_name VARCHAR(50),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    delivery_address VARCHAR(100),
    shopper_id INT,
    time TimeStamp,
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
);    

CREATE TABLE products_in_order (
    order_id INT,
    product_id INT,
    status VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
   

show TABLES;
DROP TABLE products_in_order;
DROP TABLE image;
DROP TABLE product;
DROP TABLE category;
SHOW TABLES;

CREATE TABLE category (
    name VARCHAR(100) not null,
    isParent boolean,
    parent VARCHAR(100),
    category_id INT PRIMARY KEY
); 

CREATE TABLE product (
    product_id INT PRIMARY KEY,
    name VARCHAR(50),
    category_id INT,
    price FLOAT(10, 2),
    quantity INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);
    
CREATE TABLE image (
	product_id INT NOT NULL,
    image_name VARCHAR(50),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE products_in_order (
    order_id INT,
    product_id INT,
    status VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
SHOW TABLES;

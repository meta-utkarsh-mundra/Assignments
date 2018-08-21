use store_front;

DESCRIBE orders;
CREATE INDEX orderDate
    ON orders (order_date);
DESCRIBE orders;    
    
DESCRIBE category;
CREATE INDEX name
    on category (name);
DESCRIBE category;    

DESCRIBE product;
CREATE INDEX name
    on product (name);
DESCRIBE product;



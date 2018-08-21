use store_front;

DELIMITER //
CREATE PROCEDURE average_sales (year int, month int)
BEGIN
    SELECT sum(price) as average_sales, product_id from products_in_order pio inner join
        orders o on o.order_id = pio.order_id 
        inner join product p on p.product_id = pio.product_id
        where year(o.order_date) = year and month(o.order_date) = month
        group by pio.product_id;
END //



DELIMITER //
CREATE PROCEDURE order_details (in start_date date, in end_date date)
BEGIN
    select * from products_in_order pio inner join orders o
        on o.order_id = pio.order_id
        where date(o.order_date) between start_date and end_date;
END //


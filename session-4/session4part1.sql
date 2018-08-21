use store_front;

Delimiter $$
create function number_of_orders (month int, year int)
    Returns int
    begin
    declare total_count int;
    select count(order_id) as number_of_orders into total_count from orders o
    where month(o.order_date) = month and year(o.order_date) = year;
    return(total_count);
 END
 $$
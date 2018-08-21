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
 
  Delimiter $$
create function number_of_orders (year int)
	Returns int
    begin
    declare max_orders int;
	select count(order_id) as count, month(order_date) into max_orders from orders
		where year(order_id) = year
		group by month(order_date) order by count desc limit 1;
    return(max_orders);
END
$$    

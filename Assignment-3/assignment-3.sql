select order_id, shopper_id from orders order by order_id desc limit 3;

select p_io.order_id, sum(prod.price) from products_in_order as p_io inner join product as 
prod on p_io.product_id = prod.product_id
group by p_io.order_id
order by sum(prod.price) desc limit 3;

select s.shopper_name,  o.shopper_id from shopper as s left outer join orders as o
 on o.shopper_id = s.shopper_id where o.shopper_id is null;
 
select distinct(p_io.order_id) from products_in_order as p_io where status = 'shipped';
 
select p_io.order_id, sum(prod.price) from products_in_order as p_io inner join product as 
prod on p_io.product_id = prod.product_id
group by p_io.order_id having sum(prod.price) between 10000.00 and 20000.00
order by sum(prod.price) desc ;

update products_in_order set status = 'shipped' where order_id < 6;
use store_Front;

alter table product
	ADD column date DATE ;
    
select * from product;    

update product set date = '2018-07-19' where product_id = 1;
update product set date = '2017-07-01' where product_id = 2;
update product set date = '2018-08-19' where product_id = 3;
update product set date = '2018-08-12' where product_id = 4;
update product set date = '2018-08-02' where product_id = 5;
update product set date = '2018-06-04' where product_id = 6;
update product set date = '2018-05-30' where product_id = 7;
update product set date = '2018-08-16' where product_id = 8;
update product set date = '2017-06-10' where product_id = 8;
update product set date = '2016-09-27' where product_id = 9;
update product set date = '2016-02-05' where product_id = 10;
update product set date = '2014-10-10' where product_id = 11;
update product set date = '2015-02-15' where product_id = 12;
update product set date = '2018-07-30' where product_id = 13;

select * from product;

alter table orders
	ADD column date DATE ;

update orders set date = '2018-07-19' where order_id = 1;
update orders set date = '2017-07-01' where order_id = 2;
update orders set date = '2018-02-19' where order_id = 3;
update orders set date = '2018-04-12' where order_id = 4;
update orders set date = '2018-08-02' where order_id = 5;
update orders set date = '2018-08-04' where order_id = 6;

select * from orders;

alter table orders
	change date order_date DATE;
    
select a.*, count(b.order_id) as 'number of orders' from shopper a, orders b where a.shopper_id = b.shopper_id 
	and order_date between date_sub(date(now()), interval 280 day) and date(now()) group by shopper_id;
    
select * from products order by price desc limit 10;  

select * from product p, products_in_order pio where p.product_id = pio.product_id 
	group by pio.order_id order by price desc limit 10;
    
select s.shopper_name from products_in_order pio, product p, shopper s, orders o 
	where pio.product_id = p.product_id and s.shopper_id = o.shopper_id and o.order_id = pio.order_id
    and o.order_date between date_sub(date(now()), interval 30 day) and date(now()) 
	group by pio.order_id order by sum(p.price) desc limit 3;
    
select p.name from product p, products_in_order pio, orders o where 
	pio.product_id = p.product_id and o.order_id = pio.order_id and
	o.order_date between date_sub(date(now()), interval 60 day) and date(now())
    group by pio.product_id order by count(pio.order_id) desc limit 20;
    
select sum(p.price) from product p, products_in_order pio, orders o
	where o.order_id = pio.order_id and pio.product_id = p.product_id and
	o.order_date between date_sub(date(now()), interval 180 day) and date(now());
       
select p.name as 'Inactive Products' from product p, products_in_order pio, orders o
	where pio.product_id = p.product_id and o.order_id = pio.order_id and
    not o.order_date between date_sub(date(now()), interval 90 day) and date(now())
    group by pio.order_id;
    
select p.name from product p, category c
	where p.category_id = c.category_id and
	(c.name like 'l%' or c.parent like 'l%');
        
select p.name, pio.status from product p, products_in_order pio
	where pio.product_id = p.product_id and pio.status = 'cancelled' 
	group by pio.product_id order by count(pio.status = 'cancelled') desc limit 10;

    
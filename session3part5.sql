create view order_information AS SELECT p.product_id, p.name, p.price, s.shopper_name, pio.status, o.order_date
	from product p, shopper s, orders o, products_in_order pio
    where p.product_id = pio.product_id
    and o.order_id = pio.order_id
    and o.shopper_id = s.shopper_id; 
	
select * from order_information;    

select name from order_information where status = 'shipped'; 

select distinct(name) from order_information where status != 'cancelled';
use store_front;
select prod.product_id, prod.name, cat.name, cat.parent FROM product as prod
inner join category as cat 
on prod.category_id = cat.category_id where price > 0 order by prod.product_id desc;


select distinct (prod.name) from product as prod inner join image as im on prod.product_id = im.product_id
where im.image_name is null;

select name, parent, category_id from category;

select name, parent, category_id from category where isParent = 0;

select prod.product_id, prod.name, prod.price, prod.quantity, cat.name as category_title from product as prod 
inner join category as cat
on prod.category_id = cat.category_id where cat.name = 'kitchen';

select name from product where quantity < 50;

update product set quantity = quantity + 100;
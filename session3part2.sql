use store_front;

SELECT name, COUNT(*) AS "count"
	FROM product
	GROUP BY name having count > 1;
    
Select '0-500' as "Range" , count(name) as "Count" from product where price between 0 and 500
union
Select '500-5000' as "Range" , count(name) as "Count" from product where price between 500 and 5000
union 
Select '5000-10000' as "Range" , count(name) as "Count" from product where price between 5000.00 and 10000.00;


select a.name, a.parent, COUNT(b.name) from category a, product b where a.category_id = b.category_id group by b.category_id;
use store_front;
Create table city_code (
		zip_code INT NOT NULL,
        city VARCHAR(100) NOT NULL,
        State VARCHAR(100) NOT NULL
);
insert into city_code (zip_code, city, State) Values (312601, 'Nimbahera', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (302033, 'Jaipur', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (302018, 'Jaipur', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (312600, 'chittor', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (356701, 'Bhilwara', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (315091, 'tonk', 'Rajasthan');
insert into city_code (zip_code, city, State) Values (313554, 'bhopal', 'madhya pradesh');

select * from city_code order by State, city;


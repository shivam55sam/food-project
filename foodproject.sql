create database FoodProject;
use FoodProject;
drop database FoodProject;
CREATE TABLE customer (
    c_id INT PRIMARY KEY AUTO_INCREMENT,
    c_name VARCHAR(50) NOT NULL,
    c_email VARCHAR(50) NOT NULL,
    c_pass VARCHAR(50) NOT NULL,
    c_contact BIGINT NOT NULL,
    c_address VARCHAR(50)
    )

select*from customer;

create table food(
f_id int not null primary key auto_increment,
f_name varchar(50) not null,
f_type varchar(50) not null,
f_category varchar(50) not null,
f_price float(10,2) not null
)
select * from food;

create table admin(
a_email varchar(50) not null primary key,
a_pass varchar(50) not null 
)
select* from admin;
insert into admin

create table cart(
c_id int not null primary key auto_increment,
f_id int not null,
c_email varchar(50) not null,
f_name varchar(50) not null,
f_price float(10,2) not null,
f_quantity int not null,
t_price int not null
)
select * from cart;

create table orders(
o_id int not null primary key auto_increment,
c_email varchar(50) not null,
t_price float(10,2) not null,
date varchar(50) not null
)
select * from orders;
use flipkart;
create table customers(
id int primary key auto_increment,
mobile_number int not null,
user_name varchar (30) not null,
email varchar(50) not null,
address varchar(50) not null,
password varchar(8) not null

);

create table product_catagory(
id int primary key auto_increment,
name varchar(20) not null

);

create table products(
id int primary key auto_increment,
product_name varchar(40) not null,
catagory_id int,
created_on datetime,
updated_on datetime,
specifications varchar(100),
foreign key (catagory_id) references product_catagory(id)


);
create table orders(
id int primary key auto_increment,
product_id int not null,
customer_id int not null,
status varchar(20),
payment_mode varchar(20),
payment_status varchar(10),
created_on datetime,
updated_on datetime,
foreign key (product_id) references products (id),
foreign key (customer_id) references customers(id)
);
select * from user;
insert into user values("oaxelou", "1234", "Olympia", "Axelou", "oaxelou@uth.gr", "Garivaldi 7", "6989871538", "Female", "1997-03-26");
delete from user where username="oaxelou";

-- ---------------------------------------------------------

insert into product values(0, "blue shirt", "This is a blue shirt with grey button.", 20, 19.99, "images/product_one.png");
select * from product;

-- ---------------------------------------------------------

insert into belongsto values(0, "Shirts");
select * from belongsto;

select p.pname, b.category_name_FK 
from product as p, belongsto as b;

-- ---------------------------------------------------------

insert into category values ("Shirts");

-- ---------------------------------------------------------

drop table cart;
insert into cart(`username_FK`,`idproduct_cart_FK`,`quantity`) values("oaxelou",0,2);
select * from cart;

-- ---------------------------------------------------------

select password 
from user
where username='oax';

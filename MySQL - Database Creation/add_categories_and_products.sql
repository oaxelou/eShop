insert into category values ("Shirts");
insert into category values ("Trousers");
insert into category values ("Shoes");

select * from category;
-- ---------------------------------------------------------
select * from product;
delete from product ;

select * from belongsto;
delete from belongsto where idproduct_belongsto_FK=0;

insert into product values(0, "Red Shirt", "This is a red turtleneck shirt.", 20, 18.99, "images/womens_shirt1.png");
insert into belongsto values(0, "Shirts");

insert into product values(1, "Purple Shirt", "This is a purple one shoulder top.", 20, 10.99, "images/womens_shirt2.png");
insert into belongsto values(1, "Shirts");

insert into product values(2, "Yellow Shirt", "This is a yellow shirt with sleeves.", 20, 20, "images/womens_shirt3.png");
insert into belongsto values(2, "Shirts");

insert into product values(3, "Purple Sweater", "Long sleeve purple sweater.", 20, 25, "images/womens_shirt4.png");
insert into belongsto values(3, "Shirts");

insert into product values(4, "Baige Sweater", "Long sleeve baige sweater.", 20, 25, "images/womens_shirt5.png");
insert into belongsto values(4, "Shirts");

insert into product values(5, "Black Fancy Shirt", "Long sleeve black shirt.", 20, 24.90, "images/womens_shirt6.png");
insert into belongsto values(5, "Shirts");

insert into product values(6, "Green Shirt", "Fancy green top.", 20, 10.99, "images/womens_shirt7.png");
insert into belongsto values(6, "Shirts");

insert into product values(7, "Black Top", "Black fancy crop-top.", 20, 10.99, "images/womens_shirt8.png");
insert into belongsto values(7, "Shirts");

-- ---------------------------------------------------------


insert into belongsto values(0, "Trousers");
insert into belongsto values(0, "Shoes");
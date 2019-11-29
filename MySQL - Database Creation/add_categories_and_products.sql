insert into category values ("Shirts");
insert into category values ("Trousers");
insert into category values ("Shoes");

select * from category;
-- ---------------------------------------------------------
select * from product;
delete from product ;

-- --------------------------------
select p.pname 
from product as p, belongsto as b
where (p.idproduct = b.idproduct_belongsto_FK) and (b.category_name_FK="Shirts");

-- --------------------------------
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
insert into product values(8, "Basic Jeans", "Two buttoned jeans with belt", 20, 45, "images/womens_trousers1.png");
insert into belongsto values(8, "Trousers");

insert into product values(9, "Jeans with belt", "High waist skinny jeans with belt.", 20, 13.09, "images/womens_trousers2.png");
insert into belongsto values(9, "Trousers");

insert into product values(10, "Ripped Jeans", "High waist subtly ripped jeans.", 20, 20, "images/womens_trousers3.png");
insert into belongsto values(10, "Trousers");

insert into product values(11, "Denim Jeans", "Push up denim in color coal/grey.", 20, 25, "images/womens_trousers4.png");
insert into belongsto values(11, "Trousers");

insert into product values(12, "Cargo Pants", "Brown cargo leather-like pants.", 20, 25, "images/womens_trousers5.png");
insert into belongsto values(12, "Trousers");

insert into product values(13, "Cargo Pants", "Semi transparent sequin pants.", 20, 24.90, "images/womens_trousers6.png");
insert into belongsto values(13, "Trousers");

insert into product values(14, "Black Pants", "Black cargo pants with belt.", 20, 30, "images/womens_trousers7.png");
insert into belongsto values(14, "Trousers");

insert into product values(15, "Pink Tights", "Pink wlastic tights.", 20, 27.89, "images/womens_trousers8.png");
insert into belongsto values(15, "Trousers");

-- -----------------------------------------------------------------
insert into belongsto values(0, "Trousers");
insert into belongsto values(0, "Shoes");
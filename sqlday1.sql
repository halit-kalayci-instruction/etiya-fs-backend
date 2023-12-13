-- SQL => Structured Query Language
-- DDL - DML => 
-- Data Definition Language => Verinin tanımının başrolde olduğu komutlar => Create Table, Alter Table
-- Data Manipulation Language => Verinin içeriğinin başrolde olduğu komutlar => Select,Update,Insert

-- * => All Columns
Select * from products

-- Select [kolon(lar), *] from [tablo_ismi]
Select product_id,product_name from products

-- .... Where [filtre(ler)]
select * from products WHERE supplier_id > 5

select * from products WHERE supplier_id > 5 and category_id = 1

select * from products WHERE supplier_id > 5 or category_id = 1

select * from products WHERE (supplier_id > 5 or category_id = 1) and unit_price > 15


-- Order by [column] 
-- Default => ASC
Select * from products ORDER BY product_name -- a-z
Select * from products ORDER BY supplier_id -- küçükten büyüğe

-- ASC, DESC => Ascending,Descending
Select * from products ORDER BY product_name DESC -- z-a
Select * from products ORDER BY supplier_id DESC -- büyükten küçüğe

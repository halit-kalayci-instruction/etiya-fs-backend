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

-- .... Filtre, Sıralama
Select * from products Where units_in_stock > 20 ORDER BY product_name


-- Distinct => Veri setinde ilgili veriden yalnızca bir adet olmasını sağlar.
Select DISTINCT city from customers Order by city
Select city from customers Order by city

-- Kombinasyon olarak iki veriyi de kontrol eder.
Select DISTINCT city,region from customers order by city

-- "" => ''
Select * from customers Where city='México D.F.'

-- % => bu metinden öncesi/sonrası önemli değil

-- İçinde Mar geçen customerlar
Select * from customers Where contact_name LIKE '%rio%'
-- H ile başlayan s ile biten customerlar
Select * from customers Where contact_name LIKE 'H%s'
-- s ile biten customerlar
Select * from customers Where contact_name LIKE '%s'
-- Mart ile başlayan customerlar
Select * from customers Where contact_name LIKE 'Mart%'

-- Built-in Functions
--LOWER()
--UPPER()
--SUBSTRING()
--TRIM()
Select UPPER(company_name) from customers

-- Martin Sommer
-- MART

-- martin sommer
-- mart
Select * from customers Where LOWER(contact_name) LIKE LOWER('MART%')
-- _ => karakter sayısı önemli, karakterin içeriği önemli değil
-- li_ liu, liz
-- liza
Select * from customers Where LOWER(contact_name) LIKE LOWER('_li%') Order By contact_name

Select * from customers Where LOWER(contact_name) LIKE LOWER('__i%') Order By contact_name


-- Sum => Verilerdeki bir column'ın tüm toplamı
Select sum(unit_price) from order_details
Select sum(units_in_stock) from products
-- Count => Veri adeti
Select COUNT(*) from customers
-- Avg => Average => aritmetik ortalama
Select AVG(unit_price) from products
-- Select SUM(unit_price) / Count(unit_price) from products
-- Min
Select MIN(unit_price) from products
-- Max
Select MAX(unit_price) from products

-- Select * from products where unit_price = MAX(unit_price)

-- IN
Select * from customers Where customer_id = 'ALFKI' or customer_id = 'ANATR' or customer_id='AROUT'
Select * from customers where customer_id IN('ALFKI','ANATR','AROUT')

-- Between
Select * from products where unit_price > 10 and unit_price < 20
Select * from products where unit_price BETWEEN 10 and 20

-- JOIN
Select * from products
select * from suppliers

-- 14:00
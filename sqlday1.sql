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

-- En pahalı ürünüm hangisi?
-- İç içe sorgular - Sub Queries
Select * from products where unit_price= ( Select max(unit_price) from products ) 


-- En çok satış yaptığım ürün hangisi?


-- En kârlı satış yaptığım ürün hangisi?

--"Beverages"
-- Kullanıcının girdiği kategori ismindeki ürünler?

-- JOINLER => FK ile bağlı iki tablonun tek veri setinde toplanması.
Select * from products INNER JOIN categories on products.category_id = categories.category_id
-- alias => takma ad
Select p.supplier_id, p.category_id from products p INNER JOIN categories c on p.category_id = c.category_id

-- Hiç sipariş edilmemiş ürün?
-- products inner join order_details

-- Her ürünün sipariş miktarını bulmak
-- 80 idli ürün 0 kez sipariş edilmiştir.
Select * from products p left join order_details od on p.product_id = od.product_id where p.product_id=80

Select * from products p full outer join order_details od on p.product_id = od.product_id




Select * from products p
INNER JOIN categories c on p.category_id = c.category_id 
INNER JOIN order_details od on p.product_id=od.product_id
INNER JOIN orders o on od.order_id = o.order_id
INNER JOIN employees e on o.employee_id=e.employee_id
-- 

-- Limit X => X adet veri getirir.
Select * from products order by unit_price desc LIMIT 10


-- Group By
Select city, count(*) from customers
group by city
-- group by'da groupladığım alanları seçebilirim

-- having => Group BY'ın where'i
Select product_id,quantity, count(*) from order_details
group by product_id,quantity
HAVING product_id=19

-- 50'den fazla en fazla sipariş alan çalışanların ilk 5'i
-- Alias verirken çift tırnak!!
Select e.first_name as "Ad", e.last_name as "Soyad", count(*) as "Toplam Sipariş Sayısı" from orders o
INNER JOIN employees e on o.employee_id=e.employee_id
group by e.first_name,e.last_name
HAVING count(*) > 50
order by count(*) desc
LIMIT 5

Select * from categories where deleted_date IS NULL
-- Insert INTO => 

Insert INTO categories(category_name, description, picture) 
VALUES ('Insert deneme', 'Bu sql komutuyla eklenmiştir', NULL)

Insert INTO categories(category_name, description) 
VALUES ('Insert deneme', 'Bu sql komutuyla eklenmiştir')


-- Update,Delete => Sensitive

Update categories
SET category_name='Update Deneme 2',description='Bu sql komutuyla güncellenmiştir. 2'
Where category_id=10

-- bir koşul verilmediğinde tüm veri setini etkiler
-- Hard Delete
Delete from categories WHERE category_id=1

-- Soft Delete

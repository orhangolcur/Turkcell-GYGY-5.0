-- Alias -> Takma ad
SELECT * FROM customers c WHERE c.contact_name LIKE '%a%';


-- JOIN
SELECT * FROM orders o
INNER JOIN customers c
ON o.customer_id = c.customer_id;

SELECT * FROM orders o
RIGHT JOIN customers c
ON o.customer_id = c.customer_id;

SELECT * FROM orders o
FULL OUTER JOIN customers c
ON o.customer_id = c.customer_id;
--

INSERT INTO customers(customer_id, company_name, contact_name, contact_title, address, city, postal_code,country,phone,fax)
VALUES ('HALIT', 'Deneme', 'Halit Kalaycı', 'Abc','Abc','İstanbul','34788','Türkiye','+90', 'abc');

---
SELECT * FROM orders o
INNER JOIN employees e
ON o.employee_id = e.employee_id;
---

SELECT * FROM orders o
INNER JOIN customers c
ON o.customer_id = c.customer_id
INNER JOIN order_details od
ON o.order_id = od.order_id
INNER JOIN products p
ON od.product_id = p.product_id
WHERE od.quantity > 10
ORDER BY c.contact_name

-- GROUP BY
SELECT c.country, c.city, COUNT(*) FROM customers c
GROUP BY c.country, c.city;

SELECT c.country, c.city, COUNT(*) FROM customers c
GROUP BY c.country, c.city
ORDER BY COUNT(*) DESC
--


--
SELECT s.company_name, COUNT(*) FROM shippers s
INNER JOIN orders o
ON s.shipper_id = o.ship_via
GROUP BY s.shipper_id, s.company_name;

-- COUNT kullanımına dikkat !!
SELECT s.company_name, COUNT(o.order_id) FROM shippers s
LEFT JOIN orders o
ON s.shipper_id = o.ship_via
GROUP BY s.shipper_id, s.company_name
HAVING COUNT(o.order_id) > 250
ORDER BY COUNT(o.order_id) DESC;
--

-- Hangi müşteriler 10'dan fazla sipariş vermiş ?
SELECT c.contact_name, COUNT(*) AS total_orders FROM customers c
JOIN orders o -- INNER JOIN'i sadece JOIN ile yazabiliriz
ON o.customer_id = c.customer_id
GROUP BY c.customer_id, c.contact_name
HAVING COUNT(*) > 10 -- burada total_orders diyip karşılaştırma yapamayız. buraya dikkat !!!
ORDER BY total_orders DESC;
--


-- HW

-- Toplam cirosu 50k'dan büyük müşteriler


-- Her kategori için en az 5 farklı ürün satan kategoriler


-- Çalışan bazlı toplam satış tutarı (birim fiyat)

# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
FROM Sales s
Left join Product p
ON s.Product_id = p.Product_id
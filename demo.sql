CREATE DATABASE salespos;

USE salespos;

CREATE TABLE product (
    id INT PRIMARY KEY,
    Product_name VARCHAR(100),
    price DECIMAL(10, 2)
);

INSERT INTO product (id, Product_name, price) VALUES
(1, 'Product A', 10.00),
(2, 'Product B', 15.00);

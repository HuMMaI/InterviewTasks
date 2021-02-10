CREATE DATABASE my_shop;

USE my_shop;

CREATE TABLE suppliers(
	SupplierID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SupplierName VARCHAR(50) NOT NULL,
    City VARCHAR(30) NOT NULL,
    Country VARCHAR(10) NOT NULL
);

CREATE TABLE categories(
	CategoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(50) NOT NULL,
    Description TEXT NOT NULL
);

CREATE TABLE products(
	ProductID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(50) NOT NULL,
    SupplierID INT NOT NULL,
    CategoryID INT NOT NULL,
    Price DOUBLE NOT NULL,
    CONSTRAINT supplier_id_FK FOREIGN KEY (SupplierID) REFERENCES suppliers(SupplierID),
    CONSTRAINT category_id_FK FOREIGN KEY (CategoryID) REFERENCES categories(CategoryID)
);

INSERT INTO suppliers(SupplierName, City, Country) VALUES
	('Exotic Liquid', 'London', 'UK'),
    ('New Orleans Cajun Delights', 'New Orlean', 'USA'),
    ('Grandma Kelly\'s Homestead', 'Ann Arbor', 'USA'),
    ('Tokyo Traders', 'Tokyo', 'Japan'),
    ('Cooperativa de Quesos \'Las Cabras\'', 'Oviedo', 'Spain');
    
INSERT INTO categories(CategoryName, Description) VALUES
	('Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
    ('Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
    ('Confections', 'Desserts, candies, and sweet breads'),
    ('Dairy Products', 'Cheeses'),
    ('Grains/Cereals', 'Breads, crackers, pasta, and cereal');
    
INSERT INTO products(ProductName, SupplierID, CategoryID, Price) VALUES
	('Chais', 1, 1, 18.00),
    ('Chang', 1, 1, 19.00),
    ('Anisees Syrup', 1, 2, 10.00),
    ('Chef Anton\'s Cajun Seasoning', 2, 2, 22.00),
    ('Chef Anton\'s Gumbo Mix', 2, 2, 21.35);
    
SELECT * FROM products WHERE ProductName like 'C%';

SELECT * FROM products WHERE Price = (
	SELECT MIN(Price) FROM products
);

SELECT SUM(p.Price) as 'Sum' FROM products p
	INNER JOIN suppliers s ON p.SupplierID = s.SupplierID
WHERE s.Country = 'USA';

SELECT DISTINCT s.* FROM suppliers s
	INNER JOIN products p ON s.SupplierID = p.SupplierID
    INNER JOIN categories c ON c.CategoryID = p.CategoryID
WHERE c.CategoryName = 'Condiments';

INSERT INTO suppliers(SupplierName, City, Country) VALUES
	('Norske Meierier', 'Lviv', 'Ukraine');
INSERT INTO products(ProductName, SupplierID, CategoryID, Price) VALUES
	('Green tea', 6, 1, 10.00);
SELECT * FROM products;
SELECT * FROM suppliers;

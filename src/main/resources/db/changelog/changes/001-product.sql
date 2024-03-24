CREATE TABLE IF NOT EXISTS product_category (
  id VARCHAR(255) NOT NULL,
  category_name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
  id VARCHAR(255) NOT NULL,
  sku VARCHAR(255) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  active BOOLEAN DEFAULT TRUE, -- Using BOOLEAN instead of BIT for simplicity
  units_in_stock INT DEFAULT NULL,
  date_created TIMESTAMP DEFAULT NULL, -- Changed DATETIME to TIMESTAMP with default value
  last_updated TIMESTAMP DEFAULT NULL, -- Auto-updating timestamp
  category_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (id)
);


INSERT INTO product_category(id, category_name) VALUES ('412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', 'BOOKS');

INSERT INTO product (id, sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('18cc6962-7446-4fdd-98d8-19f12df8e7cf', 'BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript',
'assets/images/products/placeholder.png'
, true, 100, 19.99, '412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', NOW());

INSERT INTO product (id, sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('cab23490-2949-4e97-a2e9-30cb8acb6620', 'BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring',
'assets/images/products/placeholder.png'
, true, 100, 29.99, '412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', NOW());

INSERT INTO product (id, sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('cb8a4536-a073-430e-91e5-d2702cc5f7cb', 'BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes',
'assets/images/products/placeholder.png'
, true, 100, 24.99, '412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', NOW());

INSERT INTO product (id, sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('3b5eeac1-91fa-443e-8053-688312d1697d', 'BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
'assets/images/products/placeholder.png'
, true, 100, 29.99, '412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', NOW());

INSERT INTO product (id, sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('4ad5b01f-19ea-486b-803a-a3950e9d5d92', 'BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go',
'assets/images/products/placeholder.png'
, true, 100, 24.99, '412ddfa1-35eb-4dc6-89fa-9aa62ce9b990', NOW());

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
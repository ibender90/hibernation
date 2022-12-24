
CREATE TABLE IF NOT EXISTS products (id BIGSERIAL, name VARCHAR(255), PRIMARY KEY(id));
INSERT INTO products (name) VALUES ('saw');
INSERT INTO products (name) VALUES ('hammer');
INSERT INTO products (name) VALUES ('spanner');


CREATE TABLE IF NOT EXISTS customers (id BIGSERIAL, name VARCHAR(255), PRIMARY KEY(id));
INSERT INTO customers (name) VALUES ('Artjom');
INSERT INTO customers (name) VALUES ('Alex');


CREATE TABLE IF NOT EXISTS customers_products (id BIGSERIAL, customer_id (BIGSERIAL), product_id(BIGSERIAL), PRIMARY KEY(id));
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 1);
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 2);
INSERT INTO customers_products (customer_id, product_id) VALUES (2, 3);


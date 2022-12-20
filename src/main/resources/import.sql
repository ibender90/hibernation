DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id BIGSERIAL, name VARCHAR(255), PRIMARY KEY(id));
INSERT INTO products (name) VALUES ('saw');
INSERT INTO products (name) VALUES ('hammer');
INSERT INTO products (name) VALUES ('spanner');
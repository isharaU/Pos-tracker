
--  Product Table
CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

--  Store Table
CREATE TABLE store (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255)
);

--  Sale Table
CREATE TABLE sale (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    store_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NULL,
    timestamp DATETIME NOT NULL,

    CONSTRAINT fk_sale_store FOREIGN KEY (store_id) REFERENCES store(id),
    CONSTRAINT fk_sale_product FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Sales Summary Table
CREATE TABLE sales_summary (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    store_id BIGINT,
    hour DATETIME NOT NULL,
    total_sales_amount DECIMAL(10, 2) NOT NULL,
    created_at DATETIME NOT NULL,

    CONSTRAINT fk_summary_store FOREIGN KEY (store_id) REFERENCES store(id)
);

-- User Table
CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL -- ENUM-style (CASHIER, STORE_MANAGER, HEAD_OFFICE_MANAGER)
);

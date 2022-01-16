DROP TABLE if EXISTS product;
CREATE TABLE product (
	code_product BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	price float NOT NULL,
	PRIMARY KEY (code),
);

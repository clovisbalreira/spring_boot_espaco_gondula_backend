DROP TABLE if EXISTS provider;
CREATE TABLE provider (
	code_provider BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	PRIMARY KEY (code)
);

DROP TABLE if EXISTS product;
CREATE TABLE product (
	code_product BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	id_provider INT NOT NULL,
	PRIMARY KEY (code),
	FOREIGN KEY (`id_provider`) REFERENCES `provider`(`code`);
);

DROP TABLE if EXISTS marketplace;
CREATE TABLE marketplace (
	code_marketplace BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	gondola FLOAT NOT NULL,
	shelf FLOAT NOT NULL,
	PRIMARY KEY (code)
);

DROP TABLE if EXISTS contractprovider;
CREATE TABLE contractprovider (
	code_contractprovider BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	percentage FLOAT NOT NULL,
	id_provider INT NOT NULL,
	id_marketplace INT NOT NULL,
	PRIMARY KEY (code)
	FOREIGN KEY (`id_provider`) REFERENCES `provider`(`code`);
    FOREIGN KEY (`id_marketplace`) REFERENCES `marketplace`(`code`);
);

DROP TABLE if EXISTS contractproduct;
CREATE TABLE contractproduct (
	code_contractproduct BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	percentage FLOAT NOT NULL,
	id_product INT NOT NULL,
	id_contractprovider INT NOT NULL,
	PRIMARY KEY (`code`)
    FOREIGN KEY (`id_product`) REFERENCES `product`(`code`);
    FOREIGN KEY (`id_contractprovider`) REFERENCES `contractprovider`(`code`);
);










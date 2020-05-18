CREATE DATABASE  IF NOT EXISTS `Ecommerce_CRUD1` ;
USE `Ecommerce_CRUD1`;

DROP TABLE IF EXISTS `products`;


CREATE TABLE `user`(
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` varchar(12) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
)

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL ,
  `type` varchar(45) DEFAULT NULL ,
  `price` varchar(45) DEFAULT NULL ,
  `quantity` int DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `products` VALUES 
	(101,'Redmi Note 9 Pro ','Mobile Phones',15000,10),
	(102,'Realme 6 Pro','Mobile Phones',16000,15);


CREATE TABLE `orders`(
    `order_id` int(11) NOT NULL AUTO_INCREMENT,
    `order_quantity` int NOT NULL,
    `email` varchar(40) NOT NULL,
    `product_id` int NOT NULL,
    PRIMARY KEY(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (email) REFERENCES user(email)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
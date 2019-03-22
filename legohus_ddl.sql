CREATE SCHEMA IF NOT EXISTS `legohus` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_danish_ci;

USE `legohus`;

DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`(
`user_id` INT UNIQUE NOT NULL AUTO_INCREMENT, 
`password` VARCHAR(45) DEFAULT '1234',
`email` VARCHAR(45) NOT NULL,
`role` ENUM('customer','employee') NOT NULL DEFAULT 'customer',
PRIMARY KEY(`user_id`)
);
 
CREATE TABLE `Order`(
`order_id` INT UNIQUE AUTO_INCREMENT,
`user_id` INT DEFAULT NULL,
`length` INT NOT NULL,
`width` INT NOT NULL,
`height` INT NOT NULL,
`order_receive_date` DATE NOT NULL,
`order_status` ENUM ('pending','sent') DEFAULT 'pending',
`order_send_date` DATE DEFAULT NULL,
PRIMARY KEY(`order_id`),
    
	CONSTRAINT `User_fk` 
	FOREIGN KEY (`user_id`)
	REFERENCES `User` (`user_id`)
);
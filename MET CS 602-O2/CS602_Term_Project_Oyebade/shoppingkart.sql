-- Create Tables for database
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `address_street` varchar(255) NOT NULL,
  `address_city` varchar(100) NOT NULL,
  `address_state` varchar(100) NOT NULL,
  `address_zip` varchar(50) NOT NULL,
  `address_country` varchar(100) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_ids` varchar(50) NOT NULL,
  `product_ids` varchar(50) NOT NULL,
  `discount_code` varchar(50) NOT NULL,
  `discount_type` enum('Percentage','Fixed') NOT NULL,
  `discount_value` decimal(7,2) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `rrp` decimal(7,2) NOT NULL DEFAULT '0.00',
  `quantity` int(11) NOT NULL,
  `img` text NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `url_structure` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `products_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `products_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `products_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `shipping` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price_from` decimal(7,2) NOT NULL,
  `price_to` decimal(7,2) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `weight_from` decimal(7,2) NOT NULL DEFAULT '0.00',
  `weight_to` decimal(7,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `transactions` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `txn_id` varchar(255) NOT NULL,
  `payment_amount` decimal(7,2) NOT NULL,
  `payment_status` varchar(30) NOT NULL,
  `created` datetime NOT NULL,
  `payer_email` varchar(255) NOT NULL DEFAULT '',
  `first_name` varchar(100) NOT NULL DEFAULT '',
  `last_name` varchar(100) NOT NULL DEFAULT '',
  `address_street` varchar(255) NOT NULL DEFAULT '',
  `address_city` varchar(100) NOT NULL DEFAULT '',
  `address_state` varchar(100) NOT NULL DEFAULT '',
  `address_zip` varchar(50) NOT NULL DEFAULT '',
  `address_country` varchar(100) NOT NULL DEFAULT '',
  `account_id` int(11) DEFAULT NULL,
  `payment_method` varchar(50) NOT NULL DEFAULT 'website',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `transactions_items` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `txn_id` varchar(255) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_price` decimal(7,2) NOT NULL,
  `item_quantity` int(11) NOT NULL,
  `item_options` varchar(255) NOT NULL,
  `item_shipping_price` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `accounts` (`id`, `email`, `password`, `first_name`, `last_name`, `address_street`, `address_city`, `address_state`, `address_zip`, `address_country`, `admin`) VALUES
(1, 'testadmin@gmail.com', 'love2023', 'Meghan', 'Love', '98 High Street', 'New York', 'NY', '10001', 'United States', 1),
(2, 'testqueen@gmail.com', '$2y$10$pEHRAE4Ia0mE9BdLmbS.ueQsv/.WlTUSW7/cqF/T36iW.zDzSkx4y', 'John', 'Doe', '98 High Street', 'New York', 'NY', '10001', 'United States', 1),
(3, 'whitneyhouston@aol.com', 'queen@2012', 'Whitney', 'Houston', '98 High Street', 'New York', 'NY', '10001', 'United States', 1);

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Sale'),
(2, 'Jersey'),
(3, 'Accessories');

INSERT INTO `discounts` (`id`, `category_ids`, `product_ids`, `discount_code`, `discount_type`, `discount_value`, `start_date`, `end_date`) VALUES
(1, '', '', 'cs602', 'Percentage', '5.00', '2021-08-17 00:00:00', '2021-08-20 00:00:00'),
(2, '', '', 'bostonuniv', 'Percentage', '10.00', '2021-08-17 00:00:00', '2021-08-20 00:00:00');

INSERT INTO `products` (`id`, `name`, `description`, `price`, `rrp`, `quantity`, `img`, `date_added`, `url_structure`) VALUES
(1, 'Miami Heat', 'Rock the latest Miami Heat on-court looks', '110.00', '0.00', 10, 'heat_jersey_black.png', '2021-08-13 17:55:22', ''),
(2, 'Los Angeles Lakers', 'Rock the most coveted jerseys ever since legendary Lakers champion Kobe Bryant wore them early in his career', '109.00', '0.00', 20, 'lakers_jersey.png', '2021-08-14 18:52:49', ''),
(3, 'Brooklyn Nets', 'Designed to honor the life and lasting legacy of the visionary from Kings County', '105.00', '0.00', 10, 'nets_jersey.jpg', '2021-08-16 18:47:56', ''),
(4, 'Golden State Warriors', 'Wear to impress with the latest ''The Bay'' jersey', '74.99', '0.00', 25, 'warriors_jersey.jpg', '2021-08-14 17:42:04', ''),
(5, 'B-ball Socks', 'Bare Feet 2-Pack Team Quarter-Length Socks', '12.99', '21.99', 5, 'heatsocks.jpg', '2021-08-13 17:32:22', ''),
(6, 'B-ball Beanies', 'Look cool and keep your head warm', '25.00', '45.00', 5, 'wbeanies.jpg', '2021-08-16 17:46:40', '');

INSERT INTO `products_categories` (`id`, `product_id`, `category_id`) VALUES
(1, 1, 2),
(2, 2, 2),
(3, 3, 2),
(4, 4, 2),
(5, 5, 3),
(6, 5, 1),
(7, 6, 1),
(8, 6, 3);

INSERT INTO `products_images` (`id`, `product_id`, `img`) VALUES
(1, 5, 'warriorssocks.jpg'),
(2, 6, 'wbeanies.jpg'),
(3, 5, 'lakerssocks.jpg'),
(4, 5, 'heatsocks.jpg'),
(5, 6, 'heatbeanies.jpg'),
(6, 1, 'heat_jersey_black.png'),
(7, 1, 'heat_jersey_blackback.png'),
(8, 1, 'heat_jersey_vice.png'),
(9, 1, 'heat_jersey_viceback.png'),
(10, 1, 'heat_jersey_yellow.png'),
(11, 2, 'lakers_jersey_white.png'),
(12, 2, 'lakers_jersey_whiteback.png'),
(13, 2, 'lakers_jersey_yellow.png'),
(14, 2, 'lakers_jersey.png'),
(15, 3, 'nets_jersey_white.jpg'),
(16, 3, 'nets_jersey.jpg'),
(17, 4, 'warriors_jersey_white.jpg'),
(18, 4, 'warriors_jersey_yellow.jpg'),
(19, 4, 'warriors_jersey.jpg'),
(20, 2, 'lakers_jerseyback.png');

INSERT INTO `products_options` (`id`, `title`, `name`, `price`, `product_id`) VALUES
(1, 'Color', 'Red', '12.99', 5),
(2, 'Color', 'Black', '110.00', 1),
(3, 'Color', 'Black', '105.00', 3),
(4, 'Color', 'Purple', '12.99', 5),
(5, 'Color', 'White', '109.00', 2),
(6, 'Color', 'White', '105.00', 3),
(7, 'Color', 'White', '74.99', 4),
(8, 'Color', 'Blue', '12.99', 5),
(9, 'Color', 'Blue',  '74.99', 4),
(10, 'Color', 'Vice',  '110.00', 1),
(11, 'Color', 'Yellow',  '110.00', 1),
(12, 'Color', 'Yellow',  '109.00', 2),
(13, 'Color', 'Yellow',  '74.99', 4),
(14, 'Color', 'Purple', '110.00', 2),
(15, 'Color', 'White', '105.00', 3),
(16, 'Color', 'Red', '25.00', 6),
(17, 'Color', 'Blue', '25.00', 6);

INSERT INTO `shipping` (`id`, `name`, `price_from`, `price_to`, `price`, `weight_from`, `weight_to`) VALUES
(1, 'Standard', '0.00', '99999.00', '3.99', '0.00', '99999.00'),
(2, 'International', '0.00', '99999.00', '7.99', '0.00', '99999.00');

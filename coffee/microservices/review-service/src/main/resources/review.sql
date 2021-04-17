CREATE TABLE `review` (
       `id` bigint(20) NOT NULL AUTO_INCREMENT,
       `user_id` bigint(20) NOT NULL,
       `contents` varchar(255) NOT NULL,
       `product_id` bigint(20) NOT NULL,
       `rating` int(11) NOT NULL,
       `created_date` datetime(6) DEFAULT NULL,
       `updated_date` datetime(6) DEFAULT NULL,
       `version` bigint(20) NOT NULL,
       PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
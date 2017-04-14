CREATE TABLE `person` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `idCard` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
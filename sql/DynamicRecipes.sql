DROP TABLE IF EXISTS `dynamicrecipes`;
CREATE TABLE `dynamicrecipes`  (
  `id` int(250) NOT NULL,
  `count_image` text(3000) NULL DEFAULT NULL,
  `circle_image` text(3000) NULL DEFAULT NULL,
  `name` text(3000) NULL DEFAULT NULL,
  `like_count` int(250) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
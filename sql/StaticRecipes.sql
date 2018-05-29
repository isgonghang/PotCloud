DROP TABLE IF EXISTS `staticrecipes`;
CREATE TABLE `staticrecipes`  (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `like` int(11) NULL DEFAULT NULL,
  `time` varchar(30) NOT NULL,
  `image_left` text(30000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_right` text(30000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `recipesdetail`;
CREATE TABLE `recipesdetail`  (
  `recipeid` int(11) NOT NULL,
  `image` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(30) NOT NULL,
  `time` int(11) NULL DEFAULT NULL,
  `source` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `other` varchar(30) NULL DEFAULT NULL,
  `map1` integer(30) NULL DEFAULT NULL,
  `map2` float(30) NULL DEFAULT NULL,
  PRIMARY KEY (`recipeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
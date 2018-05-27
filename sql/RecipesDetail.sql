DROP TABLE IF EXISTS `recipesdetail`;
CREATE TABLE `recipesdetail`  (
  `recipeid` bigint(250)  NOT NULL,
  `image` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(300) NULL DEFAULT NULL,
  `time` int(30) NULL DEFAULT NULL,
  `source` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `other` varchar(30) NULL DEFAULT NULL,
  `map1` integer(30) NULL DEFAULT NULL,
  `map2` float(30) NULL DEFAULT NULL,
  PRIMARY KEY (`recipeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
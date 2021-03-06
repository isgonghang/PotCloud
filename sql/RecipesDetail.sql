DROP TABLE IF EXISTS `recipesdetail`;
CREATE TABLE `recipesdetail`  (
  `recipeid` bigint(250)  NOT NULL,
  `image` TEXT(65534) NULL DEFAULT NULL,
  `score` varchar(300) NULL DEFAULT NULL,
  `time` bigint(250) NULL DEFAULT NULL,
  `source` TEXT(65534) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL NULL DEFAULT NULL,
  `other` TEXT(65534) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL NULL DEFAULT NULL,
  `map` bigint(250) NULL DEFAULT NULL,
  PRIMARY KEY (`recipeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
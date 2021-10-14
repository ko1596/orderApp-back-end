# 新增資料庫
CREATE DATABASE `project_database`;

# 新增使用者，設定密碼
CREATE USER 'admin'@'localhost' IDENTIFIED BY '89022189';
GRANT ALL PRIVILEGES ON my_db.* TO 'admin'@'localhost';

#登入之後，選擇剛建立的資料庫：
use project_database;

  CREATE TABLE `general_log` (
   `event_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
                          ON UPDATE CURRENT_TIMESTAMP,
   `user_host` mediumtext NOT NULL,
   `thread_id` bigint(21) unsigned NOT NULL,
   `server_id` int(10) unsigned NOT NULL,
   `command_type` varchar(64) NOT NULL,
   `argument` mediumtext NOT NULL
  ) ENGINE=CSV DEFAULT CHARSET=utf8 COMMENT='General log';
  
show variables like '%general%';
SET GLOBAL log_output = 'FILE';
SET GLOBAL general_log = 'ON';
SET global general_log = 1;
SET global log_output = 'table';

SELECT * FROM mysql.general_log;

CREATE TABLE `project_database`.`member` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Birthday` DATE NOT NULL,
  `Phone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (idMember)
  );
  
CREATE TABLE `project_database`.`Seller` (
  `idMember` INT NOT NULL ,
  `Sellerid` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (Sellerid),
  FOREIGN KEY (idMember) REFERENCES member(idMember)
  );

INSERT INTO `project_database`.`Seller`
(`idMember`
)
VALUES
(1
);

CREATE TABLE `project_database`.`Coupon` (
  `idCoupon` INT NOT NULL AUTO_INCREMENT, 
  `Description` VARCHAR(45) NOT NULL,
  `dataline`  DATE NOT NULL,
  `Discount` INT NOT NULL ,
  PRIMARY KEY (idCoupon)
  );  

Select Sellerid from `project_database`.`Seller` where idMember=3;
SELECT * FROM seller;


INSERT INTO `project_database`.`Coupon`
(`Description`,
`dataline`,
`Discount`
)
VALUES
(
"抵用卷",
"2021-10-31",
200
);
  
CREATE TABLE `project_database`.`shop_cart` (
  `UserID` INT NOT NULL,
  `Date` DATE NOT NULL,
  PRIMARY KEY (UserID),
  FOREIGN KEY (UserID) REFERENCES member(idMember)
);

INSERT INTO `project_database`.`shop_cart`
(`UserID`,
`Date`,
`MemberType`
)
VALUES
(3,
"2000-02-21",
"B"
);




  
  
  
  





ALTER TABLE member AUTO_INCREMENT=100000;


# 查詢資料

SELECT * FROM member;
SELECT * FROM Seller;

INSERT INTO `project_database`.`member`
(`Name`,
`password`,
`Birthday`,
`Phone`,
`Email`
)
VALUES
("user_name",
"1234",
"2000-02-21",
"09-12345678",
"T10759003@gmail.com"
);

CREATE TABLE `project_database`.`Shop_order` (
  `ID` INT NOT NULL,
  `Product amount` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));
  
SELECT * FROM Shop_order;
  
INSERT INTO `project_database`.`Shop_order`
(`ID`,`Product amount`,`Status`)
VALUES
(03,12,"VERY GOOD");
  
  CREATE TABLE `project_database`.`history` (
  `Order_Id` INT NOT NULL,
  PRIMARY KEY (`Order_Id`));
  
  
SELECT * FROM history;
  
INSERT INTO `project_database`.`history`
(`Order_Id`)
VALUES
(03);
  
  CREATE TABLE `project_database`.`card` (
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`User_ID`));
  
  CREATE TABLE `project_database`.`product` (
  `ProductID` INT NOT NULL AUTO_INCREMENT,
  `Sellerid` INT NOT NULL,
  `Price` INT NOT NULL,
  `Name` VARCHAR(30) NOT NULL,
  `Photo`  varchar(500) DEFAULT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `Tag` VARCHAR(45) NULL,
  PRIMARY KEY (`ProductID`),
  FOREIGN KEY (Sellerid) REFERENCES seller(Sellerid)
  );
  
SELECT * FROM product;
  
INSERT INTO `project_database`.`product`
(`Sellerid` ,`Price` , `Name` ,`Photo` ,`Description` ,`Status` ,`Tag`)
VALUES
(4 , 50 , "kenny" , NULL , "so good" , "li" , "like this" );
  
  CREATE TABLE `project_database`.`comment` (
  `commentID` INT NOT NULL,
  `ProductID` INT NOT NULL,
  `Rate` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`commentID`),
  FOREIGN KEY (ProductID) REFERENCES product(ProductID) );

SELECT * FROM comment;
  
INSERT INTO `project_database`.`comment`
(`commentID`, `ProductID` ,`Rate` , `Description`)
VALUES
(01 , 2 , 50 , "very good" );

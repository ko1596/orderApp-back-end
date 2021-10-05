# 新增資料庫
CREATE DATABASE `project_database`;

# 新增使用者，設定密碼
CREATE USER 'admin'@'localhost' IDENTIFIED BY '89022189';
GRANT ALL PRIVILEGES ON my_db.* TO 'admin'@'localhost';

#登入之後，選擇剛建立的資料庫：
use project_database;

CREATE TABLE `project_database`.`member` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `MemberType` VARCHAR(11) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Birthday` DATE NOT NULL,
  `Phone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (idMember , MemberType),
  CHECK(MemberType IN("S" , "B" , "A" ))
  );
  
CREATE TABLE `project_database`.`Seller` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `MemberType` CHAR(1) NOT NULL,
  PRIMARY KEY (idMember , MemberType),
  CHECK(MemberType = 'S' ),
  FOREIGN KEY (idMember , MemberType) REFERENCES member(idMember , MemberType)
  );  

CREATE TABLE `project_database`.`Buyer` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `MemberType` CHAR(1) NOT NULL,
  PRIMARY KEY (idMember , MemberType),
  CHECK(MemberType = 'B' ),
  FOREIGN KEY (idMember , MemberType) REFERENCES member(idMember , MemberType)
  );
  
CREATE TABLE `project_database`.`Administrator` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `MemberType` CHAR(1) NOT NULL,
  PRIMARY KEY (idMember , MemberType),
  CHECK(MemberType = 'A' ),
  FOREIGN KEY (idMember , MemberType) REFERENCES member(idMember , MemberType)
  );  
  
CREATE TABLE `project_database`.`Coupon` (
  `idCoupon` INT NOT NULL AUTO_INCREMENT, 
  `Description` VARCHAR(45) NOT NULL,
  `dataline`  DATE NOT NULL,
  `Discount` INT NOT NULL ,
  PRIMARY KEY (idCoupon)
  );  
  
SELECT * FROM Coupon;

INSERT INTO `project_database`.`Coupon`
(`idCoupon`,
`Description`,
`dataline`,
`Discount`
)
VALUES
(0003,
"抵用卷",
"2021-10-31",
200
);
  

  
  
  
  





ALTER TABLE member AUTO_INCREMENT=100000;


# 查詢資料

SELECT * FROM member;
SELECT * FROM Buyer;

INSERT INTO `project_database`.`member`
(`idMember`,
`MemberType`,
`Name`,
`password`,
`Birthday`,
`Phone`,
`Email`
)
VALUES
(0003,
"B",
"user_name",
"1234",
"2000-02-21",
"09-12345678",
"T107590033"
);

INSERT INTO `project_database`.`Buyer`
(`idMember`,
 `MemberType`
)
VALUES
(0003,
"S"
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
  `ProductID` INT NOT NULL,
  `Price` INT NOT NULL,
  `Name` VARCHAR(30) NOT NULL,
  `Photo` BLOB NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `Tag` VARCHAR(45) NULL,
  PRIMARY KEY (`ProductID`));
  
SELECT * FROM product;
  
INSERT INTO `project_database`.`product`
(`ProductID`, `Price` , `Name` ,`Photo` ,`Description` ,`Status` ,`Tag`)
VALUES
(03 , 50 , "kenny" , NULL , "so good" , "li" , "like this" );
  
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

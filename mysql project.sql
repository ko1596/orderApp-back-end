# 新增資料庫
CREATE DATABASE `project_database`;

# 新增使用者，設定密碼
CREATE USER 'admin'@'localhost' IDENTIFIED BY '89022189';
GRANT ALL PRIVILEGES ON my_db.* TO 'admin'@'localhost';

#登入之後，選擇剛建立的資料庫：
use project_database;

CREATE TABLE `project_database`.`member` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Birthday` DATE NOT NULL,
  `Phone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`idMember`));

ALTER TABLE member AUTO_INCREMENT=100000;

SELECT email FROM MEMBER
WHERE email 
REGEXP '^[a-zA-Z0-9][a-zA-Z0-9._+-]*[a-zA-Z0-9_-]@[a-zA-Z0-9][a-zA-Z0-9._-]*[a-zA-Z0-9]+..[a-zA-Z]{2,4}$';

# 查詢資料

SELECT * FROM member;

INSERT INTO `project_database`.`member`
(`idMember`,
`Name`,
`password`,
`Birthday`,
`Phone`,
`Email`)
VALUES
(0003,
"user_name",
"1234",
"2000-02-21",
"09-12345678",
"T107590033");

CREATE TABLE `project_database`.`Shop_order` (
  `ID` INT NOT NULL,
  `Product amount` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));
  
SELECT * FROM Shop_order;
  
INSERT INTO `project_database`.`Shop_order`
(`ID`,`Product amount`,`Status`)
VALUES
(02,12,"VERY GOOD");
  
  CREATE TABLE `project_database`.`history` (
  `Order_Id` INT NOT NULL,
  PRIMARY KEY (`Order_Id`));
  
  CREATE TABLE `project_database`.`card` (
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`User_ID`));
  
  CREATE TABLE `project_database`.`product` (
  `ID` INT NOT NULL,
  `Price` INT NOT NULL,
  `Name` VARCHAR(30) NOT NULL,
  `Photo` BLOB NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `Tag` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
  
  CREATE TABLE `project_database`.`comment` (
  `ID` INT NOT NULL,
  `Rate` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  FOREIGN KEY (ID) REFERENCES product(ID) );


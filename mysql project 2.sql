CREATE DATABASE `project_database`;
CREATE USER 'admin'@'localhost' IDENTIFIED BY '89022189';
GRANT ALL PRIVILEGES ON my_db.* TO 'admin'@'localhost';
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
  
  CREATE TABLE `project_database`.`coupon` (
  `idcoupon` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `is_enabled` INT NOT NULL,
  `percent` INT NOT NULL,
  `due_date` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcoupon`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE);

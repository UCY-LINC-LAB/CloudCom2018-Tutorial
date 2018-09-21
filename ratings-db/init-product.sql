CREATE DATABASE ratings;
USE ratings;

CREATE TABLE `ratings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bookid` INT,
  `rating` INT,
  PRIMARY KEY (`id`)
);

INSERT INTO ratings (bookid, rating) VALUES (1 , 5);
INSERT INTO ratings (bookid, rating) VALUES (2 , 4);
INSERT INTO ratings (bookid, rating) VALUES (3 , 3);
INSERT INTO ratings (bookid, rating) VALUES (4 , 5);

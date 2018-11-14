CREATE DATABASE products;
USE products;

CREATE TABLE `products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR (500),
  `description` VARCHAR (500),
  `image` VARCHAR (500),
  PRIMARY KEY (`id`)
);

INSERT INTO products (title, description, image) VALUES ('The Comedy of Errors', '<a href="https://en.wikipedia.org/wiki/The_Comedy_of_Errors">Wikipedia Summary</a>: The Comedy of Errors is one of early plays. It is his shortest and one of his most farcical comedies, with a major part of the humour coming from slapstick and mistaken identity, in addition to puns and word play.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Robson_Crane_Comedy_of_Errors.jpg/250px-Robson_Crane_Comedy_of_Errors.jpg');
INSERT INTO products (title, description, image) VALUES ('Romeo and Juliet', '<a href="https://en.wikipedia.org/wiki/Romeo_and_Juliet">Wikipedia Summary</a>: Romeo and Juliet belongs to a tradition of tragic romances stretching back to antiquity.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Romeo_and_juliet_brown.jpg/220px-Romeo_and_juliet_brown.jpg');
INSERT INTO products (title, description, image) VALUES ('Otello', '<a href="https://en.wikipedia.org/wiki/Otello">Wikipedia Summary</a>: Otello  is an opera in four acts by Giuseppe Verdi to an Italian libretto by Arrigo Boito.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Otello-Alexandre-Marie_Colin_1829.jpg/220px-Otello-Alexandre-Marie_Colin_1829.jpg');
INSERT INTO products (title, description, image) VALUES ('Hamlet', '<a href="https://en.wikipedia.org/wiki/Hamlet">Wikipedia Summary</a>: The Tragedy of Hamlet, Prince of Denmark, often shortened to Hamlet, is a tragedy written by William Shakespeare at an uncertain date between 1599 and 1602', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Edwin_Booth_Hamlet_1870.jpg/220px-Edwin_Booth_Hamlet_1870.jpg');


CREATE DATABASE reviews;
USE reviews;

CREATE TABLE `reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bookid` INT,
  `review` VARCHAR (500),
  PRIMARY KEY (`id`)
);

INSERT INTO reviews (bookid, review) VALUES (1 , 'Very Good Book');
INSERT INTO reviews (bookid, review) VALUES (1 , 'I will read it again!');
INSERT INTO reviews (bookid, review) VALUES (1 , 'Not worth it.');
INSERT INTO reviews (bookid, review) VALUES (2 , 'This book is not for me');
INSERT INTO reviews (bookid, review) VALUES (3 , 'Hello Otello!');
INSERT INTO reviews (bookid, review) VALUES (3 , 'Bye Otello!');
INSERT INTO reviews (bookid, review) VALUES (4 , 'Thumbs up for this book');

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

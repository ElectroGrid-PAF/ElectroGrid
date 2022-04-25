CREATE DATABASE payment;
USE payment;

DROP TABLE IF EXISTS payment;
CREATE TABLE payment(
id INT NOT NULL AUTO_INCREMENT,
pid VARCHAR(45) NOT NULL,
acc VARCHAR(45) NOT NULL,
unit INT NOT NULL,
price INT NOT NULL,


PRIMARY KEY (id)
);


insert into payment(pid,acc,unit,price) values("p343","re453454",400,45000);

insert into payment(pid,acc,unit,price) values("p5667","re7566",456,76747);

insert into payment(pid,acc,unit,price) values("p5654","re76867",700,155678);

insert into payment(pid,acc,unit,price) values("p8566","re5878",354,25556);

insert into payment(pid,acc,unit,price) values("p8786","ryt6767",434,54563);

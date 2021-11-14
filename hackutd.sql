create database hackutd_nebula;

create table user (
	user_id int not null primary key,
    name text
);

create table login (
	user_id int not null primary key,
    password text
);

CREATE TABLE subjects (
    sub_id VARCHAR(10) NOT NULL,
    sub_name TEXT NOT NULL,
    prof_name TEXT NOT NULL,
    
    PRIMARY KEY (sub_id)
);

create table chat(
	sub_id varchar(10) NOT NULL,
    user_id int NOT NULL,
    msg_id int AUTO_INCREMENT PRIMARY KEY,
    msg TEXT,
    Time_stamp datetime,
    is_sent bool,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (sub_id) REFERENCES subjects (sub_id)
);

create table subscription (
	id int AUTO_INCREMENT not null primary key,
	sub_id varchar(10) NOT NULL,
    user_id int NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (sub_id) REFERENCES subjects (sub_id)
);

INSERT INTO `hackutd_nebula`.`user`
(`user_id`,
`name`)
VALUES
(1, "Manav"),
(2, "Dhruvi"),
(3, "Renil"),
(4, "Namrata");

INSERT INTO `hackutd_nebula`.`chat`
(`sub_id`,
`user_id`,
`msg_id`,
`msg`,
`Time_stamp`,
`is_sent`)
VALUES
("cs6360.001",
2,
2,
"Hello Manav!",
'2021-11-14 10:00:00',
1
);

INSERT INTO `hackutd_nebula`.`subjects`
(`sub_id`,
`sub_name`,
`prof_name`)
VALUES
("cs6350_201",
"Big Data",
"Anurag Nagar");

INSERT INTO `hackutd_nebula`.`login`
(`user_id`,
`password`)
VALUES
(1,
"Manav"),
(2, "Dhruvi"),
(3, "Renil"),
(4, "Namrata");

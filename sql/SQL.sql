-- writing fields are reverse declaration which is different from Programming. Example - dataType fieldName -reverse-> fieldNametrainings DATATYPE

CREATE TABLE users(
	id INT UNSIGNED NOT NULL,
    username VARCHAR(45) NOT NULL,
    email VARCHAR(50) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL,
    address VARCHAR (45) NOT NULL,
    international_card VARCHAR(45),
    user_type ENUM('User', 'Admin') NOT NULL,
    profile_type ENUM('Student', 'Fighter', 'Performer', 'Trainer', 'Elite', 'Master') NOT NULL,
    `status` ENUM('Active','Inactive','Deactivated'),
    PRIMARY KEY(id)
);

ALTER TABLE users
ADD COLUMN full_name VARCHAR(45) NOT NULL AFTER username;

ALTER TABLE users
CHANGE COLUMN email email VARCHAR(45) UNIQUE NOT NULL;

CREATE TABLE ranks(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE tournaments_fighters_matches(
	tournament_id INT UNSIGNED NOT NULL,
    fighter_id INT UNSIGNED NOT NULL,
    match_id INT UNSIGNED NOT NULL,
    PRIMARY KEY(tournament_id, fighter_id, match_id),
    FOREIGN KEY(tournament_id) REFERENCES tournaments(id) ON DELETE CASCADE,
    FOREIGN KEY(fighter_id) REFERENCES fighters(id) ON DELETE CASCADE,
    FOREIGN KEY(match_id) REFERENCES matches(id) ON DELETE CASCADE
);

CREATE TABLE tournaments_performers_matches(
    tournament_id INT UNSIGNED NOT NULL,
    performer_id INT UNSIGNED NOT NULL,
    match_id INT UNSIGNED NOT NULL,
    PRIMARY KEY(tournament_id, performer_id, match_id),
    FOREIGN KEY(tournament_id) REFERENCES tournaments(id) ON DELETE CASCADE,
    FOREIGN KEY(performer_id) REFERENCES performers(id) ON DELETE CASCADE,
    FOREIGN KEY(match_id) REFERENCES matches(id) ON DELETE CASCADE
);

ALTER TABLE users
ADD COLUMN create_date DATETIME,
ADD COLUMN update_date DATETIME;

ALTER TABLE users
ADD COLUMN rank_id INT NOT NULL;

ALTER TABLE students
ADD COLUMN `name` VARCHAR(45) NOT NULL,
ADD COLUMN rank_id INT NOT NULL,
ADD COLUMN join_date DATETIME,
ADD COLUMN `status` ENUM('learning', 'on leave', 'banned', 'graduated', 'quitted') NOT NULL,
ADD COLUMN user_id INT NOT NULL,
ADD COLUMN create_date DATETIME,
ADD COLUMN update_date DATETIME;

ALTER TABLE trainers
ADD COLUMN create_date DATETIME,
ADD COLUMN update_date DATETIME;

INSERT INTO ranks(title) VALUES("11th Kyu - White Belt");
INSERT INTO ranks(title) VALUES("10th Kyu - Orange Belt");
INSERT INTO ranks(title) VALUES("9th Kyu - Orange Belt with Stripe");
INSERT INTO ranks(title) VALUES("8th Kyu - Blue Belt");
INSERT INTO ranks(title) VALUES("7th Kyu - Blue Belt with Stripe");
INSERT INTO ranks(title) VALUES("6th Kyu - Yellow Belt");
INSERT INTO ranks(title) VALUES("5th Kyu - Yellow Belt with Stripe");
INSERT INTO ranks(title) VALUES("4th Kyu - Green Belt");
INSERT INTO ranks(title) VALUES("3rd Kyu - Green Belt with Stripe");
INSERT INTO ranks(title) VALUES("2nd Kyu - Brown Belt");
INSERT INTO ranks(title) VALUES("1st Kyu - Brown Belt with Stripe");
INSERT INTO ranks(title) VALUES("1st Dan - Black Belt with 1 Gold Stripe");
INSERT INTO ranks(title) VALUES("2nd Dan - Black Belt with 2 Gold Stripes");
INSERT INTO ranks(title) VALUES("3rd Dan - Black Belt with 3 Gold Stripes");
INSERT INTO ranks(title) VALUES("4th Dan - Black Belt with 4 Gold Stripes");
INSERT INTO ranks(title) VALUES("5th Dan - Black Belt with 5 Gold Stripes");
INSERT INTO ranks(title) VALUES("6th Dan - Black Belt with 6 Gold Stripes");
INSERT INTO ranks(title) VALUES("7th Dan - Black Belt with 7 Gold Stripes");
INSERT INTO ranks(title) VALUES("8th Dan - Black Belt with 8 Gold Stripes");
INSERT INTO ranks(title) VALUES("9th Dan - Black Belt with 9 Gold Stripes");
INSERT INTO ranks(title) VALUES("10th Dan - Black Belt with 10 Gold Stripes");

DROP TABLE blog;
DROP TABLE blog_seq;
DROP TABLE IF EXISTS registration;
CREATE TABLE registration (
	id INTEGER AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	PRIMARY KEY(id),
	KEY username(username),
	KEY password(password)
);

DROP TABLE IF EXISTS login;
	CREATE TABLE login (
	id INTEGER AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(username) REFERENCES registration(username),
	FOREIGN KEY(password) REFERENCES registration(password),
	KEY username(username)
);

DROP TABLE IF EXISTS chat;
	CREATE TABLE chat (
		id INTEGER AUTO_INCREMENT,
		username VARCHAR(15) NOT NULL,
		message TEXT NOT NULL,
		date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		PRIMARY KEY(id),
		FOREIGN KEY(username) REFERENCES login(username)
);

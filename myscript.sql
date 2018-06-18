 DROP TABLE IF EXISTS registration;
 CREATE TABLE registration (
	id INTEGER AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
 );

 DROP TABLE IF EXISTS login;
	CREATE TABLE login (
	id INTEGER AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(username) REFERENCES registration(username),
	FOREIGN KEY(password) REFERENCES registration(password)
);

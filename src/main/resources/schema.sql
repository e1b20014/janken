CREATE TABLE users(
	id IDENTITY PRIMARY KEY,
	name VARCHAR NOT NULL
);

CREATE TABLE matches(
    id IDENTITY PRIMARY KEY,
	user1 VARCHAR NOT NULL,
	user2 VARCHAR NOT NULL,
	user1Hand VARCHAR NOT NULL,
	user2Hand VARCHAR NOT NULL,
	isActive boolean 
);

CREATE TABLE matchinfo(
    id IDENTITY,
	user1 VARCHAR NOT NULL,
	user2 VARCHAR NOT NULL,
	user1Hand VARCHAR NOT NULL,
	isActive boolean 
);


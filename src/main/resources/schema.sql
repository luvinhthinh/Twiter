DROP TABLE IF EXISTS MESSAGE;  
DROP TABLE IF EXISTS EMO; 
DROP TABLE IF EXISTS REACTION; 

CREATE TABLE MESSAGE (  
	id INT AUTO_INCREMENT  PRIMARY KEY,  
	content VARCHAR(160) NOT NULL,  
	email VARCHAR(32) NOT NULL 
);  

CREATE TABLE EMO (  
	code VARCHAR(8) PRIMARY KEY,
	name VARCHAR(16) NOT NULL
);

CREATE TABLE REACTION (  
	msgid INT NOT NULL,  
	emo VARCHAR(8) NOT NULL,
	email VARCHAR(32) NOT NULL,
	foreign key (msgid) references MESSAGE(id)
);  
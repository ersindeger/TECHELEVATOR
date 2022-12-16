BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS home;
DROP TABLE IF EXISTS address;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE address (
   addressId serial,
   addressLine varchar(64) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   zip int not null,
   
   CONSTRAINT pk_address PRIMARY KEY (addressId) 

);


CREATE TABLE home (
  homeId serial,
  mlsNumber varchar(15) not null,
  imageName varchar(15),
  addressId int not null,
  numberOfBathrooms int,
  numberOfBedrooms int,
  price decimal(12,2) not null,
  shortDescription varchar(255) not null,

  
  CONSTRAINT pk_home PRIMARY KEY (homeId),
  CONSTRAINT fk_home_address FOREIGN KEY (addressId) references address (addressId)

);


-- UPDATING SEQUENCES SO THERE ARE NO CLASHES WHEN APP RUNS WITH EXISTING KEYS...
ALTER SEQUENCE address_addressid_seq RESTART WITH 100;
ALTER SEQUENCE home_homeid_seq RESTART WITH 100;



COMMIT TRANSACTION;

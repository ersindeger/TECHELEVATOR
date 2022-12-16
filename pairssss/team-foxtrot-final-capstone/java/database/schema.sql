BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS resource_type;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS host;
DROP TABLE IF EXISTS host_event;
DROP TABLE IF EXISTS host_address;
DROP TABLE IF EXISTS event_address;
DROP TABLE IF EXISTS event_resource_type;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	host_id int NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE event (
	event_id SERIAL,
	event_name varchar(100) NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	event_date timestamp NOT NULL,
	event_description varchar(500) NOT NULL,
	image_url varchar(1000),

	CONSTRAINT pk_event PRIMARY KEY (event_id)
);

CREATE TABLE resource_type (
	resource_type_id SERIAL,
	resource_name varchar(50) NOT NULL UNIQUE,

	CONSTRAINT pk_resource_type PRIMARY KEY (resource_type_id)
);

CREATE TABLE event_resource_type (
	event_id int,
	resource_type_id int,

	CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event(event_id),
	CONSTRAINT fk_resource_type FOREIGN KEY (resource_type_id) REFERENCES resource_type(resource_type_id)
);

CREATE TABLE host (
	host_id SERIAL,
	host_name varchar(100) NOT NULL,
	host_description varchar(500) NOT NULL,
	host_img varchar(500) NOT NULL,

	CONSTRAINT pk_host PRIMARY KEY (host_id)
);

CREATE TABLE host_event (
	event_id int,
	host_id int,

	CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event(event_id),
	CONSTRAINT fk_host FOREIGN KEY (host_id) REFERENCES host(host_id)
);

CREATE TABLE address (
	address_id SERIAL,
	address_1 varchar(150) NOT NULL,
	address_2 varchar(150),
	city varchar(50) NOT NULL,
	state varchar(50) NOT NULL,
	zip varchar(10) NOT NULL,

	CONSTRAINT pk_address PRIMARY KEY (address_id)
);

CREATE TABLE host_address (
	host_id int,
	address_id int,

	CONSTRAINT fk_host FOREIGN KEY (host_id) REFERENCES host(host_id),
	CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(address_id)
);


CREATE TABLE event_address (
	event_id int,
	address_id int,

	CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event(event_id),
	CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(address_id)
);


COMMIT TRANSACTION;

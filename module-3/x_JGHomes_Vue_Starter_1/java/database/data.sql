BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- SAMPLE DATA

--House 1
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (1, '123 Elm Street', 'Columbus', 'Ohio', 43323);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1000', '1000.jpg', 1, 4, 3, 250000.00,'Freddies Nightmare will come to your life in the classic home. Sweet dreams!');

--House 2
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (2, '125 Elm Street', 'Columbus', 'Ohio', 43323);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1001', '1001.jpg', 2, 3, 3, 100000.00,'Nice house but the neighbor is a little strange.');

--House 3
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (3, '777 Oak Street', 'Dublin', 'Ohio', 43017);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1002', '1002.jpg', 3, 3, 5, 350000.00,'Charming house far away from those Elm street weirdos.');

--House 4
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (4, '555 E Main Street', 'Columbus', 'Ohio', 43203);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1003', '1003.jpg', 4, 10, 25, 450000.00,'This house was featured on the reality tv show: Kevin Flipped My House.');

--House 5
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (5, '127 Slider Lane', 'Columbus', 'Ohio', 43210);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1004', '1004.jpg', 5, 10, 25, 150000.00,'Next door to the White Castle, always be on the lookout for Harold and Kumar!');

--House 6
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (6, '127 Crime Fighters Blvd', 'Columbus', 'Ohio', 43210);
INSERT INTO home ( mlsNumber, imageName, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('1005', '1005.jpg', 6, 10, 25, 750000.00,'Rumour has it batman used to live here before upgrading to the bat cave!');



COMMIT TRANSACTION;

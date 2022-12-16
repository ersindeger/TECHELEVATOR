BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO address (address_1, address_2, city, state, zip) VALUES
('946 Parsons Ave', '', 'Columbus', 'OH', '43206');

INSERT INTO host (host_name, host_description) VALUES
('United Methodist Church & Community Development for All People', 'Our vision is for a whole, healthy, and engaged community where All People are empowered to pursue their hopes, dreams, and aspirations; where lives are transformed by faith and trust, and personal fulfillment is experienced through the abundance of God''s love and grace. To bring our Vision to life, CD4AP catalyzes collaborations with key strategic partners to improve the quality of life for all residents of the South Side through individual and community services.');

INSERT INTO host_address (host_id, address_id) VALUES
(1, 1);

INSERT INTO event (event_name, start_date_time, end_date_time, event_description, image_url) VALUES
('Haircuts for All People', '2023-01-02 09:00:00', '2023-01-02 17:00:00', 'On the first Monday of every month from 9am-5pm, free haircuts are available at our Connection Center at 911 Parsons Avenue. Haircuts are offered on a walk in basis.', 'https://faithconnector.s3.amazonaws.com/4allpeople/images/library/haircuts_for_all_people.jpg'),
('Free Store', '2022-12-05 09:00:00', '2022-12-05 13:00:00', 'The United Methodist Free Store provides gently used clothing and household items to individuals and families in a hospitable atmosphere that affirms the self-worth of each individual. More than 50,000 families have become members of the Free Store since we opened our doors in January 1999.', 'https://faithconnector.s3.amazonaws.com/4allpeople/images/library/free_store_btn1.jpg');


INSERT INTO resource_type (resource_name) VALUES
('Clothing'),
('School supplies'),
('Food drives'),
('Grooming (haircuts, etc)'),
('Technology'),
('Health (dental visits, vaccination sites)'),
('Education (free workshops, library events)'),
('Childcare');

INSERT INTO event_address (event_id, address_id) VALUES (1,1), (2,1);
INSERT INTO event_resource_type (event_id, resource_type_id) VALUES (1,4), (2,1);
INSERT INTO host_event (event_id, host_id) VALUES (1,1), (2,1);


COMMIT TRANSACTION;

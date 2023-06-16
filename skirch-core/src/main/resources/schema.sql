CREATE SCHEMA IF NOT EXISTS skirch;
CREATE TABLE IF NOT EXISTS skirch.users(
                      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL
                      );

CREATE TABLE IF NOT EXISTS skirch.resorts(
                               country VARCHAR(255) NOT NULL,
                               region VARCHAR(255) NOT NULL,
                               href VARCHAR(255) NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

ALTER TABLE skirch.resorts MODIFY COLUMN name TEXT CHARACTER SET utf8;
ALTER TABLE skirch.resorts MODIFY COLUMN region TEXT CHARACTER SET utf8;
ALTER TABLE skirch.resorts MODIFY COLUMN country TEXT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS skirch.locations(
                                 latitude DOUBLE NOT NULL,
                                 longitude DOUBLE NOT NULL,
                                 data_id INT,
                                 FOREIGN KEY (data_id) REFERENCES resorts(id)
);

CREATE TABLE IF NOT EXISTS skirch.lifts(
                             data_id INT,
                             FOREIGN KEY (data_id) REFERENCES resorts(id)
);

CREATE TABLE IF NOT EXISTS skirch.stats(
                             open DOUBLE NOT NULL,
                             hold DOUBLE NOT NULL,
                             scheduled DOUBLE NOT NULL,
                             closed DOUBLE NOT NULL,
                             lifts_id INT,
                             FOREIGN KEY (lifts_id) REFERENCES resorts(id)
);

CREATE TABLE IF NOT EXISTS skirch.percentages(
                                   open DOUBLE NOT NULL,
                                   hold DOUBLE NOT NULL,
                                   scheduled DOUBLE NOT NULL,
                                   closed DOUBLE NOT NULL,
                                   stats_id INT,
                                   FOREIGN KEY (stats_id) REFERENCES resorts(id)
);

# CREATE TABLE IF NOT EXISTS skirch.favorite_resorts(
#                                                       user_id INT NOT NULL,
#                                                       resort_id INT NOT NULL);
# ALTER TABLE skirch.favorite_resorts
# ADD CONSTRAINT FK_favorite_resorts_user_id FOREIGN KEY (user_id) REFERENCES skirch.users(id);
# ALTER TABLE skirch.favorite_resorts
# ADD CONSTRAINT FK_favorite_resorts_resort_id FOREIGN KEY (resort_id) REFERENCES skirch.resorts(id);

# DROP TABLE skirch.percentages;
# DROP TABLE skirch.stats;
# DROP TABLE skirch.lifts;
# DROP TABLE skirch.locations;
# DROP TABLE skirch.resorts;
# DROP TABLE skirch.favorite_resorts;

CREATE TABLE IF NOT EXISTS skirch.favorite_resorts(
    user_id INT NOT NULL,
    resort_id INT NOT NULL);
ALTER TABLE skirch.favorite_resorts
ADD CONSTRAINT FK_favorite_resorts_user_id FOREIGN KEY (user_id) REFERENCES skirch.users(id);
ALTER TABLE skirch.favorite_resorts
ADD CONSTRAINT FK_favorite_resorts_resort_id FOREIGN KEY (resort_id) REFERENCES skirch.resorts(id);




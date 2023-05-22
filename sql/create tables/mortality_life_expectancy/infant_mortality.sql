CREATE TABLE IF NOT EXISTS `infant_mortality` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`infant_mortality` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

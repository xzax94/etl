CREATE TABLE IF NOT EXISTS `domestic_credits` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`domestic_credits` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

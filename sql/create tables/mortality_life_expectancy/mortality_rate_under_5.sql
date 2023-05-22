CREATE TABLE IF NOT EXISTS `mortality_rate_under_5` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`mortality_rate_under_5` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

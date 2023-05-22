CREATE TABLE IF NOT EXISTS `mortality_rate_1_to_4` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`mortality_rate_1_to_4` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

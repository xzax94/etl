CREATE TABLE IF NOT EXISTS `rate_natural_increase` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`rate_natural_increase` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

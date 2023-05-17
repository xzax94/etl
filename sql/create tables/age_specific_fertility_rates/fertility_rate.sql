CREATE TABLE IF NOT EXISTS `fertility_rate` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`age` INT NOT NULL,
	`fertility_rate` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `age`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

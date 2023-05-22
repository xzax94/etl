CREATE TABLE IF NOT EXISTS `life_expectancy` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`life_expectancy` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

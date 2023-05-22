CREATE TABLE IF NOT EXISTS `life_expectancy_by_sex` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex` VARCHAR(6) NOT NULL,
	`life_expectancy` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

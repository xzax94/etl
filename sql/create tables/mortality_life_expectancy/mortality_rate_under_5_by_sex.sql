CREATE TABLE IF NOT EXISTS `mortality_rate_under_5_by_sex` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex` VARCHAR(6) NOT NULL,
	`mortality_rate_under_5` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

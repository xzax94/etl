CREATE TABLE IF NOT EXISTS `mortality_rate_1_to_4_by_sex` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex` VARCHAR(6) NOT NULL,
	`mortality_rate_1_to_4` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

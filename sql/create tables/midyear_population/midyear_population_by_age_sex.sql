CREATE TABLE IF NOT EXISTS `midyear_population_by_age_sex` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`age` INT NOT NULL,
	`sex` VARCHAR(6),
	`midyear_population` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `age`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

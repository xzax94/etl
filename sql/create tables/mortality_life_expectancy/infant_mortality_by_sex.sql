CREATE TABLE IF NOT EXISTS `infant_mortality_by_sex` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex` VARCHAR(6) NOT NULL,
	`infant_mortality` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

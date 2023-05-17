CREATE TABLE IF NOT EXISTS `estimated_gni` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex` VARCHAR(6) NOT NULL,
	`estimated_gni` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`, `sex`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

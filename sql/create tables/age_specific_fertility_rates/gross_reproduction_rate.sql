CREATE TABLE IF NOT EXISTS `gross_reproduction_rate` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`gross_reproduction_rate` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

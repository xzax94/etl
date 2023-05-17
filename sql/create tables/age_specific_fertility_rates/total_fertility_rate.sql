CREATE TABLE IF NOT EXISTS `total_fertility_rate` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`total_fertility_rate` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

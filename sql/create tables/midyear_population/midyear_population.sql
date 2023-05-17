CREATE TABLE IF NOT EXISTS `midyear_population` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`midyear_population` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

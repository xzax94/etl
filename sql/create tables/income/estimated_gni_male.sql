CREATE TABLE IF NOT EXISTS `estimated_gni_male` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`estimated_gni_male` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

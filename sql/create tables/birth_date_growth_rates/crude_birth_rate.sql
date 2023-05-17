CREATE TABLE IF NOT EXISTS `crude_birth_rate` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`crude_birth_rate` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

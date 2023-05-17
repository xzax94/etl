CREATE TABLE IF NOT EXISTS `net_migration` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`net_migration` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

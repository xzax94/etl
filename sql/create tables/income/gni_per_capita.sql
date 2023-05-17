CREATE TABLE IF NOT EXISTS `gni_per_capita` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`gni_per_capita` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

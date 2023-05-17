CREATE TABLE IF NOT EXISTS `income_index` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`income_index` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

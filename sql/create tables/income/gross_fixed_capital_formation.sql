CREATE TABLE IF NOT EXISTS `gross_fixed_capital_formation` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`gross_fixed_capital_formation` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

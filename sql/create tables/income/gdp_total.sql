CREATE TABLE IF NOT EXISTS `gdp_total` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`gdp_total` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

CREATE TABLE IF NOT EXISTS `labour_share_of_gdp` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`labour_share_of_gdp` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

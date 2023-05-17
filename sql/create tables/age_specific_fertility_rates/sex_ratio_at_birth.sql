CREATE TABLE IF NOT EXISTS `sex_ratio_at_birth` (
	`country_id` BIGINT NOT NULL,
	`year` INT NOT NULL,
	`sex_ratio_at_birth` FLOAT NOT NULL,
	PRIMARY KEY(`country_id`, `year`),
	FOREIGN KEY (`country_id`) REFERENCES countries(`country_id`)
);

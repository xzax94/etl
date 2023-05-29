CREATE TABLE IF NOT EXISTS `measures` (
	`measure_description` VARCHAR(75),
	`table_name` VARCHAR(55),
	PRIMARY KEY(`measure_description`,`table_name`)
);

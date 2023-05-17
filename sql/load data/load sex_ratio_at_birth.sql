LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/sex_ratio_at_birth.txt' IGNORE INTO TABLE sex_ratio_at_birth
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, sex_ratio_at_birth);
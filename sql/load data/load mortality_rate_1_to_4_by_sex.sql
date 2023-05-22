LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/mortality_rate_1_to_4_by_sex.txt' IGNORE INTO TABLE mortality_rate_1_to_4_by_sex
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, sex, mortality_rate_1_to_4);
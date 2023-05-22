LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/mortality_rate_1_to_4.txt' IGNORE INTO TABLE mortality_rate_1_to_4
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, mortality_rate_1_to_4);
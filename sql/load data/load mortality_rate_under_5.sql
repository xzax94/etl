LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/mortality_rate_under_5.txt' IGNORE INTO TABLE mortality_rate_under_5
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, mortality_rate_under_5);
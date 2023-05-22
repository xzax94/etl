LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/gdp_per_capita.txt' IGNORE INTO TABLE gdp_per_capita
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, gdp_per_capita);
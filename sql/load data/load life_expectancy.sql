LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/life_expectancy.txt' IGNORE INTO TABLE life_expectancy
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, life_expectancy);
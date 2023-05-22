LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/life_expectancy_by_sex.txt' IGNORE INTO TABLE life_expectancy_by_sex
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, sex, life_expectancy);
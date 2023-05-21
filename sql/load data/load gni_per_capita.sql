LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/gni_per_capita.txt' IGNORE INTO TABLE gni_per_capita
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, gni_per_capita);
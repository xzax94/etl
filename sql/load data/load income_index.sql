LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/income_index.txt' IGNORE INTO TABLE income_index
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, income_index);
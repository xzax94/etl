LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/domestic_credits.txt' IGNORE INTO TABLE domestic_credits
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, domestic_credits);
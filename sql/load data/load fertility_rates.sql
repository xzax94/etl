LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/fertility_rates.txt' IGNORE INTO TABLE fertility_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, age, fertility_rate);
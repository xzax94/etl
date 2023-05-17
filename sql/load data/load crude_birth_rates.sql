LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/crude_birth_rates.txt' IGNORE INTO TABLE crude_birth_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, crude_birth_rate);
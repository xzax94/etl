LOAD DATA LOCAL INFILE 'C:/Workspace/etl/crude_birth_rates.txt' INTO TABLE crude_birth_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, crude_birth_rate);
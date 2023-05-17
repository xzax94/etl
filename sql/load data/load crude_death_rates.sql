LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/crude_death_rates.txt' IGNORE INTO TABLE crude_death_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, crude_death_rate);
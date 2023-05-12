LOAD DATA LOCAL INFILE 'C:/Workspace/etl/crude_death_rates.txt' INTO TABLE crude_death_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, crude_death_rate);
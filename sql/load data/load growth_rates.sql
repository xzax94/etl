LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/growth_rates.txt' INTO TABLE growth_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, growth_rate);
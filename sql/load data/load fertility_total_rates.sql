LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/fertility_total_rates.txt' INTO TABLE total_fertility_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, total_fertility_rate);
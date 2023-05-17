LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/gross_reproduction_rates.txt' INTO TABLE gross_reproduction_rate
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, gross_reproduction_rate);
LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/rate_natural_increases.txt' INTO TABLE rate_natural_increase
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, rate_natural_increase);
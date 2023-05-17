LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/midyear_population.txt' IGNORE INTO TABLE midyear_population
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, midyear_population);
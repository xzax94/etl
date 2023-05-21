LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/gdp_total.txt' IGNORE INTO TABLE gdp_total
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, gdp_total);
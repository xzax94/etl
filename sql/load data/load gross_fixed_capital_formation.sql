LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/gross_fixed_capital_formation.txt' IGNORE INTO TABLE gross_fixed_capital_formation
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, gross_fixed_capital_formation);
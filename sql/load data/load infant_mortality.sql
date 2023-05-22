LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/infant_mortality.txt' IGNORE INTO TABLE infant_mortality
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, infant_mortality);
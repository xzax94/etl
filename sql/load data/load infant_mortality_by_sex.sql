LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/infant_mortality_by_sex.txt' IGNORE INTO TABLE infant_mortality_by_sex
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, sex, infant_mortality);
LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/estimated_gni.txt' IGNORE INTO TABLE estimated_gni
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, sex, estimated_gni);
LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/labour_share_of_gdp.txt' IGNORE INTO TABLE labour_share_of_gdp
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, labour_share_of_gdp);
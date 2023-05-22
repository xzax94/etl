LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/midyear_population_by_age_sex.txt' IGNORE INTO TABLE midyear_population_by_age_sex
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, age, sex, midyear_population);
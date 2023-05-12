LOAD DATA LOCAL INFILE 'C:/Workspace/etl/output/net_migrations.txt' INTO TABLE net_migration
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, year, net_migration);
LOAD DATA LOCAL INFILE 'C:/Workspace/etl/countries.txt' INTO TABLE countries
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
(country_id, iso, iso3, iso_code, fips, display_name, official_name, capital_name, continent_name, currency_code, currency_name, phone_code, region_code, region_name, sub_region_code, sub_region_name, intermediate_region_code, intermediate_region_name, status, development_status, sids, lldc, ldc, area_squared_km, population);
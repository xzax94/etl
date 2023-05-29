/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : country_stat_db

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-05-29 19:19:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `table_metadata`
-- ----------------------------
DROP TABLE IF EXISTS `table_metadata`;
CREATE TABLE `table_metadata` (
  `measure_description` varchar(75) NOT NULL,
  `table_name` varchar(55) NOT NULL,
  `stat_column_name` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`measure_description`,`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of table_metadata
-- ----------------------------
INSERT INTO `table_metadata` VALUES ('Crude birth rate', 'crude_birth_rate', 'crude_birth_rate');
INSERT INTO `table_metadata` VALUES ('Crude death rate', 'crude_death_rate', 'crude_death_rate');
INSERT INTO `table_metadata` VALUES ('Domestic credits', 'domestic_credits', 'domestic_credits');
INSERT INTO `table_metadata` VALUES ('Estimated GNI', 'estimated_gni', 'estimated_gni');
INSERT INTO `table_metadata` VALUES ('Fertility rate', 'fertility_rate', 'fertility_rate');
INSERT INTO `table_metadata` VALUES ('GDP per capita', 'gdp_per_capita', 'gdp_per_capita');
INSERT INTO `table_metadata` VALUES ('GDP total', 'gdp_total', 'gdp_total');
INSERT INTO `table_metadata` VALUES ('GNI per capita', 'gni_per_capita', 'gni_per_capita');
INSERT INTO `table_metadata` VALUES ('Gross fixed capital formation', 'gross_fixed_capital_formation', 'gross_fixed_capital_formation');
INSERT INTO `table_metadata` VALUES ('Gross reproduction rate', 'gross_reproduction_rate', 'gross_reproduction_rate');
INSERT INTO `table_metadata` VALUES ('Growth rate', 'growth_rate', 'growth_rate');
INSERT INTO `table_metadata` VALUES ('Income index', 'income_index', 'income_index');
INSERT INTO `table_metadata` VALUES ('Infant mortality', 'infant_mortality', 'infant_mortality');
INSERT INTO `table_metadata` VALUES ('Infant mortality by sex', 'infant_mortality_by_sex', 'infant_mortality_by_sex');
INSERT INTO `table_metadata` VALUES ('Labour share of GDP', 'labour_share_of_gdp', 'labour_share_of_gdp');
INSERT INTO `table_metadata` VALUES ('Life expectancy', 'life_expectancy', 'life_expectancy');
INSERT INTO `table_metadata` VALUES ('Life expectancy by sex', 'life_expectancy_by_sex', 'life_expectancy_by_sex');
INSERT INTO `table_metadata` VALUES ('Midyear population', 'midyear_population', 'midyear_population');
INSERT INTO `table_metadata` VALUES ('Midyear population by age sex', 'midyear_population_by_age_sex', 'midyear_population');
INSERT INTO `table_metadata` VALUES ('Mortality rate 1 to 4', 'mortality_rate_1_to_4', 'mortality_rate_1_to_4');
INSERT INTO `table_metadata` VALUES ('Mortality rate 1 to 4 by sex', 'mortality_rate_1_to_4_by_sexmortality_rate_1_to_4', 'mortality_rate_1_to_4');
INSERT INTO `table_metadata` VALUES ('Mortality rate under 5', 'mortality_rate_under_5', 'mortality_rate_under_5');
INSERT INTO `table_metadata` VALUES ('Mortality rate under 5 by sex', 'mortality_rate_under_5_by_sex', 'mortality_rate_under_5');
INSERT INTO `table_metadata` VALUES ('Net migration', 'net_migration', 'net_migration');
INSERT INTO `table_metadata` VALUES ('Rate natural increase', 'rate_natural_increase', 'rate_natural_increase');
INSERT INTO `table_metadata` VALUES ('Sex ratio at birth', 'sex_ratio_at_birth', 'sex_ratio_at_birth');
INSERT INTO `table_metadata` VALUES ('Total fertility rate', 'total_fertility_rate', 'total_fertility_rate');

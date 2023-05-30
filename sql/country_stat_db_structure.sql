/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : mpampisdb

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 29/05/2023 22:20:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for countries
-- ----------------------------
DROP TABLE IF EXISTS `countries`;
CREATE TABLE `countries`  (
  `country_id` bigint NOT NULL AUTO_INCREMENT,
  `iso` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `iso3` varchar(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `iso_code` int NULL DEFAULT NULL,
  `fips` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `display_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `official_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `capital_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `continent_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `currency_code` varchar(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `currency_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `phone_code` int NULL DEFAULT NULL,
  `region_code` int NULL DEFAULT NULL,
  `region_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sub_region_code` int NULL DEFAULT NULL,
  `sub_region_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `intermediate_region_code` int NULL DEFAULT NULL,
  `intermediate_region_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `development_status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sids` tinyint NULL DEFAULT NULL,
  `lldc` tinyint NULL DEFAULT NULL,
  `ldc` tinyint NULL DEFAULT NULL,
  `area_squared_km` float NULL DEFAULT NULL,
  `population` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 253 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for crude_birth_rate
-- ----------------------------
DROP TABLE IF EXISTS `crude_birth_rate`;
CREATE TABLE `crude_birth_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `crude_birth_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `crude_birth_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for crude_death_rate
-- ----------------------------
DROP TABLE IF EXISTS `crude_death_rate`;
CREATE TABLE `crude_death_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `crude_death_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `crude_death_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for domestic_credits
-- ----------------------------
DROP TABLE IF EXISTS `domestic_credits`;
CREATE TABLE `domestic_credits`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `domestic_credits` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `domestic_credits_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for estimated_gni
-- ----------------------------
DROP TABLE IF EXISTS `estimated_gni`;
CREATE TABLE `estimated_gni`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `estimated_gni` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `sex`) USING BTREE,
  CONSTRAINT `estimated_gni_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fertility_rate
-- ----------------------------
DROP TABLE IF EXISTS `fertility_rate`;
CREATE TABLE `fertility_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `age` int NOT NULL,
  `fertility_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `fertility_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gdp_per_capita
-- ----------------------------
DROP TABLE IF EXISTS `gdp_per_capita`;
CREATE TABLE `gdp_per_capita`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `gdp_per_capita` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `gdp_per_capita_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gdp_total
-- ----------------------------
DROP TABLE IF EXISTS `gdp_total`;
CREATE TABLE `gdp_total`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `gdp_total` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `gdp_total_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gni_per_capita
-- ----------------------------
DROP TABLE IF EXISTS `gni_per_capita`;
CREATE TABLE `gni_per_capita`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `gni_per_capita` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `gni_per_capita_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gross_fixed_capital_formation
-- ----------------------------
DROP TABLE IF EXISTS `gross_fixed_capital_formation`;
CREATE TABLE `gross_fixed_capital_formation`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `gross_fixed_capital_formation` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `gross_fixed_capital_formation_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gross_reproduction_rate
-- ----------------------------
DROP TABLE IF EXISTS `gross_reproduction_rate`;
CREATE TABLE `gross_reproduction_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `gross_reproduction_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `gross_reproduction_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for growth_rate
-- ----------------------------
DROP TABLE IF EXISTS `growth_rate`;
CREATE TABLE `growth_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `growth_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `growth_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for income_index
-- ----------------------------
DROP TABLE IF EXISTS `income_index`;
CREATE TABLE `income_index`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `income_index` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `income_index_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for infant_mortality
-- ----------------------------
DROP TABLE IF EXISTS `infant_mortality`;
CREATE TABLE `infant_mortality`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `infant_mortality` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `infant_mortality_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for infant_mortality_by_sex
-- ----------------------------
DROP TABLE IF EXISTS `infant_mortality_by_sex`;
CREATE TABLE `infant_mortality_by_sex`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `infant_mortality` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `sex`) USING BTREE,
  CONSTRAINT `infant_mortality_by_sex_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for labour_share_of_gdp
-- ----------------------------
DROP TABLE IF EXISTS `labour_share_of_gdp`;
CREATE TABLE `labour_share_of_gdp`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `labour_share_of_gdp` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `labour_share_of_gdp_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for life_expectancy
-- ----------------------------
DROP TABLE IF EXISTS `life_expectancy`;
CREATE TABLE `life_expectancy`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `life_expectancy` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `life_expectancy_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for life_expectancy_by_sex
-- ----------------------------
DROP TABLE IF EXISTS `life_expectancy_by_sex`;
CREATE TABLE `life_expectancy_by_sex`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `life_expectancy` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `sex`) USING BTREE,
  CONSTRAINT `life_expectancy_by_sex_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for midyear_population
-- ----------------------------
DROP TABLE IF EXISTS `midyear_population`;
CREATE TABLE `midyear_population`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `midyear_population` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `midyear_population_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for midyear_population_by_age_sex
-- ----------------------------
DROP TABLE IF EXISTS `midyear_population_by_age_sex`;
CREATE TABLE `midyear_population_by_age_sex`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `age` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `midyear_population` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `age`, `sex`) USING BTREE,
  CONSTRAINT `midyear_population_by_age_sex_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mortality_rate_1_to_4
-- ----------------------------
DROP TABLE IF EXISTS `mortality_rate_1_to_4`;
CREATE TABLE `mortality_rate_1_to_4`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `mortality_rate_1_to_4` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `mortality_rate_1_to_4_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mortality_rate_1_to_4_by_sex
-- ----------------------------
DROP TABLE IF EXISTS `mortality_rate_1_to_4_by_sex`;
CREATE TABLE `mortality_rate_1_to_4_by_sex`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `mortality_rate_1_to_4` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `sex`) USING BTREE,
  CONSTRAINT `mortality_rate_1_to_4_by_sex_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mortality_rate_under_5
-- ----------------------------
DROP TABLE IF EXISTS `mortality_rate_under_5`;
CREATE TABLE `mortality_rate_under_5`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `mortality_rate_under_5` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `mortality_rate_under_5_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mortality_rate_under_5_by_sex
-- ----------------------------
DROP TABLE IF EXISTS `mortality_rate_under_5_by_sex`;
CREATE TABLE `mortality_rate_under_5_by_sex`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `mortality_rate_under_5` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`, `sex`) USING BTREE,
  CONSTRAINT `mortality_rate_under_5_by_sex_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for net_migration
-- ----------------------------
DROP TABLE IF EXISTS `net_migration`;
CREATE TABLE `net_migration`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `net_migration` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `net_migration_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rate_natural_increase
-- ----------------------------
DROP TABLE IF EXISTS `rate_natural_increase`;
CREATE TABLE `rate_natural_increase`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `rate_natural_increase` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `rate_natural_increase_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sex_ratio_at_birth
-- ----------------------------
DROP TABLE IF EXISTS `sex_ratio_at_birth`;
CREATE TABLE `sex_ratio_at_birth`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `sex_ratio_at_birth` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `sex_ratio_at_birth_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for table_metadata
-- ----------------------------
DROP TABLE IF EXISTS `table_metadata`;
CREATE TABLE `table_metadata`  (
  `measure_description` varchar(75) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `table_name` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `stat_column_name` varchar(55) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`measure_description`, `table_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_fertility_rate
-- ----------------------------
DROP TABLE IF EXISTS `total_fertility_rate`;
CREATE TABLE `total_fertility_rate`  (
  `country_id` bigint NOT NULL,
  `year` int NOT NULL,
  `total_fertility_rate` float NOT NULL,
  PRIMARY KEY (`country_id`, `year`) USING BTREE,
  CONSTRAINT `total_fertility_rate_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

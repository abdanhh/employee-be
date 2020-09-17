/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 120003
 Source Host           : localhost:5432
 Source Catalog        : employee
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120003
 File Encoding         : 65001

 Date: 17/09/2020 20:26:09
*/

-- ----------------------------
-- Sequence structure for employee_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."employee_seq";
CREATE SEQUENCE "public"."employee_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for division
-- ----------------------------
DROP TABLE IF EXISTS "public"."division";
CREATE TABLE "public"."division" (
  "id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of division
-- ----------------------------
INSERT INTO "public"."division" VALUES (1, 'IT');
INSERT INTO "public"."division" VALUES (2, 'HRD');
INSERT INTO "public"."division" VALUES (3, 'Loading');
INSERT INTO "public"."division" VALUES (4, 'Ticketing');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee";
CREATE TABLE "public"."employee" (
  "id" int8 NOT NULL,
  "created_date" timestamp(6),
  "division_id" int8,
  "last_position" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "nik" varchar(255) COLLATE "pg_catalog"."default",
  "position_id" int8,
  "type" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO "public"."employee" VALUES (1, '2020-09-17 20:13:59.195', 1, 4, 'Dio Odading', 'EM0001', 4, 'PROMOTION');
INSERT INTO "public"."employee" VALUES (2, '2020-09-17 20:25:55.847', 1, 4, 'Dio Odading', 'EM0002', 4, 'PROMOTION');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS "public"."position";
CREATE TABLE "public"."position" (
  "id" int8 NOT NULL,
  "level" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO "public"."position" VALUES (1, 1, 'Staff');
INSERT INTO "public"."position" VALUES (2, 2, 'Supervisor');
INSERT INTO "public"."position" VALUES (3, 3, 'Asisten Manager');
INSERT INTO "public"."position" VALUES (4, 4, 'Manager');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."employee_seq"
OWNED BY "public"."employee"."id";
SELECT setval('"public"."employee_seq"', 3, true);

-- ----------------------------
-- Primary Key structure for table division
-- ----------------------------
ALTER TABLE "public"."division" ADD CONSTRAINT "division_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE "public"."employee" ADD CONSTRAINT "employee_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table position
-- ----------------------------
ALTER TABLE "public"."position" ADD CONSTRAINT "position_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table employee
-- ----------------------------
ALTER TABLE "public"."employee" ADD CONSTRAINT "fk_divions_id" FOREIGN KEY ("division_id") REFERENCES "public"."division" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE "public"."employee" ADD CONSTRAINT "fk_position_id" FOREIGN KEY ("position_id") REFERENCES "public"."position" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;

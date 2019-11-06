/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90313
Source Host           : localhost:5432
Source Database       : icare
Source Schema         : icare

Target Server Type    : PGSQL
Target Server Version : 90313
File Encoding         : 65001

Date: 2019-11-06 14:26:49
*/


-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS "icare"."province";
CREATE TABLE "icare"."province" (
"id" int4 NOT NULL,
"code" varchar(100) COLLATE "default",
"name" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "icare"."province" IS '省份表';
COMMENT ON COLUMN "icare"."province"."code" IS '机构id';
COMMENT ON COLUMN "icare"."province"."name" IS '省份名称';

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO "icare"."province" VALUES ('1', '', '北京市');
INSERT INTO "icare"."province" VALUES ('2', '', '天津市');
INSERT INTO "icare"."province" VALUES ('3', '', '河北省');
INSERT INTO "icare"."province" VALUES ('4', '', '山西省');
INSERT INTO "icare"."province" VALUES ('5', '', '内蒙古');
INSERT INTO "icare"."province" VALUES ('6', '', '辽宁省');
INSERT INTO "icare"."province" VALUES ('7', '', '吉林省');
INSERT INTO "icare"."province" VALUES ('8', '', '黑龙江省');
INSERT INTO "icare"."province" VALUES ('9', '', '上海市');
INSERT INTO "icare"."province" VALUES ('10', '', '江苏省');
INSERT INTO "icare"."province" VALUES ('11', '', '浙江省');
INSERT INTO "icare"."province" VALUES ('12', '', '安徽省');
INSERT INTO "icare"."province" VALUES ('13', '', '福建省');
INSERT INTO "icare"."province" VALUES ('14', '', '江西省');
INSERT INTO "icare"."province" VALUES ('15', '', '山东省');
INSERT INTO "icare"."province" VALUES ('16', '', '河南省');
INSERT INTO "icare"."province" VALUES ('17', '', '湖北省');
INSERT INTO "icare"."province" VALUES ('18', '', '湖南省');
INSERT INTO "icare"."province" VALUES ('19', '', '广东省');
INSERT INTO "icare"."province" VALUES ('20', '', '广西省');
INSERT INTO "icare"."province" VALUES ('21', '', '海南省');
INSERT INTO "icare"."province" VALUES ('22', '', '重庆省');
INSERT INTO "icare"."province" VALUES ('23', '', '四川省');
INSERT INTO "icare"."province" VALUES ('24', '', '贵州省');
INSERT INTO "icare"."province" VALUES ('25', '', '云南省');
INSERT INTO "icare"."province" VALUES ('26', '', '西藏省');
INSERT INTO "icare"."province" VALUES ('27', '', '陕西省');
INSERT INTO "icare"."province" VALUES ('28', '', '甘肃省');
INSERT INTO "icare"."province" VALUES ('29', '', '青海省');
INSERT INTO "icare"."province" VALUES ('30', '', '宁夏省');
INSERT INTO "icare"."province" VALUES ('31', '', '新疆');
INSERT INTO "icare"."province" VALUES ('32', '', '香港');
INSERT INTO "icare"."province" VALUES ('33', '', '澳门');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table province
-- ----------------------------
ALTER TABLE "icare"."province" ADD PRIMARY KEY ("id");

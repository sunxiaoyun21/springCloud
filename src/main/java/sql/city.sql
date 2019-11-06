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

Date: 2019-11-06 14:26:26
*/


-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS "icare"."city";
CREATE TABLE "icare"."city" (
"id" int4 NOT NULL,
"province_id" int4,
"code" varchar(100) COLLATE "default",
"name" varchar(100) COLLATE "default",
"province_code" varchar(100) COLLATE "default",
"area_code" varchar(10) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "icare"."city" IS '城市表';
COMMENT ON COLUMN "icare"."city"."province_id" IS '所属省市id';
COMMENT ON COLUMN "icare"."city"."code" IS '市code';
COMMENT ON COLUMN "icare"."city"."name" IS '市名称';
COMMENT ON COLUMN "icare"."city"."province_code" IS '省份code';
COMMENT ON COLUMN "icare"."city"."area_code" IS '区号';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO "icare"."city" VALUES ('1', '1', '', '北京市', '', '0010');
INSERT INTO "icare"."city" VALUES ('2', '2', '', '天津市', '', '0022');
INSERT INTO "icare"."city" VALUES ('3', '3', '', '石家庄市', '', '0311');
INSERT INTO "icare"."city" VALUES ('4', '3', '', '唐山市', '', '0315');
INSERT INTO "icare"."city" VALUES ('5', '3', '', '秦皇岛市', '', '0335');
INSERT INTO "icare"."city" VALUES ('6', '3', '', '邯郸市', '', '0310');
INSERT INTO "icare"."city" VALUES ('7', '3', '', '邢台市', '', '0319');
INSERT INTO "icare"."city" VALUES ('8', '3', '', '保定市', '', '0312');
INSERT INTO "icare"."city" VALUES ('9', '3', '', '张家口市', '', '0313');
INSERT INTO "icare"."city" VALUES ('10', '3', '', '承德市', '', '0314');
INSERT INTO "icare"."city" VALUES ('11', '3', '', '沧州市', '', '0317');
INSERT INTO "icare"."city" VALUES ('12', '3', '', '廊坊市', '', '0316');
INSERT INTO "icare"."city" VALUES ('13', '3', '', '衡水市', '', '0318');
INSERT INTO "icare"."city" VALUES ('14', '4', '', '太原市', '', '0351');
INSERT INTO "icare"."city" VALUES ('15', '4', '', '大同市', '', '0352');
INSERT INTO "icare"."city" VALUES ('16', '4', '', '阳泉市', '', '0353');
INSERT INTO "icare"."city" VALUES ('17', '4', '', '长治市', '', '0355');
INSERT INTO "icare"."city" VALUES ('18', '4', '', '晋城市', '', '0356');
INSERT INTO "icare"."city" VALUES ('19', '4', '', '朔州市', '', '0349');
INSERT INTO "icare"."city" VALUES ('20', '4', '', '晋中市', '', '0354');
INSERT INTO "icare"."city" VALUES ('21', '4', '', '运城市', '', '0359');
INSERT INTO "icare"."city" VALUES ('22', '4', '', '忻州市', '', '0350');
INSERT INTO "icare"."city" VALUES ('23', '4', '', '临汾市', '', '0357');
INSERT INTO "icare"."city" VALUES ('24', '4', '', '吕梁市', '', '0358');
INSERT INTO "icare"."city" VALUES ('25', '5', '', '呼和浩特市', '', '0471');
INSERT INTO "icare"."city" VALUES ('26', '5', '', '包头市', '', '0472');
INSERT INTO "icare"."city" VALUES ('27', '5', '', '乌海市', '', '0473');
INSERT INTO "icare"."city" VALUES ('28', '5', '', '赤峰市', '', '0476');
INSERT INTO "icare"."city" VALUES ('29', '5', '', '通辽市', '', '0475');
INSERT INTO "icare"."city" VALUES ('30', '5', '', '鄂尔多斯市', '', '0477');
INSERT INTO "icare"."city" VALUES ('31', '5', '', '呼伦贝尔市', '', '0470');
INSERT INTO "icare"."city" VALUES ('32', '5', '', '巴彦淖尔市', '', '0478');
INSERT INTO "icare"."city" VALUES ('33', '5', '', '乌兰察布市', '', '0474');
INSERT INTO "icare"."city" VALUES ('34', '5', '', '兴安盟', '', '0482');
INSERT INTO "icare"."city" VALUES ('35', '5', '', '锡林郭勒盟', '', '0479');
INSERT INTO "icare"."city" VALUES ('36', '5', '', '阿拉善盟', '', '0483');
INSERT INTO "icare"."city" VALUES ('37', '6', '', '沈阳市', '', '0024');
INSERT INTO "icare"."city" VALUES ('38', '6', '', '大连市', '', '0411');
INSERT INTO "icare"."city" VALUES ('39', '6', '', '鞍山市', '', '0412');
INSERT INTO "icare"."city" VALUES ('40', '6', '', '抚顺市', '', '0024');
INSERT INTO "icare"."city" VALUES ('41', '6', '', '本溪市', '', '0024');
INSERT INTO "icare"."city" VALUES ('42', '6', '', '丹东市', '', '0415');
INSERT INTO "icare"."city" VALUES ('43', '6', '', '锦州市', '', '0416');
INSERT INTO "icare"."city" VALUES ('44', '6', '', '营口市', '', '0417');
INSERT INTO "icare"."city" VALUES ('45', '6', '', '阜新市', '', '0418');
INSERT INTO "icare"."city" VALUES ('46', '6', '', '辽阳市', '', '0419');
INSERT INTO "icare"."city" VALUES ('47', '6', '', '盘锦市', '', '0427');
INSERT INTO "icare"."city" VALUES ('48', '6', '', '铁岭市', '', '0024');
INSERT INTO "icare"."city" VALUES ('49', '6', '', '朝阳市', '', '0421');
INSERT INTO "icare"."city" VALUES ('50', '6', '', '葫芦岛市', '', '0429');
INSERT INTO "icare"."city" VALUES ('51', '7', '', '长春市', '', '0431');
INSERT INTO "icare"."city" VALUES ('52', '7', '', '吉林市', '', '0432');
INSERT INTO "icare"."city" VALUES ('53', '7', '', '四平市', '', '0434');
INSERT INTO "icare"."city" VALUES ('54', '7', '', '辽源市', '', '0437');
INSERT INTO "icare"."city" VALUES ('55', '7', '', '通化市', '', '0435');
INSERT INTO "icare"."city" VALUES ('56', '7', '', '白山市', '', '0439');
INSERT INTO "icare"."city" VALUES ('57', '7', '', '松原市', '', '0438');
INSERT INTO "icare"."city" VALUES ('58', '7', '', '白城市', '', '0436');
INSERT INTO "icare"."city" VALUES ('59', '7', '', '延边朝鲜族自治州', '', '0433');
INSERT INTO "icare"."city" VALUES ('60', '8', '', '哈尔滨市', '', '0451');
INSERT INTO "icare"."city" VALUES ('61', '8', '', '齐齐哈尔市', '', '0452');
INSERT INTO "icare"."city" VALUES ('62', '8', '', '鸡西市', '', '0467');
INSERT INTO "icare"."city" VALUES ('63', '8', '', '鹤岗市', '', '0468');
INSERT INTO "icare"."city" VALUES ('64', '8', '', '双鸭山市', '', '0469');
INSERT INTO "icare"."city" VALUES ('65', '8', '', '大庆市', '', '0459');
INSERT INTO "icare"."city" VALUES ('66', '8', '', '伊春市', '', '0458');
INSERT INTO "icare"."city" VALUES ('67', '8', '', '佳木斯市', '', '0454');
INSERT INTO "icare"."city" VALUES ('68', '8', '', '七台河市', '', '0464');
INSERT INTO "icare"."city" VALUES ('69', '8', '', '牡丹江市', '', '0453');
INSERT INTO "icare"."city" VALUES ('70', '8', '', '黑河市', '', '0456');
INSERT INTO "icare"."city" VALUES ('71', '8', '', '绥化市', '', '0455');
INSERT INTO "icare"."city" VALUES ('72', '8', '', '大兴安岭地区', '', '0457');
INSERT INTO "icare"."city" VALUES ('73', '9', '', '上海市', '', '0021');
INSERT INTO "icare"."city" VALUES ('74', '10', '', '南京市', '', '0025');
INSERT INTO "icare"."city" VALUES ('75', '10', '', '无锡市', '', '0510');
INSERT INTO "icare"."city" VALUES ('76', '10', '', '徐州市', '', '0516');
INSERT INTO "icare"."city" VALUES ('77', '10', '', '常州市', '', '0519');
INSERT INTO "icare"."city" VALUES ('78', '10', '', '苏州市', '', '0512');
INSERT INTO "icare"."city" VALUES ('79', '10', '', '南通市', '', '0513');
INSERT INTO "icare"."city" VALUES ('80', '10', '', '连云港市', '', '0518');
INSERT INTO "icare"."city" VALUES ('81', '10', '', '淮安市', '', '0517');
INSERT INTO "icare"."city" VALUES ('82', '10', '', '盐城市', '', '0515');
INSERT INTO "icare"."city" VALUES ('83', '10', '', '扬州市', '', '0514');
INSERT INTO "icare"."city" VALUES ('84', '10', '', '镇江市', '', '0511');
INSERT INTO "icare"."city" VALUES ('85', '10', '', '泰州市', '', '0523');
INSERT INTO "icare"."city" VALUES ('86', '10', '', '宿迁市', '', '0527');
INSERT INTO "icare"."city" VALUES ('87', '11', '', '杭州市', '', '0571');
INSERT INTO "icare"."city" VALUES ('88', '11', '', '宁波市', '', '0574');
INSERT INTO "icare"."city" VALUES ('89', '11', '', '温州市', '', '0577');
INSERT INTO "icare"."city" VALUES ('90', '11', '', '嘉兴市', '', '0573');
INSERT INTO "icare"."city" VALUES ('91', '11', '', '湖州市', '', '0572');
INSERT INTO "icare"."city" VALUES ('92', '11', '', '绍兴市', '', '0575');
INSERT INTO "icare"."city" VALUES ('93', '11', '', '金华市', '', '0579');
INSERT INTO "icare"."city" VALUES ('94', '11', '', '衢州市', '', '0570');
INSERT INTO "icare"."city" VALUES ('95', '11', '', '舟山市', '', '0580');
INSERT INTO "icare"."city" VALUES ('96', '11', '', '台州市', '', '0576');
INSERT INTO "icare"."city" VALUES ('97', '11', '', '丽水市', '', '0578');
INSERT INTO "icare"."city" VALUES ('98', '12', '', '合肥市', '', '0551');
INSERT INTO "icare"."city" VALUES ('99', '12', '', '芜湖市', '', '0553');
INSERT INTO "icare"."city" VALUES ('100', '12', '', '蚌埠市', '', '0552');
INSERT INTO "icare"."city" VALUES ('101', '12', '', '淮南市', '', '0554');
INSERT INTO "icare"."city" VALUES ('102', '12', '', '马鞍山市', '', '0555');
INSERT INTO "icare"."city" VALUES ('103', '12', '', '淮北市', '', '0561');
INSERT INTO "icare"."city" VALUES ('104', '12', '', '铜陵市', '', '0562');
INSERT INTO "icare"."city" VALUES ('105', '12', '', '安庆市', '', '0556');
INSERT INTO "icare"."city" VALUES ('106', '12', '', '黄山市', '', '0559');
INSERT INTO "icare"."city" VALUES ('107', '12', '', '滁州市', '', '0550');
INSERT INTO "icare"."city" VALUES ('108', '12', '', '阜阳市', '', '0558');
INSERT INTO "icare"."city" VALUES ('109', '12', '', '宿州市', '', '0557');
INSERT INTO "icare"."city" VALUES ('110', '12', '', '巢湖市', '', '0551');
INSERT INTO "icare"."city" VALUES ('111', '12', '', '六安市', '', '0564');
INSERT INTO "icare"."city" VALUES ('112', '12', '', '亳州市', '', '0558');
INSERT INTO "icare"."city" VALUES ('113', '12', '', '池州市', '', '0566');
INSERT INTO "icare"."city" VALUES ('114', '12', '', '宣城市', '', '0563');
INSERT INTO "icare"."city" VALUES ('115', '13', '', '福州市', '', '0591');
INSERT INTO "icare"."city" VALUES ('116', '13', '', '厦门市', '', '0592');
INSERT INTO "icare"."city" VALUES ('117', '13', '', '莆田市', '', '0594');
INSERT INTO "icare"."city" VALUES ('118', '13', '', '三明市', '', '0598');
INSERT INTO "icare"."city" VALUES ('119', '13', '', '泉州市', '', '0595');
INSERT INTO "icare"."city" VALUES ('120', '13', '', '漳州市', '', '0596');
INSERT INTO "icare"."city" VALUES ('121', '13', '', '南平市', '', '0599');
INSERT INTO "icare"."city" VALUES ('122', '13', '', '龙岩市', '', '0597');
INSERT INTO "icare"."city" VALUES ('123', '13', '', '宁德市', '', '0593');
INSERT INTO "icare"."city" VALUES ('124', '14', '', '南昌市', '', '0791');
INSERT INTO "icare"."city" VALUES ('125', '14', '', '景德镇市', '', '0798');
INSERT INTO "icare"."city" VALUES ('126', '14', '', '萍乡市', '', '0799');
INSERT INTO "icare"."city" VALUES ('127', '14', '', '九江市', '', '0792');
INSERT INTO "icare"."city" VALUES ('128', '14', '', '新余市', '', '0790');
INSERT INTO "icare"."city" VALUES ('129', '14', '', '鹰潭市', '', '0701');
INSERT INTO "icare"."city" VALUES ('130', '14', '', '赣州市', '', '0797');
INSERT INTO "icare"."city" VALUES ('131', '14', '', '吉安市', '', '0796');
INSERT INTO "icare"."city" VALUES ('132', '14', '', '宜春市', '', '0795');
INSERT INTO "icare"."city" VALUES ('133', '14', '', '抚州市', '', '0794');
INSERT INTO "icare"."city" VALUES ('134', '14', '', '上饶市', '', '0793');
INSERT INTO "icare"."city" VALUES ('135', '15', '', '济南市', '', '0531');
INSERT INTO "icare"."city" VALUES ('136', '15', '', '青岛市', '', '0532');
INSERT INTO "icare"."city" VALUES ('137', '15', '', '淄博市', '', '0533');
INSERT INTO "icare"."city" VALUES ('138', '15', '', '枣庄市', '', '0632');
INSERT INTO "icare"."city" VALUES ('139', '15', '', '东营市', '', '0546');
INSERT INTO "icare"."city" VALUES ('140', '15', '', '烟台市', '', '0535');
INSERT INTO "icare"."city" VALUES ('141', '15', '', '潍坊市', '', '0536');
INSERT INTO "icare"."city" VALUES ('142', '15', '', '济宁市', '', '0537');
INSERT INTO "icare"."city" VALUES ('143', '15', '', '泰安市', '', '0538');
INSERT INTO "icare"."city" VALUES ('144', '15', '', '威海市', '', '0631');
INSERT INTO "icare"."city" VALUES ('145', '15', '', '日照市', '', '0633');
INSERT INTO "icare"."city" VALUES ('146', '15', '', '莱芜市', '', '0634');
INSERT INTO "icare"."city" VALUES ('147', '15', '', '临沂市', '', '0539');
INSERT INTO "icare"."city" VALUES ('148', '15', '', '德州市', '', '0534');
INSERT INTO "icare"."city" VALUES ('149', '15', '', '聊城市', '', '0635');
INSERT INTO "icare"."city" VALUES ('150', '15', '', '滨州市', '', '0543');
INSERT INTO "icare"."city" VALUES ('151', '15', '', '荷泽市', '', '0530');
INSERT INTO "icare"."city" VALUES ('152', '16', '', '郑州市', '', '0371');
INSERT INTO "icare"."city" VALUES ('153', '16', '', '开封市', '', '0371');
INSERT INTO "icare"."city" VALUES ('154', '16', '', '洛阳市', '', '0379');
INSERT INTO "icare"."city" VALUES ('155', '16', '', '平顶山市', '', '0375');
INSERT INTO "icare"."city" VALUES ('156', '16', '', '安阳市', '', '0372');
INSERT INTO "icare"."city" VALUES ('157', '16', '', '鹤壁市', '', '0392');
INSERT INTO "icare"."city" VALUES ('158', '16', '', '新乡市', '', '0373');
INSERT INTO "icare"."city" VALUES ('159', '16', '', '焦作市', '', '0391');
INSERT INTO "icare"."city" VALUES ('160', '16', '', '濮阳市', '', '0393');
INSERT INTO "icare"."city" VALUES ('161', '16', '', '许昌市', '', '0374');
INSERT INTO "icare"."city" VALUES ('162', '16', '', '漯河市', '', '0395');
INSERT INTO "icare"."city" VALUES ('163', '16', '', '三门峡市', '', '0398');
INSERT INTO "icare"."city" VALUES ('164', '16', '', '南阳市', '', '0377');
INSERT INTO "icare"."city" VALUES ('165', '16', '', '商丘市', '', '0370');
INSERT INTO "icare"."city" VALUES ('166', '16', '', '信阳市', '', '0376');
INSERT INTO "icare"."city" VALUES ('167', '16', '', '周口市', '', '0394');
INSERT INTO "icare"."city" VALUES ('168', '16', '', '驻马店市', '', '0396');
INSERT INTO "icare"."city" VALUES ('169', '17', '', '武汉市', '', '0027');
INSERT INTO "icare"."city" VALUES ('170', '17', '', '黄石市', '', '0714');
INSERT INTO "icare"."city" VALUES ('171', '17', '', '十堰市', '', '0719');
INSERT INTO "icare"."city" VALUES ('172', '17', '', '宜昌市', '', '0717');
INSERT INTO "icare"."city" VALUES ('173', '17', '', '襄阳市', '', '0710');
INSERT INTO "icare"."city" VALUES ('174', '17', '', '鄂州市', '', '0711');
INSERT INTO "icare"."city" VALUES ('175', '17', '', '荆门市', '', '0724');
INSERT INTO "icare"."city" VALUES ('176', '17', '', '孝感市', '', '0712');
INSERT INTO "icare"."city" VALUES ('177', '17', '', '荆州市', '', '0716');
INSERT INTO "icare"."city" VALUES ('178', '17', '', '黄冈市', '', '0713');
INSERT INTO "icare"."city" VALUES ('179', '17', '', '咸宁市', '', '0715');
INSERT INTO "icare"."city" VALUES ('180', '17', '', '随州市', '', '0722');
INSERT INTO "icare"."city" VALUES ('181', '17', '', '恩施土家族苗族自治州', '', '0718');
INSERT INTO "icare"."city" VALUES ('182', '17', '', '神农架', '', '0719');
INSERT INTO "icare"."city" VALUES ('183', '18', '', '长沙市', '', '0731');
INSERT INTO "icare"."city" VALUES ('184', '18', '', '株洲市', '', '0731');
INSERT INTO "icare"."city" VALUES ('185', '18', '', '湘潭市', '', '0731');
INSERT INTO "icare"."city" VALUES ('186', '18', '', '衡阳市', '', '0734');
INSERT INTO "icare"."city" VALUES ('187', '18', '', '邵阳市', '', '0739');
INSERT INTO "icare"."city" VALUES ('188', '18', '', '岳阳市', '', '0730');
INSERT INTO "icare"."city" VALUES ('189', '18', '', '常德市', '', '0736');
INSERT INTO "icare"."city" VALUES ('190', '18', '', '张家界市', '', '0744');
INSERT INTO "icare"."city" VALUES ('191', '18', '', '益阳市', '', '0737');
INSERT INTO "icare"."city" VALUES ('192', '18', '', '郴州市', '', '0735');
INSERT INTO "icare"."city" VALUES ('193', '18', '', '永州市', '', '0746');
INSERT INTO "icare"."city" VALUES ('194', '18', '', '怀化市', '', '0745');
INSERT INTO "icare"."city" VALUES ('195', '18', '', '娄底市', '', '0738');
INSERT INTO "icare"."city" VALUES ('196', '18', '', '湘西土家族苗族自治州', '', '0743');
INSERT INTO "icare"."city" VALUES ('197', '19', '', '广州市', '', '0020');
INSERT INTO "icare"."city" VALUES ('198', '19', '', '韶关市', '', '0751');
INSERT INTO "icare"."city" VALUES ('199', '19', '', '深圳市', '', '0755');
INSERT INTO "icare"."city" VALUES ('200', '19', '', '珠海市', '', '0756');
INSERT INTO "icare"."city" VALUES ('201', '19', '', '汕头市', '', '0754');
INSERT INTO "icare"."city" VALUES ('202', '19', '', '佛山市', '', '0757');
INSERT INTO "icare"."city" VALUES ('203', '19', '', '江门市', '', '0750');
INSERT INTO "icare"."city" VALUES ('204', '19', '', '湛江市', '', '0759');
INSERT INTO "icare"."city" VALUES ('205', '19', '', '茂名市', '', '0668');
INSERT INTO "icare"."city" VALUES ('206', '19', '', '肇庆市', '', '0758');
INSERT INTO "icare"."city" VALUES ('207', '19', '', '惠州市', '', '0752');
INSERT INTO "icare"."city" VALUES ('208', '19', '', '梅州市', '', '0753');
INSERT INTO "icare"."city" VALUES ('209', '19', '', '汕尾市', '', '0660');
INSERT INTO "icare"."city" VALUES ('210', '19', '', '河源市', '', '0762');
INSERT INTO "icare"."city" VALUES ('211', '19', '', '阳江市', '', '0662');
INSERT INTO "icare"."city" VALUES ('212', '19', '', '清远市', '', '0763');
INSERT INTO "icare"."city" VALUES ('213', '19', '', '东莞市', '', '0769');
INSERT INTO "icare"."city" VALUES ('214', '19', '', '中山市', '', '0760');
INSERT INTO "icare"."city" VALUES ('215', '19', '', '潮州市', '', '0768');
INSERT INTO "icare"."city" VALUES ('216', '19', '', '揭阳市', '', '0663');
INSERT INTO "icare"."city" VALUES ('217', '19', '', '云浮市', '', '0766');
INSERT INTO "icare"."city" VALUES ('218', '20', '', '南宁市', '', '0771');
INSERT INTO "icare"."city" VALUES ('219', '20', '', '柳州市', '', '0772');
INSERT INTO "icare"."city" VALUES ('220', '20', '', '桂林市', '', '0773');
INSERT INTO "icare"."city" VALUES ('221', '20', '', '梧州市', '', '0774');
INSERT INTO "icare"."city" VALUES ('222', '20', '', '北海市', '', '0779');
INSERT INTO "icare"."city" VALUES ('223', '20', '', '防城港市', '', '0770');
INSERT INTO "icare"."city" VALUES ('224', '20', '', '钦州市', '', '0777');
INSERT INTO "icare"."city" VALUES ('225', '20', '', '贵港市', '', '0775');
INSERT INTO "icare"."city" VALUES ('226', '20', '', '玉林市', '', '0775');
INSERT INTO "icare"."city" VALUES ('227', '20', '', '百色市', '', '0776');
INSERT INTO "icare"."city" VALUES ('228', '20', '', '贺州市', '', '0774');
INSERT INTO "icare"."city" VALUES ('229', '20', '', '河池市', '', '0778');
INSERT INTO "icare"."city" VALUES ('230', '20', '', '来宾市', '', '0772');
INSERT INTO "icare"."city" VALUES ('231', '20', '', '崇左市', '', '0771');
INSERT INTO "icare"."city" VALUES ('232', '21', '', '海口市', '', '0898');
INSERT INTO "icare"."city" VALUES ('233', '21', '', '三亚市', '', '0898');
INSERT INTO "icare"."city" VALUES ('234', '22', '', '重庆市', '', '0023');
INSERT INTO "icare"."city" VALUES ('235', '23', '', '成都市', '', '0028');
INSERT INTO "icare"."city" VALUES ('236', '23', '', '自贡市', '', '0813');
INSERT INTO "icare"."city" VALUES ('237', '23', '', '攀枝花市', '', '0812');
INSERT INTO "icare"."city" VALUES ('238', '23', '', '泸州市', '', '0830');
INSERT INTO "icare"."city" VALUES ('239', '23', '', '德阳市', '', '0838');
INSERT INTO "icare"."city" VALUES ('240', '23', '', '绵阳市', '', '0816');
INSERT INTO "icare"."city" VALUES ('241', '23', '', '广元市', '', '0839');
INSERT INTO "icare"."city" VALUES ('242', '23', '', '遂宁市', '', '0825');
INSERT INTO "icare"."city" VALUES ('243', '23', '', '内江市', '', '0832');
INSERT INTO "icare"."city" VALUES ('244', '23', '', '乐山市', '', '0833');
INSERT INTO "icare"."city" VALUES ('245', '23', '', '南充市', '', '0817');
INSERT INTO "icare"."city" VALUES ('246', '23', '', '眉山市', '', '0028');
INSERT INTO "icare"."city" VALUES ('247', '23', '', '宜宾市', '', '0831');
INSERT INTO "icare"."city" VALUES ('248', '23', '', '广安市', '', '0826');
INSERT INTO "icare"."city" VALUES ('249', '23', '', '达州市', '', '0818');
INSERT INTO "icare"."city" VALUES ('250', '23', '', '雅安市', '', '0835');
INSERT INTO "icare"."city" VALUES ('251', '23', '', '巴中市', '', '0827');
INSERT INTO "icare"."city" VALUES ('252', '23', '', '资阳市', '', '0028');
INSERT INTO "icare"."city" VALUES ('253', '23', '', '阿坝藏族羌族自治州', '', '0837');
INSERT INTO "icare"."city" VALUES ('254', '23', '', '甘孜藏族自治州', '', '0836');
INSERT INTO "icare"."city" VALUES ('255', '23', '', '凉山彝族自治州', '', '0834');
INSERT INTO "icare"."city" VALUES ('256', '24', '', '贵阳市', '', '0851');
INSERT INTO "icare"."city" VALUES ('257', '24', '', '六盘水市', '', '0858');
INSERT INTO "icare"."city" VALUES ('258', '24', '', '遵义市', '', '0852');
INSERT INTO "icare"."city" VALUES ('259', '24', '', '安顺市', '', '0853');
INSERT INTO "icare"."city" VALUES ('260', '24', '', '铜仁地区', '', '0856');
INSERT INTO "icare"."city" VALUES ('261', '24', '', '黔西南布依族苗族自治州', '', '0859');
INSERT INTO "icare"."city" VALUES ('262', '24', '', '毕节地区', '', '0857');
INSERT INTO "icare"."city" VALUES ('263', '24', '', '黔东南苗族侗族自治州', '', '0855');
INSERT INTO "icare"."city" VALUES ('264', '24', '', '黔南布依族苗族自治州', '', '0854');
INSERT INTO "icare"."city" VALUES ('265', '25', '', '昆明市', '', '0871');
INSERT INTO "icare"."city" VALUES ('266', '25', '', '曲靖市', '', '0874');
INSERT INTO "icare"."city" VALUES ('267', '25', '', '玉溪市', '', '0877');
INSERT INTO "icare"."city" VALUES ('268', '25', '', '保山市', '', '0875');
INSERT INTO "icare"."city" VALUES ('269', '25', '', '昭通市', '', '0870');
INSERT INTO "icare"."city" VALUES ('270', '25', '', '丽江市', '', '0888');
INSERT INTO "icare"."city" VALUES ('271', '25', '', '思茅市', '', '0879');
INSERT INTO "icare"."city" VALUES ('272', '25', '', '临沧市', '', '0883');
INSERT INTO "icare"."city" VALUES ('273', '25', '', '楚雄彝族自治州', '', '0878');
INSERT INTO "icare"."city" VALUES ('274', '25', '', '红河哈尼族彝族自治州', '', '0873');
INSERT INTO "icare"."city" VALUES ('275', '25', '', '文山壮族苗族自治州', '', '0876');
INSERT INTO "icare"."city" VALUES ('276', '25', '', '西双版纳傣族自治州', '', '0691');
INSERT INTO "icare"."city" VALUES ('277', '25', '', '大理白族自治州', '', '0872');
INSERT INTO "icare"."city" VALUES ('278', '25', '', '德宏傣族景颇族自治州', '', '0692');
INSERT INTO "icare"."city" VALUES ('279', '25', '', '怒江傈僳族自治州', '', '0886');
INSERT INTO "icare"."city" VALUES ('280', '25', '', '迪庆藏族自治州', '', '0887');
INSERT INTO "icare"."city" VALUES ('281', '26', '', '拉萨市', '', '0891');
INSERT INTO "icare"."city" VALUES ('282', '26', '', '昌都地区', '', '0895');
INSERT INTO "icare"."city" VALUES ('283', '26', '', '山南地区', '', '0893');
INSERT INTO "icare"."city" VALUES ('284', '26', '', '日喀则地区', '', '0892');
INSERT INTO "icare"."city" VALUES ('285', '26', '', '那曲地区', '', '0896');
INSERT INTO "icare"."city" VALUES ('286', '26', '', '阿里地区', '', '0897');
INSERT INTO "icare"."city" VALUES ('287', '26', '', '林芝地区', '', '0894');
INSERT INTO "icare"."city" VALUES ('288', '27', '', '西安市', '', '0029');
INSERT INTO "icare"."city" VALUES ('289', '27', '', '铜川市', '', '0919');
INSERT INTO "icare"."city" VALUES ('290', '27', '', '宝鸡市', '', '0917');
INSERT INTO "icare"."city" VALUES ('291', '27', '', '咸阳市', '', '0029');
INSERT INTO "icare"."city" VALUES ('292', '27', '', '渭南市', '', '0913');
INSERT INTO "icare"."city" VALUES ('293', '27', '', '延安市', '', '0911');
INSERT INTO "icare"."city" VALUES ('294', '27', '', '汉中市', '', '0916');
INSERT INTO "icare"."city" VALUES ('295', '27', '', '榆林市', '', '0912');
INSERT INTO "icare"."city" VALUES ('296', '27', '', '安康市', '', '0915');
INSERT INTO "icare"."city" VALUES ('297', '27', '', '商洛市', '', '0914');
INSERT INTO "icare"."city" VALUES ('298', '28', '', '兰州市', '', '0931');
INSERT INTO "icare"."city" VALUES ('299', '28', '', '嘉峪关市', '', '0937');
INSERT INTO "icare"."city" VALUES ('300', '28', '', '金昌市', '', '0935');
INSERT INTO "icare"."city" VALUES ('301', '28', '', '白银市', '', '0943');
INSERT INTO "icare"."city" VALUES ('302', '28', '', '天水市', '', '0938');
INSERT INTO "icare"."city" VALUES ('303', '28', '', '武威市', '', '0935');
INSERT INTO "icare"."city" VALUES ('304', '28', '', '张掖市', '', '0936');
INSERT INTO "icare"."city" VALUES ('305', '28', '', '平凉市', '', '0933');
INSERT INTO "icare"."city" VALUES ('306', '28', '', '酒泉市', '', '0937');
INSERT INTO "icare"."city" VALUES ('307', '28', '', '庆阳市', '', '0934');
INSERT INTO "icare"."city" VALUES ('308', '28', '', '定西市', '', '0932');
INSERT INTO "icare"."city" VALUES ('309', '28', '', '陇南市', '', '0939');
INSERT INTO "icare"."city" VALUES ('310', '28', '', '临夏回族自治州', '', '0930');
INSERT INTO "icare"."city" VALUES ('311', '28', '', '甘南藏族自治州', '', '0941');
INSERT INTO "icare"."city" VALUES ('312', '29', '', '西宁市', '', '0971');
INSERT INTO "icare"."city" VALUES ('313', '29', '', '海东地区', '', '0972');
INSERT INTO "icare"."city" VALUES ('314', '29', '', '海北藏族自治州', '', '0970');
INSERT INTO "icare"."city" VALUES ('315', '29', '', '黄南藏族自治州', '', '0973');
INSERT INTO "icare"."city" VALUES ('316', '29', '', '海南藏族自治州', '', '0974');
INSERT INTO "icare"."city" VALUES ('317', '29', '', '果洛藏族自治州', '', '0975');
INSERT INTO "icare"."city" VALUES ('318', '29', '', '玉树藏族自治州', '', '0976');
INSERT INTO "icare"."city" VALUES ('319', '29', '', '海西蒙古族藏族自治州', '', '0977');
INSERT INTO "icare"."city" VALUES ('320', '30', '', '银川市', '', '0951');
INSERT INTO "icare"."city" VALUES ('321', '30', '', '石嘴山市', '', '0952');
INSERT INTO "icare"."city" VALUES ('322', '30', '', '吴忠市', '', '0953');
INSERT INTO "icare"."city" VALUES ('323', '30', '', '固原市', '', '0954');
INSERT INTO "icare"."city" VALUES ('324', '30', '', '中卫市', '', '0955');
INSERT INTO "icare"."city" VALUES ('325', '31', '', '乌鲁木齐市', '', '0991');
INSERT INTO "icare"."city" VALUES ('326', '31', '', '克拉玛依市', '', '0990');
INSERT INTO "icare"."city" VALUES ('327', '31', '', '吐鲁番地区', '', '0995');
INSERT INTO "icare"."city" VALUES ('328', '31', '', '哈密地区', '', '0902');
INSERT INTO "icare"."city" VALUES ('329', '31', '', '昌吉回族自治州', '', '0994');
INSERT INTO "icare"."city" VALUES ('330', '31', '', '博尔塔拉蒙古自治州', '', '0909');
INSERT INTO "icare"."city" VALUES ('331', '31', '', '巴音郭楞蒙古自治州', '', '0996');
INSERT INTO "icare"."city" VALUES ('332', '31', '', '阿克苏地区', '', '0997');
INSERT INTO "icare"."city" VALUES ('333', '31', '', '克孜勒苏柯尔克孜自治州', '', '0908');
INSERT INTO "icare"."city" VALUES ('334', '31', '', '喀什地区', '', '0998');
INSERT INTO "icare"."city" VALUES ('335', '31', '', '和田地区', '', '0903');
INSERT INTO "icare"."city" VALUES ('336', '31', '', '伊犁哈萨克自治州', '', '0999');
INSERT INTO "icare"."city" VALUES ('337', '31', '', '塔城地区', '', '0901');
INSERT INTO "icare"."city" VALUES ('338', '31', '', '阿勒泰地区', '', '0906');
INSERT INTO "icare"."city" VALUES ('339', '31', '', '石河子市', '', '0993');
INSERT INTO "icare"."city" VALUES ('340', '31', '', '阿拉尔市', '', '0997');
INSERT INTO "icare"."city" VALUES ('341', '31', '', '图木舒克市', '', '0998');
INSERT INTO "icare"."city" VALUES ('342', '31', '', '五家渠市', '', '0994');
INSERT INTO "icare"."city" VALUES ('343', '32', '', '香港', '', '1852');
INSERT INTO "icare"."city" VALUES ('344', '33', '', '澳门', '', '1853');
INSERT INTO "icare"."city" VALUES ('345', '11', '', '桐乡市', '', '0573');
INSERT INTO "icare"."city" VALUES ('346', '10', '', '金华市', '', '0579');
INSERT INTO "icare"."city" VALUES ('347', '16', '', '长葛市', '', '0374');
INSERT INTO "icare"."city" VALUES ('348', '10', '', '太仓市', '', '0512');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table city
-- ----------------------------
ALTER TABLE "icare"."city" ADD PRIMARY KEY ("id");

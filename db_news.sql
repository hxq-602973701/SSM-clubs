/*
Navicat MySQL Data Transfer

Source Server         : mine
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : db_news

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-03-18 18:41:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', '1', '1', '100');
INSERT INTO `employees` VALUES ('2', '1', '1', '200');
INSERT INTO `employees` VALUES ('3', '2', '1', '200');
INSERT INTO `employees` VALUES ('4', '2', '1', '300');
INSERT INTO `employees` VALUES ('5', '3', '2', '1000');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `newsId` int(11) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `userIP` varchar(40) DEFAULT NULL,
  `commentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('11', '104', 'da', '127.0.0.1', '2014-05-12 08:44:45');
INSERT INTO `t_comment` VALUES ('13', '103', '上单', '127.0.0.1', '2016-12-17 15:13:28');
INSERT INTO `t_comment` VALUES ('14', '51', '碉堡了', '127.0.0.1', '2016-12-22 23:31:19');
INSERT INTO `t_comment` VALUES ('15', '51', '碉堡了', '127.0.0.1', '2016-12-22 23:31:19');
INSERT INTO `t_comment` VALUES ('16', '51', '很强势', '127.0.0.1', '2016-12-22 23:32:18');
INSERT INTO `t_comment` VALUES ('17', '51', '可以', '127.0.0.1', '2016-12-22 23:33:45');
INSERT INTO `t_comment` VALUES ('18', '51', '卧槽', '127.0.0.1', '2016-12-22 23:37:41');
INSERT INTO `t_comment` VALUES ('19', '51', '尼玛', '127.0.0.1', '2016-12-22 23:38:17');
INSERT INTO `t_comment` VALUES ('20', '50', '是打算', '127.0.0.1', '2016-12-22 23:44:06');
INSERT INTO `t_comment` VALUES ('21', '102', 'sdsa', '127.0.0.1', '2017-03-15 22:15:23');
INSERT INTO `t_comment` VALUES ('22', '73', '我也要去，你们等我', '127.0.0.1', '2017-03-25 20:19:01');
INSERT INTO `t_comment` VALUES ('23', '73', '我不怕', '127.0.0.0', '2017-03-25 20:19:38');
INSERT INTO `t_comment` VALUES ('24', '73', '楼上评论亮了', '1207.0.0.1', '2017-03-25 20:20:00');
INSERT INTO `t_comment` VALUES ('25', '128', 'sad ', '127.0.0.1', '2017-03-29 19:52:08');
INSERT INTO `t_comment` VALUES ('26', '128', '???', '127.0.0.1', '2017-03-29 19:52:13');
INSERT INTO `t_comment` VALUES ('27', '128', '??', '127.0.0.1', '2017-03-29 20:01:33');
INSERT INTO `t_comment` VALUES ('28', '103', '??', '127.0.0.1', '2017-03-29 20:06:28');
INSERT INTO `t_comment` VALUES ('29', '103', '??????ikbilb464646846', '127.0.0.1', '2017-03-29 20:06:47');
INSERT INTO `t_comment` VALUES ('30', '113', 'sdassashdaj???????', '127.0.0.1', '2017-03-29 20:11:12');
INSERT INTO `t_comment` VALUES ('31', '103', '???', '127.0.0.1', '2017-03-29 20:13:26');
INSERT INTO `t_comment` VALUES ('32', '113', '??', '127.0.0.1', '2017-04-01 17:06:23');
INSERT INTO `t_comment` VALUES ('33', '113', '???', '127.0.0.1', '2017-04-01 17:13:24');
INSERT INTO `t_comment` VALUES ('34', '113', '什么鬼', '127.0.0.1', '2017-04-01 17:21:01');
INSERT INTO `t_comment` VALUES ('35', '113', '你是', '127.0.0.1', '2017-04-18 19:29:33');

-- ----------------------------
-- Table structure for t_leave
-- ----------------------------
DROP TABLE IF EXISTS `t_leave`;
CREATE TABLE `t_leave` (
  `leave_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `leave_title` varchar(20) DEFAULT NULL,
  `leave_content` varchar(20) DEFAULT NULL,
  `del_flag` bigint(20) DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  `user_ip` varbinary(20) DEFAULT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_leave
-- ----------------------------
INSERT INTO `t_leave` VALUES ('32', '', 'fsdfsdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('33', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('34', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('35', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('36', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('37', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('38', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('39', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('40', '', 'sdfsdfsdf', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('41', null, '', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('42', null, '', '0', '2017-03-17', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('43', null, 'dfds', '0', '2017-03-23', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('44', null, '??', '0', '2017-04-01', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('45', null, '???', '0', '2017-04-01', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('46', null, '你好啊', '0', '2017-04-01', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('47', null, '这是李艳', '0', '2017-04-18', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('48', null, '这是', '0', '2017-04-18', 0x3132372E302E302E31);
INSERT INTO `t_leave` VALUES ('49', null, '必可', '0', '2017-04-18', 0x3132372E302E302E31);

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(20) DEFAULT NULL,
  `linkUrl` varchar(40) DEFAULT NULL,
  `linkEmail` varchar(40) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_link
-- ----------------------------
INSERT INTO `t_link` VALUES ('1', 'Java1234', 'http://www.java1234.com', '527085608@qq.com', '2');
INSERT INTO `t_link` VALUES ('2', '百度', 'http://www.baidu.com', null, '1');
INSERT INTO `t_link` VALUES ('3', 'CSDN', 'http://www.csdn.com', null, '3');
INSERT INTO `t_link` VALUES ('14', '开源中国', 'http://www.oschina.net', '123@qq.com', '1');
INSERT INTO `t_link` VALUES ('19', '亚洲车友俱乐部', '666', '666', '8989');
INSERT INTO `t_link` VALUES ('20', '杭州车友俱乐部', '666', '666', '6');
INSERT INTO `t_link` VALUES ('21', '学科网', '666', '666', '6');
INSERT INTO `t_link` VALUES ('22', '南阳理工学院', '7', '7', '7');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) DEFAULT NULL,
  `content` text,
  `publishDate` datetime DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `click` int(11) DEFAULT NULL,
  `isHead` tinyint(4) DEFAULT NULL,
  `isImage` tinyint(4) DEFAULT NULL,
  `imageName` varchar(20) DEFAULT NULL,
  `isHot` tinyint(4) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`newsId`),
  KEY `FK_t_news` (`typeId`),
  CONSTRAINT `FK_t_news` FOREIGN KEY (`typeId`) REFERENCES `t_newstype` (`newsTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('49', '2133啊', '2133444我', '2014-03-04 17:23:44', '213344', '3', '7', '1', '1', '1.jpg', '1', null);
INSERT INTO `t_news` VALUES ('50', '汪峰是KIng', '<p>不知不觉在百度百家写了很多东西了，多得都吓到自己了，主要是一路写到现在，仍然是文笔幼稚、面目可憎，阿弥陀佛，善哉善哉。</p>\r\n\r\n<p>处于多年的媒体习惯，写东西对我来说不仅仅是满足一己私欲，同时也想借此了解一下网友们口味，美其名曰趋势、指数、习惯。而在这个过程中我真的发现了一点什么。往下看。（括号里为阅读量）</p>\r\n', '2014-03-13 15:17:07', '李白啊', '1', '14', '0', '1', '2.jpg', '1', '1');
INSERT INTO `t_news` VALUES ('51', '马来西亚巫师作法再寻失联飞机：这次更奇葩', '马航客机MH370失联已经进入第六天了，但搜寻依然没有取得突破性的进展。<br />\r\n此前曾有报道称为了搜寻失联的马航客机，马来西亚不惜用尽各种方法，只要不违反伊斯兰教教义，欢迎任何人参与搜索行动，甚至连马来巫师也不例外。<br />\r\n著名马来巫师伊布拉欣马今（IbrahimMatZin）曾于前日前往吉隆坡国际机场，以透过灵异力量寻找失踪飞机所在位置。他在吉隆坡国际机场入口处祈祷后表示有两种感觉，即飞机还在空中飞或已坠海，但不会坠落在陆地上。<br />\r\n随而昨天，伊布拉欣马今在吉隆坡机场继续做法，这次的道具更加奇葩，除了专门的&ldquo;法器&rdquo;之外还动用了两个椰子，但报道中并未提及这次的结果如何，不知道这次大师会得出什么结论。<br />\r\n<img alt=\"\" src=\"userImage/20140313065252.jpg\" /><br />\r\n<img alt=\"\" src=\"userImage/20140313065421.jpg\" /><br />\r\n<img alt=\"\" src=\"userImage/20140313065432.jpg\" /><br />\r\n<img alt=\"\" src=\"userImage/20140313065443.jpg\" /><br />\r\n<img alt=\"\" src=\"userImage/20140313065452.jpg\" /><br />\r\n&nbsp;', '2014-03-13 18:54:57', 'v', '2', '37', '1', '1', '3.jpg', '1', null);
INSERT INTO `t_news` VALUES ('52', '25号有一起去马栏山的么', '25号有一起去马栏山的么', '2014-03-13 20:41:24', '李白啊', '1', '12', '0', '1', '4.jpg', '1', '1');
INSERT INTO `t_news` VALUES ('53', '听说汪峰又上头条了', '听说汪峰又上头条了', '2014-03-13 20:41:58', '李白啊', '1', '18', '0', '0', null, '1', '1');
INSERT INTO `t_news` VALUES ('64', '车友八卦', '车友八卦', '2014-03-13 21:18:17', '李白啊', '1', '16', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('65', '李白和白居易的故事', '李白和白居易的故事', '2014-03-13 21:18:17', '李白啊', '1', '0', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('66', '秋名山车神李清照', '秋名山车神李清照', '2014-03-13 21:18:17', '小锋', '1', '1', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('67', '八卦主播杜甫', '八卦主播杜甫', '2014-03-13 21:18:17', '李白啊', '1', '0', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('68', '娱乐新闻7', '娱乐新闻7', '2014-03-13 21:18:17', '李白啊', '1', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('69', '娱乐新闻8', '娱乐新闻8', '2014-03-13 21:18:17', '李白啊', '1', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('71', '政治新闻2', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '6', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('72', '政治新闻3', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('73', '南阳市李女士要卖车，竟然是为了？', '最近，绍兴一女士在朋友圈发消息，希望能募捐30万救患3年白血病的女儿。有网友发现，该女士曾开奔驰秀钻戒家境殷实。对此该女士丈夫回应：目前车卖了房子做抵押，已募集了26万但还不够，\r\n女儿生病不代表老婆就得穿10块钱一件的衣服。车友们来说说如果是你，你会捐钱吗? \r\n这些年，随着经济条件越来越好，农村出现了一大批“有车族”。最近某新闻的者采访发现，在一些地区的年青一代，他们挣钱后最热衷的一是建房、二是买车。还有不少人，为了买车是负债累累，并非真富裕，只是为了互相攀比争脸面。车友们对此现象你怎么看？为攀比欠款买车，是真有面吗？ \r\n\r\n众所周知，违章停车贴条就要交罚款。可最近在北京街头，一奥迪A4车主为了躲避罚单，就出了一“奇招”，让人不得不佩服车主丰富的想象力。车牌居然用两块铁皮做了个车牌盒，还用黄色小锁锁上了。如此奇葩的车牌盒挡车牌，小编还第一次见。只想说，车主你觉得这想法靠谱吗？', '2014-03-13 22:13:56', '李白啊', '2', '19', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('74', '政治新闻5', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('75', '政治新闻6', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '2', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('76', '政治新闻7', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('77', '政治新闻8', '政治新闻8', '2014-03-13 22:13:56', '李白啊', '2', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('78', '经济新闻1', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '7', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('79', '这也是一条最新的', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '14', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('80', '这是一条最新的', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '6', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('81', '经济新闻4', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('82', '经济新闻5', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('83', '经济新闻6', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('84', '经济新闻7', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('85', '经济新闻8', '经济新闻8', '2014-03-13 22:14:56', '李白啊', '3', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('86', '最近更新新闻1', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '6', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('87', '文化新闻4', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('88', '文化新闻4', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('89', '文化新闻4', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('90', '文化新闻5', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '4', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('91', '文化新闻6', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('92', '文化新闻7', '文化新闻8', '2014-03-13 22:20:38', '李白啊', '4', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('93', '文化新闻8', '文化新闻8', '2014-03-13 22:20:38', '小锋', '4', '0', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('94', '小道新闻1', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '2', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('95', '测试最新啊', '小道新闻8', '2014-03-13 22:21:03', 'v', '5', '7', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('96', '测试最新', '小道新闻8', '2014-03-13 22:21:03', 'v李白啊', '5', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('97', '萨达', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('98', '最近更新新闻2', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('99', '小道新闻6', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '2', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('100', '小道新闻7', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '1', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('101', '小道新闻8', '小道新闻8', '2014-03-13 22:21:03', '李白啊', '5', '2', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('102', '南阳市骑行集锦', '<p>&nbsp;</p>\r\n<img alt=\"西安幼儿园被指近3年都给孩子吃过药\" src=\"http://img1.gtimg.com/news/pics/hv1/5/34/1542/100277225.jpg\" />\r\n<p>&nbsp;</p>\r\n\r\n<p>一名家长情绪激动</p>\r\n\r\n<p>&nbsp;</p>\r\n<img alt=\"西安幼儿园被指近3年都给孩子吃过药\" src=\"http://img1.gtimg.com/news/pics/hv1/8/34/1542/100277228.jpg\" />\r\n<p>&nbsp;</p>\r\n\r\n<p>家长在幼儿园墙上写下愤怒的语言</p>\r\n\r\n<p>&nbsp;</p>\r\n<img alt=\"西安幼儿园被指近3年都给孩子吃过药\" src=\"http://img1.gtimg.com/news/pics/hv1/6/34/1542/100277226.jpg\" />\r\n<p>&nbsp;</p>\r\n\r\n<p>涉事的幼儿园</p>\r\n\r\n<p>&nbsp;</p>\r\n<img alt=\"西安幼儿园被指近3年都给孩子吃过药\" src=\"http://img1.gtimg.com/news/pics/hv1/7/34/1542/100277227.jpg\" />\r\n<p>&nbsp;</p>\r\n\r\n<p>病毒灵</p>\r\n\r\n<p>西安一家幼儿园被曝在未告知家长的情况下，长期给园内幼儿集体服用抗病毒药物&ldquo;病毒灵&rdquo;。不少孩子被发现存在头晕、腿疼、肚子疼等相同症状，引发众多家长的强烈不满。</p>\r\n\r\n<p>目前，西安市相关部门已开始调查并进行紧急处置，幼儿园园长及相关人员已被警方控制，但关于此事的诸多疑点仍有待解开。</p>\r\n\r\n<p>幼儿园从何时开始给孩子集体服药？给孩子服药出于什么目的？服用这种药物会带来什么样的副作用？西安市有关部门12日对记者称，对于这些问题暂时没有详细的调查结论可以提供。</p>\r\n\r\n<p>□综合新华社电、《华商报》、《<a href=\"http://t.qq.com/xmzkarts#pref=qqcom.keyword\" target=\"_blank\">新民周刊</a>》</p>\r\n\r\n<p><strong>事件 幼儿园私自给幼儿服用&ldquo;病毒灵&rdquo;</strong></p>\r\n\r\n<p>陕西省宋庆龄基金会枫韵幼儿园位于西安市高新区风韵蓝湾小区内，共有690名幼儿。根据家长们的介绍，2007年，幼儿园开园，法人代表孙雪红，院长为赵宝英。</p>\r\n\r\n<p>从2014年3月初开始，陆续有家长发现自己的孩子在幼儿园服用了不明药物。个别有心的家长让孩子将所服的药物带回家中，发现白色药片上面写着&ldquo;ABOB&rdquo;字样，查询后才知道这是一种俗称&ldquo;病毒灵&rdquo;的抗病毒药物。</p>\r\n\r\n<p>根据药物说明，这种药物用于流感病毒及疱疹病毒感染，其不良反应可引起出汗、食欲不振及低血糖等。</p>\r\n\r\n<p>有家长获悉，1999年12月11日国家药监局对地方标准的病毒灵公布停用，理由是效果不确切。还有家长获悉，&ldquo;盐酸吗啉胍片&rdquo;用于小白鼠实验出现小白鼠后代畸形的现象，这更加剧了家长们的担心。</p>\r\n\r\n<p>3月10日，有家长通过微博反映了这一情况，引起众多家长的关注和不满。11日，数十名家长聚集在幼儿园讨要说法，并一度将幼儿园周边道路围堵。</p>\r\n\r\n<p>3月12日上午，记者来到枫韵幼儿园，这里的小操场上正在举行西安市有关部门与家长的沟通会。记者在现场看到，幼儿园多个教室凌乱不堪，医务室内一片狼藉，遍地都是各种文件资料。参加沟通会的许多家长情绪激动，有的人还当场流下眼泪，情绪激动地要求政府部门加大力度处理此事。</p>\r\n\r\n<p><strong>反应 一些男孩子下身红肿、尿不出</strong></p>\r\n\r\n<p>当枫韵幼儿园给幼儿集体服药的秘密被意外发现后，数百名家长闹开了，昌女士这才发现原来自己孩子的症状在这所幼儿园的幼儿中间非常普遍。</p>\r\n\r\n<p>因为给幼儿集体服药的丑闻曝光，3月11日，枫韵幼儿园陷入了瘫痪，家长们集体罢课，并围堵在校门口讨要说法，个别家长因情绪激动围堵附近的道路，被警方带离。</p>\r\n\r\n<p>一位女家长说起这件事情绪激动:&ldquo;千挑万选给孩子找了这家幼儿园，怎么能想到会出这种事情!&rdquo;这位家长说，她的孩子曾说过膝盖疼、腿疼，半夜能疼醒，她觉得肯定是孩子白天跑累了，孩子说肚子疼不想上学，她骂孩子偷懒，以为是孩子不想上学的借口，她没想到，这或许是孩子服药出现的副作用。说到这里，现场十几名家长哭成一片。</p>\r\n\r\n<p>家长们总结了孩子出现的趋同性不良反应:长期便秘、肚子疼、腿疼、出汗、食欲不振。一位家长现场带来了刚刚给孩子做完的体检报告，6岁的孩子被查出肾积水，家长也怀疑是否和服药有关。</p>\r\n\r\n<p><strong>调查 幼儿园近3年都给孩子吃过药</strong></p>\r\n\r\n<p>目前，西安市教育局、食药监局、卫生局、公安局等有关单位组成处置工作小组，进驻幼儿园调查此事。幼儿园业务园长赵宝英、后勤副园长兼保健医生黄林侠被调查人员问话。</p>\r\n\r\n<p>孩子在幼儿园到底吃了多少&ldquo;病毒灵&rdquo;?枫韵幼儿园法人代表孙雪红表示，2012年确实给幼儿吃过&ldquo;病毒灵&rdquo;，当时是禽流感高发期，但在2013年，幼儿园开园务会议时，她明确提出，禽流感已过，必须禁止继续使用&ldquo;病毒灵&rdquo;，没想到，今年保健医生再次给孩子用了这个药。</p>\r\n\r\n<p>3月11日，有家长在幼儿园的医务室找到的几张用药记录显示，2013年3月6日、7日，3月13日、14日、15日，幼儿园给小班、中班和大班的孩子集体服用&ldquo;病毒灵&rdquo;。还有2014年的服药记录，分别是2月13日、14日，3月5日、6日、7日。但幼儿园到底给孩子们服药多长时间，调查组还在调查。</p>\r\n\r\n<p><strong>各方回应</strong></p>\r\n\r\n<p><strong>官方:幼儿服用的&ldquo;病毒灵&rdquo;毒性小</strong></p>\r\n\r\n<p>记者从西安市政府了解到，西安市卫生局组织多家医院的药剂科、神经内科、感染科、呼吸科专家，对枫韵幼儿园给在园儿童服用药品的适应症、禁忌症、疗效、毒副作用等方面进行讨论。</p>\r\n\r\n<p>经专家讨论认为:一是枫韵幼儿园使用的病毒灵为国药准字号药物，药品在有效期内，有儿童服用剂量说明INSERT INTO t_news VALUES(10mg/kg)，为处方用药;二是经讨论及查阅相关文献，预防性用药效果不明显;三是&ldquo;病毒灵&rdquo;的不良反应可引起出汗、食欲不振及低血糖等反应，查阅此药的相关文献及资料，未见其他不良反应;四是在服药方面，日服用量未超过说明书的剂量，单次剂量仅小班孩子略微超量，且服用时间为2-3天，未长时间服用，引起蓄积毒副作用的可能性较小;五是如出现不适症状，建议医学观察。</p>\r\n\r\n<p><strong>家长:专家作出的结论过于草率</strong></p>\r\n\r\n<p>但接受记者采访的多位家长对上述结论并不认可。在3月12日举行的沟通会上，许多家长提出政府部门组织专家作出的结论过于草率，药物对孩子身体是否造成长期性损害不能轻易下结论。一些家长甚至提出在政府出资的情况下自行带孩子进行独立检查，以确定孩子的身体状况。</p>\r\n\r\n<p>对于幼儿园给孩子服药的目的，虽然官方尚无定论，但许多家长有着自己的看法。</p>\r\n\r\n<p>一些家长告诉记者，枫韵幼儿园是一所民办幼儿园，每月收费1100元到1200元左右。按照收费办法，如果幼儿缺勤幼儿园就要给家长退费。如超过十天缺勤，就要退一半的托费。园方为了确保孩子不生病，保证幼儿出勤率，才会给孩子服用这种抗病毒药物。</p>\r\n\r\n<p><strong>事件追问</strong></p>\r\n\r\n<p><strong>幼儿园的1万粒药从哪来的?</strong></p>\r\n\r\n<p>关于药物来源，西安市食品药品监督管理局药品稽查分局负责人表示，3月10日晚，接家长举报后，稽查人员在幼儿园保健室发现一瓶&ldquo;病毒灵&rdquo;，里面只有3粒，当场对药品进行查封，在检查中还发现一张幼儿园购进药品的票据，显示该药是在西安一家药品批发企业批发的，该企业有资质，幼儿园一次批发100瓶，也就是1万粒。</p>\r\n\r\n<p>那么，孩子们服用的药品本身是否安全?该人士表示，多部门对市内一些零售药店里的&ldquo;病毒灵&rdquo;进行了检查，没有发现与幼儿园内同一批次的药，目前在甘肃天水市找到同一批次的&ldquo;病毒灵&rdquo;，正联系对方向西安发货。药品稽查分局收到该药后，将第一时间送往西安市食品药品检验所检验。</p>\r\n\r\n<p><strong>保健医生可以开处方药吗?</strong></p>\r\n\r\n<p>事发后，枫韵幼儿园后勤副园长兼保健医生黄林侠被警方控制。该幼儿园法人代表接受采访时表示，幼儿园的保健医生是有医师资格证的。</p>\r\n\r\n<p>经查，黄林侠目前只能提供一张广东省发的医师资格证的复印件，但按照规定，从业医师必须在从业机构所在地的卫生部门注册后，才有医师资格。据查，黄林侠并没有在雁塔区注册，所以，黄林侠没有给幼儿开处方药的资质，而&ldquo;病毒灵&rdquo;就属于处方药。</p>\r\n\r\n<p>3月10日，不需要任何处方等凭证，记者在含光北路一家药店轻松购买了一瓶&ldquo;病毒灵&rdquo;，处方药是否一定要凭处方购买呢?西安交大二附院儿科教授侯伟表示，按照规定，处方药必须凭借医生处方去药店或医院购买，但在实际中，药店执行不严格，没有处方也能买到处方药。</p>\r\n', '2014-03-13 23:00:11', '李白啊', '5', '31', '0', '1', '1.jpg', '1', '1');
INSERT INTO `t_news` VALUES ('103', '南阳市骑行集锦', '<img alt=\"\" src=\"userImage/20140313111425.jpg\" /><br />\r\n<br />\r\n　3月1日晚拍摄的昆明火车站一售票大厅外散落的行李INSERT INTO t_news VALUES(手机拍摄)。3月1日晚9时20分，10余名统一着装的暴徒蒙面持刀在云南昆明火车站广场、售票厅等处砍杀无辜群众，截至3月2日1时，暴力案件已造成28名群众遇难、113名群众受伤。公安干警当场击毙5名暴徒，其余暴徒仍在围捕中。新华社记者蔺以光摄<br />\r\n<br />\r\n　　昆明火车站暴力恐怖事件直击<br />\r\n<br />\r\n　　新华网北京３月２日新媒体专电INSERT INTO t_news VALUES(新华社&ldquo;中国网事&rdquo;记者)３月１日晚９时２０分，１０余名统一着装的暴徒蒙面持刀在云南昆明火车站广场、售票厅等处砍杀无辜群众，截至３月２日１时，暴力案件已造成２８名群众遇难、１１３名群众受伤。公安干警当场击毙５名暴徒，其余暴徒仍在围捕中。<br />\r\n<br />\r\n　　云南省政法委认为，这是一起有组织、有计划、严重暴力恐怖袭击事件，性质极其恶劣，并对后续工作进行迅速安排。<br />\r\n<br />\r\n　　暴徒如此残忍，竟在人群密集的车站持刀肆意砍杀无辜群众。人们不禁要问：这些人为什么要这样心狠？<br />\r\n&nbsp;', '2014-03-13 23:14:48', '李白啊', '5', '28', '0', '1', '3.jpg', '1', '1');
INSERT INTO `t_news` VALUES ('104', '南阳市骑行集锦', '<img alt=\"\" src=\"userImage/20140314090311.jpg\" style=\"height:338px; width:400px\" /><br />\r\n&nbsp;\r\n<p>　<a href=\"http://www.chinanews.com/\" target=\"_blank\">中新网</a>3月13日电 据香港《文汇报》报道，香港牛头角彩盈鸷发生店铺盗窃案，3名少年男女昨INSERT INTO t_news VALUES(12日)午进入该鸷商场一间便利店，涉嫌扮顾客购物，乘机偷取包括三文治和朱古力饮料等零食，夺门逃走时被职员揭发，警员到场将他们拘捕带署扣查。</p>\r\n\r\n<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n	<tbody>\r\n		<tr>\r\n			<td>&nbsp;</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>　　事发昨下午3时许，一名10余岁少年与2名分别穿热裤和短裙、年龄相若的少女，一同走进彩盈鸷商场一间便利店，在货架和雪柜旁徘徊状似选购货物，其间有人涉嫌从货架和雪柜中偷取包括三文治、花生和纸包朱古力饮品等零食，并收藏在衫袋内欲走向店门离开。但该店职员见他们形迹可疑，早已从旁暗中监视，随即将他们截停以及报警求助。</p>\r\n\r\n<p>　　警员接报迅速赶至调查，怀疑3名少年男女涉嫌店铺盗窃，并当场起出赃物，于是将3人拘捕，其间该名少年一度试图发难突围逃走，但终被警员制服，与其余2名少女一并被带署扣查。2</p>\r\n', '2014-03-14 09:03:35', '李白啊', '1', '55', '1', '1', '2.jpg', '1', null);
INSERT INTO `t_news` VALUES ('105', '南阳市骑行集锦', '是是', '2014-03-14 09:07:38', '李白啊', '6', '6', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('106', '南阳市骑行集锦', '<p>500万好啊</p>\r\n', '2014-05-22 08:57:49', 'cc', '3', '9', '1', '1', '4.jpg', '1', null);
INSERT INTO `t_news` VALUES ('107', '南阳市骑行集锦', '<p>dasfads</p>\r\n\r\n<p>dsa<img alt=\"\" src=\"userImage/20140522090035.jpg\" style=\"height:431px; width:500px\" /></p>\r\n', '2014-05-22 09:00:54', 'fda', '1', '6', '0', '1', '5.jpg', '0', null);
INSERT INTO `t_news` VALUES ('108', '南阳市骑行集锦', '<p>222</p>\r\n', '2014-05-26 07:36:31', '2222', '1', '3', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('109', '南阳市骑行集锦', '<p>2</p>\r\n', '2014-05-28 07:44:13', '2', '1', '4', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('110', '南阳市骑行集锦', '<p>3</p>\r\n', '2014-05-28 07:50:58', '3', '1', '27', '0', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('111', '骆家庄租房', '<p>骆家庄真的大</p>\r\n', '2017-02-14 21:38:04', '胡云飞', '6', '0', '0', '1', '20170214093801.txt', '0', null);
INSERT INTO `t_news` VALUES ('112', '骆家庄租房', '<p>骆家庄真的大</p>\r\n', '2017-02-14 21:38:07', '胡云飞', '6', '1', '0', '1', '20170214093801.txt', '0', null);
INSERT INTO `t_news` VALUES ('113', '城城内外', '<p>销售方式撒方法</p>\r\n', '2017-02-14 21:53:27', '小青啊', '3', '35', '1', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('114', '33', '<p>3333333</p>\r\n', '2017-02-14 23:33:15', '333', '1', '0', '1', '0', null, '0', null);
INSERT INTO `t_news` VALUES ('115', '是是安全性，广泛应用于个人PC、数据中心22', '<p>Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。44</p>\r\n', '2017-02-14 23:35:18', '2222344', '3', '2', '1', '1', null, '1', null);
INSERT INTO `t_news` VALUES ('116', '是是安全性，广泛应用于个人PC、数据中心4444', '<p>Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。</p>\r\n', '2017-02-14 23:35:59', '222', '1', '0', '1', '1', null, '1', null);
INSERT INTO `t_news` VALUES ('117', '是是安全性，广泛应用于个人PC、数据中心6666', '<p>Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。</p>\r\n', '2017-02-14 23:39:31', '222', '1', '0', '1', '1', null, '1', null);
INSERT INTO `t_news` VALUES ('118', '汪峰是互联网上名副其实的King么', '<p>不知不觉在百度百家写了很多东西了，多得都吓到自己了，主要是一路写到现在，仍然是文笔幼稚、面目可憎，阿弥陀佛，善哉善哉。</p>\r\n\r\n<p>处于多年的媒体习惯，写东西对我来说不仅仅是满足一己私欲，同时也想借此了解一下网友们口味，美其名曰趋势、指数、习惯。而在这个过程中我真的发现了一点什么。往下看。（括号里为阅读量）</p>\r\n', '2017-02-14 23:41:53', '小锋', '1', '0', '0', '1', null, '1', null);
INSERT INTO `t_news` VALUES ('119', '是是安全性，广泛应用于个人PC、数据中心5', '<p>Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。</p>\r\n', '2017-02-14 23:43:42', '222', '1', '1', '1', '1', null, '1', null);
INSERT INTO `t_news` VALUES ('120', '5', '<p>5</p>\r\n', '2017-02-15 21:44:17', '5', '1', '2', '0', '1', '20170215094417.txt', '0', null);
INSERT INTO `t_news` VALUES ('121', '545454', '<p>fdafaafa</p>\r\n', '2017-02-15 21:58:14', '2344', '1', '3', '1', '1', '20170215095814.png', '0', null);
INSERT INTO `t_news` VALUES ('122', '胡云飞', '<p>胡云飞啊</p>\r\n', '2017-02-15 22:00:08', '胡云飞啊', '1', '4', '1', '1', '20170215100008.png', '0', null);
INSERT INTO `t_news` VALUES ('123', '礼拜', '<p>的所发生的</p>\r\n', '2017-02-15 22:05:56', '礼拜', '1', '1', '1', '1', '20170215100556.png', '0', null);
INSERT INTO `t_news` VALUES ('124', '真的强势', '<p>者十大</p>\r\n', '2017-02-15 22:11:31', '真的强势', '2', '4', '1', '1', '20170215101131.png', '0', null);
INSERT INTO `t_news` VALUES ('125', 'edweew', '<p>dfsddsf</p>\r\n', '2017-02-15 22:20:12', 'efcesf', '2', '3', '1', '1', '20170215102012.png', '0', null);
INSERT INTO `t_news` VALUES ('126', '这个测试图片上传', '<p>胡云歌二分法收发</p>\r\n', '2017-02-15 22:22:27', '胡云飞啊', '2', '5', '1', '1', '20170215102227.png', '0', null);
INSERT INTO `t_news` VALUES ('127', '这是一条测试审核新闻', '<p><img alt=\"cool\" src=\"http://localhost:8080/js/ckeditor/plugins/smiley/images/shades_smile.png\" style=\"height:23px; width:23px\" title=\"cool\" />你们好啊</p>\r\n', '2017-02-22 21:44:27', '胡云飞', '4', '15', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('128', '这是前台测试', '<p>你好，世界</p>\r\n', '2017-02-22 21:56:21', '礼拜', '6', '24', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('129', '12132', '<p>34353545</p>\r\n', '2017-02-22 22:25:13', '32434', '2', '0', '0', '0', null, '0', '0');
INSERT INTO `t_news` VALUES ('130', '32434', '<p>4545</p>\r\n', '2017-02-22 22:25:39', '3545', '1', '0', '0', '0', null, '0', '0');
INSERT INTO `t_news` VALUES ('131', '232', '<p>45454</p>\r\n', '2017-02-22 22:27:10', '343435', '1', '1', '0', '0', null, '0', '1');
INSERT INTO `t_news` VALUES ('132', '454', '<p>5656565</p>\r\n', '2017-02-22 22:29:43', '545', '1', '0', '0', '0', null, '0', '0');
INSERT INTO `t_news` VALUES ('133', '撒大声地', '<p><img alt=\"\" src=\"userImage/20170418092603.jpg\" style=\"height:960px; width:720px\" /></p>\r\n', '2017-04-18 09:27:03', '实打实大师', '1', '7', '0', '1', '20170418092703.jpg', '0', '1');
INSERT INTO `t_news` VALUES ('134', '是的撒', '<p>十大撒</p>\r\n', '2017-04-18 09:36:31', '萨达啊', '1', '0', '0', '0', null, '0', '0');
INSERT INTO `t_news` VALUES ('135', '南阳市2017年首届篮球发布会', '<p><img alt=\"\" src=\"userImage/20170418073118.jpg\" style=\"height:100px; width:178px\" />美丽的篮球场，好美啊</p>\r\n\r\n<h2 style=\"font-style:italic;\">他们是全国人民的骄傲</h2>\r\n', '2017-04-18 19:32:45', '胡云飞', '2', '1', '0', '1', '20170418073245.jpg', '0', '1');

-- ----------------------------
-- Table structure for t_newstype
-- ----------------------------
DROP TABLE IF EXISTS `t_newstype`;
CREATE TABLE `t_newstype` (
  `newsTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`newsTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_newstype
-- ----------------------------
INSERT INTO `t_newstype` VALUES ('1', '车友八卦');
INSERT INTO `t_newstype` VALUES ('2', '车友见闻');
INSERT INTO `t_newstype` VALUES ('3', '车友讨论');
INSERT INTO `t_newstype` VALUES ('4', '车友聚会');
INSERT INTO `t_newstype` VALUES ('5', '车友交流');
INSERT INTO `t_newstype` VALUES ('6', '车友二手交易');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'java1234', '123456', null);
INSERT INTO `t_user` VALUES ('4', 'java123', '123', 'ee@qq.com');
INSERT INTO `t_user` VALUES ('5', 'huyunfei', '123', '602943701@qq.com');

-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.5.8-MariaDB-log - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 platform 的数据库结构
CREATE DATABASE IF NOT EXISTS `platform` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `platform`;

-- 导出  表 platform.article 结构
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(50) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `sub_title` varchar(256) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  platform.article 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- 导出  表 platform.file_info 结构
CREATE TABLE IF NOT EXISTS `file_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(256) DEFAULT NULL,
  `pos` varchar(256) DEFAULT NULL,
  `file_type` varchar(32) DEFAULT NULL,
  `file_encrypt` int(11) NOT NULL DEFAULT 0,
  `file_password` varchar(32) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  platform.file_info 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;

-- 导出  表 platform.in_vul 结构
CREATE TABLE IF NOT EXISTS `in_vul` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `system_id` int(11) DEFAULT NULL COMMENT '系统名称',
  `title` varchar(256) NOT NULL DEFAULT '0',
  `serial_num` varchar(32) DEFAULT NULL,
  `vul_type` int(11) NOT NULL DEFAULT 0,
  `risk` int(11) NOT NULL DEFAULT 0 COMMENT '1 低 2 中 3高 4严重',
  `is_need_fix` int(11) NOT NULL DEFAULT 1 COMMENT '1 强制修复 2可以不修复',
  `url` mediumtext DEFAULT NULL,
  `content` mediumtext DEFAULT NULL,
  `affect` mediumtext DEFAULT NULL,
  `fix` mediumtext DEFAULT NULL,
  `mitigation` mediumtext DEFAULT NULL,
  `num` int(11) NOT NULL DEFAULT 0,
  `vul_status` int(11) NOT NULL DEFAULT 1 COMMENT '0删除 1暂存 2不发布 3内部发布 4公开发布',
  `fix_status` int(11) NOT NULL DEFAULT 1 COMMENT '1 待确认 2确认漏洞 3修复中 4等待复测 5等待发布 6修复完成 7缓解风险 8接受风险',
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `expect_time` datetime DEFAULT NULL,
  `fixed_time` datetime DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `security_user` int(11) DEFAULT NULL,
  `security_user_email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_invul_title` (`title`),
  KEY `index_invul_risk` (`risk`),
  KEY `index_invul_create_time` (`create_time`),
  KEY `index_invul_expect_time` (`expect_time`),
  KEY `index_invul_url` (`url`(1024)),
  KEY `index_invul_type` (`vul_type`) USING BTREE,
  KEY `fix_status` (`fix_status`),
  KEY `system_id` (`system_id`),
  KEY `index_invul_status` (`vul_status`) USING BTREE,
  KEY `security_user` (`security_user`),
  KEY `index_invul_cve` (`serial_num`) USING BTREE,
  CONSTRAINT `FK_invul_security_user_login_user_id` FOREIGN KEY (`security_user`) REFERENCES `login_user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_invul_system_id_system_info_id` FOREIGN KEY (`system_id`) REFERENCES `system_info` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_invul_vultype_id` FOREIGN KEY (`vul_type`) REFERENCES `vul_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  platform.in_vul 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `in_vul` DISABLE KEYS */;
INSERT INTO `in_vul` (`id`, `system_id`, `title`, `serial_num`, `vul_type`, `risk`, `is_need_fix`, `url`, `content`, `affect`, `fix`, `mitigation`, `num`, `vul_status`, `fix_status`, `create_time`, `expect_time`, `fixed_time`, `department`, `create_user`, `security_user`, `security_user_email`) VALUES
	(1, 1, 'SQL注入漏洞', 'vul-2022-1122', 3, 2, 1, 'www.test.com', 'dfaaaaaaa', 'dddsfad', 'fewfa', NULL, 14, 3, 1, '2021-12-10 13:45:30', NULL, NULL, 'IT', NULL, NULL, NULL),
	(2, 1, 'CSRF漏洞', 'vul-2022-3331', 4, 3, 1, 'www.test.com', 'dfaaaaaaa', 'dddsfad', 'fewfa', NULL, 211, 3, 2, '2021-12-18 09:32:43', NULL, NULL, 'IT', NULL, NULL, NULL),
	(3, 2, '水平越权', 'vul-2022-0012', 10, 4, 0, 'cdp-uat.test.com/aaa', 'dfaaaaaaa', 'dddsfad', 'fewfa', NULL, 0, 3, 3, '2022-05-09 09:32:43', NULL, NULL, '', NULL, NULL, NULL),
	(4, 3, '水平越权', 'vul-2022-8311', 10, 1, 1, 'vdp-uat.test.com/aaa', 'dfaaaaaaa', 'dddsfad', 'fewfa', NULL, 0, 3, 4, '2022-05-09 09:32:43', NULL, NULL, '', NULL, NULL, NULL);
/*!40000 ALTER TABLE `in_vul` ENABLE KEYS */;

-- 导出  表 platform.log 结构
CREATE TABLE IF NOT EXISTS `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_module` varchar(64) NOT NULL DEFAULT '0',
  `risk` int(11) NOT NULL DEFAULT 1 COMMENT '1常规 2风险',
  `log_type` int(11) NOT NULL DEFAULT 1 COMMENT '1增 2删 3改 4查',
  `result` int(11) NOT NULL DEFAULT 1 COMMENT '1成功 2失败',
  `msg` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `index_log_result` (`result`),
  KEY `index_log_risk` (`risk`),
  KEY `index_log_user_id` (`user_id`),
  KEY `type` (`log_type`) USING BTREE,
  KEY `module` (`log_module`) USING BTREE,
  CONSTRAINT `FK_log_user_id` FOREIGN KEY (`user_id`) REFERENCES `login_user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  platform.log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;

-- 导出  表 platform.login_user 结构
CREATE TABLE IF NOT EXISTS `login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '0',
  `password` varchar(64) NOT NULL DEFAULT '0',
  `mail` varchar(64) NOT NULL DEFAULT '0',
  `real_name` varchar(64) DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '0：废弃 1：可用',
  `dept` varchar(64) DEFAULT '0',
  `phone` varchar(16) DEFAULT '0',
  `user_auth` int(11) NOT NULL DEFAULT 0,
  `user_group` int(11) NOT NULL DEFAULT 0,
  `user_type` int(11) NOT NULL DEFAULT 0 COMMENT '用户类型：1：安全员 2：业务人员',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_user_mail` (`mail`),
  KEY `index_user_status` (`status`),
  KEY `username` (`username`),
  KEY `user_type` (`user_type`),
  KEY `index_user_auth` (`user_auth`) USING BTREE,
  KEY `group` (`user_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  platform.login_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` (`id`, `username`, `password`, `mail`, `real_name`, `status`, `dept`, `phone`, `user_auth`, `user_group`, `user_type`, `create_time`) VALUES
	(1, 'test', 'd183df4a9721fe6d1267fcf086a6f0cc0b7706df565eef5be59c6c7de075d1cf', 'test@test.com', '测试用户', 1, '0', '0', 0, 0, 1, '2018-03-09 11:17:46'),
	(2, 'security', '48c56f51f0d1d9dd0f807cbbbcd99de95d8aa9c06cc3ab548a44ce2807743b63', 'security@test.com', '安全小白', 1, '0', '0', 2, 0, 1, '2018-04-10 14:16:34');
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;

-- 导出  表 platform.notice 结构
CREATE TABLE IF NOT EXISTS `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(128) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `message` varchar(512) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  platform.notice 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;

-- 导出  表 platform.out_vul 结构
CREATE TABLE IF NOT EXISTS `out_vul` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `vul_type` int(11) DEFAULT NULL,
  `cve` varchar(32) DEFAULT NULL,
  `risk` int(11) NOT NULL DEFAULT 1 COMMENT '1 低 2中 3高 4严重',
  `affect` text DEFAULT NULL,
  `content` text DEFAULT NULL,
  `fix` text DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '0废弃 1暂存 2发布',
  `num` int(11) NOT NULL DEFAULT 0,
  `hot` int(11) NOT NULL DEFAULT 0 COMMENT '0普通 1热门',
  `show_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_outvul_title` (`title`),
  KEY `index_outvul_cve` (`cve`),
  KEY `index_outvul_risk` (`risk`),
  KEY `index_outvul_status` (`status`),
  KEY `index_outvul_type` (`vul_type`) USING BTREE,
  CONSTRAINT `FK_outvul_vultype_type` FOREIGN KEY (`vul_type`) REFERENCES `vul_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8 COMMENT='外部漏洞表';

-- 正在导出表  platform.out_vul 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `out_vul` DISABLE KEYS */;
INSERT INTO `out_vul` (`id`, `title`, `vul_type`, `cve`, `risk`, `affect`, `content`, `fix`, `status`, `num`, `hot`, `show_time`, `create_time`, `update_time`) VALUES
	(1, 'Weblogic ACC组件反序列化漏洞', 16, 'CVE-2015-4852', 3, 'Oracle WebLogic Server 12.2.1.0', 'Oracle WebLogic Server 10.3.6.0, 12.1.2.0, 12.1.3.0, 12.2.1.0版本中，WLS Security组件允许远程攻击者执行任意命令。攻击者通过向TCP端口7001发送T3协议流量，其中包含精心构造的序列化Java对象利用此漏洞。此漏洞影响到WLS Security Handler的文件oracle_common/modules/com.bea.core.apache.commons.collections.jar内一个未知的函数。', 'Oracle<a href="www.baidu.com">a</a>', 2, 0, 0, '2015-11-10 00:00:00', '2018-03-16 11:13:26', '2018-03-16 11:13:29'),
	(2, 'Microsoft Windows Server服务RPC请求缓冲区溢出漏洞（MS08-067）', 11, 'CVE-2008-4250', 1, 'Microsoft Windows XP SP3\r\nMicrosoft Windows XP SP2\r\nMicrosoft Windows Vista SP1\r\nMicrosoft Windows Vista \r\nMicrosoft Windows Server 2008\r\nMicrosoft Windows Server 2003 SP2\r\nMicrosoft Windows Server 2003 SP1\r\nMicrosoft Windows 2000SP4', 'Microsoft Windows是微软发布的非常流行的操作系统。\r\n\r\nWindows的Server服务在处理特制RPC请求时存在缓冲区溢出漏洞，远程攻击者可以通过发送恶意的RPC请求触发这个溢出，导致完全入侵用户系统，以SYSTEM权限执行任意指令。\r\n\r\n对于Windows 2000、XP和Server 2003，无需认证便可以利用这个漏洞；对于Windows Vista和Server 2008，可能需要进行认证。\r\n\r\n目前这个漏洞正在被名为TrojanSpy:Win32/Gimmiv.A和TrojanSpy:Win32/Gimmiv.A.dll的木马积极的利用。', '临时解决方法：\r\n\r\n* 禁用Server和Computer Browser服务。\r\n* 在Windows Vista和Windows Server 2008上，阻断受影响的RPC标识符。在命令提示符中运行以下命令：\r\n    \r\n    netsh\r\n    \r\n然后在netsh环境中输入以下命令：\r\n\r\n    netsh>rpc\r\n    netsh rpc>filter\r\n    netsh rpc filter>add rule layer=um actiontype=block\r\n    netsh rpc filter>add condition field=if_uuid matchtype=equal data=4b324fc8-1670-01d3-1278-5a47bf6ee188\r\n    netsh rpc filter>add filter\r\n    netsh rpc filter>quit\r\n\r\n* 在防火墙阻断TCP 139和445端口。\r\n* 使用个人防火墙，如Internet连接防火墙。\r\n\r\n厂商补丁：\r\n\r\nMicrosoft\r\n---------\r\nMicrosoft已经为此发布了一个安全公告（MS08-067）以及相应补丁:\r\nMS08-067：Vulnerability in Server Service Could Allow Remote Code Execution (958644)\r\n链接：http://www.microsoft.com/technet/security/bulletin/ms08-067.mspx?pf=true', 2, 0, 0, '2008-10-22 00:00:00', '2018-03-16 11:20:30', '2018-03-16 11:20:32'),
	(3, 'SQLite本地拒绝服务漏洞', 1, 'CVE-2018-8740', 2, 'SQLite SQLite <= 3.22.0', 'SQLite 3.22.0及之前版本在实现上存在安全漏洞，可导致空指针间接引用。', '目前厂商已经发布了升级补丁以修复这个安全问题，请到厂商的主页下载：', 2, 0, 0, '2018-03-26 00:00:00', '2018-03-26 17:13:57', '2018-03-26 17:13:58'),
	(197, 'Microsoft Windows Server服务RPC请求缓冲区溢出漏洞（MS08-067）', 11, 'CVE-2008-4250', 2, '<p>Microsoft Windows XP SP3</p>', '<p>Microsoft Windows&nbsp;测试啊嘎嘎嘎嘎嘎嘎</p>', '<p>fix&nbsp;ss中文问题a</p>', 2, 0, 0, '2008-10-22 00:00:00', '2018-04-03 14:14:40', '2018-04-03 14:14:40'),
	(198, 'Microsoft Windows Server服务RPC请求缓冲区溢出漏洞（MS08-067）', 11, 'CVE-2008-4250', 1, '<p>Microsoft Windows XP SP3\nMicrosoft Windows XP SP2\nMicrosoft Windows Vista SP1\nMicrosoft Windows Vista \nMicrosoft Windows Server 2008\nMicrosoft Windows Server 2003 SP2\nMicrosoft Windows Server 2003 SP1\nMicrosoft Windows 2000SP4</p>', '<p>Microsoft Windows&nbsp; afewafew阿城cafe挖坟哇</p>', '<p>规划图发饿然后fashtjuktg看咯i号</p>', 2, 0, 0, '2008-10-22 00:00:00', '2018-04-03 14:31:59', '2018-04-03 14:31:59'),
	(199, 'TEST', 10, 'CVE-2018-2893', 4, '<p>FDAdsfa好友推荐溃疡面</p>', '<p>暗示法施工i家</p>', '<p>的大幅湖科技园</p>', 1, 0, 0, '2018-03-22 00:00:00', '2018-04-11 09:21:35', '2018-04-11 09:21:35'),
	(200, 'ABCDEF', 8, 'CVE-2018-3333', 1, '<p><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">Hive是一个基于</span><a href="http://www.oschina.net/p/hadoop" style="box-sizing: border-box; background-color: rgb(255, 255, 255); text-decoration-line: none; outline: 0px; color: rgb(68, 102, 187); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; white-space: normal;">Hadoop</a><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">的数据仓库平台。通过hive，我们可以方便地进行ETL的工作。hive定义了一个类似于SQL的查询语言：HQL，能 够将用户编写的QL转化为相应的Mapreduce程序基于Hadoop执行。</span></p>', '<p><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">Hive是Facebook 2008年8月刚开源的一个数据仓库框架，其系统目标与&nbsp;</span><a href="http://www.oschina.net/p/pig" style="box-sizing: border-box; background-color: rgb(255, 255, 255); text-decoration-line: none; outline: 0px; color: rgb(68, 102, 187); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; white-space: normal;">Pig</a><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">&nbsp;有相似之处，但它有一些Pig目前还不支持的机制，比如：更丰富的类型系统、更类似SQL的查询语言、Table/Partition元数据的持久化等。</span></p>', '<p><a class="news-link is-today " href="https://www.oschina.net/news/95208/osc-yuanchuanghui-wuhan-421" title="RTMP、WebRTC、UDP 三种互动直播方案的优劣比较" target="_blank" style="box-sizing: border-box; text-decoration-line: none; outline: 0px; font-size: 14px; position: relative; overflow: hidden; max-width: 372px; padding: 0px 0px 0px 13px; transition: color 0.2s; text-overflow: ellipsis; color: rgb(73, 144, 226); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif;">RTMP、WebRTC、UDP 三种互动直播方案的优劣比较</a></p><p><br/></p>', 1, 0, 0, '2018-04-04 00:00:00', '2018-04-16 16:44:43', '2018-04-16 16:44:43'),
	(201, '好啊好哈好好好好', 14, 'CVE-2018-4758', 4, '<p><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">Hive是一个基于</span><a href="http://www.oschina.net/p/hadoop" style="box-sizing: border-box; background-color: rgb(255, 255, 255); text-decoration-line: none; outline: 0px; color: rgb(68, 102, 187); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; white-space: normal;">Hadoop</a><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">的数据仓库平台。通过hive，我们可以方便地进行ETL的工作。hive定义了一个类似于SQL的查询语言：HQL，能 够将用户编写的QL转化为相应的Mapreduce程序基于Hadoop执行。</span></p>', '<p><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">Hive是Facebook 2008年8月刚开源的一个数据仓库框架，其系统目标与&nbsp;</span><a href="http://www.oschina.net/p/pig" style="box-sizing: border-box; background-color: rgb(255, 255, 255); text-decoration-line: none; outline: 0px; color: rgb(68, 102, 187); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; white-space: normal;">Pig</a><span style="color: rgb(17, 17, 17); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif; background-color: rgb(255, 255, 255);">&nbsp;有相似之处，但它有一些Pig目前还不支持的机制，比如：更丰富的类型系统、更类似SQL的查询语言、Table/Partition元数据的持久化等。</span></p>', '<p><a class="news-link is-today " href="https://www.oschina.net/news/95208/osc-yuanchuanghui-wuhan-421" title="RTMP、WebRTC、UDP 三种互动直播方案的优劣比较" target="_blank" style="box-sizing: border-box; text-decoration-line: none; outline: 0px; font-size: 14px; position: relative; overflow: hidden; max-width: 372px; padding: 0px 0px 0px 13px; transition: color 0.2s; text-overflow: ellipsis; color: rgb(73, 144, 226); font-family: &quot;PingFang SC&quot;, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, &quot;Noto Sans CJK SC&quot;, Sathu, EucrosiaUPC, sans-serif;">RTMP、WebRTC、UDP 三种互动直播方案的优劣比较</a></p><br/>', 0, 0, 0, '2018-04-16 00:00:00', '2018-04-16 16:46:27', '2018-04-16 16:46:27'),
	(202, 'null', 2, 'null', 1, '<p>dafefgdsf</p>', '', 'function(a,b,c,d,e){var f=this;if(a&&utils.isFunction(a)&&(b=a,a=""),b?!b():!this.hasContents())return"";f.fireEvent("beforegetcontent");var g=UE.htmlparser(f.body.innerHTML,d);return f.filterOutputRule(g),f.fireEvent("aftergetcontent",a,g),g.toHtml(e)}', 2, 0, 0, '2021-01-12 13:28:20', '2021-01-12 13:28:20', NULL),
	(203, '1111', 8, 'CVE-2020-1111', 3, '<p><img src="http://localhost:8080/SecurityPlatform/upload/image/20210112/1610429687567086782.png" title="1610429687567086782.png" alt="222.png"/></p><p>good ahdoahfdoafdasfd</p>', '<p>这里是一个详情</p>', 'function(a,b,c,d,e){var f=this;if(a&&utils.isFunction(a)&&(b=a,a=""),b?!b():!this.hasContents())return"";f.fireEvent("beforegetcontent");var g=UE.htmlparser(f.body.innerHTML,d);return f.filterOutputRule(g),f.fireEvent("aftergetcontent",a,g),g.toHtml(e)}', 2, 0, 0, '2021-01-12 13:35:15', '2021-01-12 13:35:15', NULL),
	(204, 'SQLite本地拒绝服务漏洞', 2, 'CVE-2021-4567', 3, '<p><img src=".//upload/image/20210112/1610431298796086130.png" title="1610431298796086130.png" alt="333.png"/></p>', '<p><img src="http://localhost:8080/SecurityPlatform/upload/image/20210112/1610419545671032228.png" alt="1610419545671032228.png"/></p>', 'function(a,b,c,d,e){var f=this;if(a&&utils.isFunction(a)&&(b=a,a=""),b?!b():!this.hasContents())return"";f.fireEvent("beforegetcontent");var g=UE.htmlparser(f.body.innerHTML,d);return f.filterOutputRule(g),f.fireEvent("aftergetcontent",a,g),g.toHtml(e)}', 2, 0, 0, '2021-01-12 14:02:19', '2021-01-12 14:02:19', NULL);
/*!40000 ALTER TABLE `out_vul` ENABLE KEYS */;

-- 导出  表 platform.system_info 结构
CREATE TABLE IF NOT EXISTS `system_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `full_name` varchar(128) DEFAULT NULL,
  `department` varchar(128) DEFAULT NULL,
  `owner` varchar(128) DEFAULT NULL,
  `sit_address` varchar(128) DEFAULT NULL,
  `sit_username` varchar(64) DEFAULT NULL,
  `sit_password` varchar(64) DEFAULT NULL,
  `uat_address` varchar(128) DEFAULT NULL,
  `uat_username` varchar(64) DEFAULT NULL,
  `uat_password` varchar(64) DEFAULT NULL,
  `dev_address` varchar(128) DEFAULT NULL,
  `dev_username` varchar(64) DEFAULT NULL,
  `dev_password` varchar(64) DEFAULT NULL,
  `prod_address` varchar(128) DEFAULT NULL,
  `prod_username` varchar(64) DEFAULT NULL,
  `prod_password` varchar(64) DEFAULT NULL,
  `pm_name` varchar(64) DEFAULT NULL,
  `pm_email` varchar(128) DEFAULT NULL,
  `pm_phone` varchar(16) DEFAULT NULL,
  `pm_manager` varchar(64) DEFAULT NULL,
  `pm_manager_email` varchar(64) DEFAULT NULL,
  `dev_manager` varchar(64) DEFAULT NULL,
  `dev_manager_email` varchar(64) DEFAULT NULL,
  `pmo` varchar(64) DEFAULT NULL,
  `pmo_email` varchar(64) DEFAULT NULL,
  `vendor_name` varchar(64) DEFAULT NULL,
  `vendor_email1` varchar(64) DEFAULT NULL,
  `vendor_email2` varchar(64) DEFAULT NULL,
  `vendor_email3` varchar(64) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '0关闭 1活跃',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  platform.system_info 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `system_info` DISABLE KEYS */;
INSERT INTO `system_info` (`id`, `name`, `full_name`, `department`, `owner`, `sit_address`, `sit_username`, `sit_password`, `uat_address`, `uat_username`, `uat_password`, `dev_address`, `dev_username`, `dev_password`, `prod_address`, `prod_username`, `prod_password`, `pm_name`, `pm_email`, `pm_phone`, `pm_manager`, `pm_manager_email`, `dev_manager`, `dev_manager_email`, `pmo`, `pmo_email`, `vendor_name`, `vendor_email1`, `vendor_email2`, `vendor_email3`, `status`, `create_time`) VALUES
	(1, 'app', 'app', NULL, NULL, 'http://192.168.1.1', 'test', 'test@1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '张三', NULL, NULL, NULL, NULL, '哈哈哈', NULL, '王五', NULL, '专注科技', NULL, NULL, NULL, 1, '2022-05-17 21:25:08'),
	(2, 'cdp', 'custome data platform', NULL, NULL, 'https://192.168.2.2', NULL, NULL, 'https://cdp.test.com', 'admin', 'dsafdslafdslfdjioe', NULL, NULL, NULL, NULL, NULL, NULL, '李四', NULL, NULL, NULL, NULL, '哈哈哈', NULL, '王五', NULL, NULL, NULL, NULL, NULL, 1, '2022-05-17 22:08:56'),
	(3, 'vdp', 'vehicle data platform', NULL, NULL, 'https://192.168.2.3', NULL, NULL, 'https://vdp-uat.test.com', 'admin', '1qaz@WSX', NULL, NULL, NULL, NULL, NULL, NULL, '李四', NULL, NULL, NULL, NULL, '三生石', NULL, '啊啊啊', NULL, 'NTT', NULL, NULL, NULL, 1, '2022-05-17 22:08:56'),
	(4, 'cms', 'vehicle data platform', NULL, NULL, 'https://192.168.2.3', NULL, NULL, 'https://vdp-uat.test.com', 'admin', '1qaz@WSX', NULL, NULL, NULL, NULL, NULL, NULL, '李四', NULL, NULL, NULL, NULL, '三生石', NULL, '啊啊啊', NULL, 'NTT', NULL, NULL, NULL, 1, '2022-05-17 22:08:56');
/*!40000 ALTER TABLE `system_info` ENABLE KEYS */;

-- 导出  表 platform.system_log 结构
CREATE TABLE IF NOT EXISTS `system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_module` varchar(64) DEFAULT NULL,
  `method` varchar(64) DEFAULT NULL,
  `log_type` int(11) DEFAULT 1 COMMENT '1信息 2告警 3错误',
  `msg` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `method` (`method`),
  KEY `module` (`log_module`) USING BTREE,
  KEY `type` (`log_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  platform.system_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `system_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_log` ENABLE KEYS */;

-- 导出  表 platform.vul_type 结构
CREATE TABLE IF NOT EXISTS `vul_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `index_vulType_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='漏洞类型表';

-- 正在导出表  platform.vul_type 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `vul_type` DISABLE KEYS */;
INSERT INTO `vul_type` (`id`, `name`, `status`) VALUES
	(1, '拒绝服务', 1),
	(2, '命令执行', 1),
	(3, '注入', 1),
	(4, 'XSS/CSRF', 1),
	(5, '文件上传/下载', 1),
	(6, 'CSRF', 1),
	(7, '目录遍历', 1),
	(8, '权限提升', 1),
	(9, '弱口令', 1),
	(10, '越权', 1),
	(11, '内存/堆栈溢出', 1),
	(12, '本地/远程文件包含', 1),
	(13, '后门/shell', 1),
	(14, '逻辑错误', 1),
	(15, '信息泄漏', 1),
	(16, '反序列化', 1),
	(17, '认证绕过', 1);
/*!40000 ALTER TABLE `vul_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : mycolor

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-03-27 17:39:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for e_menu
-- ----------------------------
DROP TABLE IF EXISTS `e_menu`;
CREATE TABLE `e_menu` (
  `menu_id` varchar(36) NOT NULL COMMENT '菜单id',
  `menu_code` varchar(36) DEFAULT NULL COMMENT '菜单编码',
  `menu_name` varchar(18) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单请求路径',
  `menu_order` int(11) NOT NULL COMMENT '菜单排序',
  `menu_parent_id` varchar(36) DEFAULT NULL COMMENT '父级id',
  `menu_is_valid` varchar(2) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of e_menu
-- ----------------------------
INSERT INTO `e_menu` VALUES ('MENU_MAIN', null, '首页', '/admin/main', '11', 'TOP_MAIN', '1');
INSERT INTO `e_menu` VALUES ('MENU_MANGE', null, '菜单管理', '/admin/menu/index', '22', 'TOP_SYSTEM', '0');
INSERT INTO `e_menu` VALUES ('MENU_QUERY_VACATE', null, '请假统计', '/amdin/queryVacate/queryIndex', '42', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_ROLE', null, '角色管理', '/admin/role/roleIndex', '21', 'TOP_SYSTEM', '1');
INSERT INTO `e_menu` VALUES ('MENU_SALARY_MANAGE', null, '考勤统计', '/admin/querySalary/querySalaryIndex', '43', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_SCHOOL_CLASS', null, '班级管理', '/admin/schoolClass/index', '32', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('MENU_STUDENT_RECORD', null, '学生管理', '/admin/studentRecord/index', '33', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('MENU_STUDENT_VACATE', null, '请假申请', '/admin/studentVacate/vacateIndex', '41', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_TEACHER', null, '教务人员管理', '/admin/teachTeacher/index', '31', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('TOP_MAIN', null, '首页', null, '1', null, '1');
INSERT INTO `e_menu` VALUES ('TOP_SALARY_MANAGE', null, '考勤管理', null, '4', null, '1');
INSERT INTO `e_menu` VALUES ('TOP_SYSTEM', null, '系统管理', null, '2', null, '1');
INSERT INTO `e_menu` VALUES ('TOP_TEACH', null, '教务管理', null, '3', null, '1');

-- ----------------------------
-- Table structure for e_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `e_menu_role`;
CREATE TABLE `e_menu_role` (
  `menu_id` varchar(36) NOT NULL COMMENT '菜单id',
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of e_menu_role
-- ----------------------------
INSERT INTO `e_menu_role` VALUES ('MENU_ACCOUNT', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_MANGE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_ROLE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_USER', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_CUSTORMER', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_SYSTEM', '3089cdfd3f51478e87d51995b93d0c03');

-- ----------------------------
-- Table structure for e_role
-- ----------------------------
DROP TABLE IF EXISTS `e_role`;
CREATE TABLE `e_role` (
  `role_id` varchar(50) NOT NULL,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_code` varchar(100) NOT NULL COMMENT '角色编码',
  `role_is_valid` int(2) NOT NULL COMMENT '是否有效（1有效，0无效）',
  `role_create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of e_role
-- ----------------------------
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c03', '系统管理员', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c11', '系统管理员1', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c12', '系统管理员2', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c13', '系统管理员3', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c14', '系统管理员4', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c15', '系统管理员5', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c16', '系统管理员6', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c17', '系统管理员7', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c18', '系统管理员8', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c19', '系统管理员9', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c21', '系统管理员21', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c22', '系统管理员222', 'system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c23', '系统管理员23', 'system', '1', '2017-12-14 10:10:51');

-- ----------------------------
-- Table structure for e_salary_manage
-- ----------------------------
DROP TABLE IF EXISTS `e_salary_manage`;
CREATE TABLE `e_salary_manage` (
  `salary_manage_id` varchar(36) NOT NULL COMMENT '考勤管理id',
  `student_user_id` varchar(36) NOT NULL COMMENT '学生id',
  `student_user_name` varchar(36) NOT NULL COMMENT '学生姓名',
  `salary_class` varchar(50) DEFAULT NULL COMMENT '班级',
  `salary_time` datetime DEFAULT NULL COMMENT '考勤时间',
  `salary_class_number` double(5,1) DEFAULT NULL COMMENT '节次',
  `salary_course_name` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `salary_class_address` varchar(100) DEFAULT NULL COMMENT '教室地址',
  `salary_status` varchar(10) DEFAULT NULL COMMENT '考勤状态',
  `teacher_user_id` varchar(36) DEFAULT NULL COMMENT '老师id',
  `teacher_user_name` varchar(36) DEFAULT NULL COMMENT '老师姓名',
  `salary_is_vaild` varchar(2) DEFAULT NULL COMMENT '是否有效（0无效，1有效）',
  `salary_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `salary_last_uptime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `salary_last_upuid` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `salary_last_upuname` varchar(36) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`salary_manage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤管理';

-- ----------------------------
-- Records of e_salary_manage
-- ----------------------------

-- ----------------------------
-- Table structure for e_school_class
-- ----------------------------
DROP TABLE IF EXISTS `e_school_class`;
CREATE TABLE `e_school_class` (
  `school_class_id` varchar(36) NOT NULL COMMENT '班级管理id',
  `school_grade_number` varchar(25) NOT NULL COMMENT '年级',
  `school_class_number` varchar(25) NOT NULL COMMENT '班级',
  `class_specialty` varchar(50) NOT NULL COMMENT '专业',
  `class_student_number` int(11) DEFAULT NULL COMMENT '人数',
  `class_train_scheme` varchar(50) NOT NULL COMMENT '培训方案',
  `class_graduation_time` datetime DEFAULT NULL COMMENT '毕业时间',
  `class_instructor_uid` varchar(36) DEFAULT NULL COMMENT '辅导员id',
  `class_instructor_uname` varchar(25) DEFAULT NULL COMMENT '辅导员',
  `class_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `class_create_uid` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `class_create_uname` varchar(36) DEFAULT NULL COMMENT '创建人姓名',
  `class_last_upuid` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `class_last_upuname` varchar(36) DEFAULT NULL COMMENT '修改人',
  `class_last_uptime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`school_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级管理';

-- ----------------------------
-- Records of e_school_class
-- ----------------------------

-- ----------------------------
-- Table structure for e_student_record
-- ----------------------------
DROP TABLE IF EXISTS `e_student_record`;
CREATE TABLE `e_student_record` (
  `student_record_id` varchar(36) NOT NULL COMMENT '学生档案id',
  `student_record_name` varchar(50) NOT NULL COMMENT '姓名',
  `student_record_sex` varchar(2) NOT NULL COMMENT '性别',
  `student_birth_years` varchar(50) NOT NULL COMMENT '出生年月',
  `student_record_height` int(3) DEFAULT NULL COMMENT '身高',
  `student_id_card` varchar(18) NOT NULL COMMENT '身份证',
  `student_record_nation` varchar(2) DEFAULT NULL COMMENT '民族',
  `student_native_place` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `student_phone` varchar(11) NOT NULL COMMENT '联系电话',
  `student_patriarch_phone` varchar(11) NOT NULL COMMENT '家长联系电话',
  `student_family_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `student_remark` varchar(1000) DEFAULT NULL COMMENT '个人简介',
  `student_user_id` varchar(36) NOT NULL COMMENT '学生userId',
  `student_is_vaild` varchar(2) NOT NULL COMMENT '是否有效',
  `student_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `student_create_uid` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `student_create_uname` varchar(10) DEFAULT NULL COMMENT '创建人',
  `student_last_upuid` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `student_last_upuname` varchar(50) DEFAULT NULL COMMENT '修改人',
  `student_last_uptime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`student_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生档案';

-- ----------------------------
-- Records of e_student_record
-- ----------------------------

-- ----------------------------
-- Table structure for e_student_vacate
-- ----------------------------
DROP TABLE IF EXISTS `e_student_vacate`;
CREATE TABLE `e_student_vacate` (
  `student_vacate_id` varchar(36) NOT NULL COMMENT '学生请假id',
  `vacate_user_id` varchar(36) NOT NULL COMMENT '请假人id',
  `vacate_user_name` varchar(25) NOT NULL COMMENT '姓名',
  `vacate_user_class` varchar(50) NOT NULL COMMENT '班级',
  `student_instructor_uid` varchar(36) NOT NULL COMMENT '辅导员',
  `student_instructor_uname` varchar(36) NOT NULL COMMENT '辅导员姓名',
  `vacate_type` varchar(2) NOT NULL COMMENT '请假类型',
  `vacate_number` double(5,1) NOT NULL COMMENT '节次/天数',
  `vacate_start_time` datetime DEFAULT NULL COMMENT '请假开始时间',
  `vacate_end_time` datetime DEFAULT NULL COMMENT '请假结束时间',
  `vacate_course_name` varchar(100) DEFAULT NULL COMMENT '课时名称',
  `vacate_reason` varchar(500) DEFAULT NULL COMMENT '请假理由',
  `vacate_is_vaild` varchar(2) DEFAULT NULL COMMENT '是否有效',
  `vacate_state` varchar(2) DEFAULT NULL COMMENT '请假状态',
  `vacate_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`student_vacate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生请假';

-- ----------------------------
-- Records of e_student_vacate
-- ----------------------------

-- ----------------------------
-- Table structure for e_teacher_class
-- ----------------------------
DROP TABLE IF EXISTS `e_teacher_class`;
CREATE TABLE `e_teacher_class` (
  `teacher_user_id` varchar(36) NOT NULL COMMENT '老师id',
  `school_class_id` varchar(36) DEFAULT NULL COMMENT '班级id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任课老师班级关联表';

-- ----------------------------
-- Records of e_teacher_class
-- ----------------------------

-- ----------------------------
-- Table structure for e_teach_teacher
-- ----------------------------
DROP TABLE IF EXISTS `e_teach_teacher`;
CREATE TABLE `e_teach_teacher` (
  `teach_teacher_id` varchar(36) NOT NULL COMMENT '教务老师档案id',
  `teacher_user_id` varchar(36) NOT NULL COMMENT 'userid',
  `teach_teacher_name` varchar(12) NOT NULL COMMENT '姓名',
  `teach_teacher_sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `teach_teacher_age` int(11) DEFAULT NULL COMMENT '年龄',
  `teach_teacher_nation` varchar(18) DEFAULT NULL COMMENT '民族',
  `teach_teacher_id_card` varchar(18) NOT NULL COMMENT '身份证号码',
  `teach_teacher_diploma` varchar(10) DEFAULT NULL COMMENT '学历',
  `teach_school_age` varchar(2) DEFAULT NULL COMMENT '教龄',
  `teach_teacher_post` varchar(10) DEFAULT NULL COMMENT '职位',
  `teach_teacher_phone` varchar(11) NOT NULL COMMENT '联系电话',
  `teach_teacher_address` varchar(100) DEFAULT NULL COMMENT '住址',
  `teacher_is_valid` varchar(2) DEFAULT NULL COMMENT '是否有效',
  `teacher_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `teacher_create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `teacher_create_user_name` varchar(25) DEFAULT NULL COMMENT '创建人',
  `teacher_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `teacher_update_user_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `teacher_update_user_name` varchar(25) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`teach_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教务老师档案';

-- ----------------------------
-- Records of e_teach_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for e_user
-- ----------------------------
DROP TABLE IF EXISTS `e_user`;
CREATE TABLE `e_user` (
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `user_account` varchar(50) NOT NULL COMMENT '用户登录账号',
  `user_password` varchar(100) NOT NULL COMMENT '登陆密码',
  `user_sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `user_id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(100) NOT NULL COMMENT '联系电话',
  `user_email` varchar(100) DEFAULT NULL COMMENT 'email',
  `user_type` varchar(2) DEFAULT NULL COMMENT '用户类型（1系统管理，2教务管理员，3辅导员，4任课老师，5学生）',
  `user_open_id` varchar(200) DEFAULT NULL COMMENT '微信openid',
  `user_app_token` varchar(100) DEFAULT NULL COMMENT 'app的token',
  `user_login_number` int(11) DEFAULT NULL COMMENT '登录次数(默认为0)',
  `user_login_phone_code` varchar(200) DEFAULT NULL COMMENT '手机码（手机身份唯一标识，登录时，验证和上次登录是否同一手机，不同则发送验证码）',
  `user_is_valid` varchar(2) NOT NULL COMMENT '是否有效（0无效，1有效）',
  `user_create_time` datetime NOT NULL COMMENT '创建时间',
  `user_last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `user_last_updatetime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

-- ----------------------------
-- Records of e_user
-- ----------------------------
INSERT INTO `e_user` VALUES ('0555137b929047769255c519912b232b', '系统管理员', 'admin', '223ce7b851123353479d85757fbbf4e320d1e251', '1', null, '123456789', null, null, null, null, null, null, '1', '2017-12-04 11:15:17', '2018-03-17 09:16:23', null);

-- ----------------------------
-- Table structure for e_user_role
-- ----------------------------
DROP TABLE IF EXISTS `e_user_role`;
CREATE TABLE `e_user_role` (
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `role_id` varchar(50) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of e_user_role
-- ----------------------------
INSERT INTO `e_user_role` VALUES ('0555137b929047769255c519912b232b', '3089cdfd3f51478e87d51995b93d0c03');

-- ----------------------------
-- Table structure for e_vacate_notice
-- ----------------------------
DROP TABLE IF EXISTS `e_vacate_notice`;
CREATE TABLE `e_vacate_notice` (
  `vacate_notice_id` varchar(36) NOT NULL COMMENT '请假通知id',
  `wait_deal_id` varchar(36) DEFAULT NULL COMMENT '待处理id',
  `notice__reference_id` varchar(36) DEFAULT NULL COMMENT '请假id',
  `notice_teacher_uid` varchar(36) DEFAULT NULL COMMENT '通知老师id',
  `notice_teacher_uname` varchar(36) DEFAULT NULL COMMENT '老师姓名',
  `vacate_student_uid` varchar(36) DEFAULT NULL COMMENT '学生id',
  `vacate_student_uname` varchar(36) DEFAULT NULL COMMENT '学生姓名',
  `vacate_start_time` datetime DEFAULT NULL COMMENT '请假开始时间',
  `vacate_end_time` datetime DEFAULT NULL COMMENT '请假结束时间',
  `notice_is_vaild` varchar(2) DEFAULT NULL COMMENT '是否有效',
  `notice_is_read` varchar(2) DEFAULT NULL COMMENT '是否已读',
  `notice_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`vacate_notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假通知';

-- ----------------------------
-- Records of e_vacate_notice
-- ----------------------------

-- ----------------------------
-- Table structure for e_wait_deal
-- ----------------------------
DROP TABLE IF EXISTS `e_wait_deal`;
CREATE TABLE `e_wait_deal` (
  `wait_deal_id` varchar(36) NOT NULL COMMENT '待处理id',
  `wait_reference_id` varchar(36) NOT NULL COMMENT '请假单id',
  `wait_instructor_uid` varchar(36) DEFAULT NULL COMMENT '辅导员id',
  `wait_instructor_uname` varchar(36) DEFAULT NULL COMMENT '辅导员名称',
  `wait_student_uid` varchar(36) DEFAULT NULL COMMENT '学生id',
  `wait_student_uname` varchar(36) DEFAULT NULL COMMENT '学生姓名',
  `wait_is_vaild` varchar(2) DEFAULT NULL COMMENT '是否有效',
  `wait_deal_state` varchar(2) DEFAULT NULL COMMENT '处理状态',
  `wait_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `wait_reply_time` datetime DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`wait_deal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假待处理';

-- ----------------------------
-- Records of e_wait_deal
-- ----------------------------

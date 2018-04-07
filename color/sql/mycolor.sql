/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : mycolor

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-04-07 17:43:14
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
INSERT INTO `e_menu` VALUES ('MENU_NOTICE', null, '请假通知', '/admin/vacateNotice/index', '14', 'TOP_MAIN', '1');
INSERT INTO `e_menu` VALUES ('MENU_QUERY_VACATE', null, '请假统计', '/amdin/queryVacate/queryIndex', '42', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_ROLE', null, '角色管理', '/admin/role/roleIndex', '21', 'TOP_SYSTEM', '1');
INSERT INTO `e_menu` VALUES ('MENU_SALARY', null, '考勤管理', '/admin/salaryManage/index', '43', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_SALARY_MANAGE', null, '考勤统计', '/admin/querySalary/querySalaryIndex', '44', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_SCHOOL_CLASS', null, '班级管理', '/admin/schoolClass/index', '32', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('MENU_STUDENT_RECORD', null, '学生管理', '/admin/studentRecord/index', '33', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('MENU_STUDENT_VACATE', null, '请假申请', '/admin/studentVacate/vacateIndex', '41', 'TOP_SALARY_MANAGE', '1');
INSERT INTO `e_menu` VALUES ('MENU_TEACHER', null, '教务人员管理', '/admin/teachTeacher/index', '31', 'TOP_TEACH', '1');
INSERT INTO `e_menu` VALUES ('MENU_USER_CONTER', null, '个人中心', '/admin/userContre/index', '12', 'TOP_MAIN', '1');
INSERT INTO `e_menu` VALUES ('MENU_WAIT_DEAL', null, '请假待办', '/admin/waitDeal/index', '13', 'TOP_MAIN', '1');
INSERT INTO `e_menu` VALUES ('TOP_MAIN', null, '首页', null, '1', null, '1');
INSERT INTO `e_menu` VALUES ('TOP_SALARY_MANAGE', null, '考勤管理', null, '2', null, '1');
INSERT INTO `e_menu` VALUES ('TOP_SYSTEM', null, '系统管理', null, '4', null, '1');
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
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('MENU_MAIN', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_MANGE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_NOTICE', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_QUERY_VACATE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_QUERY_VACATE', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_ROLE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY_MANAGE', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY_MANAGE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY_MANAGE', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY_MANAGE', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('MENU_SALARY_MANAGE', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_SCHOOL_CLASS', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_SCHOOL_CLASS', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_STUDENT_RECORD', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_STUDENT_RECORD', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_STUDENT_RECORD', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_STUDENT_VACATE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_STUDENT_VACATE', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('MENU_TEACHER', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_TEACHER', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('MENU_USER_CONTER', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('MENU_USER_CONTER', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('MENU_USER_CONTER', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('MENU_USER_CONTER', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('MENU_USER_CONTER', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('MENU_WAIT_DEAL', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('TOP_MAIN', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('TOP_SALARY_MANAGE', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('TOP_SALARY_MANAGE', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_SALARY_MANAGE', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('TOP_SALARY_MANAGE', 'e0f9553f149041a5a4ee19a2c50110f9');
INSERT INTO `e_menu_role` VALUES ('TOP_SALARY_MANAGE', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_menu_role` VALUES ('TOP_SYSTEM', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_TEACH', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_menu_role` VALUES ('TOP_TEACH', '3089cdfd3f51478e87d51995b93d0c03');
INSERT INTO `e_menu_role` VALUES ('TOP_TEACH', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_menu_role` VALUES ('TOP_TEACH', 'f491f2d85398437db55551e410961f3d');

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
INSERT INTO `e_role` VALUES ('231cd593031e4c4faf48e4d725e45181', '任课老师', 'role_teacher', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('3089cdfd3f51478e87d51995b93d0c03', '系统管理员', 'role_system', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('cc2958f8ce6e4114a10300cd7ab1b798', '教务管理员', 'role_teach', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('e0f9553f149041a5a4ee19a2c50110f9', '学生', 'role_student', '1', '2017-12-14 10:10:51');
INSERT INTO `e_role` VALUES ('f491f2d85398437db55551e410961f3d', '辅导员', 'role_instructor', '1', '2017-12-14 10:10:51');

-- ----------------------------
-- Table structure for e_salary_manage
-- ----------------------------
DROP TABLE IF EXISTS `e_salary_manage`;
CREATE TABLE `e_salary_manage` (
  `salary_manage_id` varchar(36) NOT NULL COMMENT '考勤管理id',
  `student_user_id` varchar(36) NOT NULL COMMENT '学生id',
  `student_user_name` varchar(36) NOT NULL COMMENT '学生姓名',
  `salary_class_id` varchar(50) NOT NULL COMMENT '班级',
  `salary_class_name` varchar(50) NOT NULL COMMENT '班级名称',
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
INSERT INTO `e_salary_manage` VALUES ('711f81bc763a4facaae76bc9c4aefc8c', 'c1c6addcfc2c401889bb54b3de30946b', '小李', '1046b59be1ea4079abaef575a44a0874', '1905建筑', '2018-04-05 00:00:00', '2.0', 'java', 'sdsfdf', '2', '0555137b929047769255c519912b232b', '系统管理员', '1', '2018-04-05 13:41:03', null, null, null);

-- ----------------------------
-- Table structure for e_school_class
-- ----------------------------
DROP TABLE IF EXISTS `e_school_class`;
CREATE TABLE `e_school_class` (
  `school_class_id` varchar(36) NOT NULL COMMENT '班级管理id',
  `school_grade_number` varchar(25) NOT NULL COMMENT '年级',
  `school_class_number` varchar(25) NOT NULL COMMENT '班级',
  `class_specialty` varchar(50) NOT NULL COMMENT '专业',
  `school_class_name` varchar(100) DEFAULT NULL COMMENT '班级名称',
  `class_student_number` int(11) DEFAULT NULL COMMENT '人数',
  `class_train_scheme` varchar(50) NOT NULL COMMENT '培训方案',
  `class_graduation_time` datetime DEFAULT NULL COMMENT '毕业时间',
  `class_instructor_uid` varchar(36) DEFAULT NULL COMMENT '辅导员id',
  `class_instructor_uname` varchar(25) DEFAULT NULL COMMENT '辅导员',
  `class_is_vaild` varchar(2) DEFAULT NULL COMMENT '是否有效',
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
INSERT INTO `e_school_class` VALUES ('1046b59be1ea4079abaef575a44a0874', '19', '05', '建筑', '1905建筑', '36', '土地方案', '2019-09-01 00:00:00', '41f3fa61f0874f80815765ac60ff92ae', '李亚楼', '1', '2018-04-01 16:56:26', '0555137b929047769255c519912b232b', '系统管理员', null, null, null);

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
  `student_class_id` varchar(36) DEFAULT NULL COMMENT '班级ID',
  `student_class_name` varchar(50) DEFAULT NULL COMMENT '班级名称',
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
INSERT INTO `e_student_record` VALUES ('a8add5bab6004cbdbd55bc2f61c13a1b', '小李', '男', '1993-06-17', '185', '510000000000000000', '汉', '遂宁', '18511111111', '15111111111', '佛挡杀佛付付付付付付付', '的点点滴滴多多多多多多多多多多多', 'c1c6addcfc2c401889bb54b3de30946b', '1', '1046b59be1ea4079abaef575a44a0874', '1905建筑', '2018-04-01 16:57:43', '0555137b929047769255c519912b232b', '系统管理员', null, null, null);

-- ----------------------------
-- Table structure for e_student_vacate
-- ----------------------------
DROP TABLE IF EXISTS `e_student_vacate`;
CREATE TABLE `e_student_vacate` (
  `student_vacate_id` varchar(36) NOT NULL COMMENT '学生请假id',
  `vacate_user_id` varchar(36) NOT NULL COMMENT '请假人id',
  `vacate_user_name` varchar(25) NOT NULL COMMENT '姓名',
  `student_class_id` varchar(36) NOT NULL COMMENT '班级ID',
  `student_class_name` varchar(50) NOT NULL COMMENT '班级名称',
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
INSERT INTO `e_student_vacate` VALUES ('cd2ffa36f1b3495f9b263ba4ef850df8', 'c1c6addcfc2c401889bb54b3de30946b', '小李', '1046b59be1ea4079abaef575a44a0874', '1905建筑', '41f3fa61f0874f80815765ac60ff92ae', '李亚楼', '1', '2.0', '2018-04-05 13:04:55', '2018-04-06 13:04:55', 'javakaifa ', 'sdsd ', '1', '1', '2018-04-05 13:03:15');

-- ----------------------------
-- Table structure for e_teacher_class
-- ----------------------------
DROP TABLE IF EXISTS `e_teacher_class`;
CREATE TABLE `e_teacher_class` (
  `school_class_id` varchar(36) NOT NULL COMMENT '班级id',
  `teacher_user_id` varchar(36) NOT NULL COMMENT '老师id',
  `teacher_type` varchar(2) NOT NULL COMMENT '老师类型（3辅导员，4任课老师）',
  PRIMARY KEY (`school_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任课老师班级关联表';

-- ----------------------------
-- Records of e_teacher_class
-- ----------------------------
INSERT INTO `e_teacher_class` VALUES ('1046b59be1ea4079abaef575a44a0874', '41f3fa61f0874f80815765ac60ff92ae', '3');

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
INSERT INTO `e_teach_teacher` VALUES ('0dca58a3b92541f19b66d811b9a758c4', '41f3fa61f0874f80815765ac60ff92ae', '李亚楼', '男', '28', '汉', '510921199009145356', '博士', '5', '教导主任', '18508253688', '成都市', '1', '2018-04-01 16:55:41', '0555137b929047769255c519912b232b', '系统管理员', null, null, null);
INSERT INTO `e_teach_teacher` VALUES ('30e033a9dd964d238ae27dc374da633a', '11ac510a851f4c50a691a5f3b7d22d94', '李主管', '男', '28', '汉', '513666666666666666', '博士', '5', '教务管理员', '18166666666', '多福多寿', '1', '2018-04-07 16:38:07', '0555137b929047769255c519912b232b', '系统管理员', null, null, null);
INSERT INTO `e_teach_teacher` VALUES ('b49a4773a6524982bec385f47d370830', '53f5079d1f724bdba8004e9e34a2bfdf', '李老师', '男', '28', '汉', '510921111111111111', '本科', '2', '主任', '18113126261', '佛挡杀佛', '1', '2018-04-07 15:34:43', '0555137b929047769255c519912b232b', '系统管理员', null, null, null);

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
INSERT INTO `e_user` VALUES ('0555137b929047769255c519912b232b', '系统管理员', 'admin', '223ce7b851123353479d85757fbbf4e320d1e251', '1', null, '123456789', null, '1', null, null, null, null, '1', '2017-12-04 11:15:17', '2018-04-07 16:37:12', null);
INSERT INTO `e_user` VALUES ('11ac510a851f4c50a691a5f3b7d22d94', '李主管', '18166666666', '7596a366a929d094bfe9fae98510d1c1637d5b91', '男', '513666666666666666', '18166666666', null, '2', null, null, '0', null, '1', '2018-04-07 16:38:07', '2018-04-07 17:03:32', null);
INSERT INTO `e_user` VALUES ('41f3fa61f0874f80815765ac60ff92ae', '李亚楼', '18508253688', 'fb39e228978e2c298e111ab592920ab045a260b0', '男', '510921199009145356', '18508253688', null, '3', null, null, '0', null, '1', '2018-04-01 16:55:41', '2018-04-07 16:12:06', null);
INSERT INTO `e_user` VALUES ('53f5079d1f724bdba8004e9e34a2bfdf', '李老师', '18113126261', 'a862d77e8d968ed386ca320a7c6b977841dfcb00', '男', '510921111111111111', '18113126261', null, '4', null, null, '0', null, '1', '2018-04-07 15:34:43', '2018-04-07 16:11:56', null);
INSERT INTO `e_user` VALUES ('c1c6addcfc2c401889bb54b3de30946b', '小李', '18511111111', '821bcfcfb519bb1d0738b57dff0daa364e36c6d6', '男', '510000000000000000', '18511111111', null, '5', null, null, '0', null, '1', '2018-04-01 16:57:43', '2018-04-05 17:07:23', null);

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
INSERT INTO `e_user_role` VALUES ('11ac510a851f4c50a691a5f3b7d22d94', 'cc2958f8ce6e4114a10300cd7ab1b798');
INSERT INTO `e_user_role` VALUES ('41f3fa61f0874f80815765ac60ff92ae', 'f491f2d85398437db55551e410961f3d');
INSERT INTO `e_user_role` VALUES ('53f5079d1f724bdba8004e9e34a2bfdf', '231cd593031e4c4faf48e4d725e45181');
INSERT INTO `e_user_role` VALUES ('c1c6addcfc2c401889bb54b3de30946b', 'e0f9553f149041a5a4ee19a2c50110f9');

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
  `notice_is_read` varchar(2) DEFAULT NULL COMMENT '是否已读（1未读，2未读）',
  `notice_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`vacate_notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假通知';

-- ----------------------------
-- Records of e_vacate_notice
-- ----------------------------
INSERT INTO `e_vacate_notice` VALUES ('kjhjkshdf645544', 'd38233c8c2ee43e79df0f09698ca6089', 'cd2ffa36f1b3495f9b263ba4ef850df8', '53f5079d1f724bdba8004e9e34a2bfdf', '李老师', 'c1c6addcfc2c401889bb54b3de30946b', '小李', '2018-04-05 13:04:55', '2018-04-06 13:04:55', '1', '1', '2018-04-07 15:36:17');

-- ----------------------------
-- Table structure for e_wait_deal
-- ----------------------------
DROP TABLE IF EXISTS `e_wait_deal`;
CREATE TABLE `e_wait_deal` (
  `wait_deal_id` varchar(36) NOT NULL COMMENT '待处理id',
  `wait_reference_id` varchar(36) NOT NULL COMMENT '请假单id',
  `wait_instructor_uid` varchar(36) NOT NULL COMMENT '辅导员id',
  `wait_instructor_uname` varchar(36) NOT NULL COMMENT '辅导员名称',
  `wait_student_uid` varchar(36) NOT NULL COMMENT '学生id',
  `wait_student_uname` varchar(36) NOT NULL COMMENT '学生姓名',
  `wait_class_id` varchar(36) NOT NULL,
  `wait_class_name` varchar(36) NOT NULL,
  `wait_is_vaild` varchar(2) NOT NULL COMMENT '是否有效',
  `wait_deal_state` varchar(2) DEFAULT NULL COMMENT '处理状态',
  `wait_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `wait_reply_result` varchar(2) DEFAULT NULL,
  `wait_reply_time` datetime DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`wait_deal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假待处理';

-- ----------------------------
-- Records of e_wait_deal
-- ----------------------------
INSERT INTO `e_wait_deal` VALUES ('d38233c8c2ee43e79df0f09698ca6089', 'cd2ffa36f1b3495f9b263ba4ef850df8', '41f3fa61f0874f80815765ac60ff92ae', '李亚楼', 'c1c6addcfc2c401889bb54b3de30946b', '小李', '1046b59be1ea4079abaef575a44a0874', '1905建筑', '1', '0', '2018-04-05 17:07:28', null, null);

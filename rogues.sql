CREATE SCHEMA IF NOT EXISTS `rogues` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `rogues`.`rouge` (
	`id` VARCHAR(36) NOT NULL COMMENT '主键',
	`name` VARCHAR(255) NOT NULL COMMENT '名字',
`gender` TINYINT(1) DEFAULT 0 COMMENT '性别 0:未知 1:男 2:女',
`cellphone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
`email` VARCHAR(36) DEFAULT NULL COMMENT '邮箱',
`province` VARCHAR(36) DEFAULT NULL COMMENT '省',
`city` VARCHAR(36) DEFAULT NULL COMMENT '市',
`district` VARCHAR(36) DEFAULT NULL COMMENT '区',
`address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
`single` TINYINT(1) DEFAULT 1 COMMENT '是否单身 0:否 1:是',
`deleted` TINYINT(1) DEFAULT 0 COMMENT '是否已删除 0:否 1:是',
`ctime` BIGINT(13) COMMENT '创建时间',
`mtime` BIGINT(13) COMMENT '更改时间',
`version` INT(11) COMMENT '版本',
PRIMARY KEY (`id`),
INDEX `idx_name` (`name`),
INDEX `idx_cellphone` (`cellphone`),
INDEX `idx_ctime` (`ctime`),
INDEX `idx_mtime` (`mtime`)
) COMMENT = '成员';

CREATE TABLE IF NOT EXISTS `rogues`.`strongpoint` (
	`id` VARCHAR(36) NOT NULL COMMENT '主键',
	`name` VARCHAR(255) NOT NULL COMMENT '据点名称',
`category` VARCHAR(36) DEFAULT '餐饮' COMMENT '据点分类',
`province` VARCHAR(36) DEFAULT NULL COMMENT '省',
`city` VARCHAR(36) DEFAULT NULL COMMENT '市',
`district` VARCHAR(36) DEFAULT NULL COMMENT '区',
`address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
`count` INT(11) DEFAULT 0 COMMENT '去过多少次',
`score` DOUBLE DEFAULT 0.0 COMMENT '评分',
`deleted` TINYINT(1) DEFAULT 0 COMMENT '是否已删除 0:否 1:是',
`ctime` BIGINT(13) COMMENT '创建时间',
`mtme` BIGINT(13) COMMENT '更改时间',
`version` INT(11) COMMENT '版本',
PRIMARY KEY (`id`),
INDEX `idx_name` (`name`),
INDEX `idx_ctime` (`ctime`)
) COMMENT = '据点';

CREATE TABLE IF NOT EXISTS `rogues`.`strongpoint_log` (
	`id` VARCHAR(36) NOT NULL COMMENT '主键',
	`sp_id` VARCHAR(36) NOT NULL COMMENT '据点ID',
`consume_time` BIGINT(13) NOT NULL COMMENT '消费时间',
`consume_amount` BIGINT(13) DEFAULT 0 COMMENT '消费金额',
`users_count` INT(11) NOT NULL COMMENT '去的人数',
`user_ids` VARCHAR(255) NOT NULL COMMENT '去的人',
`deleted` TINYINT(1) DEFAULT 0 COMMENT '是否已删除 0:否 1:是',
`ctime` BIGINT(13) COMMENT '创建时间',
`mtime` BIGINT(13) COMMENT '更改时间',
`version` INT(11) COMMENT '版本',
PRIMARY KEY (`id`),
INDEX `idx_consume_time` (`consume_time`),
INDEX `idx_ctime` (`ctime`)
) COMMENT = '据点日志';
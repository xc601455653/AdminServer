/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/1 20:38:32                            */
/*==============================================================*/


drop table if exists t_dictionary;

drop table if exists t_menu;

drop table if exists t_role;

drop table if exists t_role_menu;

drop table if exists t_user;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: t_dictionary                                          */
/*==============================================================*/
create table t_dictionary
(
   id                   bigint(20) not null comment '主键ID',
   table_name           varchar(20) comment '表名',
   field_name           varchar(20) comment '字段名',
   field_value          int(2) comment '字段值',
   field_label          varchar(20) comment '字段标签',
   des                  varchar(100) comment '描述',
   create_time          datetime comment '创建时间',
   create_id            bigint(20) comment '创建人',
   update_time          datetime comment '更新时间',
   update_id            bigint(20) comment '更新人',
   primary key (id)
);

alter table t_dictionary comment '字典表';

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   id                   bigint(20) not null comment '主键ID',
   menu_name            varbinary(32) comment '菜单名称',
   menu_desc            varbinary(32) comment '菜单描述',
   menu_icon            varbinary(32) comment '菜单图标样式',
   menu_cls             varbinary(32) comment '菜单样式',
   route_name           varbinary(32) comment '路由名称',
   pid                  bigint(20) comment '父级菜单ID',
   menu_level           int(2) comment '菜单级别',
   status               int(2) comment '菜单状态',
   create_time          datetime comment '创建时间',
   create_id            bigint(20) comment '创建人',
   update_time          datetime comment '更新时间',
   update_id            bigint(20) comment '更新人',
   primary key (id)
);

alter table t_menu comment '资源表（菜单表）';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   bigint(20) not null comment '主键ID',
   role_name            varchar(10) comment '角色名称',
   role_desc            varchar(100) comment '角色描述',
   status               int(2) comment '角色状态',
   create_time          datetime comment '创建时间',
   create_id            bigint(20) comment '创建人',
   update_time          datetime comment '更新时间',
   update_id            bigint(20) comment '更新人',
   primary key (id)
);

alter table t_role comment '角色表';

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   id                   bigint(20) not null comment '主键Id',
   role_id              bigint(20) comment '角色id',
   menu_Id              bigint(20) comment '菜单Id',
   create_id            bigint(20) comment '创建人id',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table t_role_menu comment '角色资源关联表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   bigint(20) not null comment '主键ID',
   open_id              varchar(32) comment 'openId',
   user_name            varchar(20) comment '用户名',
   password             varchar(32) comment '密码',
   full_name            varchar(32) comment '全名',
   qq                   varchar(32) comment 'QQ号',
   user_sign            varchar(100) comment '个人签名',
   head_url             varchar(32) comment '头像',
   birthday             date comment '出生日期',
   sex                  int(2) comment '性别',
   school               varchar(32) comment '毕业学校',
   user_info            varchar(200) comment '个人说明',
   email                varchar(32) comment '邮箱',
   phone_number         varchar(32) comment '手机号码',
   tel                  varchar(32) comment '座机号',
   address              varchar(32) comment '详细地址',
   province             int(10) comment '省',
   city                 int(10) comment '市',
   area                 int(10) comment '区',
   status               int(2) comment '状态',
   create_time          datetime comment '创建时间',
   create_id            bigint comment '创建人',
   update_time          datetime comment '更新时间',
   update_id            bigint(20) comment '更新人',
   primary key (id)
);

alter table t_user comment '用户表';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   bigint(20) not null comment '主键Id',
   user_id              bigint(20) comment '用户id',
   roel_id              bigint(20) comment '角色id',
   create_id            bigint(20) comment '创建人id',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table t_user_role comment '用户角色关联表';


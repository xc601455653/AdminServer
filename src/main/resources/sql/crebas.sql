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
   id                   bigint(20) not null comment '����ID',
   table_name           varchar(20) comment '����',
   field_name           varchar(20) comment '�ֶ���',
   field_value          int(2) comment '�ֶ�ֵ',
   field_label          varchar(20) comment '�ֶα�ǩ',
   des                  varchar(100) comment '����',
   create_time          datetime comment '����ʱ��',
   create_id            bigint(20) comment '������',
   update_time          datetime comment '����ʱ��',
   update_id            bigint(20) comment '������',
   primary key (id)
);

alter table t_dictionary comment '�ֵ��';

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   id                   bigint(20) not null comment '����ID',
   menu_name            varbinary(32) comment '�˵�����',
   menu_desc            varbinary(32) comment '�˵�����',
   menu_icon            varbinary(32) comment '�˵�ͼ����ʽ',
   menu_cls             varbinary(32) comment '�˵���ʽ',
   route_name           varbinary(32) comment '·������',
   pid                  bigint(20) comment '�����˵�ID',
   menu_level           int(2) comment '�˵�����',
   status               int(2) comment '�˵�״̬',
   create_time          datetime comment '����ʱ��',
   create_id            bigint(20) comment '������',
   update_time          datetime comment '����ʱ��',
   update_id            bigint(20) comment '������',
   primary key (id)
);

alter table t_menu comment '��Դ���˵���';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   bigint(20) not null comment '����ID',
   role_name            varchar(10) comment '��ɫ����',
   role_desc            varchar(100) comment '��ɫ����',
   status               int(2) comment '��ɫ״̬',
   create_time          datetime comment '����ʱ��',
   create_id            bigint(20) comment '������',
   update_time          datetime comment '����ʱ��',
   update_id            bigint(20) comment '������',
   primary key (id)
);

alter table t_role comment '��ɫ��';

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   id                   bigint(20) not null comment '����Id',
   role_id              bigint(20) comment '��ɫid',
   menu_Id              bigint(20) comment '�˵�Id',
   create_id            bigint(20) comment '������id',
   create_time          datetime comment '����ʱ��',
   primary key (id)
);

alter table t_role_menu comment '��ɫ��Դ������';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   bigint(20) not null comment '����ID',
   open_id              varchar(32) comment 'openId',
   user_name            varchar(20) comment '�û���',
   password             varchar(32) comment '����',
   full_name            varchar(32) comment 'ȫ��',
   qq                   varchar(32) comment 'QQ��',
   user_sign            varchar(100) comment '����ǩ��',
   head_url             varchar(32) comment 'ͷ��',
   birthday             date comment '��������',
   sex                  int(2) comment '�Ա�',
   school               varchar(32) comment '��ҵѧУ',
   user_info            varchar(200) comment '����˵��',
   email                varchar(32) comment '����',
   phone_number         varchar(32) comment '�ֻ�����',
   tel                  varchar(32) comment '������',
   address              varchar(32) comment '��ϸ��ַ',
   province             int(10) comment 'ʡ',
   city                 int(10) comment '��',
   area                 int(10) comment '��',
   status               int(2) comment '״̬',
   create_time          datetime comment '����ʱ��',
   create_id            bigint comment '������',
   update_time          datetime comment '����ʱ��',
   update_id            bigint(20) comment '������',
   primary key (id)
);

alter table t_user comment '�û���';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   bigint(20) not null comment '����Id',
   user_id              bigint(20) comment '�û�id',
   roel_id              bigint(20) comment '��ɫid',
   create_id            bigint(20) comment '������id',
   create_time          datetime comment '����ʱ��',
   primary key (id)
);

alter table t_user_role comment '�û���ɫ������';


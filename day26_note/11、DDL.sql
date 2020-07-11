#һ��DDL
#��һ������database��SQL
#1���鿴��ǰmysql���ݿ��������е��������ݿ�
show databases;

#2��ʹ��ĳ�����ݿ�
use ���ݿ���;

#���磺use test;

#3������һ�����ݿ�
create database ���ݿ���;

#���磺
create database library;

#4��ɾ��һ�����ݿ�
drop database ���ݿ���;

#���磺
drop database  0513db;

#������������ṹ��SQL
1���鿴ĳ�����ݿ��µ����б��
show tables;

mysql> show tables;
ERROR 1046 (3D000): No database selected
������������֣�
��1����use���ٲ������
use ���ݿ���;
show tables;
��2��show tables from ������;

2������ĳ�����
create table �����ݿ���.��������(�ֶ���1 ��������,�ֶ���2 ��������,�ֶ���3 ��������);
create table �����ݿ���.��������(
	�ֶ���1 ��������,
	�ֶ���2 ��������,
	�ֶ���3 ��������
);
˵�������ǰ����use��䣬��ô�����ݿ���.������ʡ��

���磺
create table test.t_stu(
	sid int,
	sname varchar(20),
	gender char,
	birthday date,
	score double
);

3���鿴��ṹ
desc ������;

mysql> desc t_stu;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| sid      | int(11)     | YES  |     | NULL    |       |
| sname    | varchar(20) | YES  |     | NULL    |       |
| gender   | char(1)     | YES  |     | NULL    |       |
| birthday | date        | YES  |     | NULL    |       |
| score    | double      | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
������ͨ��Class���������Ϣ��

4���޸ı�����
rename table �ɱ��� to �±���;
alter table �ɱ��� rename �±���;
���磺
rename table t_stu to student;
alter table student rename t_stu;

5���޸ı�ṹ
��1������һ�У�����һ���ֶ�
alter table ������ add ��column�� �ֶ��� ��������; #Ĭ����ӵ����
alter table ������ add ��column�� �ֶ��� �������� first;
alter table ������ add ��column�� �ֶ��� �������� after ��һ���ֶ�;

���磺����һ�У��洢�绰����
alter table t_stu add  tel char(11);

����һ�У��洢��ַ����ӵ���һ�е�λ��
alter table t_stu add  address varchar(50) first;

����һ�У����䣬��ӵ�sname�ĺ���
alter table t_stu add  age int after sname;

��2���޸ģ��ֶε��������ͻ�λ��
alter table ������ modify  ��column�� �ֶ��� �µ���������;
alter table ������ modify  ��column�� �ֶ��� �������� first;
alter table ������ modify  ��column�� �ֶ��� �������� after ��һ���ֶ�;

���磺�޸�gender����������Ϊchar(2)
alter table t_stu modify   gender char(2);
���磺�޸�address��λ�õ����һ��
alter table t_stu modify   address varchar(50) after tel;

��3���޸ģ��е�����
alter table ������ change  ��column�� ���ֶ���  �µ��ֶ��� ��������;
���磺�޸��е�����telΪphone
alter table t_stu change tel phone char(11); 

��4��ɾ��һ��
alter table ������ drop ��column�� �ֶ���;

���磺ɾ����ַ��
alter table t_stu drop address;

6��ɾ�����ű�
drop table ������;

���磺drop table t_stu;
1������Լ��
�ص㣺
��1��һ��������ֻ����һ������Լ��
��2������Լ����ζ�ţ�Ψһ���ҷǿ�
��3������Լ����PRIMARY
��4�������������Զ�������Ӧ��������ͬ��ɾ��������Ӧ������Ҳ��ɾ��

2���ڽ����ʱ�����ָ������Լ��
create table �����ݿ���.��������(
	�ֶ���1 ��������  primary key,
	�ֶ���2 �������ͣ�
	��������
);

���磺
create table test.t_stu(
	sid int primary key,
	sname varchar(20),
	gender char
);

mysql> desc t_stu;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| sid    | int(11)     | NO   | PRI | NULL    |       |
| sname  | varchar(20) | YES  |     | NULL    |       |
| gender | char(1)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

insert into t_stu values(1,'����','��'),(1,'����','Ů');#�����

mysql> insert into t_stu values(1,'����','��'),(1,'����','Ů');
ERROR 1062 (23000): Duplicate entry '1' for key 'PRIMARY'  Υ��������Լ��

insert into t_stu values(1,'����','��'),(2,'����','Ů');

3����������ָ������Լ��
alter table �����ݿ���.�������� add primary key(�ֶ��б�);

create table test.t_stu(
	sid int,
	sname varchar(20),
	gender char
);
alter table test.t_stu add primary key(sid);

4������Լ����Ϊ���֣�
��1����������Լ��
��2����������Լ��
����ʱ���ָ����������Լ����
create table �����ݿ���.��������(
	�ֶ���1 ��������,
	�ֶ���2 �������ͣ�
	��������,
	primary key(�ֶ��б�)
);
��������ָ����������Լ����
alter table �����ݿ���.�������� add primary key(�ֶ��б�);

create table t_course(
	cid int primary key,
	cname varchar(20)
);

#����Ҫ��sid��cid���������������Ψһ��
create table xuanke(
	sid int,
	cid int,
	score int,
	primary key(sid,cid)
);

5��ɾ������Լ��
alter table �����ݿ���.�������� drop primary key;


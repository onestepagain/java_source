1���ǿ�Լ��
�ص㣺
��1��һ��������кܶ�ķǿ�Լ��
��2���ǿ�Լ��ֻ�����ĳһ���ֶ���˵
��3���ǿ�Լ����ζ�ţ����ֶβ��ܴ���nullֵ

2������ڽ���ʱָ���ǿ�Լ����
create table �����ݿ���.��������(
	�ֶ���1 ��������  primary key,
	�ֶ���2 �������� ��unique key�� not null,
	�ֶ���3 �������� not null��
	��������
);

���磺
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char
);
insert into t_stu values(1,'����','��');

insert into t_stu values(2,null,'��');#�����
ERROR 1048 (23000): Column 'sname' cannot be null

insert into t_stu values(2,'����',null);

3����������ָ��ĳ���ֶηǿ��أ�
alter table �����ݿ���.�������� modify �ֶ��� �������� not null;

create table test.t_stu(
	sid int primary key,
	sname varchar(20),
	gender char
);
alter table t_stu modify sname varchar(20) not null;

4�������ȡ��ĳ���ֶεķǿ�Լ��
alter table �����ݿ���.�������� modify �ֶ��� ��������;

alter table t_stu modify sname varchar(20);
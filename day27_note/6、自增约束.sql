1������Լ��
�ص㣺
��1��һ����ֻ����һ������Լ��
��Ϊһ����ֻ��һ��ά������ֵ�ı�����
��2������Լ������ֻ����������
��3������Լ�����б����Ǽ��У�������Ψһ�����������
ʵ����һ���������������

2������ڽ���ʱָ��ĳ��������
create table �����ݿ���.��������(
	�ֶ���1 xxInt  primary key auto_increment,
	�ֶ���2 �������� ��unique key����not null�� default Ĭ��ֵ,
	�ֶ���3 �������� default Ĭ��ֵ��
	��������
);

create table t_stu(
	sid int auto_increment, #���� 
	sname varchar(20)
);
ERROR 1075 (42000): Incorrect table definition; 
there can be only one auto column and it must be defined as a key

create table t_stu(
	sid int primary key auto_increment,
	sname varchar(20)
);

mysql> desc t_stu;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| sid   | int(11)     | NO   | PRI | NULL    | auto_increment |
| sname | varchar(20) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
2 rows in set (0.01 sec)


3����θ����������������
�����У����ָ��ֵ���Ͱ���ָ�����������û��ָ��ֵ��������
���ָ����ֵ��0��null���Ͱ�������������


insert into t_stu values('����');#�����
ERROR 1136 (21S01): Column count doesn't match value count at row 1' 

insert into t_stu(sname) values('����');  #sid=1
insert into t_stu(sname) values('����');  #sid=2

insert into t_stu values(5,'����');      #sid=5
insert into t_stu(sname) values('����');  #sid=6
insert into t_stu values(0,'Ǯ��');     #sid=7
insert into t_stu values(null,'����');   #sid = 8
insert into t_stu values(-1,'����'); 	#sid=-1
insert into t_stu(sname) values('����');	#sid=9
insert into t_stu values(3,'333');         #sid=3
insert into t_stu(sname) values('���Զ�������');#sid=10

���飺����ʹ��ʱ����Ҫ�Ҳ�

4���������������
alter table �����ݿ���.�������� modify �ֶ��� �������� auto_increment;

5�����ȡ������
alter table �����ݿ���.�������� modify �ֶ��� ��������;


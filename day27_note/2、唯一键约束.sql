1��Ψһ��Լ��
�ص㣺
��1��һ��������ж��Ψһ��Լ��
��2��Ψһ��Լ����ζ�ţ�Ψһ������ΪNULL
��3��Ψһ����Լ���������Լ�ָ����Ҳ����Ĭ�ϣ�
���Ĭ�ϵĻ���һ���������Ψһ��Ĭ�Ͼ���������
����Ƕ������Ψһ����ôĬ���Ǹ���ϵ�1�е����ơ�
��4������Ψһ��Լ����Ҳ���ڶ�Ӧ���Ͻ���������
����ɾ��Ψһ��Լ���ķ�ʽ��ͨ��ɾ����Ӧ������ʵ�ֵġ�

2��Ψһ��Լ��Ҳ�Ƿ�Ϊ����
��1�����е�Ψһ��
��2��������ϵ�Ψһ��

3������ʱ���ָ��Ψһ��
create table �����ݿ���.��������(
	�ֶ���1 ��������  primary key,
	�ֶ���2 �������� unique key�� #ֻ�����ڵ��е�Ψһ��
	��������
);

create table �����ݿ���.��������(
	�ֶ���1 ��������  primary key,
	�ֶ���2 ��������,
	��������,
	unique key(�ֶ���) #�������ڵ��У�Ҳ�����ڶ���
);

create table books(
	bid int primary key,
	bname varchar(20) unique key,
	price double
);

insert into books values
(1,'�������ŵ�������',100),
(2,'�������ŵ�������',88);
ERROR 1062 (23000): Duplicate entry '�������ŵ�������' for key 'bname' 

insert into books values
(1,'�������ŵ�������',100),
(2,'�������ŵ��ɹ���',88);

4����������ָ��Ψһ��Լ��
alter table �����ݿ���.�������� add unique key(�ֶ��б�);

create table books(
	bid int primary key,
	bname varchar(20) ,
	price double
);
alter table books add unique key(bname);

5��ɾ��Ψһ��Լ��
alter table �����ݿ���.�������� drop index ������;

alter table books drop index bname;

6����β鿴ĳ������������
show index from �����ݿ���.��������;

show index from books;


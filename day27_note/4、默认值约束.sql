1��Ĭ��ֵԼ��
�ص㣺
��1��һ��������кܶ��Ĭ��ֵԼ��
��2��Ĭ��ֵԼ��ֻ�����ĳһ���ֶ���˵
��3��Ĭ��ֵԼ����ζ�ţ����ֶ����û���ֶ���ֵ���ᰴĬ��ֵ����

2������ڽ���ʱָ��Ĭ��ֵԼ����
create table �����ݿ���.��������(
	�ֶ���1 ��������  primary key,
	�ֶ���2 �������� ��unique key����not null�� default Ĭ��ֵ,
	�ֶ���3 �������� default Ĭ��ֵ��
	��������
);

���磺
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char default '��'
);

insert into t_stu values(1,'����');
ERROR 1136 (21S01): Column count doesn't match value count at row 1 ' ������ֵ������ƥ��

insert into t_stu values(1,'����',default);
insert into t_stu(sid,sname) values(2,'����');

3����������ָ��ĳ���ֶ���Ĭ��ֵ�أ�
alter table �����ݿ���.�������� modify �ֶ��� �������� default Ĭ��ֵ;

create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char 
);
alter table t_stu modify gender char default '��';

���ѣ����ĳ���ֶμ�Ҫ�ǿգ���ҪĬ��ֵ����ôalter ������������Ҫд��
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char not null
);
����gender����Ĭ��ֵ
alter table t_stu modify gender char default '��' not null;

4�����ȡ��ĳ���ֶε�Ĭ��ֵԼ��
alter table �����ݿ���.�������� modify �ֶ��� �������� ��not null��; #��дĬ��ֵԼ��

insert into t_stu values (1,'����','Ů');
update t_stu set gender = default where sid = 1;

#����DML����ɾ�Ĳ�    ��Ӧ����Ա��˵��DML����Ҫ��Ҫ��������DDL��Ҫ��Ҫ��
1��������ݣ������в�������
��1��insert into �����ݿ���.�������� values(ֵ�б�);
		Ҫ��Ϊ�����и�ֵ��(ֵ�б�)�����͡��������ṹ���е����͡�����һ��
��2��insert into �����ݿ���.��������(�ֶ��б�) values(ֵ�б�);
		Ϊ(�ֶ��б�)ָ�����и�ֵ��(ֵ�б�)��������(�ֶ��б�)�����͡�������Ӧ
��3��insert into �����ݿ���.�������� values(ֵ�б�1),(ֵ�б�2)������;
��4��insert into �����ݿ���.��������(�ֶ��б�) values(ֵ�б�1),(ֵ�б�2)������;

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
5 rows in set (0.01 sec)
���磺
insert into t_stu values(1,'����','��','1995-05-09',89.5);

mysql> insert into t_stu values(2,'����',60);
ERROR 1136 (21S01): Column count doesn't match value count at row 1'

insert into t_stu(sid,sname,score) values(2,'����',60);

insert into t_stu values
(3,'����','��','1993-05-09',80.5),
(4,'����','Ů','1992-05-09',82.5),
(5,'Ǯ��','��','1991-05-09',82.5);

insert into t_stu(sid,sname,score) values
(6,'����',60),
(7,'����',70);

2���޸�
update �����ݿ���.�������� 
set �ֶ���1 = ��ֵ,
	�ֶ���2 = ��ֵ,
	�ֶ���3 = ��ֵ
	������
��where ������;

˵�������û��where������˵���޸������е��⼸���ֶε�ֵ
	
���磺�޸������˵ĳɼ�Ϊ80��
update t_stu set score = 80;

���磺�޸����ĵĳɼ�Ϊ40��
update t_stu set score = 40 where sname = '����';

���磺��û����д�Ա��ѧ�����Ա�����Ϊ'��'
update t_stu set gender = '��' where gender <=> null;
update t_stu set gender = '��' where gender is null;

���磺�޸������˵ĳɼ�����10��
update t_stu set score = score + 10;

3��ɾ������
delete from ������ ��where ������;

���磺ɾ���������ݣ���ṹ����
delete from t_stu;

���磺ɾ���ɼ���82.5��ѧ��
delete from t_stu where score = 82.5;

4����ѯ����
��1��select * from ������;
��2��select * from ������ ��where ������;
��3��select �ֶ��б� from ������ ��where ������;

���磺��ѯȫ��
select * from t_stu;

���磺��ѯ��Щѧ��û����д�Ա�
select * from t_stu where gender is null;

���磺��ѯû����д�Ա��ѧ��������
select sname from t_stu where gender is null;

���磺��ѯû����д�Ա��ѧ���������ͳɼ�
select sname,score from t_stu where gender is null;

5����ѯʱ���ֶ�ȡ����
�ֶ��� as "����"
���У�
(1)���""�еı���û�пո񣬿���ʡ��""
(2)���as����ʡ��

���磺��ѯû����д�Ա��ѧ���������ͳɼ�����ѯ���sname��ʾ������score��ʾ�ɼ�
select sname as "����",score as "�ɼ�" from t_stu where gender is null;

select sname ����,score �ɼ� from t_stu where gender is null;


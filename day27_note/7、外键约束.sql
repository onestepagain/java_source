1�����Լ��
�ص㣺
��1��һ��������кܶ�����Լ��
��2�����Լ������Ҫһ����������ֶλ�������������ֶ�֮�佨�����Լ��
��3�����Լ��һ�����ڴӱ�/�ӱ��н�����
��4���ڴӱ������Լ�����У��������������Լ���ο����У��������е����ƿ��Բ�ͬ��
�������塢�������ͱ���һ�¡�
��5�����Լ����ͬʱԼ��˫������Ϊ��
����������˵���޸ĺ�ɾ������Լ����
���ڴӱ���˵����Ӻ��޸ľ���Լ����
��6�������ο����ֶ�/�б����Ǽ���

����ʱ���Ƚ������ٽ��ӱ�
ɾ��ʱ����ɾ�ӱ���ɾ����

�ӱ��ӱ��ο����˵ģ��������˵�
�����������ο��ģ���������
������
��1�����ű��Ա����
	Ա��������һ���ֶΣ���ʾ��Ա�����ڵĲ���
	���ű�������
	Ա�����Ǵӱ�˵Ա��ѡ������ĸ�����
	�����Ļ������������Ա����
	
	���ű��б�ʾ���ű�ţ���did��ʾ,int����
	Ա�����б�ʾ��Ա�����ڵĲ��ţ����ñ�ű�ʾ������ʹ��did��Ҳ����ʹ��deptid int����
	
��2��ѧ�����γ̱�ѡ�α�
	����ѧ����Ϳγ̱�
	�ӱ�ѡ�α�����������������һ���ο�ѧ����һ���ο��γ̱�
	

2��Լ���ĵȼ���5����
��1��Cascade��ʽ������
	����Ȩ�������ϡ�
	������������ֶ��޸��ˣ��ӱ��Ӧ������ֶθ����޸�
	������������ֶεļ�¼ɾ���ˣ��ӱ��Ӧ������ֶεļ�¼Ҳ��ɾ��
��2��Set null��ʽ
	����Ȩ�������ϡ�
	������������ֶ��޸��ˣ��ӱ��Ӧ������ֶ�����Ϊnull
	������������ֶεļ�¼ɾ���ˣ��ӱ��Ӧ������ֶε�ֵ����Ϊnull
	����Ҫ������ֶα��벻���зǿ�Լ����
��3��No action��ʽ������Ϊ
��4��Restrict��ʽ���ϸ�
  ��3����4�����������ı������ֶε�ֵ�������ˣ���ô����Ը��ֶε��޸ĺ�ɾ���ͱ���ȫ�����ˡ��Ͳ��ܺ�ɾ����
  ��3����4������û������Ȩ�������ȴ���ӱ��Ӧ��ֵ��Ȼ������޸ĺ�ɾ����
��5��Set default��ʽ��mysql��Innodb���治֧�֡�  
  
3������ڽ���ʱָ�����
create table �����ݿ���.���ӱ�����(
	�ֶ���1 xxInt  primary key auto_increment,
	�ֶ���2 �������� ��unique key����not null�� default Ĭ��ֵ,
	�ֶ���3 �������� default Ĭ��ֵ��
	��������,
	foreign key(�ӱ��ĳ�ֶ�) references ������(���ο��ֶ�) ��on update �ȼ�����on delete �ȼ��� 
);
  
���磺
create database 0513db;
use 0513db;

#����
create table dept(
	did int ,
	dname varchar(20)
);	

#�ӱ�
create table emp(
	eid int primary key,
	ename varchar(20),
	did int,
	foreign key(did) references dept(did) on update cascade on delete set null
);
insert into emp values(1,'����',1);#����ģ���Ϊ����û�ж�Ӧ��¼
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)


insert into dept values(1,'��ѯ��'),(2,'��ѧ��')
insert into emp values(1,'����',1);
mysql> insert into emp values(2,'����',4);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)

delete from dept where did = 1;
update dept set did = 5 where did = 2;

4����������ָ�����
alter table �����ݿ���.���ӱ����� add foreign key(�ӱ��ĳ�ֶ�) references ������(���������ֶ�) ��on update �ȼ�����on delete �ȼ��� ;

5�����ɾ�����
alter table �����ݿ���.���ӱ����� drop foreign key Լ����;

alter table emp drop foreign key emp_ibfk_1;

6����β鿴ĳ��������Լ����
SELECT * FROM information_schema.table_constraints WHERE table_name = '������';
	
	
SELECT * FROM information_schema.table_constraints WHERE table_name = 'emp';	
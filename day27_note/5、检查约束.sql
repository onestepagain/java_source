1�����Լ����check
����mysql�ݲ�֧��
��oracle��sql server��ʹ��

create table t_stu(
	sid int primary key,
	sname varchar(20),
	gender char check('��' or 'Ů')
);

insert into t_stu values(1,'����','��');

insert into t_stu values(2,'����','��');
#ע��
#1���鿴��ǰmysql���ݿ��������ж���ʲô���ݿ�
show databases;

#ʹ��һ�����ݿ�
use test;

#���test�����ڣ����Դ���һ���µ����ݿ�
create database test;

#�鿴��ǰ���ݿ��ж���ʲô���
show tables;

#�鿴ĳ���������
select * from ������;
select * from t_employee;

#��ѯ�����˵�н��
select salary from t_employee;
select salary+1000 from t_employee;

#�޸������˵�н�ʣ���1000Ԫ
update t_employee set salary = salary + 1000;

#��ѯн�ʼ���1000Ԫ�󣬳���20000
select * from t_employee where salary+1000 > 20000;



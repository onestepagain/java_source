/*һ�������
1�����������
+����
-����
*����
/����   ���Ա���С������
div����  ����������������ֻ������������
%��������
mod��������
*/
select 1/2; #0.5
select 1 div 2; #0

/*
2���Ƚ������
>������
<��С��
=������  ע������Java����==,mysql����=
>=�����ڵ���
<=��С�ڵ���
!=��������
<>��������
<=>����ȫ����  �����ж�nullֵ�ıȽ������
		nullֵ���жϣ�ϰ����������is null ��is not null
*/
#��ѯн�ʴ���20000Ԫ��Ա��
select * from t_employee where salary > 20000;

#��ѯ������Ա��
select * from t_employee where gender = '��';
select * from t_employee where gender != 'Ů';
select * from t_employee where gender <> 'Ů';

#��ѯ�������commision_pct��null��Ա��
select  * from t_employee where commission_pct <=> null;
select  * from t_employee where commission_pct is null;

/*
3���߼������
&&��and���߼���
	��������ͬʱ����
||��or���߼���
	����������������һ��
^��xor���߼����
	��������ֻ����������һ��
!��not��
	������xx����
	*/
#��ѯн�ʴ���20000Ԫ��ŮԱ��	
select * from t_employee where salary > 20000 && gender = 'Ů';
select * from t_employee where salary > 20000 and gender = 'Ů';

#��ѯ��Ա��
select * from t_employee where not gender = 'Ů';
select * from t_employee where !(gender = 'Ů');

#��ѯн�ʴ���10000  ��� �Ա����еģ�������ֻ������һ��
#����ѯн�ʴ���10000��Ů�Ļ�н�ʵ���10000���е�
select * from t_employee where salary>10000 ^ gender ='��';
select * from t_employee where salary>10000 xor gender ='��';
/*
4����Χ
��1�����䷶Χ��
	��[a,b]֮�䣬between a and b
	����[a,b]֮�䣬not between a and b
��2�����Ϸ�Χ
	in(...)
	not in(...)
*/
#��ѯн����[15000,20000]֮���Ա��
select * from t_employee where salary between 15000 and 20000;
select * from t_employee where salary >= 15000 and salary <=20000;

#��ѯн����9000,10000,12000
select * from t_employee where salary in(9000,10000,12000);
select * from t_employee where salary =9000 || salary =10000 || salary =12000;
 /*
5��ģ����ѯ
like '%x%' x����ȷ�����ַ� %��ʾ��ȷ����0~n���ַ�
     '_x%'  x����ȷ�����ַ� _��ʾȷ����1���ַ�
*/
#��ѯ������ename�а�������������ֵ�Ա��
select * from t_employee where ename like '%��%';

#��ѯ������ename����xx��������
select * from t_employee where ename like '��__';

#��ѯ������ename�ǵڶ�������'��'
select * from t_employee where ename like '_��%';

/*
����(array)��
	�򵥵�˵������һ����
	
	��һ�����ݵ��������ͣ�������һ����ʱ����ôΪ�˷����ͳһ�Ĺ������ǣ�������Ҫ
	���µ����ݵĴ洢�ṹ�����д洢�����磺����
	
��ν����(Array)��������ͬ�������͵�Ԫ�ذ�һ��˳�����еļ��ϣ�
���ǰ����޸�������ͬ�ı�����һ�������������Ա�ͳһ�������ǣ�
Ȼ���ñ���������ǣ�������ֳ�Ϊ����������ų�Ϊ�±������(index)��
�������ĸ���������Ϊ�����Ԫ��(element)��������Ԫ�صĸ�����Ϊ����ĳ���(length)��	

int[] scores = new int[7];
scores[0] = 89;
�����������磺scores
�±꣺��Χ��[0,����-1]
	���磺[0]
Ԫ�أ�������[�±�]
	���磺scores[0]

����ĳ��ȣ�Ԫ�ص��ܸ�����������ô��ʾ��   ������.length
*/
class Test01_Array{
	public static void main(String[] args){
		/*
		Ҫ�洢����ѧԱ�ĳɼ������磺��1�飬��7��ͬѧ
		*/
		/*
		int score1 = 89;
		int score2 = 89;
		int score3 = 67;
		int score4 = 99;
		int score5 = 89;
		int score6 = 34;
		int score7 = 89;
		
		//��7�������洢û���⣬��������漰�������ݵĹ��������磬����ֵ������ȣ��ͷǳ��鷳
		*/
		int[] scores = new int[7];//��scores��һ��ͳһ�����ƣ�������7��int���͵�Ԫ��
		scores[0] = 89;//ÿһ��Ԫ�ض����Լ����±꣬��ţ�����
		scores[1] = 89;
		scores[2] = 67;
		scores[3] = 99;
		scores[4] = 89;
		scores[5] = 34;
		scores[6] = 89;
	//	scores[7] = 56;// java.lang.ArrayIndexOutOfBoundsException:�����±�Խ���쳣
		
		System.out.println(scores.length);
	}
}
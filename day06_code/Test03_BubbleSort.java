/*
������㷨��
1������ֵ
2������ֵ�����±�
3��ͳ�ƣ��ۼӺ͡�ƽ��ֵ��
4����ת
5������
6�����ң��������У�����ĳ��ֵ�Ƿ���ڣ����߲���ĳ��ֵ���±�
��1�������е�Ԫ���������
	˳�����
��2�������е�Ԫ���������
	��˳�����
	�ڶ��ֲ���
7�����������
��1��ð������
��2��ֱ��ѡ������
*/
class Test03_BubbleSort{
	public static void main(String[] args){
		int[] arr = {4,2,1,8,3};
		
		//ϣ������������{1,2,3,4,8}��{8,4,3,2,1}
		//����Ҫʵ�ִ�С����
		/*
		ð������ͨ������Ԫ�رȽϣ��������Ԫ�ص�˳�򲻷���Ҫ����ô�ͽ�����
				 ��������֮��ʵ�����յ�����ÿһ�ֶ�����һ���Ѿ�������ȷλ�õ�Ԫ���˳��Ƚϡ�
				 
		��һ�֣�
			��1�Σ�arr[0]��arr[1]�Ƚϣ�4��2�Ƚϣ�������Ҫ�󣬽�����{2,4,1,8,3}
			��2�Σ�arr[1]��arr[2]�Ƚϣ�4��1�Ƚϣ�������Ҫ�󣬽�����{2,1,4,8,3}
			��3�Σ�arr[2]��arr[3]�Ƚϣ�4��8�Ƚϣ�����Ҫ��
			��4�Σ�arr[3]��arr[4]�Ƚϣ�8��3�Ƚϣ�������Ҫ�󣬽�����{2,1,4,3,8}
		
		��һ��֮�����ģ������ף��ܵ����ұ�
		
		�ڶ��֣�
			��1�Σ�arr[0]��arr[1]�Ƚϣ�2��1�Ƚϣ�������Ҫ�󣬽�����{1,2,4,3,8}
			��2�Σ�arr[1]��arr[2]�Ƚϣ�2��4�Ƚϣ�����Ҫ��
			��3�Σ�arr[2]��arr[3]�Ƚϣ�4��3�Ƚϣ�������Ҫ�󣬽�����{1,2,3,4,8}
		
		�ڶ���֮�󣬴δ�ĵ�����ȷλ��
		
		�����֣�
			��1�Σ�arr[0]��arr[1]�Ƚϣ�1��2�Ƚϣ�����Ҫ��
			��2�Σ�arr[1]��arr[2]�Ƚϣ�2��3�Ƚϣ�����Ҫ��
			
		�����֣�
			��1�Σ�arr[0]��arr[1]�Ƚϣ�1��2�Ƚϣ�����Ҫ��
			
		���� = ����ĳ��� - 1; //��Ϊÿһ��ֻ��ȷ��һ��
		*/
		//����
		for(int i=1; i<arr.length; i++){//ѭ������ = ���� -1����������
			/*
			���磺5��Ԫ��
			ÿһ�ֵĴ��� = ���� - i;
			��1�֣�4��
			��2�֣�3��
			��3�֣�2��
			��4�֣�1��
			
			��1�֣�arr[0]��arr[1]��arr[1]��arr[2]��arr[2]��arr[3]��arr[3]��arr[4]
			��2�֣�arr[0]��arr[1]��arr[1]��arr[2]��arr[2]��arr[3]
			��3�֣�arr[0]��arr[1]��arr[1]��arr[2]
			��4�֣�arr[0]��arr[1]
			
			����Ԫ�أ�arr[j] �� arr[j+1]
			��1�֣�j��ֵ ��0,1,2,3  j<4		j<5-1	j<5-i
			��2�֣�j��ֵ ��0,1,2	j<3		j<5-2
			��3�֣�j��ֵ ��0,1		j<2		j<5-3
			��4�֣�j��ֵ ��0		j<1		j<5-4
			*/
			for(int j=0; j<5-i; j++){
				if(arr[j] > arr[j+1]){//����Ԫ�رȽϣ���>�ң�����
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//��ʾ���
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
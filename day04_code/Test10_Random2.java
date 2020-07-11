/*
在Java的核心类库中，除了在Math类中提供了random()来产生随机数，
还在java.util.Random类中也提供产生随机数的方法。
*/
class Test10_Random2{
	public static void main(String[] args){
		//(1)先准备产生随机数的工具
		java.util.Random tools = new java.util.Random();
		
		//(2)用工具获取随机数
		int num = tools.nextInt();
		System.out.println("随机整数：" + num) ;
		
		double d = tools.nextDouble();
		System.out.println("随机小数：" + d) ;
		
		//(3)用工具获取一定范围内的随机值
		int rangeNum = tools.nextInt(10);//[0,10)
		System.out.println("随机[0,10)整数：" + rangeNum) ;
	}
}
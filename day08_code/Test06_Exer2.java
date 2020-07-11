/*
2、声明一个数学工具类，包含如下方法：
（1）可以求0~n字符串的拼接结果
（2）可以求1~n整数的乘积

*/
class Test06_Exer2{
	public static void main(String[] args){
		MyMath my = new MyMath();
		System.out.println("拼接结果：" + my.concat("尚硅谷", "是","一家","靠谱的","培训机构"));
		System.out.println("5! = " + my.mutiply(1,2,3,4,5));
	}
}
class MyMath{
	//（1）可以求0~n字符串的拼接结果
	String concat(String... args){
		String str = "";//空字符串
		for(int i=0; i<args.length; i++){
			str += args[i];
		}
		return str;
	}	
	
	//（2）可以求1~n整数的乘积
	long mutiply(int a, int... nums){
		long result = a;
		for(int i=0; i<nums.length; i++){
			result *= nums[i];
		}		
		return result;
	}
}
/*
值：数据
变量：用来保存/存储值
表达式：
	用来计算的
语句：
	可以独立执行的，并且是要完成一件事情的。
	不是所有的表达式直接加;就可以构成语句的。

流程控制语句结构：
1、顺序结构（每一步都要走，而且从上往下顺着走）
2、分支结构（选择其中一个分支运行）
3、循环结构（重复执行某些语句）
*/
class Test01_Statement{
	public static void main(String[] args){
		int a = 10;
		//a;//没有意义，什么也没干
		//a>0?true:false;//这个表达式算完后，没有做具体的事情，例如：打印还是赋值等这些事情
		System.out.println("a = " + a);
		
		if(a%2==0){
			System.out.println(a+"是偶数");
		}else{
			System.out.println(a+"是奇数");
		}
		
		for(int i=1; i<=5; i++){
			System.out.println("柴老师真漂亮！");
		}
	}
}

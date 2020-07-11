package com.atguigu.test04;

/*
 * 一、异常的处理方式：try...catch
 * 1、语法格式：
 * try{
 * 		可能发生异常的代码
 * }catch(异常类型1  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }catch(异常类型2  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }catch(异常类型3  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }
 * 。。。。
 * 
 * 2、异常对象的常用方法
 * （1）e.printStackTrace();
 * 打印异常的详细信息，包括追踪跟踪信息，即这个异常对象一路经过了哪些方法
 * （2）e.getMessage()；
 * 返回异常对象中简单的错误信息提示
 * 
 * 3、打印异常/错误信息
 * System.err.println(xx);打印错误信息
 * 
 * System.out.println(xx);打印正常信息
 * 
 * 4、多个catch分支，如何匹配和执行的？
 * 从上到下依次判断，一旦有一个满足，后面就不看了。
 * 
 * 建议：如果多个catch中的异常类型有大小包含关系，那么小的在上，大的在下，如果没有大小包含关系，顺序随意。
 * 
 * 5、如果catch，可以捕获try中发生的异常，那么程序，会从try...catch下面的代码继续运行 ，不会崩溃。
 * 	如果catch无法捕获try中发生的异常，那么就会导致当前方法结束，并把异常对象抛出调用者，
 * 如果调用者可以处理，那么从调用者处理代码的后面继续运行，否则继续往上抛，最终到达JVM，程序就崩溃了。
 */
public class TestTryCatch {
	//从命令行接收2个整数，求商
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);//第一个参数赋值给a变量
			int b = Integer.parseInt(args[1]);//第二个参数赋值给b变量
			int shang = a/b;
			System.out.println(a +"/" + b + "=" + shang);
		} catch (NumberFormatException e) {
			e.printStackTrace();//标准的
//			System.err.println(e.getMessage());
//			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		} catch (ArithmeticException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} 
		
		
		System.out.println("其他的代码....");
	}
}

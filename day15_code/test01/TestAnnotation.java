package com.atguigu.test01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 一个注解有三部分组成：
 * （1）声明
 * （2）使用
 * （3）读取
 * 
 * 一、声明注解
 * 1、形式一
 * @元注解
 * 【修饰符】 @interface 注解名{
 * }
 * 
 * 2、形式二
 * @元注解
 * 【修饰符】 @interface 注解名{
 * 		配置参数列表;
 * }
 * 说明：
 * （1）如果声明注解时，有配置参数，那么在使用注解的时候，需要给这个配置参数赋值
 * 例如：
 * @SuppressWarings("all")
 * @Target(ElementType.TYPE)
 * 
 * （2）如果注解的配置参数只有一个，并且名字是value，那么在使用赋值时，可以省略"value="，
 * 其他的配置参数名称不可以省略
 * 
 * 建议：大家在声明配置参数时，首先考虑使用value
 * 
 * （3）这个配置参数的类型有要求：
 * ①8种基本数据类型
 * ②String
 * ③枚举
 * ④Class类型
 * ⑤Annotation类型
 * ⑥以上这些类型的数组
 * 
 * （4）配置参数可以有默认值
 * @元注解
 * 【修饰符】 @interface 注解名{
 * 		数据类型  参数名()  default 默认值;
 * }
 * 如果这个配置参数有默认值，那么在使用时可以不用赋值，也可以重新赋值
 * 
 * 回忆：default
 * ①switch
 * ②接口的默认方法
 * ③自定义注解的配置参数的默认值
 * 
 */
public class TestAnnotation {
	public static void main(String[] args) {
		//3、读取，我们到反射时再说
	}
}

//1、声明注解
@Target(ElementType.TYPE)//表示MyAnnotation这个注解只能用在类、接口等上面
@Retention(RetentionPolicy.RUNTIME)//表示MyAnnotation这个注解可以滞留到运行时，可以被反射读取到
@interface MyAnnotation{
	
}

//2、使用注解
@MyAnnotation
class MyClass{
	
}

//1、声明另一个注解
@Target(ElementType.TYPE)//表示YourAnnotation这个注解只能用在类、接口等上面
@Retention(RetentionPolicy.RUNTIME)//表示YourAnnotation这个注解可以滞留到运行时，可以被反射读取到
@interface YourAnnotation{
	String value() default "尚硅谷";
}

//2、使用这个注解
@YourAnnotation//这个atguigu的值是要读取注解的程序使用的
class YourClass{
	
}
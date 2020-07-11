package com.atguigu.test02;

/*
 * 这些函数式接口集中在java.util.function包中。
 * 四大类：
 * （1）消费型接口
 * 		它的抽象方法有一个特征：    有参无返回值		例如：void accept(T t)
 * （2）供给型接口
 * 		它的抽象方法有一个特征：    无参有返回值		例如：T get()
 * （3）判断型接口
 * 		它的抽象方法有一个特征：    有参有返回值，但是返回值类型是boolean   例如：boolean  test(T t)
 * （4）功能型接口
 * 		它的抽象方法有一个特征：    有参有返回值	       例如： R apply(T t)
 * 
 * 一、消费型接口
 * 经典代表：
 * 		Consumer<T>   抽象方法  void accept(T t)  
 * 
 * 延伸代表：各种变形们

（1）BiConsumer<T,U>	void accept(T t, U u) 	接收两个对象用于完成功能
（2）
DoubleConsumer	void accept(double value) 		接收一个double值
IntConsumer		void accept(int value)  		接收一个int值
LongConsumer	void accept(long value)  		接收一个long值
（3）
ObjDoubleConsumer<T>	void accept(T t, double value)  	接收一个对象和一个double值
ObjIntConsumer<T>		void accept(T t, int value) 		接收一个对象和一个int值
ObjLongConsumer<T>		void accept(T t, long value) 		接收一个对象和一个long值
 * 
 * 
 * 总结：（1）消费型接口，都以“Consumer”单词为结尾
 * 	         （2）Bi开头，传两个参数   Binary（二元的）
 * 	          （3）xxConsumer，前面的xx代表形参类型
 *
 * 二、供给型接口
 * 经典代表：
 * 	 Supplier<T>   抽象方法    T get()  
 * 
 * 延伸的代表们：
 *（1）BooleanSupplier	boolean getAsBoolean()  	返回一个boolean值
 *（2）DoubleSupplier		double getAsDouble()  		返回一个double值
 *（3）IntSupplier		int getAsInt()  			返回一个int值
 *（4）LongSupplier		long getAsLong()  			返回一个long值
 *
 *  总结：（1）供给型接口以“Supplier”单词结尾
 *  	（2）xxSupplier说明返回xx类型的结果
 *  	（3）供给型接口的抽象方法都是无参的
 *  
 *  
 * 三、判断型接口
 * 经典代表：
 * 		Predicate<T>  抽象方法    boolean test(T t)  
 * 
 * 延伸代表们：
（1）BiPredicate<T,U>		boolean test(T t, U u)  		接收两个对象
（2）DoublePredicate		boolean test(double value)  	接收一个double值
（3）IntPredicate			boolean test(int value)  		接收一个int值
（4）LongPredicate		boolean test(long value) 		接收一个long值
 *
 *	总结：（1）判断型接口以“Predicate”结尾
 *		（2）判断型接口抽象方法的返回值类型是固定的，是boolean
 *		（3）xxPredicate，说明形参是xx类型的
 *
 * 四、功能型接口
 * 	  经典代表：
 * 		Function<T,R>   抽象方法    R apply(T t)  
 * 
 *  延伸代表：
 *  （1）UnaryOperator<T>	T apply(T t)	接收一个T类型对象，返回一个T类型对象结果
 *  （2）
 *  DoubleFunction<R>	R apply(double value)  	接收一个double值，返回一个R类型对象
	IntFunction<R>		R apply(int value)		接收一个int值，返回一个R类型对象
	LongFunction<R>		R apply(long value)		接收一个long值，返回一个R类型对象
 *  （3）
 *  ToDoubleFunction<T>	double applyAsDouble(T value) 	接收一个T类型对象，返回一个double
	ToIntFunction<T>	int applyAsInt(T value)  		接收一个T类型对象，返回一个int
	ToLongFunction<T>	long applyAsLong(T value) 		接收一个T类型对象，返回一个long
 *  （4）
	DoubleToIntFunction		int applyAsInt(double value)  		接收一个double值，返回一个int结果
	DoubleToLongFunction	long applyAsLong(double value) 		接收一个double值，返回一个long结果
	IntToDoubleFunction		double applyAsDouble(int value) 	接收一个int值，返回一个double结果
	IntToLongFunction		long applyAsLong(int value)  		接收一个int值，返回一个long结果
	LongToDoubleFunction	double applyAsDouble(long value)  	接收一个long值，返回一个double结果
	LongToIntFunction		int applyAsInt(long value) 			接收一个long值，返回一个int结果
 *  （5）
	DoubleUnaryOperator	double applyAsDouble(double operand)  	接收一个double值，返回一个double
	IntUnaryOperator	int applyAsInt(int operand)  			接收一个int值，返回一个int结果
	LongUnaryOperator	long applyAsLong(long operand)  		接收一个long值，返回一个long结果
	
 *  （6）BiFunction<T,U,R>	R apply(T t, U u) 	接收一个T类型和一个U类型对象，返回一个R类型对象结果
 *  （7）BinaryOperator<T>	T apply(T t, T u) 	接收两个T类型对象，返回一个T类型对象结果
	（8）	ToDoubleBiFunction<T,U>  double applyAsDouble(T t, U u) 	接收一个T类型和一个U类型对象，返回一个double
		ToIntBiFunction<T,U>	 int applyAsInt(T t, U u) 	接收一个T类型和一个U类型对象，返回一个int
		ToLongBiFunction<T,U>	long applyAsLong(T t, U u) 	接收一个T类型和一个U类型对象，返回一个long
		
	（9）	DoubleBinaryOperator	double applyAsDouble(double left, double right)  	接收两个double值，返回一个double结果
		IntBinaryOperator	int applyAsInt(int left, int right) 	接收两个int值，返回一个int结果
		LongBinaryOperator	long applyAsLong(long left, long right)  	接收两个long值，返回一个long结果
 *  
 *  
 *  总结：（1）以Unary开头的，表示一元的，泛型的类型只有一个，形参和返回值都是同一种类型
 *  	（2）xxFunction，说明形参的类型是xx类型的
 *  	（3）toXXFunction，说明返回值类型是xx类型
 *  	（4）xxToyyFunction，说明形参的类型是xx类型的,返回值类型是yy类型
 *  	（5）xxUnary开头的，表示一元，形参类型和返回值类型都是xx
 *  	（6）Bi开头，表示二元，形参类型是2个
 *  	（7）BinaryOperator，既是Bi开头表示两个形参，又是Operator结尾，表示形参和返回值类型是一样
 *  	（8）toXXBi开头的，表返回值类型是xx，并且形参是两个
 *  	（9）xxBinaryOperator，表示两个形参，又是Operator结尾，表示形参和返回值类型是一样
 */
public class Test03 {

}

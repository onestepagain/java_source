package com.atguigu.test02;

/*
 * 函数式接口：SAM接口
 *    Single Abstract Method，即该接口中只有一个抽象方法需要实现，当然该接口可以包含其他非抽象方法（默认方法和静态方法，或者是从Object继承的方法）。
 *    
 *    
 * 回忆之前学过的接口：
 * （1）Runnable
 * （2）Comparable
 * （3）Comparator
 * （4）Iterable
 * （5）Iterator
 * （6）Collection，Set，List，Map，Queue，Deque....
 * （7）Serializable
 * （8）Externalizable
 * （9）FileFilter
 * （10）InvocationHandler
 * ....
 * 
 * 哪些是符号SAM特征的呢？
 * （1）Runnable      public void run()
 * （2）Comparable    public int compareTo(T t)
 * （3）Comparator    public int compare(T t1, T t2)
 * （4）Iterable  	 public Iterator iterator()
 * （5）FileFilter   public boolean accept(File pathname);
 * （6）InvocationHandler   public Object invoke(Object proxy, Method method, Object[] args)
 * 
 * 按照语法来说，只要符号SAM特征的接口，都可以使用Lambda表达式。
 * 但是Java建议只针对标记了@FunctionalInterface这注解的SAM接口使用Lambda表达式
 * 
 * 上面哪些标记了@FunctionalInterface注解：
 * （1）Runnable      public void run()
 * （3）Comparator    public int compare(T t1, T t2)
 * （5）FileFilter   public boolean accept(File pathname);
 * 
 * 如果没有标记@FunctionalInterface注解的，说明它考虑了以后可能增加抽象方法。目前使用没问题，就是以后可能有风险。
 * 
 * Java8增加了大量的函数式接口给我们使用，而且基本上能满足常规的所有情况。
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
 */
public class Test02 {

}

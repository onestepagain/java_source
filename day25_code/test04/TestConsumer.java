package com.atguigu.test04;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.junit.Test;

public class TestConsumer {
	@Test
	public void test01(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		/*
		 * default void forEach(Consumer<? super T> action)
		 * 形参的类型是Consumer接口，可以使用Lambda表达式赋值
		 * Consumer<T>  void accept(T t)
		 * 
		 */
		list.forEach(num -> System.out.println(num));
	}
	
	/*
	 *default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
	 */
}

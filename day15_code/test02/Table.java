package com.atguigu.test02;

//import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(ElementType.TYPE)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String value();
}

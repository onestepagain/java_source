package com.atguigu.test06.exer;

import java.util.Comparator;

/*
 * （4）声明SalaryComparator类，实现java.util.Comparator接口，
		重写抽象方法，按照薪资从高到低排序
 */
public class SalaryComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		
		if(e1.getSalary() > e2.getSalary()){
			return -1;
		}else if(e1.getSalary() < e2.getSalary()){
			return 1;
		}
		return 0;
	}

}

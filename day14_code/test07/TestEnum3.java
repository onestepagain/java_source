package com.atguigu.test07;

/*
 * 补充：枚举类型实现接口
 */
public class TestEnum3 {
	public static void main(String[] args) {
		MyEnum a = MyEnum.A;
		a.test();
		
		MyEnum b = MyEnum.B;
		b.test();
	}
}
interface MyInter{
	void test();
}
enum MyEnum implements MyInter{
	A{
		@Override
		public void test() {
			System.out.println("aaa");
		}
	},B{
		@Override
		public void test() {
			System.out.println("bbb");
		}
	}
}
/*enum MyEnum implements MyInter{
	A,B;

	@Override
	public void test() {
		System.out.println("test");
	}
}*/
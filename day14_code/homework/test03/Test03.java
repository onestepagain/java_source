package com.atguigu.homework.test03;

import java.util.Scanner;

/*
 * * 模拟玩家选择角色。
* 定义接口FightAble：
  * 抽象方法：specialFight。
  * 默认方法：commonFight,方法中打印"普通打击"。
* 定义战士类：
  * 实现FightAble接口,重写方法中打印"武器攻击"。
* 定义法师类Mage：
  * 实现FightAble接口,重写方法中打印"法术攻击"。
* 定义玩家类Player：
  * 静态方法：FightAble select(String str)，根据指令选择角色。
    * 法力角色，选择法师。
    * 武力角色，选择战士。
* 代码实现，效果如图所示：
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("选择：");
		String role = input.next();
		
		FightAble f = Player.select(role);
		f.specialFight();
		f.commonFight();
		
		System.out.println("================");
		System.out.print("选择：");
		String role2 = input.next();
		
		FightAble f2 = Player.select(role2);
		f2.specialFight();
		f2.commonFight();
	}
}
interface FightAble{
	void specialFight();
	public default void commonFight(){
		System.out.println("普通打击");
	}
}
class Soldier implements FightAble{

	@Override
	public void specialFight() {
		System.out.println("武器攻击");
	}
	
}
class Mage implements FightAble{

	@Override
	public void specialFight() {
		System.out.println("法术攻击");
	}
	
}
class Player{
	public static FightAble select(String str){
		if("法力角色".equals(str)){
			return new Mage();
		}else if("武力角色".equals(str)){
			return new Soldier();
		}
		return null;
	}
}
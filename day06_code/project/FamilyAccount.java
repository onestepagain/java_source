class FamilyAccount{
	public static void main(String[] args){
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		boolean flag = true;
		
		int balance = 10000;//基本金
		String details = "收支\t账户金额\t收支金额\t说    明\n";

		while(flag){
			System.out.println("-----------------家庭收支记账软件-----------------");

			System.out.println("\t\t1 收支明细");
			System.out.println("\t\t2 登记收入");
			System.out.println("\t\t3 登记支出");
			System.out.println("\t\t4 退    出");

			System.out.print("请选择(1-4)：");
			int select = input.nextInt();//接收用户的选择
			
			//判断用户的选择，进行对应的操作
			switch(select){
				case 1:
					System.out.println(details);
					break;
				case 2:
					System.out.print("本次收入金额：");
					int money = input.nextInt();
					
					System.out.print("本次收入说明：");
					String info = input.next();
					
					balance += money;
					//收入    1000           11000            劳务费
					details += "收入\t" + money + "\t\t" + balance + "\t\t" + info + "\n";
					break;
				case 3:
					System.out.print("本次支出金额：");
					money = input.nextInt();
					
					System.out.print("本次支出说明：");
					info = input.next();
					
					balance -= money;
					//支出    800            10200            物业费
					details += "支出\t" + money + "\t\t" + balance + "\t\t" + info + "\n";
					break;
				case 4:
					System.out.print("确认是否退出(Y/N)：");
					char confirm = input.next().charAt(0);
					if(confirm == 'Y' || confirm =='y'){
						flag = false;
					}
			}
		}
	}
}
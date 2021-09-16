
public class FamilyAccount
{
	public static void main(String args[])
	{
		boolean isFlag = true;
		String details = "收支-------账户金额--------收支金额-------说明\n";
		//初始金额
		int balance = 10000;
		label:for(;;)
		{
			System.out.println("---------------家庭收支记账软件---------------");
			System.out.println("---------------1 . 收  支  明  细---------------");
			System.out.println("---------------2 . 登  记  收  入---------------");
			System.out.println("---------------3 . 登  记  支  出---------------");
			System.out.println("---------------4 . 退             出---------------");
			System.out.println("---------------请 选 择  (1 - 4)---------------");
			//获取用户的选择：1-4
			char selection = Utility.readMenuSelection();
			switch(selection)
			{
			case '1':
				//System.out.println("---------------1 . 收  支  明  细---------------");
				System.out.println("---------------当前收支明细记录---------------");
				
				//System.out.println("收支-------账户金额--------收支金额-------说明");
				System.out.println(details);
				System.out.println("---------------------------------------------");
				
				break;
			case '2':
				System.out.println("---------------2 . 登  记  收  入---------------");
				
				System.out.println("本次收入金额:");
				int inCome = Utility.readNumber();
				
				System.out.println("本次收入说明:");
				String explain = Utility.readString();
				
				//处理balance
				balance += inCome;
				
				//处理details
				details += ("收入-------" + balance + "-----------" + inCome + "-----------" + explain + "\n");
				
				System.out.println("---------------2 . 登  记  完  成---------------\n");
				break;
			case '3':
				System.out.println("---------------3 . 登  记  支  出---------------");
				System.out.println("本次支出金额:");
				int outCome = Utility.readNumber();
				System.out.println("本次支出说明:");
				String outExplain = Utility.readString();
				//处理支出后的余额
				balance -= outCome;
				//处理支出后的账户信息
				details += ("收入-------" + balance + "------------" + outCome + "-----------" + outExplain + "\n");
				System.out.println("---------------3 . 登  记  完  成---------------");
				
				break;
			case '4':
				//退出
				System.out.println("--------------确认是否退出 (Y/N)--------------");
				char isExit = Utility.readConfirmSelection();
				if(isExit == 'Y')
				{
					break label;
				}
				
				//break;
			}
		}
		
	}
}

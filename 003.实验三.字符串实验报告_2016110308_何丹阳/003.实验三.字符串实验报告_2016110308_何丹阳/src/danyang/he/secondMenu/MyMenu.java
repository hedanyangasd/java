/**
 * Author:何丹阳
 * Date:2018-10-6
 * Version:2.0
 * function:主菜单，没登录之前的各种功能
**/
package danyang.he.secondMenu;

public class MyMenu {
	public static void main(String[] args){
		boolean exit=true;
		SetMenu menu=new SetMenu();		
		do{
		menu.menubegin();
		int operation=menu.judg();
		switch (operation){
			case 1:
				menu.loginregister();
				break;
			case 2:				
			case 3:
			case 4:	
				menu.remindre();
				break;
			case 5:
				System.out.println("谢谢使用，再见");
				exit=false;
				break;
			default:
				System.out.println("输入不对，请重新选择！");
		}
		}while(exit);
	}
}

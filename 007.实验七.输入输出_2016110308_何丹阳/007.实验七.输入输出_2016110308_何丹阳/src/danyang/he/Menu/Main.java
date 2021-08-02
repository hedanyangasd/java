/**
 * Author:何丹阳
 * Date:2018-11-12
 * Version:3.0
 * function:主菜单，整个程序执行的开始
**/
package danyang.he.Menu;

public class Main {
	public static int isloginsuccess;
	
	public static void main(String[] args){
		boolean exit=true;
		SetMenu setmenu=new SetMenu();	
		MyMenu menu=new MyMenu();
		do{
			menu.menubegin();
			int operation=menu.judg();
			switch (operation){
			case 1:
				setmenu.loginregister();
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
				System.out.println("输入不对，请重新选择");
		}
		}while(exit);
	}
}

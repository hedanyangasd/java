/**
 * Author:何丹阳
 * Date:2018-9-16
 * Version:1.0
**/
package danyang.he.menu;
import java.util.Scanner;

public class Menu {
	public static void func(){
		System.out.println("正在执行某功能");
	}
	public static void main(String[] args){
		boolean exit1=true;
		Scanner input=new Scanner(System.in);
		do{
			boolean cont1=true;
			System.out.println("1.登录系统");
	  	    System.out.println("2.系统设置");
		    System.out.println("3.写日记");
		    System.out.println("4.查找日记");
		    System.out.println("5.退出系统");
		    System.out.println("请输入选择");
		    while(cont1){
		       	if(!input.hasNextInt()){
		       		input.nextLine();
	    		 	System.out.println("输入不对，请重新选择！");	
	    		 	System.out.println("1.登录系统");
	    	  	    System.out.println("2.系统设置");
	    		    System.out.println("3.写日记");
	    		    System.out.println("4.查找日记");
	    		    System.out.println("5.退出系统");
	    		    System.out.println("请输入选择");
	    		}
	    		else{
  	    			cont1=false;
	    		}
    		}
		    int operation=input.nextInt();
		    switch (operation){
			case 1:
			case 2:
			case 3:
				func();
				break;
			case 4:		
				boolean exit2=true;
				do{
					boolean cont2=true;
					System.out.println("1.按标题查找：");
					System.out.println("2.按内容查找：");
					System.out.println("3.按日期查找：");
					System.out.println("4.按心情查找：");
					System.out.println("5.按天气查找：");
					System.out.println("6.返回上一级菜单：");	
				    System.out.println("请输入选择");
				    while(cont2){
					if(!input.hasNextInt()){
						System.out.println("输入不对，请重新选择！");	
						System.out.println("1.按标题查找：");
						System.out.println("2.按内容查找：");
						System.out.println("3.按日期查找：");
						System.out.println("4.按心情查找：");
						System.out.println("5.按天气查找：");
						System.out.println("6.返回上一级菜单：");	
						System.out.println("请输入选择");
						input.nextLine();
					}
					else{
						cont2=false;
					}
				  }
				    int operation1=input.nextInt();
				    switch (operation1){
				    case 1:
				    case 2:
				    case 3:
				    case 4:
				    case 5:
				  	      func();
					      break;
				    case 6:
				    	exit2=false;
				    	break;
				    default:
						System.out.println("输入不对，请重新选择！");	
				    }
				}while(exit2);
				break;
			case 5:
				System.out.println("谢谢使用，再见");
				exit1=false;
				break;	
			default:
				System.out.println("输入不对，请重新选择！");	
		     }
		}while(exit1);
	}
}



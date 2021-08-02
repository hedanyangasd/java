/**
 * Author:何丹阳
 * Date:2018-10-6
 * Version:2.0
 * function:菜单类
**/package danyang.he.Menu;

import java.util.Scanner;

public class MyMenu {
	public void remindre(){
		System.out.println("用户未登录，请先登录");
	}
	
	//开始菜单
		public void menubegin(){ 
			System.out.println("1.登录系统");
	  	    System.out.println("2.系统设置");
		    System.out.println("3.写日记");
		    System.out.println("4.查找日记");
		    System.out.println("5.退出系统");
		    System.out.println("请输入选择");
		}
		
		//注册登录菜单
		public void menulogin(){  
			System.out.println("1.注册");
	  	    System.out.println("2.登录");
		    System.out.println("3.找回密码");
		    System.out.println("4.返回上一层菜单");
		    System.out.println("请输入选择");
		}
		
		//功能菜单
		public void menufunc(){    
			System.out.println("1.按标题查找：");
			System.out.println("2.按内容查找：");
			System.out.println("3.按日期查找：");
			System.out.println("4.按心情查找：");
			System.out.println("5.按天气查找：");
			System.out.println("6.返回上一级菜单：");	
		    System.out.println("请输入选择");
		}
		
		//天气菜单
		public void menuweather(){    
			System.out.println("今天的天气怎么样?");
			System.out.println("1.多云");
		    System.out.println("2.晴天");
		    System.out.println("3.有雨");
		    System.out.println("4.雪天");
		    System.out.println("5.有风");
		    System.out.println("6.阴天");
		    System.out.println("请输入选择");
		}

		//心情菜单
		public void menumood(){    
			System.out.println("今天的心情怎么样?");
			System.out.println("1.开心");
		    System.out.println("2.伤心");
		    System.out.println("3.紧张");
		    System.out.println("4.生气");
		    System.out.println("5.兴奋");
		    System.out.println("请输入选择");
		}
		
		//选择菜单的正确输�?
		public int judg(){   
			Scanner input=new Scanner(System.in);
			int x=0;
			boolean exit = true;
			while(exit){
				try{
					x=input.nextInt();
					exit = false;
				}catch(Exception e){
					System.out.println("输入不对,请重新输入");
					input.nextLine();
				}	
			}
			return x;
		}
		
}


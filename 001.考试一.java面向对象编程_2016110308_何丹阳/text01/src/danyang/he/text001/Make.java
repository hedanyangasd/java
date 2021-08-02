/**
 * Author：何丹阳
 * Data：2018/11.1
 * Version：1.0
 * Function：实现测试 
 **/

package danyang.he.text001;

import java.util.Scanner;


import java.util.ArrayList;

public class Make {
	static ArrayList<Artifact> makes = new ArrayList<Artifact>();
	
	//选择菜单的正确输入
	public static int menujudg(){   
		Scanner input=new Scanner(System.in);
		int x=0;
		boolean exit = true;
		while(exit){
			try{
				x=input.nextInt();
				exit = false;
			}catch(Exception e){
				System.out.println("请重新选择！");
				input.nextLine();
			}	
		}
		return x;
	}
	
	public static double doublejuge(){
		Scanner input=new Scanner(System.in);
		double x=0;
		boolean exit = true;
		while(exit){
			try{
				x=input.nextDouble();
				exit = false;
			}catch(Exception e){
				System.out.println("请重新选择！");
				input.nextLine();
			}	
		}
		return x;
	}
	
	public static void makemenu(){ 
		System.out.println("1.壶");
  	    System.out.println("2.锅");
	    System.out.println("3.盒子");
	    System.out.println("请选择");
	}
	
	public static boolean ismake(){
		boolean ismake = true;
		boolean exit = true;
		System.out.println("是否制作另外一个物品：");
		System.out.println("1. 是；2. 否； ");	
		do{
			int operation=menujudg();
			switch(operation){
			case 1:
				exit = true;
				ismake = true;
				break;
			case 2:
				exit = true;
				ismake = false;
				break;
			default:
				exit = false;
				System.out.println("请重新选择！");
			}
		}while(!exit);
		return ismake;
	}
	
	public static void main(String[] args){
		Pot pot = new Pot();
		Box box = new Box();
		Wok wok = new Wok();
		Scanner input=new Scanner(System.in);
		Craftsman man = new Craftsman();
		System.out.println("请问你需要制作:");
		boolean exit = true;
		do{
			makemenu();
			int operation=menujudg();
			switch (operation){
				case 1:	
					System.out.println("请输入壶的半径:");
					double r1 = doublejuge();
					pot.setRadius(r1);
					makes.add(pot);		
					exit = ismake();
					break;
				case 2:	
					System.out.println("请输入锅的半径:");
					double r2 = doublejuge();
					System.out.println("请输入锅的深度:");
					double depth = doublejuge();
					wok = new Wok(r2,depth);
					makes.add(wok);
					exit = ismake();
					break;
				case 3:
					System.out.println("请输入盒子的长:");
					double longe = doublejuge();
					System.out.println("请输入盒子的宽:");
					double width = doublejuge();
					System.out.println("请输入盒子的高:");
					double height = doublejuge();
					box = new Box(longe,width,height);
					makes.add(box);
					exit = ismake();
					break;
				default:
					System.out.println("请重新选择！");
					exit = true;
			}
		}while(exit&&makes.size()<3);
		
		double sum=0;
		int count = 1;
		System.out.println("你一共制作了"+makes.size()+"个物品");
		for(;count<=makes.size();count++){
			System.out.println(count+"."+makes.get(count-1).show());
			sum += man.calculateManufactureCost(makes.get(count-1));
		}
		System.out.println("总计"+":"+sum+"元");
	}
}

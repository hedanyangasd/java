/**
 * Author���ε���
 * Data��2018/11.1
 * Version��1.0
 * Function��ʵ�ֲ��� 
 **/

package danyang.he.text001;

import java.util.Scanner;


import java.util.ArrayList;

public class Make {
	static ArrayList<Artifact> makes = new ArrayList<Artifact>();
	
	//ѡ��˵�����ȷ����
	public static int menujudg(){   
		Scanner input=new Scanner(System.in);
		int x=0;
		boolean exit = true;
		while(exit){
			try{
				x=input.nextInt();
				exit = false;
			}catch(Exception e){
				System.out.println("������ѡ��");
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
				System.out.println("������ѡ��");
				input.nextLine();
			}	
		}
		return x;
	}
	
	public static void makemenu(){ 
		System.out.println("1.��");
  	    System.out.println("2.��");
	    System.out.println("3.����");
	    System.out.println("��ѡ��");
	}
	
	public static boolean ismake(){
		boolean ismake = true;
		boolean exit = true;
		System.out.println("�Ƿ���������һ����Ʒ��");
		System.out.println("1. �ǣ�2. �� ");	
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
				System.out.println("������ѡ��");
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
		System.out.println("��������Ҫ����:");
		boolean exit = true;
		do{
			makemenu();
			int operation=menujudg();
			switch (operation){
				case 1:	
					System.out.println("��������İ뾶:");
					double r1 = doublejuge();
					pot.setRadius(r1);
					makes.add(pot);		
					exit = ismake();
					break;
				case 2:	
					System.out.println("��������İ뾶:");
					double r2 = doublejuge();
					System.out.println("������������:");
					double depth = doublejuge();
					wok = new Wok(r2,depth);
					makes.add(wok);
					exit = ismake();
					break;
				case 3:
					System.out.println("��������ӵĳ�:");
					double longe = doublejuge();
					System.out.println("��������ӵĿ�:");
					double width = doublejuge();
					System.out.println("��������ӵĸ�:");
					double height = doublejuge();
					box = new Box(longe,width,height);
					makes.add(box);
					exit = ismake();
					break;
				default:
					System.out.println("������ѡ��");
					exit = true;
			}
		}while(exit&&makes.size()<3);
		
		double sum=0;
		int count = 1;
		System.out.println("��һ��������"+makes.size()+"����Ʒ");
		for(;count<=makes.size();count++){
			System.out.println(count+"."+makes.get(count-1).show());
			sum += man.calculateManufactureCost(makes.get(count-1));
		}
		System.out.println("�ܼ�"+":"+sum+"Ԫ");
	}
}

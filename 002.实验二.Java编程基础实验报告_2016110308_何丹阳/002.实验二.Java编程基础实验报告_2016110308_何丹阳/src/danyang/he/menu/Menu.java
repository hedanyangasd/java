/**
 * Author:�ε���
 * Date:2018-9-16
 * Version:1.0
**/
package danyang.he.menu;
import java.util.Scanner;

public class Menu {
	public static void func(){
		System.out.println("����ִ��ĳ����");
	}
	public static void main(String[] args){
		boolean exit1=true;
		Scanner input=new Scanner(System.in);
		do{
			boolean cont1=true;
			System.out.println("1.��¼ϵͳ");
	  	    System.out.println("2.ϵͳ����");
		    System.out.println("3.д�ռ�");
		    System.out.println("4.�����ռ�");
		    System.out.println("5.�˳�ϵͳ");
		    System.out.println("������ѡ��");
		    while(cont1){
		       	if(!input.hasNextInt()){
		       		input.nextLine();
	    		 	System.out.println("���벻�ԣ�������ѡ��");	
	    		 	System.out.println("1.��¼ϵͳ");
	    	  	    System.out.println("2.ϵͳ����");
	    		    System.out.println("3.д�ռ�");
	    		    System.out.println("4.�����ռ�");
	    		    System.out.println("5.�˳�ϵͳ");
	    		    System.out.println("������ѡ��");
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
					System.out.println("1.��������ң�");
					System.out.println("2.�����ݲ��ң�");
					System.out.println("3.�����ڲ��ң�");
					System.out.println("4.��������ң�");
					System.out.println("5.���������ң�");
					System.out.println("6.������һ���˵���");	
				    System.out.println("������ѡ��");
				    while(cont2){
					if(!input.hasNextInt()){
						System.out.println("���벻�ԣ�������ѡ��");	
						System.out.println("1.��������ң�");
						System.out.println("2.�����ݲ��ң�");
						System.out.println("3.�����ڲ��ң�");
						System.out.println("4.��������ң�");
						System.out.println("5.���������ң�");
						System.out.println("6.������һ���˵���");	
						System.out.println("������ѡ��");
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
						System.out.println("���벻�ԣ�������ѡ��");	
				    }
				}while(exit2);
				break;
			case 5:
				System.out.println("ллʹ�ã��ټ�");
				exit1=false;
				break;	
			default:
				System.out.println("���벻�ԣ�������ѡ��");	
		     }
		}while(exit1);
	}
}



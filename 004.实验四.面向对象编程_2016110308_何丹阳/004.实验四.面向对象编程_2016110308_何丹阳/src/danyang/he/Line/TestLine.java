package danyang.he.Line;
import java.util.Scanner;

public class TestLine {
	
	//判断输入
	public static double judg(){   
		Scanner input=new Scanner(System.in);
		while(!input.hasNextDouble()){
			input.nextLine();
		 	System.out.println("输入不对，请重新选择！");
		}
	    return input.nextDouble();
	}
	
	public static void main(String[] args){
		System.out.println("请输入你将要比较的两条直线：");
		int j,i=0;
		Line2D L1 = null;
		Line2D L2 = null;
		Scanner input=new Scanner(System.in);
		do{
			Line2D L=null;
			System.out.println("请选择第"+(i+1)+"条直线的构造方式");
			System.out.println("1.一般式:Ax+By+c=0");
	  	    System.out.println("2.点斜式:y-y0=k(x-x0)");
		    System.out.println("3.两点式:(y-y2)/(y1-y2)=(x-x2)/(x1-x2)");
		    System.out.println("4.截距式:x/a+y/b=1");
		    System.out.println("请输入选择");
		    while(!input.hasNextInt()){		       	
	       		input.nextLine();
    		 	System.out.println("输入不对，请重新选择！");	
    		 	System.out.println("1.一般式:Ax+By+c=0");
    	  	    System.out.println("2.点斜式:y-y0=k(x-x0)");
    		    System.out.println("3.两点式:(y-y2)/(y1-y2)=(x-x2)/(x1-x2)");
    		    System.out.println("4.截距式:x/a+y/b=1");
    		    System.out.println("请输入选择");		    
		    }
		    int operation=input.nextInt();
		    switch (operation){
			case 1:
				System.out.println("请输入一般式的A、B、C:");
				System.out.print("A:");
				double A = judg();
				System.out.print("B:");
				double B = judg();
				System.out.print("C:");
				double C = judg();
				L =new Line2D(A,B,C);
				break;
			case 2:
				System.out.println("请输入点斜式的点和斜率:");
				System.out.print("x0:");
				double x0 = judg();
				System.out.print("y0:");
				double y0 = judg();
				System.out.print("k:");
				double k = judg();
				Point2D p = new Point2D(x0,y0);			
				L =new Line2D(p,k);
				break;
			case 3:
				System.out.println("请输入两点式的两点:");
				System.out.print("x1:");
				double x1 = judg();
				System.out.print("y1:");
				double y1 = judg();
				System.out.print("x2:");
				double x2 = judg();
				System.out.print("y2:");
				double y2 = judg();
				Point2D p1 = new Point2D(x1,y1);
				Point2D p2 = new Point2D(x2,y2);
				L=new Line2D(p1,p2);
				break;
			case 4:
				System.out.println("请输入截距式的a,b:");
				System.out.print("a:");
				double a = judg();
				System.out.print("b:");
				double b = judg();
				L = new Line2D(a,b);				
				break;
			default:
				System.out.println("输入不对，请重新选择！");	
				i--;
		    }
			if(i==0){
				L1=L;
				System.out.println("L1："+L1.show());
			}
			if(i==1){
				L2=L;
				System.out.println("L2："+L2.show());
			}
		    i++;
		}while(i<=1);	
		
		System.out.println("两条直线分别是：");

	
	
			System.out.println("L1："+L1.show());
			System.out.println("L2："+L2.show());
			System.out.println("这两条直线的关系是：");
			if(L1.equals(L2)){
				System.out.println("这两条直线相等。");
			}
			else if(L1.isParallel(L2)){
				System.out.println("这两条直线平行。");
			}
			else{
				System.out.println("这两条直线既不平行也不相等。");
			}
		}
	
}


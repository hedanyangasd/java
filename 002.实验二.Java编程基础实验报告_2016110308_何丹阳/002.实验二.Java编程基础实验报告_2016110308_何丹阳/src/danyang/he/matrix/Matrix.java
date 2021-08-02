/**
 * Author:何丹阳
 * Date:2018-9-16
 * Version:1.0
**/
package danyang.he.matrix;
import java.util.Scanner;

public class Matrix {

    public static int[][] getmatrix(int a[][], int b[][]) {
        //当a的列数与矩阵b的行数不相等时，不能做乘法，返回null
        if (a[0].length != b.length){
        	System.out.println("第一个矩阵的列和第二个的矩阵的行不能相同，请重新输入：");
            return null;
        }
        int c[][] = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b[0].length; j++){    
                for (int k = 0; k < a[0].length; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    
    public static void printmatrix(int c[][]){
    	for(int i=0;i<c.length;i++){
    		for(int j=0;j<c[0].length;j++){
    			System.out.print(c[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static int shuru(){
    	Scanner input=new Scanner(System.in);
    	boolean cont=true;
    	while(cont){
    		if(!input.hasNextInt()){
    			input.nextLine();
    			System.out.print("输入不对，请重新输入：");
    		}
    		else{
	    		cont=false;
    		}
    	}
    	int shuchu=input.nextInt();
    	return shuchu;
    }
    
      public static void main(String[] args){   
    	  Scanner input=new Scanner(System.in);
    	  boolean panduan=false;
    	  do{
    	  System.out.print("请输入第一个矩阵的行：");
    	  int firstRow=shuru();
    	  while(firstRow<=0){
    		  System.out.print("输入不对，请重新输入：");
    		  firstRow=shuru();
    	  }
    	
    	  
    	  System.out.print("请输入第一个矩阵的列：");
    	  int firstCol=shuru();
    	  while(firstCol<=0){
    		  System.out.print("输入不对，请重新输入：");
    		  firstCol=shuru();
    	  }
    	  
    	  System.out.print("请输入第二个矩阵的行：");
    	  int secondRow=shuru();
    	  while(secondRow<=0){
    		  System.out.print("输入不对，请重新输入：");
    		  secondRow=shuru();
    	  }
    	
    	  System.out.print("请输入第二个矩阵的列：");
    	  int secondCol=shuru();
    	  while(secondCol<=0){
    		  System.out.print("输入不对，请重新输入：");
    		  secondCol=shuru();
    	  }
    	
    	  
    	  int firstmatrix[][]=new int[firstRow][firstCol]; 
    	  int secondmatrix[][]=new int[secondRow][secondCol];
    	  System.out.println("输入连续的数构成第一个矩阵:");
    	     for(int i=0;i<firstRow;i++)
    	      for(int j=0;j<firstCol;j++)
    	      firstmatrix[i][j]=input.nextInt();
    	     input.nextLine();
    	     
    	     System.out.println("输入连续的数构成第二个矩阵:");
    	     for(int i=0;i<secondRow;i++)
       	      for(int j=0;j<secondCol;j++)
       	      secondmatrix[i][j]=input.nextInt();
    	     input.nextLine();
    	     
    	     
    	     System.out.println("第一个矩阵：");
    	     printmatrix(firstmatrix);
    	     System.out.println("第二个矩阵："); 
    	     printmatrix(secondmatrix);
    	     int thirdmatrix[][]=getmatrix(firstmatrix, secondmatrix);
    	     if(thirdmatrix==null){
    	    	 panduan=true;
    	     }
    	     else{
    	    	 panduan=false;
    	    	 System.out.println("第三个矩阵："); 
    	         printmatrix(thirdmatrix);
    	     }
    	  }while(panduan); 
    	       	    
    	     input.close();
    	    
      }
}








 
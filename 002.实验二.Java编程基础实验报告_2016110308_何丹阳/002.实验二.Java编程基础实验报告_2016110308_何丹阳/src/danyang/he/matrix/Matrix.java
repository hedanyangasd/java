/**
 * Author:�ε���
 * Date:2018-9-16
 * Version:1.0
**/
package danyang.he.matrix;
import java.util.Scanner;

public class Matrix {

    public static int[][] getmatrix(int a[][], int b[][]) {
        //��a�����������b�����������ʱ���������˷�������null
        if (a[0].length != b.length){
        	System.out.println("��һ��������к͵ڶ����ľ�����в�����ͬ�����������룺");
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
    			System.out.print("���벻�ԣ����������룺");
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
    	  System.out.print("�������һ��������У�");
    	  int firstRow=shuru();
    	  while(firstRow<=0){
    		  System.out.print("���벻�ԣ����������룺");
    		  firstRow=shuru();
    	  }
    	
    	  
    	  System.out.print("�������һ��������У�");
    	  int firstCol=shuru();
    	  while(firstCol<=0){
    		  System.out.print("���벻�ԣ����������룺");
    		  firstCol=shuru();
    	  }
    	  
    	  System.out.print("������ڶ���������У�");
    	  int secondRow=shuru();
    	  while(secondRow<=0){
    		  System.out.print("���벻�ԣ����������룺");
    		  secondRow=shuru();
    	  }
    	
    	  System.out.print("������ڶ���������У�");
    	  int secondCol=shuru();
    	  while(secondCol<=0){
    		  System.out.print("���벻�ԣ����������룺");
    		  secondCol=shuru();
    	  }
    	
    	  
    	  int firstmatrix[][]=new int[firstRow][firstCol]; 
    	  int secondmatrix[][]=new int[secondRow][secondCol];
    	  System.out.println("���������������ɵ�һ������:");
    	     for(int i=0;i<firstRow;i++)
    	      for(int j=0;j<firstCol;j++)
    	      firstmatrix[i][j]=input.nextInt();
    	     input.nextLine();
    	     
    	     System.out.println("���������������ɵڶ�������:");
    	     for(int i=0;i<secondRow;i++)
       	      for(int j=0;j<secondCol;j++)
       	      secondmatrix[i][j]=input.nextInt();
    	     input.nextLine();
    	     
    	     
    	     System.out.println("��һ������");
    	     printmatrix(firstmatrix);
    	     System.out.println("�ڶ�������"); 
    	     printmatrix(secondmatrix);
    	     int thirdmatrix[][]=getmatrix(firstmatrix, secondmatrix);
    	     if(thirdmatrix==null){
    	    	 panduan=true;
    	     }
    	     else{
    	    	 panduan=false;
    	    	 System.out.println("����������"); 
    	         printmatrix(thirdmatrix);
    	     }
    	  }while(panduan); 
    	       	    
    	     input.close();
    	    
      }
}








 
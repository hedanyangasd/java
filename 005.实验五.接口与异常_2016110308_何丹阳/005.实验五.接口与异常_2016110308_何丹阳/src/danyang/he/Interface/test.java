/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:测试类
**/
package danyang.he.Interface;

public class test {
	public static void main(String[] args){
		MyArrayList arr = new MyArrayList();
		//MyLinkedList arr = new MyLinkedList();		
		arr.add("gtegtr");
		arr.add("trj");
		arr.add("fgeg");
	 
	    
	    System.out.print("数组个数：");
		System.out.println(arr.size());
		
	    System.out.print("数组是否为空：");
		System.out.println(arr.isEmpty());
	
		System.out.print("第10个元素：");
		System.out.println(arr.get(9));
		
		System.out.print("数组空间大小：");
		System.out.println(arr.capacity());
		
		System.out.print("第1个元素：");
		System.out.println(arr.get(1));
		
		
	}
}

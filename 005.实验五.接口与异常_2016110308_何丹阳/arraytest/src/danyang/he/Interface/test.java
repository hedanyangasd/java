/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:测试类
**/
package danyang.he.Interface;

public class test {
	public static void main(String[] args){
final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT; i++) {
			list.add(new Integer(i));
		}
		System.out.println(list.capacity());
	}
}

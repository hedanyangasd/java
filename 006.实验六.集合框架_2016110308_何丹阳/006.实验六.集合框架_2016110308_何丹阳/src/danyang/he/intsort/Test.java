/*
 *Author:何丹阳
 *Date:2018-11-10
 *version:1.0
 *Description:测试
 */
package danyang.he.intsort;


public class Test {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		//创建大量的整数，可以重复
		int[] a={1,2,3,4,4,3,3,27,7,8,8,8,8,9,9,9,9};
		int[] b=null;
        int[] c={};
		FrequencyCalculator f=new FrequencyCalculator();
		f.add(a);
		f.add(3);
		f.add(5);
		f.add(b);
		f.add(2);
		f.add(1);
		f.add(c);
		f.add(5);
		f.add(9);
		System.out.println(f.getHighest());
		System.out.println(f.getLowest());
	} 
}

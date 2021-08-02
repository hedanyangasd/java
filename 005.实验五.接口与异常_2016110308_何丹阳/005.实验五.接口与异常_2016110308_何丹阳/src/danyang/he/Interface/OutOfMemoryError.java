/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:内存测试
**/
package danyang.he.Interface;

public class OutOfMemoryError {
	public static void main(String[] args) {
		MyList myList = new MyArrayList(10000);
		try {
			do {
				myList.add(" ");
			} while (true);
		} finally {
			// TODO: handle exception
			Runtime runtime = Runtime.getRuntime();
			System.err.println("Java虚拟机中的空闲内存量:"+runtime.freeMemory());
			System.err.println("Java虚拟机试图使用的最大内存量:"+runtime.maxMemory());
			System.err.println("Java虚拟机中的内存总量:"+runtime.totalMemory());
			myList.clear();
			System.gc();
			System.out.println("清理之后Java虚拟机中的空闲内存量:"+runtime.freeMemory());
			System.out.println("清理之后Java虚拟机试图使用的最大内存量:"+runtime.maxMemory());
			System.out.println("清理之后Java虚拟机中的内存总量:"+runtime.totalMemory());
			
		}

	}
}

/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:MyList接口类
**/
package danyang.he.Interface;

public interface MyList {
	void add(Object obj); //往列表尾部添加对象 
	void addFirst(Object obj); //向列表头部添加对象 
	Object get(int index); //从列表中获取索引为 index 的对象 
	void clear(); //清空所有的对象 
	boolean isEmpty();//判断列表中是否有对象
	int size();//获取列表中对象的个数
	int capacity();//所分配的空间大小 
}

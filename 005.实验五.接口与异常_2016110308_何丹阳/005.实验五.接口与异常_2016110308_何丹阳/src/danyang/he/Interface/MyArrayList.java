/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:MyArrayList
**/
package danyang.he.Interface;
import java.util.Arrays;

public class MyArrayList implements MyList{
	private static final int Size = 5; //数组增量
	private  Object[] array; //数组
	private int size;
    int count=0;
	 
	//无参构造函数
	public MyArrayList(){
		array = new Object[Size];
		System.out.println("数组初始化，大小为"+Size);
    }
	
	//有参构造
	public MyArrayList(int incSize){
		if(incSize<=0){
			System.out.println("数组初始化，大小为"+Size);
			this.size = Size;
			array = new Object[size];
		}
		else{
			this.size = incSize;
			array = new Object[size];
		}
		System.out.println("创建成功");
	}
	
		
	@Override
	//头插法
	public void add(Object obj){
		System.out.println("addִ执行，添加对象"+obj);
		int i=0;
		for(i=0;i<array.length;i++){
			if(array[i]==null){
				array[i]=obj;
				this.count += 1;
				return;
			}
		}
		if(i==array.length){
			System.out.println("数组满了，增量为"+size);
			array = Arrays.copyOf(array, array.length+size);
			i++;
			array[i]=obj;	
			this.count += 1;
		}
	}

	@Override
	//尾插法
	public void addFirst(Object obj) {
		System.out.println("addFirstִ执行，添加对象"+obj);
		int i=0;
		for(;i<array.length;i++){
			if(array[i]==null){
				for(int j=i-1;j>=0;j--){
					array[j+1] = array[j];
				}
				break;
			}
		}
		if(i==array.length){
			System.out.println("数组满了，增量为"+size);
			array = Arrays.copyOf(array, array.length+size);
			for(int j=i-1;j<0;j--){
				array[j+1] = array[j];
			}
		}
		array[0] = obj;
		this.count += 1;
	}

	@Override
	//查找index的数
	public Object get(int index) {
		if(index >= array.length || index < 0 ){
			System.err.println("index输入不对");
			return null;	
		}
		return array[index];
	}

	@Override
	//清空
	public void clear() {
		array = new Object[size];	
	}

	@Override
	//数组是否为空
	public boolean isEmpty() {
		if(size()==0 || array.length<1){
	        return true;
	      }
		return false;
	}

	@Override
	//数组数量个数
	public int size() {
		return count;
	}

	@Override
	//数组空间大小
	public int capacity() {
		return array.length;
	}
}

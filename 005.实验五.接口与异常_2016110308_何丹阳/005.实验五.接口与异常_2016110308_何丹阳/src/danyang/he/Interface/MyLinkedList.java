/**
 * Author:何丹阳
 * Date:2018-11-3
 * Version:1.0
 * function:MyLinkedList
**/
package danyang.he.Interface;

import danyang.he.Interface.MyLinkedList.Node;

public class MyLinkedList implements MyList{
	private int size;//个数
	private Node head;//头节点
	
	public MyLinkedList(){
		clear();
	}
	
	//节点类
	public class Node{
		private Object data;//节点数据
		private Node next;//节点指向下一个
		//构造函数
		public Node(Object data){
			this.data = data;
		}
	}

	@Override
	//尾插法
	public void add(Object obj) {
		System.out.println("addִ执行，添加对象"+obj);
		Node p = head;
		Node newNode = new Node(obj);
		if(p==null){
			head = newNode;
		}
		else{
			while(p.next != null){
				p = p.next;
			}
			p.next = newNode;
		}
		size++;
		
	}

	@Override
	//头插法
	public void addFirst(Object obj) {
		System.out.println("addFirst执行，添加对象"+obj);
		Node newNode = new Node(obj);
		if(head==null){
			head = newNode;
		}
		else{
			newNode.next = head;
			head = newNode;
		}	
		size++;
	}

	@Override
	//查找index的数
	public Object get(int index) {
		Node p = head;
		if (this.size < index || index < 0){
			System.err.println("index输入不对");
			return null;
		}else{
			for(int i = 1;i<=index;i++){
				p = p.next;
			}
			return p.data;
		}
	}

	@Override
	//清空
	public void clear() {
		head = null;
		size = 0;		
	}

	@Override
	//链表是否为空
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	//链表长度
	public int size() {
		return size;
	}

	@Override
	//链表长度
	public int capacity() {
		return size;
	}

}

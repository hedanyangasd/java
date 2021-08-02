package com.rainsia.exp005.test.list;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import danyang.he.Interface.MyLinkedList;
import danyang.he.Interface.MyList;

public class MyLinkedListTest {
	@Test
	public void testNormalConstructorNotNull() {
		try {
			MyList list = new MyLinkedList();
			Assert.assertNotNull("无法通过构造函数创建新的LinkedList", list);
		}catch(Exception e) {
			Assert.fail("创建对象时异常");
		}
	}


	@Test
	public void testConstructorWithZeroSizeHasDefaultCapacity() {
		MyList list = new MyLinkedList();
		
		Assert.assertEquals("LinkedList初始分配空间不正确", list.capacity(), 0);
	}
	
	@Test
	public void testNewListEmpty() {
		MyList list = new MyLinkedList();
		
		Assert.assertTrue("新创建的LinkedList不为空", list.isEmpty());
	}

	@Test
	public void testNewListSize() {
		MyList list = new MyLinkedList();
		
		Assert.assertEquals("新创建的LinkedList元素不为0", list.size(), 0);
	}

	@Test
	public void testAddOneObjectSize() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		
		Assert.assertEquals("向LinkedList中添加一个元素后，列表大小不正确", list.size(), 1);
	}

	@Test
	public void testAddOneObjectCapacity() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		
		Assert.assertEquals("向LinkedList中添加一个元素后，列表空间大小不正确", list.capacity(), 1);
	}

	@Test
	public void testAddOneObjectNotEmpty() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		
		Assert.assertFalse("向LinkedList中添加一个元素后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddTwoObjectsSize() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("向LinkedList中添加两个元素后，列表大小不正确", list.size(), 2);
	}

	@Test
	public void testAddTwoObjectsCapacity() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("向LinkedList中添加两个元素后，列表空间大小不正确", list.capacity(), 2);
	}

	@Test
	public void testAddTwoObjectsNotEmpty() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertFalse("向LinkedList中添加两个元素后，列表为空", list.isEmpty());
	}
	
	@Test
	public void testGetTheFirstObject() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		
		Assert.assertEquals("获取第一个元素结果错误", list.get(0), 1);
	}

	@Test
	public void testGetTheSecondObject() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("获取第二个元素结果错误", list.get(1), 2);
	}

	@Test
	public void testGetAllObjects() {
		final int LIMIT = 5;

		MyList list = new MyLinkedList();
		
		for(int i = 1; i <= LIMIT; i++){
			list.add(new Integer(i));
		}
		
		for(int i = 1; i <= LIMIT; i++){
			Assert.assertEquals("获取第" + i + "个元素结果错误", list.get(i - 1), i);
		}
	}
	
	@Test
	public void testGetTheNegativeObject() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		PrintStream oldErr = System.err;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		System.setErr(new PrintStream(bos));

		Assert.assertNull("获取负数索引元素结果错误", list.get(-1));
		System.setErr(oldErr);
		String message = bos.toString();
		System.err.println(message);

		Assert.assertTrue("获取元素失败时，未按要求提示错误", message.length() > 0);
	}

	@Test
	public void testGetMoreThanLastObject() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		PrintStream oldErr = System.err;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		System.setErr(new PrintStream(bos));

		Assert.assertNull("获取超出范围的元素结果错误", list.get(10));
		System.setErr(oldErr);
		String message = bos.toString();
		System.err.println(message);

		Assert.assertTrue("获取元素失败时，未按要求提示错误", message.length() > 0);
	}
	
	@Test
	public void testClearEmptyListEmpty() {
		MyList list = new MyLinkedList();
		list.clear();
		
		Assert.assertTrue("清空空对象时出错", list.isEmpty());
	}

	@Test
	public void testClearEmptyListSize() {
		MyList list = new MyLinkedList();
		list.clear();
		
		Assert.assertEquals("清空空对象后，列表数量出错", list.size(), 0);
	}

	@Test
	public void testClearEmptyListCapacity() {
		MyList list = new MyLinkedList();
		list.clear();
		
		Assert.assertEquals("清空空对象后，列表空间出错", list.capacity(), 0);
	}

	@Test
	public void testClearThenAddSize() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.clear();
		list.add(new Integer(1));
		
		Assert.assertEquals("清空空对象后，列表空间出错", list.size(), 1);
	}

	@Test
	public void testClearThenAddCapacity() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.clear();
		list.add(new Integer(1));

		Assert.assertEquals("清空空对象后，列表空间出错", list.capacity(), 1);
	}

	///////////special/////////
	@Test
	public void testAddNullObjectSize() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(null);
		
		Assert.assertEquals("添加null对象后，列表大小错误", list.size(), 2);
	}

	@Test
	public void testAddNullObjectNotEmpty() {
		MyList list = new MyLinkedList();
		list.add(null);
		
		Assert.assertFalse("添加null对象后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddNullObjectGet() {
		MyList list = new MyLinkedList();
		list.add(new Integer(1));
		list.add(null);
		list.add(new Integer(3));

		PrintStream oldErr = System.err;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		System.setErr(new PrintStream(bos));
		
		Assert.assertEquals("添加null对象后，列表为空", list.get(2), 3);

		System.setErr(oldErr);
		String message = bos.toString();
		System.err.println(message);

		Assert.assertFalse("获取含有null元素的对象时，错误输出失败信息", message.length() > 0);
	}
}

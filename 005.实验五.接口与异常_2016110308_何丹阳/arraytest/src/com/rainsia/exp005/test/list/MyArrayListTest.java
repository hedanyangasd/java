package com.rainsia.exp005.test.list;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import danyang.he.Interface.MyArrayList;
import danyang.he.Interface.MyList;

public class MyArrayListTest {
	@Test
	public void testNormalConstructorNotNull() {
		MyList list = new MyArrayList(10);
		
		Assert.assertNotNull("无法通过构造函数创建新的ArrayList", list);
	}

	@Test
	public void testConstructorWithZeroSizeNotNull() {
		MyList list = new MyArrayList(0);
		
		Assert.assertNotNull("无法通过构造函数创建新的ArrayList", list);
	}

	@Test
	public void testConstructorWithZeroSizeHasDefaultCapacity() {
		MyList list = new MyArrayList(0);
		
		Assert.assertEquals("ArrayList构造参数为0时，分配空间不正确", list.capacity(), 5);
	}

	@Test
	public void testConstructorWithNegativeSizeNotNull() {
		MyList list = new MyArrayList(-10);
		
		Assert.assertNotNull("无法通过构造函数创建新的ArrayList", list);
	}

	@Test
	public void testConstructorWithNegativeSizeHasDefaultCapacity() {
		MyList list = new MyArrayList(-10);
		
		Assert.assertEquals("ArrayList构造参数为负数时，分配空间不正确", list.capacity(), 5);
	}
	
	@Test
	public void testNewListEmpty() {
		MyList list = new MyArrayList(10);
		
		Assert.assertTrue("新创建的ArrayList不为空", list.isEmpty());
	}

	@Test
	public void testNewListSize() {
		MyList list = new MyArrayList(10);
		
		Assert.assertEquals("新创建的ArrayList元素不为0", list.size(), 0);
	}

	@Test
	public void testNewListCapacity() {
		MyList list = new MyArrayList(10);
		
		Assert.assertEquals("新创建的ArrayList初始空间大小错误", list.capacity(), 10);
	}
	
	@Test
	public void testAddOneObjectSize() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		
		Assert.assertEquals("向ArrayList中添加一个元素后，列表大小不正确", list.size(), 1);
	}

	@Test
	public void testAddOneObjectCapacity() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		
		Assert.assertEquals("向ArrayList中添加一个元素后，列表空间大小不正确", list.capacity(), 10);
	}

	@Test
	public void testAddOneObjectNotEmpty() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		
		Assert.assertFalse("向ArrayList中添加一个元素后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddTwoObjectsSize() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("向ArrayList中添加两个元素后，列表大小不正确", list.size(), 2);
	}

	@Test
	public void testAddTwoObjectsCapacity() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("向ArrayList中添加两个元素后，列表空间大小不正确", list.capacity(), 10);
	}

	@Test
	public void testAddTwoObjectsNotEmpty() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertFalse("向ArrayList中添加两个元素后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddBoundaryObjectsSize() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满元素后，列表大小不正确", list.size(), LIMIT);
	}

	@Test
	public void testAddBoundaryObjectsCapacity() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满元素后，列表空间大小不正确", list.capacity(), LIMIT);
	}

	@Test
	public void testAddBoundaryObjectsNotEmpty() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertFalse("向ArrayList中添加满元素后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddBoundaryPlusOneObjectsSize() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满元素后，再添加一个，列表大小不正确", list.size(), LIMIT + 1);
	}

	@Test
	public void testAddBoundaryPlusOneObjectsCapacity() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满元素后，再添加一个，列表空间大小不正确", list.capacity(), 2 * LIMIT);
	}

	@Test
	public void testAddBoundaryPlusOneObjectsNotEmpty() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertFalse("向ArrayList中添加满元素后，再添加一个，列表为空", list.isEmpty());
	}
	
	@Test
	public void testAddTwoBoundaryPlusOneObjectsSize() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= 2 * LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满两次元素后，再添加一个，列表大小不正确", list.size(), 2 * LIMIT + 1);
	}

	@Test
	public void testAddTwoBoundaryPlusOneObjectsCapacity() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= 2 * LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertEquals("向ArrayList中添加满两次元素后，再添加一个，列表空间大小不正确", list.capacity(), 3 * LIMIT);
	}

	@Test
	public void testAddTwoBoundaryPlusOneObjectsNotEmpty() {
		final int LIMIT = 10;
		
		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= 2 * LIMIT + 1; i++) {
			list.add(new Integer(i));
		}
		
		Assert.assertFalse("向ArrayList中添加满两次元素后，列表为空", list.isEmpty());
	}
	
	@Test
	public void testGetTheFirstObject() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		
		Assert.assertEquals("获取第一个元素结果错误", list.get(0), 1);
	}

	@Test
	public void testGetTheSecondObject() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Assert.assertEquals("获取第二个元素结果错误", list.get(1), 2);
	}

	@Test
	public void testGetAllObjects() {
		final int LIMIT = 5;

		MyList list = new MyArrayList(10);
		
		for(int i = 1; i <= LIMIT; i++){
			list.add(new Integer(i));
		}
		
		for(int i = 1; i <= LIMIT; i++){
			Assert.assertEquals("获取第" + i + "个元素结果错误", list.get(i - 1), i);
		}
	}
	
	@Test
	public void testGetTheNegativeObject() {
		MyList list = new MyArrayList(10);
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
		MyList list = new MyArrayList(10);
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
		MyList list = new MyArrayList(10);
		list.clear();
		
		Assert.assertTrue("清空空对象时出错", list.isEmpty());
	}

	@Test
	public void testClearEmptyListSize() {
		MyList list = new MyArrayList(10);
		list.clear();
		
		Assert.assertEquals("清空空对象后，列表数量出错", list.size(), 0);
	}

	@Test
	public void testClearEmptyListCapacity() {
		MyList list = new MyArrayList(10);
		list.clear();
		
		Assert.assertEquals("清空空对象后，列表空间出错", list.capacity(), 10);
	}

	@Test
	public void testClearThenAddSize() {
		MyList list = new MyArrayList(10);
		list.clear();
		list.add(new Integer(1));
		
		Assert.assertEquals("清空空对象后，列表空间出错", list.size(), 1);
	}

	@Test
	public void testClearThenAddCapacity() {
		MyList list = new MyArrayList(10);
		list.clear();
		list.add(new Integer(1));
		
		Assert.assertTrue("清空空对象后，列表空间出错", list.capacity() >= 10);
	}

	///////////special/////////
	@Test
	public void testAddNullObjectSize() {
		MyList list = new MyArrayList(10);
		list.add(new Integer(1));
		list.add(null);
		
		Assert.assertEquals("添加null对象后，列表大小错误", list.size(), 2);
	}

	@Test
	public void testAddNullObjectNotEmpty() {
		MyList list = new MyArrayList(10);
		list.add(null);
		
		Assert.assertFalse("添加null对象后，列表为空", list.isEmpty());
	}

	@Test
	public void testAddNullObjectGet() {
		MyList list = new MyArrayList(10);
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

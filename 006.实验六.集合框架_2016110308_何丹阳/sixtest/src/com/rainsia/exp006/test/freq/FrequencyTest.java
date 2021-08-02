package com.rainsia.exp006.test.freq;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import danyang.he.intsort.FrequencyCalculator;
import danyang.he.intsort.NoNumberException;



public class FrequencyTest {

	@Test
	public void testException() {
		try {
			throw new NoNumberException();
		} catch(RuntimeException e) {
			
		} catch(Exception e) {
			fail("鏈敵鏄庨潪妫�鏌ュ瀷寮傚父");
		}
	}

	@Test
	public void testHighestException() {
		boolean catched = false;
		FrequencyCalculator calculator = new FrequencyCalculator();
		try {
			calculator.getHighest();
		} catch(NoNumberException e) {
			catched = true;
		}
		
		assertTrue("鏈崟鑾峰埌寮傚父", catched);
	}

	@Test
	public void testLowestException() {
		boolean catched = false;
		FrequencyCalculator calculator = new FrequencyCalculator();
		try {
			calculator.getLowest();
		} catch(NoNumberException e) {
			catched = true;
		}
		
		assertTrue("鏈崟鑾峰埌寮傚父", catched);
	}
	
	@Test
	public void normalOneNumber() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}}
				);
		
		assertEquals("鍙湁涓�涓暟鏃惰绠楁渶澶ч鐜囧嚭閿�", expectedHighest, highest);
		assertEquals("鍙湁涓�涓暟鏃惰绠楁渶灏忛鐜囧嚭閿�", expectedLowest, lowest);
	}

	@Test
	public void normalSameNumber() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(1);
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 2);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 2);}}
				);
		
		assertEquals("鏈夊悓鏍风殑涓や釜鏁版椂璁＄畻鏈�澶ч鐜囧嚭閿�", expectedHighest, highest);
		assertEquals("鏈夊悓鏍风殑涓や釜鏁版椂璁＄畻鏈�灏忛鐜囧嚭閿�", expectedLowest, lowest);
	}

	@Test
	public void normalTwoNumbers() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(2, 1);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(2, 1);}}
				);
		
		Map<Integer, Integer> [] array = new HashMap[0];
		
		assertThat("有两个数时计算最大频率出错", highest, hasItems(expectedHighest.toArray(array)));
		assertThat("有两个数时计算最小频率出错", lowest, hasItems(expectedLowest.toArray(array)));
	}

	@Test
	public void normalThreeNumbers() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		calculator.add(3);
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(2, 1);}},
				new HashMap<Integer, Integer>(){{put(3, 1);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(2, 1);}},
				new HashMap<Integer, Integer>(){{put(3, 1);}}
				);

		Map<Integer, Integer> [] array = new HashMap[0];
		
		assertThat("有三个数时计算最大频率出错", highest, hasItems(expectedHighest.toArray(array)));
		assertThat("有三个数时计算最小频率出错", lowest, hasItems(expectedLowest.toArray(array)));
	}

	@Test
	public void normalSameNumbers() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		calculator.add(2);
		
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(2, 2);}},
				new HashMap<Integer, Integer>(){{put(1, 1);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(2, 2);}}
				);
		assertEquals("有同样的两个数时计算最大频率出错", highest, expectedHighest);
		assertEquals("有同样的两个数时计算最小频率出错", lowest, expectedLowest);
	}

	@Test
	public void normalManySameNumbers() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		calculator.add(2);
		calculator.add(5);
		calculator.add(5);
		calculator.add(6);
		calculator.add(6);
		calculator.add(7);
		calculator.add(7);
		calculator.add(7);
		calculator.add(7);
		
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		HashMap<Integer, Integer> highestItem = new HashMap<Integer, Integer>(){{put(7, 4);}};

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(2, 2);}},
				new HashMap<Integer, Integer>(){{put(5, 2);}},
				new HashMap<Integer, Integer>(){{put(6, 2);}}
				);
		
		
		HashMap<Integer, Integer> lowestItem = new HashMap<Integer, Integer>(){{put(1, 1);}};

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(2, 2);}},
				new HashMap<Integer, Integer>(){{put(5, 2);}},
				new HashMap<Integer, Integer>(){{put(6, 2);}}
				);
		
		Map<Integer, Integer> [] array = new HashMap[0];
		
		assertThat("有同样的多个数时计算最大频率出错", highest, hasSize(3));
		assertEquals("有同样的多个数时计算最大频率出错", highestItem, highest.get(0));
		
		highest.retainAll(expectedHighest);
		assertThat("有同样的多个数时计算最大频率出错", highest, hasSize(2));
		
		assertThat("有同样的多个数时计算最小频率出错", lowest, hasSize(3));
		assertEquals("有同样的多个数时计算最小频率出错", lowestItem, lowest.get(0));
		lowest.retainAll(expectedLowest);
		assertThat("有同样的多个数时计算最小频率出错", lowest, hasSize(2));
	}

	@Test
	public void normalNumbers() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		calculator.add(2);
		calculator.add(2);
		calculator.add(5);
		calculator.add(5);
		calculator.add(5);
		calculator.add(5);
		calculator.add(9);
		calculator.add(9);
		
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(5, 4);}},
				new HashMap<Integer, Integer>(){{put(2, 3);}},
				new HashMap<Integer, Integer>(){{put(9, 2);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(9, 2);}},
				new HashMap<Integer, Integer>(){{put(2, 3);}}
				);
		assertEquals("澶氫釜鏁版椂璁＄畻鏈�澶ч鐜囧嚭閿�", expectedHighest, highest);
		assertEquals("澶氫釜鏁版椂璁＄畻鏈�灏忛鐜囧嚭閿�", expectedLowest, lowest);
	}

	@Test
	public void normalNumbersArray() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(new int[] {1,2,2,2,5,5,5,5,9,9});
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		
		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedHighest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(5, 4);}},
				new HashMap<Integer, Integer>(){{put(2, 3);}},
				new HashMap<Integer, Integer>(){{put(9, 2);}}
				);

		@SuppressWarnings("serial")
		List<Map<Integer, Integer>> expectedLowest = Arrays.asList(
				new HashMap<Integer, Integer>(){{put(1, 1);}},
				new HashMap<Integer, Integer>(){{put(9, 2);}},
				new HashMap<Integer, Integer>(){{put(2, 3);}}
				);
		assertEquals("澶氫釜鏁版椂璁＄畻鏈�澶ч鐜囧嚭閿�", expectedHighest, highest);
		assertEquals("澶氫釜鏁版椂璁＄畻鏈�灏忛鐜囧嚭閿�", expectedLowest, lowest);
	}

	@Test
	public void testNullArray() {
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(null);
		boolean catched = false;
		try {
			List<Map<Integer, Integer>> highest = calculator.getHighest();
			List<Map<Integer, Integer>> lowest = calculator.getLowest();
		} catch(NoNumberException e) {
			catched = true;
		}
		
		assertTrue("鏈崟鑾峰埌寮傚父", catched);
	}
}

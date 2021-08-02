/*
 *Author:何丹阳
 *Date:2018-11-10
 *version:1.0
 *Description:测试
 */
package danyang.he.intsort;

import static org.hamcrest.Matchers.hasItems;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		FrequencyCalculator calculator = new FrequencyCalculator();
		calculator.add(1);
		calculator.add(2);
		List<Map<Integer, Integer>> highest = calculator.getHighest();
		List<Map<Integer, Integer>> lowest = calculator.getLowest();
		System.out.println(highest);
		System.out.println(lowest);
	
	} 
}

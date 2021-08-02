package danyang.he.eaxm02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Calculator {
	private Map<Order, Integer> map = new HashMap<>();
	
	public Calculator(Set<Order> orders) {
		for (Order peo : orders) {
			
		}
	}
}

//排序前五
class hightSort implements Comparator<Map.Entry<Order, Integer>>{

	@Override
	public int compare(Map.Entry<Order, Integer> o1,Map.Entry<Order, Integer> o2) {
		return o2.getValue() - o1.getValue();
	}		
}
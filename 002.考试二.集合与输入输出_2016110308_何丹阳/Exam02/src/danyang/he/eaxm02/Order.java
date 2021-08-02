package danyang.he.eaxm02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Order {
	private String date;
	private String name;
	private Map<String, String> menu = new HashMap<>() ;
	
	public int getmoney() {
		 Set keys = menu.keySet();
		 int money = 0;
		 int a = 0; 
		 Iterator it = keys.iterator();
		 while (it.hasNext()) {
			String key = (String) it.next(); 
			//a =(int) menu.get(key); // 根据key取出对应的值
			money  += a;
		}
		 return money;
	}
	
	public void getmenu(String name,String money) {
		menu.put(name, money);
	}
	
	public Order(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, String> menu) {
		this.menu = menu;
	}
	
}

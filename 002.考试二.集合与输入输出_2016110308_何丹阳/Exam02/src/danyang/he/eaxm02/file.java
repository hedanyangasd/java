package danyang.he.eaxm02;


import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class file {
	
	public static void main(String[] args) {
		
	FileReader fr = null;
	BufferedReader br = null;
	
	Map<String, String> menu = new HashMap<>();
	Map<String, String> menu1 = new HashMap<>();
	
	Set<Order> orders = new HashSet<>();
	Set<String> peoson = new HashSet<>();
	
	Order order = null; 
	
	try{
		fr = new FileReader("menu.txt");
		br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null){
			String[] name = line.split("\t");
//			System.out.println(name[0]);
//			System.out.println(name[2]);
			menu.put(name[0], name[2]);
			line = br.readLine();
		}
		
		
		
		fr = new FileReader("orders.txt");
		br = new BufferedReader(fr);
		String line1 = br.readLine();
		
		while(line1 != null){	
			String[] peo = line1.split("[=\t]");
			
//			System.out.println(peo[0]);
//			System.out.println(peo[1]);
			
			if (peo[0].equals("date")) {	
			}
			
			if(peo[0].equals("name")){
				if(!peoson.contains(peo[1])){
					order = new Order(peo[1]);
					peoson.add(peo[1]);
					orders.add(order);	
				}else{
					Iterator<Order> it = orders.iterator();
					while (it.hasNext()) {
						order = it.next();
						if (order.getName().equals(peo[1])) {
							break;
						}
					}
				}
			}
			
			
			
			line1 = br.readLine();
			}
		} catch (IOException e) {
		System.err.println("该文件不存在！");
		}finally {
		FileUtil.close(br);
		FileUtil.close(fr);
		}
	}
	}

/*
 *Author:何丹阳
 *Date:2018-11-10
 *version:1.0
 *Description:整数出现频率计算
 */
package danyang.he.intsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FrequencyCalculator{
	//数字的排名，key是数字，vlaue是频率
		 List<Map<Integer, Integer>> numlist = new ArrayList<Map<Integer, Integer>>();
		
		 //添加一个整数
		 public void add(int num){
			 //是否有相同的健
			 boolean key = false;		
	
			 //先遍历numlist的map看是否有相同的健  
		     for(Map<Integer, Integer> map : numlist) {
		    	if(map.containsKey(num)){
		    		map.put(num, map.get(num)+1);
		    		key = true;
		    	}
		     }	     
		     
		     if(!key){
		    	//选用hashmap,要快一点	 
				 Map<Integer, Integer> Map = new HashMap<Integer, Integer>();	
		    	 Map.put(num, 1);
		    	 numlist.add(Map);
		     }		 
		 }
		 
		 //添加多个整数
		 public void add(int [] nums){
			 if(nums != null){
				 for(int number : nums){
					 add(number);
				 }
			 }
		 }
		 
		 
		 //返回数字当中频率排名最高的前三名。
		 public List<Map<Integer, Integer>> getHighest() throws NoNumberException{
			 //装最高的前三名
			 List<Map<Integer, Integer>> highestlist = new ArrayList<Map<Integer, Integer>>();
			 //排序
			 Collections.sort(numlist,new hightSort());
			 //计数
			 int count =0;
			//为空抛异常
			 if(numlist.isEmpty()){
				 throw new NoNumberException("no numbers");
			 }
			 else if(numlist.size()<3){
				 return numlist;
			 }
			 else{
				 for(Map<Integer, Integer> list : numlist) {
					 highestlist.add(list);
					 count++;
					 if(count==3){
						 break;
					 }
				 }
			 }
			 return highestlist;
		 }
		 
		//返回数字当中频率排名最低的后三名。
		 public List<Map<Integer, Integer>> getLowest() throws NoNumberException{
			 //装最高的前三名
			 List<Map<Integer, Integer>> lowestlist = new ArrayList<Map<Integer, Integer>>();
			//排序s
			 Collections.sort(numlist, new lowerSort());
			 //计数
			 int count =0;
			 //为空抛异常/
			 if(numlist.isEmpty()){
				 throw new  NoNumberException("no numbers");
			 }
			 
			 else if(numlist.size()<3){
				 return numlist;
			 }
			 else{
				 for(Map<Integer, Integer> list : numlist) {
					 lowestlist.add(list);
					 count++;
					 if(count==3){
						 break;
					 }
				 }
			}
			 return lowestlist;
		 }
		 
		 //清除刚刚添加的所有整数。 
		 public void clear(){
			 numlist.clear();
		 }
	}

	//排序前三
	class hightSort implements Comparator<Map<Integer, Integer>>{

		@Override
		public int compare(Map<Integer, Integer> o1,Map<Integer, Integer> o2) {
			return -(o1.values().iterator().next() - o2.values().iterator().next());
		}		
	}

	//排序后三
	class lowerSort implements Comparator<Map<Integer, Integer>>{

		@Override
		public int compare(Map<Integer, Integer> o1,Map<Integer, Integer> o2) {
			return o1.values().iterator().next() - o2.values().iterator().next();
		}
	}

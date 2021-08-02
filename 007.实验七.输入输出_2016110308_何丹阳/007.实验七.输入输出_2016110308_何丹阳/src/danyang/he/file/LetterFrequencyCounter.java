/*
 *Author:何丹阳
 *Date:2018-11-24
 *version:1.0
 *Description:计算单词出现的频率并输出
 */
package danyang.he.file;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class LetterFrequencyCounter {
	//保存单词的次数
	private Map<Character,Integer> words = new HashMap<Character,Integer>();
	
	//总数
	private int totalNumber=0;
	
	//读文件并计算好字母出现的频率
	@SuppressWarnings("finally")
	public boolean loadFile(File file){
		//是否成功
		boolean isSuccessful = true;
		
		FileReader fr = null;
		BufferedReader br = null;
		
		char c='a';
		
		//先把a~z存进words中
		for(;c <= 'z'; c++) {
			words.put(c, 0);
		}
	    
		//文件是否可读
		if(!file.canRead()){
			isSuccessful = false;
		}
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				for(int i = 0; i <line.length(); i++) {
					c=line.charAt(i);
					if(c >= 'A' && c <= 'Z') {
						c += 32;
					}
					if(c >= 'a' && c <= 'z') {
						words.put(c, words.get(c) + 1);
						totalNumber++;
					}
				}
				line = br.readLine();
			}
			
			for(c = 'a'; c <= 'z'; c++) {
				 getFrequency(c);
			}
			
		} catch (IOException e) {
			System.err.println("该文件不存在！");
			isSuccessful = false;
		}finally {
			FileUtil.close(br);
			FileUtil.close(fr);
			return isSuccessful;
		}
	}
	
	//读文件并计算好字母出现的频率
	public boolean loadFile(String filename){
		File file = new File(filename);
		return loadFile(file);
	 }
	
	//获取某个字母出现的频率
	 public double getFrequency(char a){
		 if(totalNumber == 0) {
				return 0;
			}else {
				return words.get(a)/(totalNumber*1.0);
			}
	 }
	 
	 
	 //所有字母出现的频率打印出来
	 public void printFrequencies(){
		 for(char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + String.format("%.1f",getFrequency(c)* 100) + "%");
			}
	 }
}

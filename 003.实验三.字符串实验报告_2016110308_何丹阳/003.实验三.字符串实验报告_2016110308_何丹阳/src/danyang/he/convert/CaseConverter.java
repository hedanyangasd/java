/**
 * Author:何丹阳
 * Date:2018-9-27
 * Version:2.0
 * function:将输入的句子中每个单词的第一个字母大写，其余小写
**/
package danyang.he.convert;


public class CaseConverter {
	public String convert(String value){
    	StringBuffer juzi = new StringBuffer(); 
    	String[] word = value.split("[,;.	() ! ]");//把单词放到word中
    	String[] biaodian = value.split("[^,;.	() ! ]");//把标点符号等放进biaodian中    	
    	int i=0;
    	while(word[i].length()==0){
    		juzi.append(biaodian[i]);
    		i++;
    	}
    	for(String danci:word){ //遍历每个单词
    		if(danci.length()>0){  
    			String daxie = danci.substring(0,1).toUpperCase()+danci.substring(1).toLowerCase(); //将首字母大写，其他字母小写
    			juzi.append(daxie);	
    			if(i<biaodian.length){ //字母与字母之间也算了长度
    				while(biaodian[i].length()==0){
    					i++;
    				} 
    				juzi.append(biaodian[i]);
    				i++;
    			}
    		}
    	}
    	return juzi.toString(); 
	}	
}






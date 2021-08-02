/**
 * Author:何丹阳
 * Date:2018-11-12
 * Version:3.0
 * function:时间类
**/
package danyang.he.Menu;
import java.text.SimpleDateFormat;

public class Date {
	private String date;
	
	public Date(String date){
		this.date = date;
	}
	
	//判断用户输入的日期是否正确
	public static boolean isDate(String date){
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01 
			formatter.setLenient(false);
			try{
				formatter.format(formatter.parse(date));
			}catch(Exception e){
				return false;
			}
			return true;
	}

	//鍒ゆ柇鐢ㄦ埛杈撳叆鐨勬棩鏈熸槸鍚︿负锟�?
	public static boolean isNull(String date){
		if(date.equals("")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}

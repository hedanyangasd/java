/**
 * Author:何丹�?
 * Date:2018-10-20
 * Version:2.0
 * function:这是用户类，保存用户的各种信�?
**/
package danyang.he.interDiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	private String username;
	private String showname;
	private String password;
	private String email;
	private int question;
	private String answer;
	private List<Diary> diarys = new ArrayList<Diary>();
	
	public User(String username,String showname,String password,String email,int question,String answer){
		this.username = username;
		this.showname = showname;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}
	
	public User() {
		}


	public String getUsername() {
		return username;
	}

	public boolean setUsername(String username) {
		if(username.matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$")){
			this.username = username;
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getShowname() {
		return showname;
	}

	public boolean setShowname(String showname) {
		if(showname.length()<3 || showname.length()>20){
			return false;
		}
		else{
			this.showname=showname;
			return true;
		}
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		if(password.matches("^(?![A-Za-z0-9]+$)(?![A-Za-z\\W]+$)[a-zA-Z0-9\\W]{8,30}$")){//排除只有字母或数字与特殊符号和只有字母和数字和只有字母和特殊符号和只有字母和数字的组�?
			this.password=password;
			return true;			
		}
		else{
			return false;
		}
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		if(email.matches("[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)")){
			this.email=email;
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}

	public boolean setAnswer(String answer) {
		if(answer.isEmpty()){
			return false;
		}
		else{
			this.answer=answer;
			return true;
		}
	}
	
	
	
	public List<Diary> getDiarys() {
		return diarys;
	}

	public void setDiarys() {
		Diary diary=new Diary();
		diary=diary.write();
		diarys.add(diary);
	}

	// �? User 类中添加方法用来判断用户登录是否成功
	public boolean isloginsuccess(User user,String username,String password){
		if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
			return true;
		}
		else{
			return false;
		}
	}

}

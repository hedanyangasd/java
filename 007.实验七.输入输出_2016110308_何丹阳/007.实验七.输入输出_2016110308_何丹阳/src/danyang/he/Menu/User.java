/**
 * Author:何丹阳
 * Date:2018-10-20
 * Version:2.0
 * function:这是用户类，保存用户的各种信�?
**/
package danyang.he.Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 

public class User implements interDiary{
	private String username;
	private String showname;
	private String password;
	private String email;
	private int question;
	private String answer;
	private List<Diary> diarys;
	
	public User(String username,String showname,String password,String email,int question,String answer){
		this.username = username;
		this.showname = showname;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
		diarys = new ArrayList<Diary>();
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
		saveDiary();
	}

	//User类中添加方法用来判断用户登录是否成功
	public boolean isloginsuccess(User user,String username,String password){
		if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void readDiary() {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		List<Diary> diarys = new ArrayList<Diary>();
		try {
			fr = new FileReader(this.username);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
		} catch (IOException e) {
			System.out.println("文件不存在!");
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void saveDiary() {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(this.username,true);
			bw = new BufferedWriter(fw);
			for(Diary diary:diarys){
				bw.write(diary.toString());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("文件不存在!");
		} finally {
			try {
				if (fw != null)
					fw.close(); // 关闭流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

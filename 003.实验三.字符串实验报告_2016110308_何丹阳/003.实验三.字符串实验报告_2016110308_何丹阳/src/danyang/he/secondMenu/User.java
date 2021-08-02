/**
 * Author:何丹阳
 * Date:2018-10-6
 * Version:1.0
 * function:这是用户类，保存用户的各种信息
**/
package danyang.he.secondMenu;

public class User {
	private String username;
	private String showname;
	private String password;
	private String email;
	private int question;
	private String answer;
	
	public User(String username,String showname,String password,String email,int question,String answer){
		this.username = username;
		this.showname = showname;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getShowname() {
		return showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}

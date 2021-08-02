/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:用户类
 **/
package danyang.he.DiarySystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class User {
	private String userName = null;
	private String showName = null; 
	private String password = null; 
	private String email = null; 
	private String question = null; 
	private String answer = null;


	public User(String userName, String displayName, String password, String email, String question, String answer) {
		this.userName = userName;
		this.showName = displayName;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}
	
	//用户信息
	public String getValues() {
		return "'" + getUserName() + "', '" + getShowName() + "', '" + getPassword()+ "', '" + getEmail()+ "', '" + getQuestion()+ "', '" + getAnswer()+"'";
	}

	//添加用户
	public static void addUser(Connection conn,User user) {
		Statement stmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
				stmt = (Statement) conn.createStatement();
				StringBuffer sql = null;
				String sqlStr = "insert into user (name, showname, password, email, question, answer) values (";
				sql = new StringBuffer(sqlStr);
				sql.append(user.getValues());
				sql.append(")");
				System.out.println(sql.toString());
				stmt.execute(sql.toString());
				System.out.println("添加成功");	
			} else {
				System.out.println("未连接数据库！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			if (stmt != null) {
				try {
					stmt.close(); // 记得完成一次数据库操作之后，一定要关闭Statement
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//更新用户密码
	public static void updateUserPwd(Connection conn,String name,String pwd) {
		Statement stmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
				stmt = (Statement) conn.createStatement();
				stmt.executeUpdate("update user set password='"+ pwd +"' where name='" +name + "'");
				
				System.out.println("密码更新成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			if (stmt != null) {
				try {
					stmt.close(); // 记得完成一次数据库操作之后，一定要关闭Statement
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//判断用户是否登录成功
	public static boolean selectUserPwd(Connection conn,String username,String pwd) {
		boolean isSuccess = false;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select name,password from user";
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("name").equals(username) && rs.getString("password").equals(pwd)){
						isSuccess = true;
						break;
					}
				}
			} else {
				System.out.println("未连接数据库！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			// 4.关闭rs、statement和connection，！！注意关闭顺序 
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}

	//判断用户的问题是否回答正确
	public static boolean selectUserQues(Connection conn,String username,String queston,String answer) {
		boolean isSuccess = false;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select name,question,answer from user";
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("name").equals(username) && rs.getString("question").equals(queston) && rs.getString("answer").equals(answer)){
						isSuccess = true;
						break;
					}
				}
			} else {
				System.out.println("未连接数据库！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			// 4.关闭rs、statement和connection，！！注意关闭顺序 
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
	
	//获取用户显示名
	public static String selectUserShow(Connection conn,String username) {
		String showname = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select name,showname from user";
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("name").equals(username)){
						showname = rs.getString("showname");
						break;
					}
				}
			} else {
				System.out.println("未连接数据库！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			// 4.关闭rs、statement和connection，！！注意关闭顺序 
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return showname;
	}
	
	
	//判断用户是否存在
	public static boolean selectUser(Connection conn,String username) {
		boolean isSuccess = false;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select name from user";
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("name").equals(username)){
						isSuccess = true;
						break;
					}
				}
			} else {
				System.out.println("未连接数据库！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			// 4.关闭rs、statement和connection，！！注意关闭顺序 
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getShowName() {
		return showName;
	}


	public void setShowName(String showName) {
		this.showName = showName;
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


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}

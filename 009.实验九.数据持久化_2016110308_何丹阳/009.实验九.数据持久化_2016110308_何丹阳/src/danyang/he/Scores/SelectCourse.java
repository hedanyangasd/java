/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0 
 *Description:选课类
 */
package danyang.he.Scores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class SelectCourse {
	
	//登录选课系统
	public void StudentaddCourse(Connection conn) {
		String stdno = "";
		String password = "";
		Scanner input=new Scanner(System.in);
		boolean isSuccess = false;
		do{
			isSuccess = true;
			System.out.println("请输入要选课的学生的学号");
			stdno = Student.strStdno(input);
			while(!selectUser(conn, stdno)){
				System.out.println("学生不存在！请重新输入学号！");
				stdno = Student.strStdno(input);
			}
			System.out.println("请输入密码：");
			password = Student.strPwd(input);
			if(selectUserPwd(conn, stdno, password)){
				isSuccess = false;
			}
			else {
				System.out.println("密码错误，请重新登录");
			}
		}while(isSuccess);
		System.out.println("登录成功，请开始你的选课");
		showCourse(conn, stdno);
	}
	
	//列出选课表
	public void showCourse(Connection conn,String stuno){
		Course.CourseList(conn);	
		System.out.println("请输入您选择的课程编号(-1退出)：");
		Scanner input=new Scanner(System.in);
		String cursno = Course.strCursno(input);
		if(cursno.equals("-1")){
			System.out.println("退出选课！");
			return;
		}else {
			addSC(conn, stuno, cursno);
			showCourse(conn,stuno);
		}
	}

	
	//添加学生和课程的关系
	public void addSC(Connection conn,String stuno,String cursno){
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "insert into sc(stdno,cursno) values(?,?)";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, stuno);
				psstmt.setString(2, cursno);
				try{
					psstmt.execute();
					System.out.println("选课成功");
				}catch (SQLException e) {
					System.out.println("该课程已选或者不存在该课程!");
				}
			}
			 else {
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
			if (null != psstmt) {
				try {
					psstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	//判断是否查找到学生
	public static boolean selectUser(Connection conn,String stuno) {
		boolean isSuccess = false;
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select * from student where stdno=?";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, stuno);
				rs = psstmt.executeQuery();		
				if(rs.next()) {
					isSuccess = true;
				}else {
					isSuccess = false;
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
			if (null != psstmt) {
				try {
					psstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
	

	//判断学生的密码是否一致
	public static boolean selectUserPwd(Connection conn,String stuno,String pwd) {
		boolean isSuccess = false;
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select * from student where stdno=?";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, stuno);
				rs = psstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(pwd)) {
						isSuccess = true;
					}else {
						isSuccess = false;
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
			if (null != psstmt) {
				try {
					psstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
}

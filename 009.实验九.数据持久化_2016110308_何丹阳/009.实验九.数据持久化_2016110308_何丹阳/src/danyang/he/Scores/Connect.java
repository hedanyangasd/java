/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0 
 *Description:连接数据库
 */
package danyang.he.Scores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Connect {
	
	//判断输入
	public static int judg(){   
		Scanner input=new Scanner(System.in);
		while(!input.hasNextInt()){
			input.nextLine();
		 	System.out.println("输入不对，请重新选择！");
		}
		return input.nextInt();
	}
		
	public static void main(String[] args) {
		Connection conn = null;
		int stunum = 0;
		int coursenum = 0;
		String stdno = "";
		
		Scanner input=new Scanner(System.in);
		
		Student student = new Student();
		Course course = new Course();
		SelectCourse selectCourse = new SelectCourse();
		SelectStudent selectStudent = new SelectStudent();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/scores?useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(url, "root", "root");	
			System.out.println("连接数据库成功！进入系统");
			
			if(conn != null && !conn.isClosed()) {
				
				System.out.println("请输入要添加学生的人数");
				stunum = judg();
				while(stunum < 0){
					System.out.println("输入不对，请重新选择！");
					stunum = judg();
				}
				student.addStudent(conn, stunum);
				
				
				System.out.println("请输入要添加课程的数量");
				coursenum = judg();
				while(coursenum < 0){
					System.out.println("输入不对，请重新选择！");
					coursenum = judg();
				}
				course.addCourse(conn, coursenum);
				
				
				selectCourse.StudentaddCourse(conn);
				
				
				selectStudent.selectStudent(conn);
				
				
				
			}
			else {
				System.out.println("未连接数据库！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("未连接数据库！");
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0 
 *Description:课程
 */
package danyang.he.Scores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Statement;


public class Course {
	private String cursno = null;
	private String name = null;
	private int credit;
	
	public Course() {	
	}
	
	public Course(String cursno,String name,int credit) {
		this.cursno = cursno;
		this.name = name;
		this.credit = credit;
	}
	
	
	//添加课程
	public void addCourse(Connection conn, int num) {
		PreparedStatement psstmt = null;
		Course course = null;
		Scanner input = new Scanner(System.in);
		int cont = 1;
		try {
			if (conn != null && !conn.isClosed()) {
				while(cont <= num){
					System.out.println("添加第"+cont+"门课程");
					course = getCourse(input);
					// 使用占位符的SQl语句
					String sql = "insert into course values(?,?,?)";
					psstmt = conn.prepareStatement(sql);
					psstmt.setString(1, course.getCursno());
					psstmt.setString(2, course.getName());
					psstmt.setInt(3, course.getCredit());
					try{
						psstmt.execute();
						System.out.println("添加成功");
						cont++;
					}catch (SQLException e) {
						System.out.println("该课程已存在！不可重复添加！");
					}
				}
			}else {
					System.out.println("未连接数据库！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			if (psstmt != null) {
				try {
					psstmt.close(); // 记得完成一次数据库操作之后，一定要关闭Statement
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	//获取课程
	public Course getCourse(Scanner input) {
		Course course = null;
		String cursno = "";
		String name = "";
		int credit = 0;
		
		System.out.println("请输入课程编号(最多输入20个字符)：");
		cursno = strCursno(input);
	
		System.out.println("请输入课程名称(最多输入20个字符)：");
		name = strName(input);
		
		System.out.println("请选择学分(只能输入0~5以内的数字): ");
		credit = strCredit(input);
		
		course = new Course(cursno,name,credit);
		return course;
	}
	
	//输入课程号
	public static String strCursno(Scanner input) {
		String cursno = "";
		cursno = input.nextLine();
		while(cursno.length() <= 0 || cursno.length() > 20){
			System.out.println("输入不对，请重新输入");
			cursno = input.nextLine();
		}
		return cursno;
	}
	
	
	//输入课程名
	public static String strName(Scanner input) {
		String name = "";
		name = input.nextLine();
		while(name.length() <= 0 || name.length() > 20){
			System.out.println("输入不对，请重新输入");
			name = input.nextLine();
		}
		return name;
	}
	
	
	//判断输入
	public static int judg(){   
		Scanner input=new Scanner(System.in);
		while(!input.hasNextInt()){
			input.nextLine();
			System.out.println("输入不对，请重新选择！");
		}
		return input.nextInt();
	}
	
	//输入课程学分
	public static int strCredit(Scanner input) {
		int credit = 0;
		credit = judg();
		while( credit < 0 || credit > 5 ){
			System.out.println("输入不对，请重新输入");
			credit = judg();
		}
		return credit;
	}
	
	//显示所有课程
	public static void CourseList(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select * from course";
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.println(rs.getString("cursno")+","+rs.getString("name")+","+rs.getInt("credit"));
				}
			}else{
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
	}
	
	
	public String getCursno() {
		return cursno;
	}

	public void setCursno(String cursno) {
		this.cursno = cursno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}

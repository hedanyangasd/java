/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:学生类
 **/
package danyang.he.exam04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Student {
	private String stuno = null;
	private String name = null;
	
	public Student() {	
	}
	
	public Student(String stuno,String name) {
		this.stuno = stuno;
		this.name = name;
	}
	
	
	public static void addStudent(Connection conn,Student student) {
		PreparedStatement psstmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
					// 使用占位符的SQl语句
					String sql = "insert into student values(?,?)";
					 // 使用preparedStatement的setXxx方法设置每一个位置上的值
					psstmt = conn.prepareStatement(sql);
					psstmt.setString(1,student.getStuno());
					psstmt.setString(2,student.getName());
					try{
						psstmt.execute();
						System.out.println("添加成功");
					}catch (SQLException e) {
						System.out.println("该学生已存在！不可重复添加！");
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
	
	public static String strStdno(Scanner input) {
		String stdno = "";
		stdno = input.nextLine();
		while(stdno.length() <= 0 || stdno.length() > 20){
			System.out.println("输入不对，请重新输入");
			stdno = input.nextLine();
		}
		return stdno;
	}
	
	public static String strName(Scanner input) {
		String name = "";
		name = input.nextLine();
		while(name.length() <= 0 || name.length() > 20){
			System.out.println("输入不对，请重新输入");
			name = input.nextLine();
		}
		return name;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

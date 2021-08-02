/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0 
 *Description:学生类
 */
package danyang.he.Scores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
	private String stdno = null;
	private String name = null;
	private String sex = null;
	private Date birthday = null; 
	private String password = null;
	
	public final static String MALE = "male";
	public final static String FEMALE = "famale";
	
	public Student() {	
	}
	
	public Student(String stdno,String name,String sex,Date birthday,String password) {
		this.stdno = stdno;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.password = password;
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
	
	//添加学生
	public void addStudent(Connection conn, int num) {
		PreparedStatement psstmt = null;
		Student student = null;
		int cont = 1;
		Scanner input = new Scanner(System.in);
		try {
			if (conn != null && !conn.isClosed()) {
				while(cont <= num){
					System.out.println("添加第"+cont+"位学生");
					student = getStudent(input);
					// 使用占位符的SQl语句
					String sql = "insert into student values(?,?,?,?,?)";
					  // 使用preparedStatement的setXxx方法设置每一个位置上的值
					psstmt = conn.prepareStatement(sql);
					psstmt.setString(1,student.getStdno());
					psstmt.setString(2,student.getName());
					psstmt.setString(3,student.getSex());
					java.sql.Date sqlDate = new java.sql.Date(student.getBirthday().getTime());
					psstmt.setDate(4, sqlDate);
					psstmt.setString(5,student.getPassword());
					try{
						psstmt.execute();
						System.out.println("添加成功");
						cont++;
					}catch (SQLException e) {
						System.out.println("该学生已存在！不可重复添加！");
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
	
	//获取学生
	public Student getStudent(Scanner input) {
		Student student = null;
		String stdno = "";
		String name = "";
		String sex = "";
		Date birthday = null;
		String password = "";
		
		
		System.out.println("请输入学生的学号(最多输入20个字符)：");
		stdno = strStdno(input);
		
		System.out.println("请输入学生的姓名(最多输入20个字符)：");
		name = strName(input);
		
		System.out.println("请选择学生的性别(输入0选择" + MALE + "，输入1选择" + FEMALE + "): ");
		sex = strSex(input);
		
		System.out.println("请输入学生的出生日期(YYYY-MM-DD)：");
		birthday = dataBirthday(input);
		
		System.out.println("请输入学生的密码(只能输入4到20个字符)：");
		password = strPwd(input);
		
		student = new Student(stdno,name,sex,birthday,password);
		return student;
	}
	
	//输入学号
	public static String strStdno(Scanner input) {
		String stdno = "";
		stdno = input.nextLine();
		while(stdno.length() <= 0 || stdno.length() > 20){
			System.out.println("输入不对，请重新输入");
			stdno = input.nextLine();
		}
		return stdno;
	}
	
	//输入姓名
	public static String strName(Scanner input) {
		String name = "";
		name = input.nextLine();
		while(name.length() <= 0 || name.length() > 20){
			System.out.println("输入不对，请重新输入");
			name = input.nextLine();
		}
		return name;
	}
	
	//输入性别
	public static String strSex(Scanner input) {
		int choice = judg();
		while(choice < 0){
			System.out.println("输入不对，请重新选择！");
			choice = judg();
		}
		switch (choice) {
			case 0:
				return MALE;
			case 1:
				return FEMALE;
			default:
				return null;
		}
	}
	
	//输入生日
	public static Date dataBirthday(Scanner input) {
		Date birthday = null;
		String bir = null;	
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01 
		formatter.setLenient(false);	
		
		boolean firstInput = true;
		
		do {
			if (firstInput == false) {
				System.out.println("学生出生日期输入错误，请重新输入：");
			}
			bir = input.nextLine();
			try {
				birthday = formatter.parse(bir);
				firstInput = true;
			} catch (ParseException e) {
				firstInput = false;
			}
		} while (birthday == null || firstInput == false);
		
		return birthday;
	}
	
	//输入密码
	public static String strPwd(Scanner input) {
		String password = "";
		password = input.nextLine();
		while(password.length() < 4 || password.length() > 20){
			System.out.println("输入不对，请重新输入");
			password = input.nextLine();
		}
		return password;
	}
	
	public String getStdno() {
		return stdno;
	}
	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

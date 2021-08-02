/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:数据库连接
 **/
package danyang.he.exam04;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
public class Connect {
   public static void main(String[] args) {
		Connection conn = null;
		String stuno = "";
		String name = "";
		String dno = "";
		int height = 0;
		Scanner input=new Scanner(System.in);
		try {
			// 1、加载驱动
			// 将用户名和密码存入配置文件是一个好的习惯
			Properties properties = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("mysql.properties");
				properties.load(fis);
				
				String driver = properties.getProperty("driver");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");
				String database = properties.getProperty("database");
				String host = properties.getProperty("host");
				String port = properties.getProperty("port");

				Class.forName(driver);
				// 2、建立连接
				String url = "jdbc:mysql://" 
						+ host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf8";

				conn = DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！进入系统");
				
				if(conn != null && !conn.isClosed()) {
					System.out.println("请输入学生的学号(最多输入20个字符)：");
					stuno = Student.strStdno(input);
					
					System.out.println("请输入学生的姓名(最多输入20个字符)：");
					name = Student.strName(input);
					
					System.out.println("请输入学生的寝室(最多输入20个字符)：");
					dno = Dorm.strdno(input);
					
					System.out.println("请输入学生的身高(最多输入10个字符且单位为cm)：");
					height = Stu_Height.strHeight(input);
					
					Student student = new Student(stuno, name);
					Student.addStudent(conn, student);
					
					Dorm dorm = new Dorm(dno);
					Dorm.addDorm(conn,dorm);
					
					Stu_Dor.addStu_Dro(conn, stuno,dno);
					
					Stu_Height.addStu_Height(conn, stuno, height);
					
					AvgHeight.showAvgHeight(conn);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3、关闭连接
			if (null != conn) {
				try {
					conn.close();
					System.out.println("关闭连接成功！");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
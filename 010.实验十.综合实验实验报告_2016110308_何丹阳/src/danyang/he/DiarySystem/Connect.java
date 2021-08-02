/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:连接数据库，主函数
 **/
package danyang.he.DiarySystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、建立连接
			Properties properties = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("mysql.properties");
				properties.load(fis);

				String host = properties.getProperty("host");
				String port = properties.getProperty("port");
				String database = properties.getProperty("database");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");
				if (database != null && user != null && password != null && host != null && port != null) {
					String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf-8";
					conn = DriverManager.getConnection(url, user, password);
					
					if(conn != null && !conn.isClosed()) {
						Login login = new Login(conn);
					}
				}
				System.out.println("连接数据库成功！进入系统");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4、关闭Statement和数据库连接
			//先关闭Statement
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

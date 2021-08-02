/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:寝室
 **/
package danyang.he.exam04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dorm {
	private String dno = null;
	private String banji = null;
	
	public Dorm() {
	}
	
	public Dorm(String dno) {
		this.dno = dno;
	}
	
	public static void addDorm(Connection conn,Dorm dorm) {
		PreparedStatement psstmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
					// 使用占位符的SQl语句
					String sql = "insert into dorm(dno) values(?)";
					 // 使用preparedStatement的setXxx方法设置每一个位置上的值
					psstmt = conn.prepareStatement(sql);
					psstmt.setString(1,dorm.getDno());
					try{
						psstmt.execute();
						System.out.println("添加成功");
					}catch (SQLException e) {
						System.out.println("该寝室已存在！不可重复添加！");
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
	
	
	public static String strdno(Scanner input) {
		String dno = "";
		dno = input.nextLine();
		while(dno.length() <= 0 || dno.length() > 20){
			System.out.println("输入不对，请重新输入");
			dno = input.nextLine();
		}
		return dno;
	}
	
	
	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}
	
	
}

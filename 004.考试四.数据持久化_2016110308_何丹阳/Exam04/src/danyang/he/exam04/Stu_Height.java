/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:学生身高
 **/
package danyang.he.exam04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Stu_Height {
	private String stuno = null;
	private int height = 0;
	
	public Stu_Height() {	
	}
	
	public Stu_Height(String stuno,int height) {
		this.stuno = stuno;
		this.height = height;
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
		
		public static int strHeight(Scanner input) {
			int height = 0;
			height = judg();
			while( height < 0 || height > 999 ){
				System.out.println("输入不对，请重新输入");
				height = judg();
			}
			return height;
		}
		
		
		public static void addStu_Height(Connection conn,String stuno,int height) {
			PreparedStatement psstmt = null;
			try {
				if (conn != null && !conn.isClosed()) {
						// 使用占位符的SQl语句
						String sql = "insert into student_height values(?,?)";
						 // 使用preparedStatement的setXxx方法设置每一个位置上的值
						psstmt = conn.prepareStatement(sql);
						psstmt.setString(1,stuno);
						psstmt.setInt(2, height);
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
	
	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}

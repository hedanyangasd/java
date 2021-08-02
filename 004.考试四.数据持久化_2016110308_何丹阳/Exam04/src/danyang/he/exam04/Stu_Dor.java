/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:学生寝室
 **/
package danyang.he.exam04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stu_Dor {
	public static void addStu_Dro(Connection conn,String stuno,String dno) {
		PreparedStatement psstmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
					// 使用占位符的SQl语句
					String sql = "insert into student_in_dorm values(?,?)";
					 // 使用preparedStatement的setXxx方法设置每一个位置上的值
					psstmt = conn.prepareStatement(sql);
					psstmt.setString(1,stuno);
					psstmt.setString(2,dno);
					try{
						psstmt.execute();
						System.out.println("添加成功");
					}catch (SQLException e) {
						System.out.println("该学生已选寝室！不可重复添加！");
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
}

/**
 * Author:何丹阳
 * Data: 2018-12-28
 * Version:1.0
 * Function:计算平均身高
 **/
package danyang.he.exam04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvgHeight {
	public static void showAvgHeight(Connection conn) {
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
					// 使用占位符的SQl语句
					String sql = "select AVG(student_height.height), student_in_dorm.dno from student_height, student_in_dorm where  student_in_dorm.stuno = student_height.stuno GROUP BY student_in_dorm.dno";
					 // 使用preparedStatement的setXxx方法设置每一个位置上的值
					psstmt = conn.prepareStatement(sql);
					rs = psstmt.executeQuery();
					try{
						System.out.println("每个寝室的平均身高如下");
						rs = psstmt.executeQuery();
						while(rs.next()){
							System.out.println("dormno:"+rs.getString("dno")+",avg:"+rs.getInt("AVG(student_height.height)"));
						}
						
					}catch (SQLException e) {
						System.out.println("该学生已选寝室！不可重复添加！");
					}
			}else {
					System.out.println("未连接数据库！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { // 必须放在finally模块中执行
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
}

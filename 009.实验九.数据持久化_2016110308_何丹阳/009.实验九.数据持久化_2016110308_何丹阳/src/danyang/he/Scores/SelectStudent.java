/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0 
 *Description:数据库的查询语句
 */
package danyang.he.Scores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectStudent {
	public void selectStudent(Connection conn){
		Scanner input = new Scanner(System.in);
		System.out.println("查找出所有选了某同学所选的任何一门课程的所有学生");
		String stdno = "";
		System.out.println("请输入要选课的学生的学号");
		stdno = Student.strStdno(input);
		while(!SelectCourse.selectUser(conn, stdno)){
			System.out.println("学生不存在！请重新输入学号！");
			stdno = Student.strStdno(input);
		}
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select name from student where stdno in(select distinct stdno from sc where cursno in(select cursno from sc where stdno = ?))";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, stdno);
				rs = psstmt.executeQuery();
				System.out.println("学生包含:");
				while(rs.next()){
					System.out.println(rs.getString("name"));
				}
			}
			 else {
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

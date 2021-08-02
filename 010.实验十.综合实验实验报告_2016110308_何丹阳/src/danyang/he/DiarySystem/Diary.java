/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:日记类
 **/
package danyang.he.DiarySystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Diary implements Comparable<Diary>{
	private Date date;
	private String weather;
	private String mood;
	private String title;
	private String content;
	
	public Diary() {
	}
	
	public Diary(Date date,String weather,String mood,String title,String content) {
		this.date = date;
		this.weather = weather;
		this.mood = mood;
		this.title = title;
		this.content = content;
	}
	
	//添加日记
	public static void addDiary(Connection conn,String username,Diary diary) {
		PreparedStatement psstmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "insert into diary values(?,?,?,?,?,?)";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, username);
				psstmt.setString(2, diary.getDate().getDate());
				psstmt.setString(3, diary.getWeather());
				psstmt.setString(4, diary.getMood());
				psstmt.setString(5, diary.getTitle());
				psstmt.setString(6, diary.getContent());
				psstmt.execute();			
			} else {
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
	
	
	//删除日记
	public static void deleteDiary(Connection conn,String username,String date) {
		PreparedStatement psstmt = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "delete from diary where username=? and date=?";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, username);
				psstmt.setString(2, date);
				psstmt.executeUpdate();			
			} else {
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
	
	//用户是否存在日记
	public static boolean selectUserDate(Connection conn,String username,Date date) {
		boolean isSuccess = false;
		PreparedStatement psstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select * from diary where username=?";
				psstmt = conn.prepareStatement(sql);
				psstmt.setString(1, username);
				rs = psstmt.executeQuery();		
				while(rs.next()) {
					if(rs.getString("date").equals(date.getDate())) {
						isSuccess = true;
						break;
					}
				}
			}else {
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
		return isSuccess;
	}
	
	//查找日记
	public static ArrayList<Diary> SelectDiary(Connection conn,String username,String mas) {
		ArrayList<Diary> diarys = new ArrayList<Diary>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			if (conn != null && !conn.isClosed()) {
				String sql = "select * from diary where username=\'"+username+"\'"+mas;
				System.out.println(sql);
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Diary diary = new Diary();
					String strdate =rs.getString("date");
					Date date = new Date(strdate);
					diary.setDate(date);
					diary.setWeather(rs.getString(3));
					diary.setMood(rs.getString(4));
					diary.setTitle(rs.getString(5));
					diary.setContent(rs.getString(6));				
					diarys.add(diary);
				}
					
			} else {
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
		return diarys;
	}
		
	
	@Override
	public String toString() {
		return "title:" + title;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int compareTo(Diary o) {
		return this.date.getDate().compareTo(o.date.getDate());
	}
		
}

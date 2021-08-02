/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:学日记
 **/
package danyang.he.DiarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class WriteDiary extends JFrame{
	private JLabel lbWeather = new JLabel("天 气: ");// 天气
	private JLabel lbMood = new JLabel("心 情: ");// 心情
	private JLabel lbDate = new JLabel("日 期: ");// 日期
	private JLabel lbTitle = new JLabel("标 题: ");// 标题
	private JLabel lbContent = new JLabel("内 容: ");// 内容
	
	private JComboBox<String> cbxWeather = null;
	private JComboBox<String> cbxMood = null;
	private JTextField tfDate = new JTextField(20);
	private JTextField tfTitle = new JTextField(20);
	private JTextArea taContent = new JTextArea(10,25);
	
	private JButton btnCancel = new JButton("取消");// 取消
	private JButton btnOk = new JButton("确定");// 确定
	
	Date diarydate = new Date("");
	
	private boolean isdate = false;
	private boolean istitle = false;
	private boolean iscontent = false;

	
	private String username = "";
	
	private Container con = this.getContentPane();
	
	public WriteDiary(String username,Connection conn) {
		super("编写日记");
		this.username = username;
		init();
		writeListener(conn);
	}
	
	private void init() {
		// 设置窗体大小
		this.setSize(400, 420);
		// 设置窗体不可改变
		this.setResizable(false);
		
		//背景图
		ImageIcon icon = new ImageIcon("img/6.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,400,420);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);
		
		
		//天气
		JPanel plweather = new JPanel();
		Vector<String> weather = new Vector<String>();
		weather.add("cloudy");
		weather.add("sunny");
		weather.add("rain");
		weather.add("windy");
		weather.add("snow");
		// 用一个Vector对象来创建一个JComboBox对象
		cbxWeather = new JComboBox<String>(weather);
		plweather.add(lbWeather);
		plweather.add(cbxWeather);
		plweather.setOpaque(false);
		
		//心情
		JPanel plmood = new JPanel();
		Vector<String> mood = new Vector<String>();
		mood.add("happy");
		mood.add("sad");
		mood.add("angry");
		mood.add("nervous");
		mood.add("excited");
		// 用一个Vector对象来创建一个JComboBox对象
		cbxMood = new JComboBox<String>(mood);
		plmood.add(lbMood);
		plmood.add(cbxMood);
		plmood.setOpaque(false);
		
		
		//日期
		JPanel pldate = new JPanel();
		pldate.add(lbDate);
		pldate.add(tfDate);
		pldate.setOpaque(false);

		//标题
		JPanel pltitle = new JPanel();
		pltitle.add(lbTitle);
		pltitle.add(tfTitle);
		pltitle.setOpaque(false);

		//内容
		JPanel plcontent = new JPanel();
		taContent.setLineWrap(true);// 激活换行功能
		taContent.setWrapStyleWord(true);// 激活换行不断字功能
		JScrollPane scroplContent = new JScrollPane(taContent);
		//需要时出现垂直滚动
		scroplContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		plcontent.add(lbContent);
		plcontent.add(scroplContent);
		plcontent.setOpaque(false);

		//按钮
		JPanel plOkAndCancel = new JPanel();
		plOkAndCancel.add(btnOk);
		plOkAndCancel.add(btnCancel);
		plOkAndCancel.setOpaque(false);

		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(20));		
		box.add(plweather);
		box.add(plmood);
		box.add(pldate);
		box.add(pltitle);
		box.add(plcontent);
		box.add(plOkAndCancel);
		box.add(Box.createVerticalStrut(10));
				
		this.add(box);	
		
		// 设置窗口居中显示
		// 首先定义一个工具包
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 然后通过工具包获取窗口大小	
		Dimension screenSize = kit.getScreenSize();
		int screenWid = screenSize.width;
		int screenHeight = screenSize.height;
		int windowWid = this.getWidth();
		int windowHeight = this.getHeight();
		this.setLocation((screenWid - windowWid) / 2, (screenHeight - windowHeight) / 2);
						
						
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}	
	
	//检查输入是否正确
	public void checkinfor() {
		if(!Date.isNull(tfDate.getText())){
			if(Date.isDate(tfDate.getText())){
				diarydate = new Date(tfDate.getText());
				isdate = true;
			}
			else{
				isdate=false;
			}
		}
		else{//当日期为空，为当前日期
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			String date = formatter.format(System.currentTimeMillis());
			tfDate.setText(date);
			diarydate = new Date(tfDate.getText());
			isdate = true;			
		}
		
		if(tfTitle.getText().length()>0 && tfTitle.getText().length()<=12){
			istitle = true;
		}else{
			istitle = false;
		}
		
		if(taContent.getText().equals("")){
			iscontent = false;
		}else{
			iscontent = true;
		}
		
	}
	
	public void writeListener(Connection conn) {
		btnOk.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				checkinfor();
				String msg1 = "";
				if(!isdate){
					msg1 = msg1 + "日期输入不对\n";
				}
				if(!istitle){
					msg1 = msg1 + "标题不能超过12 个字且不为空\n";
				}
				if(!iscontent){
					msg1 = msg1 + "内容不能为空";
				}
				if(isdate && istitle && iscontent){
					boolean isExistDiary = Diary.selectUserDate(conn, username, diarydate);
					if(isExistDiary) {
						JOptionPane.showMessageDialog(con, "一个用户一天只能写一篇!", "提示", JOptionPane.YES_OPTION);
					}
					else{
						Diary diary = new Diary(diarydate, cbxWeather.getSelectedItem().toString(), cbxMood.getSelectedItem().toString(), tfTitle.getText(), taContent.getText());
						Diary.addDiary(conn,username,diary);
						JOptionPane.showMessageDialog(con, "日记保存成功！", "提示", JOptionPane.WARNING_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(con, msg1, "提示", JOptionPane.YES_OPTION);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

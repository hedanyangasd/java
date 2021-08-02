/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:查找日记类
 **/
package danyang.he.DiarySystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class FindDiary extends JFrame{
	private JLabel lbWeather = new JLabel("天 气: ");
	private JLabel lbMood = new JLabel("心 情: ");
	private JLabel lbDate = new JLabel("日 期: ");
	private JLabel lbTitle = new JLabel("标 题: ");
	private JLabel lbContent = new JLabel("内 容: ");
	

	private JTextField tfWeather = new JTextField(15);
	private JTextField tfMood = new JTextField(15);
	private JTextField tfDate = new JTextField(15);
	private JTextField tfTitle = new JTextField(15);
	private JTextArea taContent = new JTextArea();
	
	// 日程记录列表
	private DefaultListModel<Diary> listModel = new DefaultListModel<>();
	private JList<Diary> listDiary = new JList<Diary>(listModel);
	
	private JButton btnDelete = new JButton("删除日记");
	
	GridBagLayout gridBagLayout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	private Container con = this.getContentPane();
	
	private String username = "";
	
	public FindDiary(String username,ArrayList<Diary> diarys,Connection conn) {
		super("查找日记");
		this.username = username;
		init();
		showDiary(diarys);
		ShowListener(conn);
	}
	
	private void init() {	
		JPanel plleft = new JPanel();
		plleft.setLayout(gridBagLayout);
		plleft.setOpaque(false);
		
		JScrollPane scropl = new JScrollPane();
		//需要时出现垂直滚动
		scropl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scropl.setViewportView(listDiary);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		plleft.add(scropl, gbc);
		
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.insets = new Insets(5, 80, 0, 2); 
		plleft.add(btnDelete,gbc);
		
		
		JPanel plright = new JPanel();
		plright.setLayout(gridBagLayout);
		plright.setOpaque(false);

		//天气
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.insets = new Insets(5, 2, 0, 2); 
		plright.add(lbWeather, gbc);
		
		tfWeather.setEditable(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 0;
		plright.add(tfWeather, gbc);
		
		//心情
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		plright.add(lbMood, gbc);
			
		tfMood.setEditable(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0;
		plright.add(tfMood, gbc);
		
		
		//日期
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		plright.add(lbDate, gbc);
			
		tfDate.setEditable(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0;
		plright.add(tfDate, gbc);
		
		//标题
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		plright.add(lbTitle, gbc);
		
		tfTitle.setEditable(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.5;
		gbc.weighty = 0;
		plright.add(tfTitle, gbc);
		
		//内容
		taContent.setLineWrap(true);// 激活换行功能
		taContent.setWrapStyleWord(true);// 激活换行不断字功能
		taContent.setRows(4);
		JScrollPane scroplContent = new JScrollPane(taContent);
		//需要时出现垂直滚动
		scroplContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		plright.add(lbContent,gbc);
		
		taContent.setEditable(false);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.gridheight = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(5, 2, 5, 5); //padding
		plright.add(taContent,gbc);
		
					
		JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true, plleft, plright);
		content.setDividerSize(5);
		this.add(content);
		pack();
		
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
			
		//单选
		listDiary.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);				
	}
	
	public void ShowListener(Connection conn) {
		listDiary.addListSelectionListener(new ListSelectionListener() {		
			//显示日记
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Diary diary = listDiary.getSelectedValue();
				if(diary != null){
					tfWeather.setText(diary.getWeather());
					tfMood.setText(diary.getMood());
					tfDate.setText(diary.getDate().getDate());
					tfTitle.setText(diary.getTitle());
					taContent.setText(diary.getContent());
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {		
			//删除日记
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listModel.getSize() == 0){
					JOptionPane.showMessageDialog(con, "日记列表框为空!", "提示", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(listDiary.getSelectedIndex() == -1){
						JOptionPane.showMessageDialog(con, "未选中日记!", "警告框", JOptionPane.WARNING_MESSAGE);
					}
					else {
						int response = JOptionPane.showConfirmDialog(con, "是否删除该日记", "确认对话框", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if(response == 0){
							Diary diary = listDiary.getSelectedValue();
							Diary.deleteDiary(conn, username, diary.getDate().getDate());
							listModel.removeElementAt(listDiary.getSelectedIndex());
						}
					}
				}			
			}
		});
	}
	
	private void showDiary(ArrayList<Diary> diarys) {
		for(Diary diary : diarys){
			listModel.addElement(diary);
		}
	}
}

class Find extends JFrame{
	private JLabel lbWeather = new JLabel("天 气: ");// 天气
	private JLabel lbMood = new JLabel("心 情: ");// 心情
	private JLabel lbStratDate = new JLabel("起始日期: ");// 日期
	private JLabel lbEndDate = new JLabel("结束日期: ");// 日期
	private JLabel lbTitle = new JLabel("标         题: ");// 标题
	private JLabel lbContent = new JLabel("内         容: ");// 内容
	
	private JComboBox<String> cbxWeather = null;
	private JComboBox<String> cbxMood = null;
	private JTextField tfTitle = new JTextField(20);
	private JTextField tfStartDate = new JTextField(20);
	private JTextField tfEndDate = new JTextField(20);
	private JTextArea taContent = new JTextArea(5,20);

	 // 定义一个单选按钮，初始处于选中状态
 	private JRadioButton accurateFind = new JRadioButton("精确查找", true);
 	// 定义一个单按钮，初始处于没有选中状态
 	private JRadioButton BlurryFind = new JRadioButton("模糊查找", false);
 	// 定义一个ButtonGroup，用于将上面两个JRadioButton组合在一起
 	private ButtonGroup findBg = new ButtonGroup();
	
	private JButton btnCancel = new JButton("取消");// 取消
	private JButton btnOk = new JButton("查找");// 确定
	
	private String username = "";
	
	private Container con = this.getContentPane();
	
	private ArrayList<Diary> diarys;
	
	private Date Startdate = new Date("");
	private Date Enddate = new Date("");
	
	private boolean isStartdate = false;
	private boolean isEnddate = false;
	
	public Find(String username,Connection conn) {
		super("请输入查找的信息");
		this.username = username;
		init();
		FindListener(conn);
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
		weather.add("");
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
		mood.add("");
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
		JPanel plStartdate = new JPanel();
		plStartdate.add(lbStratDate);
		plStartdate.add(tfStartDate);
		plStartdate.setOpaque(false);
				
		JPanel plEnddate = new JPanel();
		plEnddate.add(lbEndDate);
		plEnddate.add(tfEndDate);
		plEnddate.setOpaque(false);

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
		
		JPanel sel = new JPanel();
		findBg.add(accurateFind);
		findBg.add(BlurryFind);
		accurateFind.setOpaque(false);
		BlurryFind.setOpaque(false);
		sel.add(accurateFind);
		sel.add(BlurryFind);
		sel.setOpaque(false);
		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(20));		
		box.add(plweather);
		box.add(plmood);
		box.add(plStartdate);
		box.add(plEnddate);
		box.add(pltitle);
		box.add(plcontent);
		box.add(sel);
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
	
	public void FindListener(Connection conn) {
		//查找
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkinfor();
				if(isEnddate && isStartdate){
					String msg = "";
					if(!cbxWeather.getSelectedItem().toString().equals("")){
						msg = msg + " and weather=\'"+cbxWeather.getSelectedItem().toString() +"\'";
					}
					if(!cbxMood.getSelectedItem().toString().equals("")){
						msg = msg + " and mood=\'"+cbxMood.getSelectedItem().toString() +"\'";
					}
					if(accurateFind.isSelected()){
						if(!tfTitle.getText().equals("")){
							msg  = msg + " and title=\'"+ tfTitle.getText() +"\'";
						}
						if(!taContent.getText().equals("")){
							msg  = msg + " and content=\'"+ taContent.getText() +"\'";
						}
					}
					if(BlurryFind.isSelected()){
						if(!tfTitle.getText().equals("")){
							msg  = msg + " and title like \'%"+ tfTitle.getText() +"%\'";
						}
						if(!taContent.getText().equals("")){
							msg  = msg + " and content like \'%"+ taContent.getText() +"%\'";
						}
					}
					if(!Startdate.getDate().equals("")){
						msg  = msg + " and date >=\""+ Startdate.getDate() +"\"";
					}
					if(!Enddate.getDate().equals("")){
						msg  = msg + " and date <=\""+ Enddate.getDate() +"\"";
					}
					diarys = Diary.SelectDiary(conn, username, msg);
					FindDiary findDiary = new FindDiary(username,diarys,conn);
				}
				else {
					JOptionPane.showMessageDialog(con, "日期输入不对!", "提示", JOptionPane.YES_OPTION);
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
	
	//判断日期是否合法
	public void checkinfor() {
		if(!Date.isNull(tfStartDate.getText())){
			if(Date.isDate(tfStartDate.getText())){
				Startdate = new Date(tfStartDate.getText());
				isStartdate = true;
			}
			else{
				isStartdate=false;
			}
		}
		else{
			isStartdate = true;			
		}
		
		if(!Date.isNull(tfEndDate.getText())){
			if(Date.isDate(tfEndDate.getText())){
				Enddate = new Date(tfEndDate.getText());
				isEnddate = true;
			}
			else{
				isEnddate = false;
			}
		}
		else{
			isEnddate = true;			
		}
	}

}


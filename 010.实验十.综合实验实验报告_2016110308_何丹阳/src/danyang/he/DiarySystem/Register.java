/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:注册类
 **/
package danyang.he.DiarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Vector;

public class Register extends JFrame {
	
	private JLabel lbusername = new JLabel("用  户  名: ");
	private JLabel lbshowname = new JLabel("显  示  名: ");
	private JLabel lbpassword = new JLabel("密        码: ");
	private JLabel lbconfirmpwd = new JLabel("确认密码: ");
	private JLabel lbemail = new JLabel("邮        箱: ");
	private JLabel lbquestion = new JLabel("请选择一个问题: ");
	private JLabel lbanswer = new JLabel("答        案: ");
	private JLabel lbarithmetic = new JLabel(Arithmetic.getArith());
	
	private JTextField tfusername = new JTextField(17);
	private JTextField tfshowname = new JTextField(17);
	private JPasswordField tfpassword = new JPasswordField(17);
	private JPasswordField tfconfirmpwd = new JPasswordField(17);
	private JTextField tfemail = new JTextField(17);
	private JTextField tfanswer = new JTextField(17);
	private JTextField tfarithmetic = new JTextField(17);
	
	
	private boolean isUserName = false;
	private boolean isShowName = false;
	private boolean isPassword = false;
	private boolean isConfirmPwd = false;
	private boolean isEmail = false;
	private boolean isAnswer = false;
	private boolean isArithmetic = false;
	
	private Container con = this.getContentPane();
	
	// 问题下拉列表框
	private JComboBox<String> boxQuestion = null;
	
	private JButton btnRegister = new JButton("立即注册");
	
	public Register(String title,Connection conn) {
		super(title);
		init();
		registerListener(conn);
	}
	
	private void init() {
		// 设置窗体大小
		this.setSize(400, 500);
		// 设置窗体不可改变
		this.setResizable(false);
		
		//背景图
		ImageIcon icon = new ImageIcon("img/5.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,400,500);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);
				
		
		//username
		JPanel plusername = new JPanel();
		plusername.add(lbusername);
		plusername.add(tfusername);
		plusername.setOpaque(false);	
				
		//showname
		JPanel plshowname = new JPanel();
		plshowname.add(lbshowname);
		plshowname.add(tfshowname);
		plshowname.setOpaque(false);	
				
		//password
		JPanel plpassword = new JPanel();
		plpassword.add(lbpassword);
		plpassword.add(tfpassword);
		plpassword.setOpaque(false);	
		
		
		//confirmpwd
		JPanel plconfirmpwd = new JPanel();
		plconfirmpwd.add(lbconfirmpwd);
		plconfirmpwd.add(tfconfirmpwd);
		plconfirmpwd.setOpaque(false);	
	
		//email
		JPanel plemail = new JPanel();
		plemail.add(lbemail);
		plemail.add(tfemail);
		plemail.setOpaque(false);	

		//question
		JPanel plquestion = new JPanel();
		plquestion.add(lbquestion);
		Vector<String> bookCollection = new Vector<String>();
		bookCollection.add("1.您的大学名称");
		bookCollection.add("2.您最喜欢的体育项目");
		bookCollection.add("3.您的爱好");
		bookCollection.add("4.您的专业");
		bookCollection.add("5.您最喜爱的学科");
		// 用一个Vector对象来创建一个JComboBox对象
		boxQuestion = new JComboBox<String>(bookCollection);
		plquestion.add(boxQuestion);
		plquestion.setOpaque(false);	

		//answer
		JPanel planswer = new JPanel();
		planswer.add(lbanswer);
		planswer.add(tfanswer);
		planswer.setOpaque(false);	

		
		//arithmetic
		JPanel plarithmetic = new JPanel();
		plarithmetic.add(lbarithmetic);
		plarithmetic.add(tfarithmetic);
		plarithmetic.setOpaque(false);	

		//btnRegister
		JPanel plRegister = new JPanel();	
		plRegister.add(btnRegister);
		plRegister.setOpaque(false);	

						
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(30));		
		box.add(plusername);		
		box.add(plshowname);						
		box.add(plpassword);			
		box.add(plconfirmpwd);			
		box.add(plemail);
		box.add(plquestion);		
		box.add(planswer);		
		box.add(plarithmetic);
		box.add(plRegister);
		box.add(Box.createVerticalStrut(30));
		
		//将Box容器添加到窗口的中间
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
	
	//判断输入是否合法
	public void checkinfor() {
		String myPassword = new String(tfpassword.getPassword());
		String myconPassword = new String(tfconfirmpwd.getPassword());
		if (tfusername.getText().matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$")) {
			isUserName = true;
		} else {
			isUserName = false;
		}
		if(tfshowname.getText().length()<3 || tfshowname.getText().length()>20){
			isShowName = false;
		}else{
			isShowName = true;
		}
		if(myPassword.matches("^(?![A-Za-z0-9]+$)(?![A-Za-z\\W]+$)[a-zA-Z0-9\\W]{8,30}$")){
			isPassword = true;
		}else{
			isPassword = false;
		}
		if(myconPassword.equals(myPassword)){
			isConfirmPwd = true;
		}else{
			isConfirmPwd = false;
		}
		if(tfemail.getText().matches("[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)")){
			isEmail = true;
		}else{
			isEmail = false;
		}
		if(tfanswer.getText().equals("")){
			isAnswer = false;
		}else{
			isAnswer = true;
		}
		if(tfarithmetic.getText().equals(Arithmetic.getResult())){
			isArithmetic = true;
		}else{
			isArithmetic = false;
		}
	}
	
	
	public void registerListener(Connection conn) {
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 判断必填项是否填写
				checkinfor();
				String msg1 = "";
				String myPassword = new String(tfpassword.getPassword());
				if (!isUserName) {
					msg1 = msg1 + "用户名只能包含字母、数字和下划线，并且首字母只能为字母,最短不能少于 6 个字符，最长不 能超过 20 个字符\n";
				}
				if (!isShowName) {
					msg1 = msg1 + "显示名任意字符，最小只能为 3 个字符，最长可以为 20 个字符\n";
				}
				if (!isPassword) {
					msg1 = msg1 + "密码必须包含字母数字和特殊符号，最短为 8 位，最长不能超过30\n";
				}
				if (!isConfirmPwd) {
					msg1 = msg1 + "确认密码与密码不一致\n";
				}
				if (!isEmail) {
					msg1 = msg1 + "不符合邮箱格式，最常不能超过50 个字符\n";
				}
				if (!isAnswer) {
					msg1 = msg1 + "答案不能为空\n";
				}
				if (!isArithmetic) {
					msg1 = msg1 + "验证码不对\n";
				}
				if (isUserName && isShowName && isPassword && isConfirmPwd && isEmail
						&& isAnswer && isArithmetic) {
					boolean isExistUser = User.selectUser(conn, tfusername.getText());
					if(isExistUser) {
						JOptionPane.showMessageDialog(con, "用户已存在！", "提示", JOptionPane.YES_OPTION);
					}
					else{
						User user = new User(tfusername.getText(), tfshowname.getText(), myPassword, tfemail.getText(),boxQuestion.getSelectedItem().toString(), tfanswer.getText());
						User.addUser(conn, user);
						JOptionPane.showMessageDialog(con, "用户注册成功！", "提示", JOptionPane.WARNING_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(con, msg1, "提示", JOptionPane.YES_OPTION);
				}
			}
		});
	}

}

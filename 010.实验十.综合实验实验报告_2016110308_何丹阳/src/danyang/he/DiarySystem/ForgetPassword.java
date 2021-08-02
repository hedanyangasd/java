/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:忘记密码类
 **/
package danyang.he.DiarySystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.*;



public class ForgetPassword extends JFrame{
	private JLabel lbusername = new JLabel("用  户  名: ");
	private JLabel lbquestion = new JLabel("请选择一个问题: ");
	private JLabel lbanswer = new JLabel("答        案: ");
	private JLabel lbpassword = new JLabel("密        码");
	private JLabel lbconfirmpwd = new JLabel("确认密码");
	
	private JTextField tfusername = null;
	private JTextField tfanswer = null;
	private JPasswordField tfpassword = null;
	private JPasswordField tfconfirmpwd = null;
	
	
	// 问题下拉列表框
	private JComboBox<String> boxQuestion = null;
	
	private JButton btnNext = new JButton("下一步");
	private JButton btnChangePwd = new JButton("修改密码");
	
	
	private Container con = this.getContentPane();

	private CardLayout cardLayout = new CardLayout();
	private JPanel card1 = new JPanel();
	private JPanel card2 = new JPanel();
	private JPanel cards = new JPanel(cardLayout);

	public ForgetPassword(String title,Connection conn) {
		super(title);
		init();
		forgetpwdListener(conn);
	}
	
	private void init() {
		//设置窗体大小
		this.setSize(400, 250); 
		//设置窗体不可改变
		this.setResizable(false);
		
		//背景图
		ImageIcon icon = new ImageIcon("img/2.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,400,250);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);

		//username
		JPanel plusername = new JPanel();
		plusername.add(lbusername);
		tfusername = new JTextField(17);
		plusername.add(tfusername);
		plusername.setOpaque(false);

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
		tfanswer = new JTextField(17);
		planswer.add(tfanswer);		
		planswer.setOpaque(false);
		
		//btnNext
		JPanel plNext = new JPanel();	
		plNext.add(btnNext);
		plNext.setOpaque(false);
		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(30));	

		box.add(plusername);	
		box.add(plquestion);	
		box.add(planswer);			
		box.add(plNext);
		
		box.add(Box.createVerticalStrut(30));
		
		card1.add(box);
		card1.setOpaque(false);
		
		
		//password
		JPanel plpassword = new JPanel();
		plpassword.add(lbpassword);
		tfpassword = new JPasswordField(17);
		plpassword.add(tfpassword);
		plpassword.setOpaque(false);

		
		//confirmpwd
		JPanel plconfirmpwd = new JPanel();
		plconfirmpwd.add(lbconfirmpwd);
		tfconfirmpwd = new JPasswordField(17);
		plconfirmpwd.add(tfconfirmpwd);
		plconfirmpwd.setOpaque(false);

		//btnNext
		JPanel plChangePwd = new JPanel();	
		plChangePwd.add(btnChangePwd);
		plChangePwd.setOpaque(false);
		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(30));	

		box1.add(plpassword);
		box1.add(plconfirmpwd);					
		box1.add(plChangePwd);
		
		box1.add(Box.createVerticalStrut(30));
		
		card2.add(box1);
		card2.setOpaque(false);
		
		cards.add(card1);
		cards.add(card2);
		cards.setOpaque(false);
		//将Box容器添加到窗口的中间
		con.add(cards);
		
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
	
	public void forgetpwdListener(Connection conn) {
		btnNext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isExistUser = User.selectUser(conn, tfusername.getText());
				if(isExistUser == false) {
					JOptionPane.showMessageDialog(con, "用户不存在！", "提示", JOptionPane.YES_OPTION);
				}
				else{
					boolean isQues = User.selectUserQues(conn, tfusername.getText(), boxQuestion.getSelectedItem().toString(), tfanswer.getText());
					if(isQues == true){
						cardLayout.next(cards);
					}
					else{
						JOptionPane.showMessageDialog(con, "答案错误！", "提示", JOptionPane.YES_OPTION);
					}
				}
			}
		});
		
		btnChangePwd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isPassword = false;
				boolean isConfirmPwd = false;
				String msg1 = "";
				String myPassword = new String(tfpassword.getPassword());
				String myconPassword = new String(tfconfirmpwd.getPassword());
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
				if (isPassword == false) {
					msg1 = msg1 + "密码必须包含字母数字和特殊符号，最短为 8 位，最长不能超过30\n";
				}
				if (isConfirmPwd == false) {
					msg1 = msg1 + "确认密码与密码不一致\n";
				}
				if (isPassword && isConfirmPwd ){
					User.updateUserPwd(conn, tfusername.getText(),myPassword);
					JOptionPane.showMessageDialog(con, "修改成功！", "提示", JOptionPane.YES_OPTION);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(con, msg1, "提示", JOptionPane.YES_OPTION);
				}
			}
		});
	}

}

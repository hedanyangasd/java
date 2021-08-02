/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:登录类
 **/
package danyang.he.DiarySystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

public class Login{

	private JFrame mainframe = new JFrame("登录");
	
	private JLabel lbtitle = new JLabel("丹丹阳的日记系统");
	private JLabel lbusername = new JLabel("用户名: ");
	private JLabel lbpassword = new JLabel("密    码: ");
	private JLabel lbregister = new JLabel("注册用户  ");
	private JLabel lbforgetpwd = new JLabel("忘记密码  ");
	
	private JTextField textname = new JTextField(20);
	private JPasswordField textpwd = new JPasswordField(20);
	
	private JButton login = new JButton("登录");
	
	public Login(Connection conn) {
		init();
		loginListener(conn);
	}
	
	private void init() {
		//设置窗体大小
		mainframe.setSize(400, 300); 
		//设置窗体不可改变
		mainframe.setResizable(false);
		
		//背景图
		ImageIcon icon = new ImageIcon("img/2.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,400,300);
		mainframe.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel j=(JPanel)mainframe.getContentPane();
		j.setOpaque(false);
		
		//title
		JPanel pltitle = new JPanel();
		pltitle.add(lbtitle);
		pltitle.setOpaque(false);
		
		//username
		JPanel plusername = new JPanel();
		plusername.add(lbusername);
		plusername.add(textname);
		plusername.setOpaque(false);		
		
		//pwd
		JPanel plpassword = new JPanel();
		plpassword.add(lbpassword);
		plpassword.add(textpwd);
		plpassword.setOpaque(false);	
				
		//register and forgetpwd
		JPanel plregisterAndforgetpwd = new JPanel();
		lbregister.setForeground(Color.BLUE);
		lbforgetpwd.setForeground(Color.BLUE);
		plregisterAndforgetpwd.add(lbregister);
		plregisterAndforgetpwd.add(lbforgetpwd);
		plregisterAndforgetpwd.setOpaque(false);
				
		//btnlogin
		JPanel pllogin = new JPanel();
		pllogin.add(login);
		pllogin.setOpaque(false);		
		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(30));
		box.add(pltitle);
		box.add(Box.createVerticalStrut(20));
		box.add(plusername);
		box.add(Box.createVerticalStrut(10));
		box.add(plpassword);
		box.add(Box.createVerticalStrut(10));
		box.add(plregisterAndforgetpwd);
		box.add(Box.createVerticalStrut(10));
		box.add(pllogin);
		box.add(Box.createVerticalStrut(50));
				
		//将Box容器添加到窗口的中间
		mainframe.add(box);		
		
		// 设置窗口居中显示
		// 首先定义一个工具包
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 然后通过工具包获取窗口大小
		Dimension screenSize = kit.getScreenSize();
		int screenWid = screenSize.width;
		int screenHeight = screenSize.height;
		int windowWid = mainframe.getWidth();
		int windowHeight = mainframe.getHeight();
		mainframe.setLocation((screenWid - windowWid) / 2, (screenHeight - windowHeight) / 2);
			
		
		//隐藏当前窗口，并释放窗体占有的其他资源,只关当前窗口
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void loginListener(Connection conn) {
		lbregister.addMouseListener(new MouseAdapter() {
			//点击
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register("注册",conn);
			}
			//移入
			@Override
			public void mouseEntered(MouseEvent e) {
				lbregister.setForeground(Color.ORANGE);
			}
			//移出
			@Override
			public void mouseExited(MouseEvent e) {
				lbregister.setForeground(Color.BLUE);
			}
		});
		lbforgetpwd.addMouseListener(new MouseAdapter() {
			//找回密码
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgetPassword forgetPwd = new ForgetPassword("找回密码",conn);
			}
			//移入
			@Override
			public void mouseEntered(MouseEvent e) {
				lbforgetpwd.setForeground(Color.ORANGE);
			}		
			//移出
			@Override
			public void mouseExited(MouseEvent e) {
				lbforgetpwd.setForeground(Color.BLUE);
			}
		});
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String myPassword = new String(textpwd.getPassword());
				if (textname.getText().equals("") || myPassword.equals("")) {
					JOptionPane.showMessageDialog(mainframe, "有未填写项！", "提示", JOptionPane.YES_OPTION);
				}
				else{
					boolean isExistUser = User.selectUser(conn, textname.getText());
					if(isExistUser == false) {
						JOptionPane.showMessageDialog(mainframe, "用户不存在！", "提示", JOptionPane.YES_OPTION);
					}else{
						boolean isCorrect = User.selectUserPwd(conn, textname.getText(), myPassword);
						if(isCorrect == true) {
							String showname = User.selectUserShow(conn, textname.getText());
							DiaryMenu diarySystem = new DiaryMenu(showname,textname.getText(),conn);
							mainframe.dispose();
						}else {
							JOptionPane.showMessageDialog(mainframe, "密码错误！请重新输入！", "提示", JOptionPane.YES_OPTION);
						}
					}
				}
			}
		});
	}
}

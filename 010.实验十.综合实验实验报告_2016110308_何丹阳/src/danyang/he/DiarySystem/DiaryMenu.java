/**
 * Author:何丹阳
 * Data: 2018-12-30
 * Version:1.0
 * Function:日记菜单
 **/
package danyang.he.DiarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;


public class DiaryMenu extends JFrame{
	
	private JLabel lbshowname = null;
	
	private JButton btnSystem = new JButton("1.系统设置");
	private JButton btnwrite = new JButton("2.编写日记");
	private JButton btnfind = new JButton("3.查找日记");
	private JButton btnexit = new JButton("4.退出系统");
	
	private String username = "";
	private String showname = "";

	private Container con = this.getContentPane();

	public DiaryMenu(String showname,String username,Connection conn) {
		super("日记管理");
		this.showname = showname;
		this.username = username;
		init();
		diaryListener(conn);
	}
	
	private void init() {
		// 设置窗体大小
		this.setSize(300, 300);
		// 设置窗体不可改变
		this.setResizable(false);
		
		//背景图
		ImageIcon icon = new ImageIcon("img/1.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,300,300);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);
		
		//lbshowname
		JPanel plshowname = new JPanel();
		Font font = new Font("宋体", Font.PLAIN, 25);//创建1个字体实例
		lbshowname = new JLabel(showname+"的日记");
		lbshowname.setFont(font);
		plshowname.add(lbshowname);
		plshowname.setOpaque(false);
		
		//btnSystem
		JPanel plSystem = new JPanel();
		plSystem.add(btnSystem);
		plSystem.setOpaque(false);
		
		//btnwrite
		JPanel plwrite = new JPanel();
		plwrite.add(btnwrite);
		plwrite.setOpaque(false);
				
		//btnfind
		JPanel plfind = new JPanel();
		plfind.add(btnfind);
		plfind.setOpaque(false);
				
		//btnexit
		JPanel plexit = new JPanel();
		plexit.add(btnexit);
		plexit.setOpaque(false);
		
		//创建一个垂直排列组件的Box，盛装Panel
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(30));	
		box.add(plshowname);
		box.add(plSystem);
		box.add(plwrite);
		box.add(plfind);
		box.add(plexit);
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
	
	
	public void diaryListener(Connection conn) {
		lbshowname.addMouseListener(new MouseAdapter() {
			//点击
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login(conn);
			}
			//移入
			@Override
			public void mouseEntered(MouseEvent e) {
				lbshowname.setForeground(Color.blue);
			}
			//移出
			@Override
			public void mouseExited(MouseEvent e) {
				lbshowname.setForeground(Color.black);
			}
		});
		btnSystem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(con, "该功能正在完善中，尽情期待!", "提示", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnwrite.addActionListener(new ActionListener() {
			//写日记
			@Override
			public void actionPerformed(ActionEvent e) {
				WriteDiary writeDiary = new WriteDiary(username,conn);	
			}
		});
		
		btnfind.addActionListener(new ActionListener() {		
			//找日记
			@Override
			public void actionPerformed(ActionEvent e) {
				Find find = new Find(username,conn);
			}
		});
		
		btnexit.addActionListener(new ActionListener() {		
			//退出系统，关闭数据库
			@Override
			public void actionPerformed(ActionEvent envent) {
				dispose();
				if (conn != null) {
					try {
						conn.close();
						System.out.println("数据库关闭");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}

/**
 * Author:何丹阳
 * Date:2018-12-5
 * Version:1.0
 * function:界面版计算器
**/
package danyang.he.calculator;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.*;


public class Calculator {
	
	JList<String> answerList;
	// 定义一个DefaultListModel对象装数据
	DefaultListModel<String> answer = new DefaultListModel<>();
	
	
	private	String [] names = {"7","4","1","0"};
	
	JFrame mainFrame = new JFrame("计算器");
	
	//总菜单
	JMenuBar mb = new JMenuBar();
	JMenu edit = new JMenu("编辑(E)");
	JMenu view = new JMenu("查看(V)");
	JMenu Help = new JMenu("帮助(H)");
	
	//编辑
	JMenuItem copyItem = new JMenuItem("");
	JMenuItem pasteItem = new JMenuItem("");
	
	//单选菜单״̬
	JRadioButtonMenuItem ordinary = new JRadioButtonMenuItem("普通", true);
	JRadioButtonMenuItem science = new JRadioButtonMenuItem("科学", false);
	JRadioButtonMenuItem programmer = new JRadioButtonMenuItem("程序员", false);
	//将单选菜单加入按钮组
	ButtonGroup bg = new ButtonGroup();
	
	//帮助
	JMenuItem help = new JMenuItem("帮助");
	JMenuItem formation = new JMenuItem("关于");
	
	//单行输入框
	JTextField input = new JTextField("");
	
	//计算器加列表
	JPanel panel = new JPanel();
	
	public Calculator(){
		init();
	}
	
	private void init() {	
		
		//粘贴复制
		copyItem = new JMenuItem(copyAction);
		pasteItem = new JMenuItem(pasteAction);
		
		//快捷键
		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		pasteItem.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
		edit.add(copyItem);
		edit.add(pasteItem);
		
		bg.add(ordinary);
		bg.add(science);
		bg.add(programmer);
		view.add(ordinary);
		view.add(science);
		view.add(programmer);
		
		//关于事件
		formation.addActionListener(new showinformation());
		
		Help.add(help);
		Help.addSeparator();
		Help.add(formation);
		
		//菜单快捷键
		edit.setMnemonic('E');
		view.setMnemonic('V');
		Help.setMnemonic('H');

		//加入菜单
		mb.add(edit);
		mb.add(view);
		mb.add(Help);
		mainFrame.setJMenuBar(mb);
		
		//文本框不可编辑
		input.setEditable(false);
		input.setBackground(Color.WHITE);
		//右对齐
		input.setHorizontalAlignment(JTextField.RIGHT);
		mainFrame.add(input,BorderLayout.NORTH);
		
		//计算器网格
		mainFrame.add(addComponentsToPane(panel));	
		
		//关闭
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		
		// 设置窗口居中显示
		// 首先定义一个工具包
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 然后通过工具包获取窗口大小
		Dimension screenSize = kit.getScreenSize();
		int screenWid = screenSize.width;
		int screenHeight = screenSize.height;
		int windowWid = mainFrame.getWidth();
		int windowHeight = mainFrame.getHeight();
		mainFrame.setLocation((screenWid - windowWid) / 2, (screenHeight - windowHeight) / 2);
		
	}
		
	public Container addComponentsToPane(Container pane) {	
		
		JButton button;
		
		GridBagLayout gbLayout = new GridBagLayout(); 
		pane.setLayout(gbLayout);
		GridBagConstraints gbCons = new GridBagConstraints();
	

		button = addbutton("Backspace",new back());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.weighty = 0.5;
		gbCons.gridx = 1;
		gbCons.gridy = 0;
		gbCons.gridwidth = 2;
		gbCons.insets = new Insets(3, 3, 3, 3);
		pane.add(button);
		gbLayout.setConstraints(button, gbCons);

		button = new JButton("CE");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 3;
		gbCons.gridy = 0;
		gbCons.gridwidth = 2;
		pane.add(button, gbCons);

		button = addbutton("C",new clear());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 5;
		gbCons.gridy = 0;
		gbCons.gridwidth = 1;
		pane.add(button, gbCons);

		button = addbutton("MC", new deletelist());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 0;
		gbCons.gridy = 1;
		pane.add(button, gbCons);
		
		button = new JButton("MR");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 0;
		gbCons.gridy = 2;
		pane.add(button, gbCons);
		
		button = new JButton("MS");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 0;
		gbCons.gridy = 3;
		pane.add(button, gbCons);
		
		button = new JButton("M+");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 0;
		gbCons.gridy = 4;
		pane.add(button, gbCons);
			
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1,5,5));
		for(String name : names){
			panel1.add(addbutton(name,new Show()));
		}
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 1;
		gbCons.gridy = 1;
		gbCons.gridheight = 4;
		pane.add(panel1,gbCons);
		
		button = addbutton("8",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 2;
		gbCons.gridy = 1;
		gbCons.gridheight = 1;
		gbCons.gridwidth = 1;
		pane.add(button, gbCons);
		
		button = addbutton("5",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 2;
		gbCons.gridy = 2;
		pane.add(button, gbCons);
		
		
		button = addbutton("2",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 2;
		gbCons.gridy = 3;
		pane.add(button, gbCons);
		
		button = addbutton("+/-",new Shownum());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 2;
		gbCons.gridy = 4;
		pane.add(button, gbCons);
		
		button = addbutton("9",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 3;
		gbCons.gridy = 1;
		gbCons.gridheight = 1;
		gbCons.gridwidth = 1;
		pane.add(button, gbCons);
		
		button = addbutton("6",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 3;
		gbCons.gridy = 2;
		pane.add(button, gbCons);
		
		button = addbutton("3",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 3;
		gbCons.gridy = 3;
		pane.add(button, gbCons);
		
		button = addbutton(".",new Show());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 3;
		gbCons.gridy = 4;
		pane.add(button, gbCons);
		
		button = new JButton("/");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 4;
		gbCons.gridy = 1;
		pane.add(button, gbCons);
		
		button = new JButton("*");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridy = 2;
		pane.add(button, gbCons);
		
		button = new JButton("-");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridy = 3;
		pane.add(button, gbCons);
		
		button = new JButton("+");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridy = 4;
		pane.add(button, gbCons);
		
		button = new JButton("sqrt");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 5;
		gbCons.gridy = 1;
		pane.add(button, gbCons);
		
		button = new JButton("1/x");
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 5;
		gbCons.gridy = 2;
		pane.add(button, gbCons);
		
		button = addbutton("=",new addlist());
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.5;
		gbCons.gridx = 5;
		gbCons.gridy = 3;
		gbCons.gridheight = 2;
		pane.add(button, gbCons);
		
		answerList = new JList<String>(answer);
		answerList.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		gbCons.fill = GridBagConstraints.BOTH;
		gbCons.weightx = 0.2;
		gbCons.gridx = 6;
		gbCons.gridy = 0;
		gbCons.gridheight = 5;
		answerList.setFixedCellWidth(70);
		
		pane.add(new JScrollPane(answerList),gbCons);
		
		return pane;
	}
	
	//点击关于的事件
	class showinformation implements ActionListener{
		String[] myformation = {"软件名:计算器","作者:何丹阳","学号:206110308","学校:四川师范大学","学院:计算机科学学院","时间:2018-12-4"};
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(mainFrame, myformation, "信息框", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	//数字按键
	public JButton addbutton(String name,ActionListener fun){
		JButton button = new JButton(name);
		button.addActionListener(fun);
		return button;
	}
	
	//工具
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	// 创建"粘贴"Action，该Action用于创建菜单项、工具按钮和普通按钮
	Action pasteAction = new AbstractAction("粘贴") {
		public void actionPerformed(ActionEvent e) {
			// 如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try {
					// 取出剪贴板中stringFlavor内容
					String content = (String) clipboard.getData(DataFlavor.stringFlavor);
					// 将选中内容替换成剪贴板中的内容
					input.replaceSelection(content);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		}
	};

	// 创建"复制"Action
	Action copyAction = new AbstractAction("复制") {
		public void actionPerformed(ActionEvent e) {
			StringSelection contents = new StringSelection(input.getSelectedText());
			// 将StringSelection对象放入剪贴板
			clipboard.setContents(contents, null);
			// 如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				// 将pasteAction激活
				pasteAction.setEnabled(true);
			}
		}
	};
	
	
	boolean firstDigit = true;
	
	//点击数字的事件
	class Show implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String num = e.getActionCommand();
			if(firstDigit && !num.equals(".")){
				input.setText(num);
			}
			else if(firstDigit && num.equals(".")){
				input.setText("0"+num);
			}
			else if( (input.getText().indexOf(".") < 0)){
				input.setText(input.getText()+num);
			}
			else if(!num.equals(".")){
				input.setText(input.getText()+num);
			}
			firstDigit = false;
		}
	
	}
	
	
	//
	class Shownum implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = input.getText();
			if(text.charAt(0)!='-'){
				input.setText("-"+text);
			}
			else{
				input.setText(text.substring(1, text.length()));
			}
		}
		
	}
	
	//在文本框删除一个
	class back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = input.getText();
			if(text.length() > 0){
				text = text.substring(0, text.length()-1);
				if(text.length() == 0){
					input.setText("");
					firstDigit = true;
				}
				else{
					input.setText(text);
				}
			}	
		}	
	}
	
	//在文本框全部清空
	class clear implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			input.setText("");
			firstDigit = true;	
		}
		
	}
	
	//添加
	class addlist implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!input.getText().trim().equals("")) {
				// 向answer中添加一个元素，系统自动会向JList中添加对应的列表项
				answer.addElement(input.getText());
			}
			else{
				JOptionPane.showMessageDialog(mainFrame, "文本框为空", "警告框", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	//在列表删除
	class deletelist implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {			
			//listmodel判断是否为0
			if(answer.getSize() == 0){
				JOptionPane.showMessageDialog(mainFrame, "列表框为空", "警告框", JOptionPane.WARNING_MESSAGE);
			}
			//选择项的删除
			else if(answerList.getSelectedIndices().length > 0) {
				int response = JOptionPane.showConfirmDialog(mainFrame, "是否删除选择项", "确认对话框", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(response == 0){
					int[] num = answerList.getSelectedIndices();
					for(int i = num.length-1;i>=0;i--)
					answer.removeElementAt(num[i]);
				}
			}
			//没有选择项时
			else{
				int response = JOptionPane.showConfirmDialog(mainFrame, "是否全部删除", "确认对话框", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(response == 0){
					answer.removeAllElements();
				}
			}
		}	
	}
	
	public void showJFrame() {
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.showJFrame();
	}
	

}

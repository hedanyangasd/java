package danyang.he.AI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.xml.ws.soap.AddressingFeature;



public class AI {
	private JFrame mainFrame = new JFrame("人工智能?");
	
	private JCheckBox tihuan = new JCheckBox("替换英文标点",false);
	
	private DefaultListModel listModel = new DefaultListModel<>();
	private JList list = new JList(listModel);
	
	//单行输入框
	private JTextField input = new JTextField(15);
	
	private JButton ask = new JButton("询问");
			
	private JButton clear = new JButton("清空列表");
	
	JPanel panel = new JPanel();
	GridBagLayout gbLayout = new GridBagLayout(); 
	GridBagConstraints gbc = new GridBagConstraints();
	
	public AI() {
		init();
		AiListener();
	}
	
	private void init() {		
	
		mainFrame.setSize(350, 400);
		panel.setLayout(gbLayout);
		
		JPanel biaodian = new JPanel();
		panel.add(tihuan,gbc);

		
	
		//显示对话
		JScrollPane scrollist = new JScrollPane(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 7;
		gbc.gridheight = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(5,5,5,5);
		panel.add(scrollist, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		gbc.weightx = 0.7;
		gbc.weighty = 0;
		panel.add(input, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(ask, gbc);

		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(clear, gbc);
		
		
		
		mainFrame.add(panel);
		//关闭
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	
	public void AiListener() {
		ask.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!input.getText().trim().equals("") && isContainChinese(input.getText())) {
					// 向answer中添加一个元素，系统自动会向JList中添加对应的列表项
					listModel.addElement("我: "+input.getText());
					listModel.addElement("AI: "+RePlace(input.getText()));
					input.setText("");
				}
				else if(!input.getText().trim().equals("") && !isContainChinese(input.getText())){
					JOptionPane.showMessageDialog(mainFrame, "请说普通话", "提示", JOptionPane.NO_OPTION);
					input.setText("");
				}
				else if(input.getText().trim().equals("")){
					JOptionPane.showMessageDialog(mainFrame, "你不说话我怎么回答", "提示", JOptionPane.NO_OPTION);
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listModel.getSize() == 0){
					JOptionPane.showMessageDialog(mainFrame, "列表框为空", "提示", JOptionPane.NO_OPTION);
				}
				else{
					int response = JOptionPane.showConfirmDialog(mainFrame, "是否清空", "确认对话框", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(response == 0){
						listModel.removeAllElements();
					}
				}
			}
		});
		
		tihuan.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(tihuan.isSelected()){
					PrintStream text = RePlaceChinese(input.getText());
					input.setText("替换英文");
				}
				else{
					input.setText("hhhhh");
				}
			}
		});
	}
	
	public boolean isContainChinese(String str) {
		 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		 Matcher m = p.matcher(str);
		 if (m.find()) {
		  return true;
		 }
		 return false;
	}
	
	// 替换方法
    public String RePlace(String str) {
    	str = str.replace('?','!'); //替换"?"
        str = str.replace('？','!'); //替换"?"
        str = str.replace('吗','!'); //替换"吗"
        str = str.replace('么','!'); //替换"么"
        str = str.replace('嘛','!'); //替换"嘛"
        str = str.replace('我','你'); //替换"我"
        str = str.replace('你','我'); //替换"你"
        return str;
     }
    
    // 把中文字符替换成英文字符
    public PrintStream RePlaceChinese(String tempString) {

       PrintStream stringBuffer = null;
	for (int i = 0; i < tempString.length(); i++) {
           //把这个字符串中的中文括号换成英文括号
           if (tempString.charAt(i) == '(')
               stringBuffer.append('（');
           else if (tempString.charAt(i) == ')')
               stringBuffer.append('）');
           else if (tempString.charAt(i) == ',')
               stringBuffer.append('，');
           else if (tempString.charAt(i) == '@')
               stringBuffer.append('@');
           else if (tempString.charAt(i) == ';')
               stringBuffer.append('；');
           else
               stringBuffer.append(tempString.charAt(i));
       }
       return stringBuffer;
   }


	
	public void showJFrame() {
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		AI ai = new AI();
		ai.showJFrame();
	}
	
}

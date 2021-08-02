/**
 * Author:何丹�?
 * Date:2018-10-20
 * Version:4.0
 * function:实现菜单中的各种功能，登录注册找回密码，增加了日记功�
 **/ 
package danyang.he.interDiary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;


public class SetMenu {
	ArrayList<User> users = new ArrayList<User>();
	User user = new User();
	//将对象存储为对象列表

	public void remindre(){
		System.out.println("用户未登录，请先登录");
	}
	
	//�?始菜�?
	public void menubegin(){ 
		System.out.println("1.登录系统");
  	    System.out.println("2.系统设置");
	    System.out.println("3.写日记");
	    System.out.println("4.查找日记");
	    System.out.println("5.退出系统");
	    System.out.println("请输入选择");
	}
	
	//注册登录菜单
	public void menulogin(){  
		System.out.println("1.注册");
  	    System.out.println("2.登录");
	    System.out.println("3.找回密码");
	    System.out.println("4.返回上一层菜单");
	    System.out.println("请输入选择");
	}
	
	//功能菜单
	public void menufunc(){    
		System.out.println("1.按标题查找：");
		System.out.println("2.按内容查找：");
		System.out.println("3.按日期查找：");
		System.out.println("4.按心情查找：");
		System.out.println("5.按天气查找：");
		System.out.println("6.返回上一级菜单：");	
	    System.out.println("请输入选择");
	}
	
	//天气菜单
	public void menuweather(){    
		System.out.println("今天的天气怎么样?");
		System.out.println("1.多云");
	    System.out.println("2.晴天");
	    System.out.println("3.有雨");
	    System.out.println("4.雪天");
	    System.out.println("5.有风");
	    System.out.println("6.阴天");
	    System.out.println("请输入选择");
	}

	//心情菜单
	public void menumood(){    
		System.out.println("今天的心情怎么样?");
		System.out.println("1.开心");
	    System.out.println("2.伤心");
	    System.out.println("3.紧张");
	    System.out.println("4.生气");
	    System.out.println("5.兴奋");
	    System.out.println("请输入选择");
	}
	
	//选择菜单的正确输�?
	public int judg(){   
		Scanner input=new Scanner(System.in);
		int x=0;
		boolean exit = true;
		while(exit){
			try{
				x=input.nextInt();
				exit = false;
			}catch(Exception e){
				System.out.println("输入不对,请重新输入");
				input.nextLine();
			}	
		}
		return x;
	}
	
	//登录注册找回密码菜单	
	public void loginregister(){ 
		boolean exit=true;
		do{
			menulogin();
			int operation=judg();
			switch (operation){
			case 1:
				register();
				break;
			case 2:
				int a=login();
				if(a==1){
					System.out.println("退出成功，返回首菜单");
					exit=false;
				}
				break;
			case 3:
				recovers();
				break;
			case 4:
				exit=false;
				break;
			default:
				System.out.println("输入不对，请重新选择");
			}
		}while(exit);
	}
	
	//注册
	public void register(){
		Scanner input=new Scanner(System.in);	
		boolean again=false;
		do{
			again=false;
		//输入用户�?
		System.out.println("请输入用户名(只能包含字母、数字和下划线，并且首字母只能为字母,最短不能少于 6 个字符，最长不 能超过 20 个字符)");
		String username = input.nextLine();
		while(!user.setUsername(username)){
			System.out.println("输入不对，请重新输入");
			username = input.nextLine();
		}
		
		//输入显示�?
		System.out.println("请输入显示名(任意字符，最小只能为 3 个字符，最长可以为 20 个字符)");
		String showname = input.nextLine();
		while(!user.setShowname(showname)){
			System.out.println("输入不对，请重新输入");
			showname = input.nextLine();
		}
		
		//输入密码以及确认密码
		System.out.println("请输入密码：(密码必须包含字母数字和特殊符号，密码最短为 8 位，最长不能超过30)");
		String password = input.nextLine();
		while(!user.setPassword(password)){
			System.out.println("输入不对，请重新输入");
			password = input.nextLine();
		}
		System.out.println("请确认密码");
		String querenpassword = input.nextLine();
		while(!querenpassword.equals(password)){
			System.out.println("确认密码不对，请重新输入");
			querenpassword = input.nextLine();
		}
		
		//输入邮箱
		System.out.println("请输入邮箱：(符合邮箱格式，最常不能超过50 个字符)");
		String email=input.nextLine();
		while(!user.setEmail(email)){
			System.out.println("输入不对，请重新输入");
			email = input.nextLine();
		}
		
		//密保问题
		System.out.println("从下面5个问题中选择其中一个进行回答");
		boolean exit=false;
		String answer="";
		int question=0;
		do{
			System.out.println("1.您的大学名称");
			System.out.println("2.您最喜欢的体育项目");
			System.out.println("3.您的爱好");
			System.out.println("4.您的专业");
			System.out.println("5.您最喜爱的学科");
			question=judg();
			switch (question){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("请输入您的答案：");
				answer=input.nextLine();
				while(!user.setAnswer(answer)){
					answer=input.nextLine();
					System.out.println("答案不能为空，请重新输入您的答案");
				}
				exit=false;
				break;
			default:
				System.out.println("输入不对，请重新选择");
			}
		}while(exit);
		
		//验证四则运算
		int b,jieguo;
		int i=0;
		do{
			Arithmetic a = new Arithmetic();
			b = a.generateArithmeticVerification();
			jieguo=input.nextInt();
			i++;
		}while(jieguo !=  b && i<5);
		if(i>=5){
			System.out.println("次数已使用完，请重新注册!");
			input.nextLine();
			again=true;
			}		
		//保存用户信息
		else{
		System.out.println("用户名:"+username);
		System.out.println("显示名:"+showname);
		System.out.println("密码:"+password);
		System.out.println("邮箱:"+email);
		System.out.println("选择问题号:"+question);
		System.out.println("答案:"+answer);
		
		User person = new User(username,showname,password,email,question,answer);		
		users.add(person);//将注册的用户保存在列�?
		System.out.println("注册成功");
		}
		}while(again);;
		
	}
	
	
	//登录
	public int login(){
		Diary diary = new Diary();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = input.nextLine();
		System.out.println("请输入密码：");
		String password = input.nextLine();
		while(username.length()<6 || username.length()>20||password.length()<8||password.length()>30){
			System.out.println("用户名和密码的字符数不对，请重新输入");
			System.out.println("请输入用户名：");
			username = input.nextLine();
			System.out.println("请输入密码：");
			password = input.nextLine();
		}
		
		//判断是否登录成功
		boolean success = false;
		String showname="";
		int num=0;
		for(User user:users){
			int i=0;
			if(user.isloginsuccess(user, username, password)){
				System.out.println("登录成功");
				showname=user.getShowname();
				num=i;
				success = true;
				break;
			}
			i++;
		}
		if(success){
			boolean exit=true;
			do{
				System.out.println("1.["+showname+"]退出登录");
		  	    System.out.println("2.系统设置");
			    System.out.println("3.写日记");
			    System.out.println("4.查找日记");
			    System.out.println("5。退出系统");
			    System.out.println("请选择");
				int operation=judg();
				switch (operation){
				case 1:
					exit=false;
					break;
				case 2:
					System.out.println("正在执行系统设置......");
					break;
				case 3:
					System.out.println("正在执行写日记......");
					users.get(num).setDiarys();
					break;
				case 4:
					boolean exit1=true;
					do{
						System.out.println("1.查看日记列表 ：");
					//	System.out.println("1.按标题查找：");
					//	System.out.println("2.按内容查找：");
					//	System.out.println("3.按日期查找：");
					//	System.out.println("4.按心情查找：");
					//	System.out.println("5.按天气查找：");
						System.out.println("2.返回上一级菜单：");	
					    System.out.println("请输入选择");
					    int operation1=judg();
					    switch (operation1){
					    case 1:
					    	System.out.println("按日期排序列出日记的标题和日期");
					    	List<Diary> diarys= users.get(num).getDiarys();
					        showDiary(diarys);
						    break;
/*					    case 2:
					    	System.out.println("正在执行按内容查找......");
						    break;
					    case 3:
					    	System.out.println("正在执行按日期查找......");
						    break;
					    case 4:
					    	System.out.println("正在执行按心情查找......");
						    break;
					    case 5:
					    	 System.out.println("正在执行按天气查找......");
						      break;*/
					    case 2:
					    	exit1=false;
					    	break;
					    default:
							System.out.println("输入不对，请重新选择");	
					    }
					}while(exit1);
					break;
				case 5:
					System.out.println("谢谢使用，返回首菜单");
					exit=false;
				default:
					System.out.println("输入不对，请重新选择");
				}
			}while(exit);
			return 1;
		}
		else{
			System.out.println("用户名和密码不配或没有该用户，请重新登录");
			return 0;
		}		
	}
	
	public void showDiary(List<Diary> diarys){
		boolean exit = true;
		int operation = 0;
		Collections.sort(diarys);
		for(int i=0;i<diarys.size();i++){
			System.out.println("日记第"+(i+1)+"篇: "+"标题:"+diarys.get(i).getTitle()+
					" 日期:"+diarys.get(i).getDate().getDate());
		}
		System.out.println("请输入要查看的日记的序号");
		do{
			operation=judg();
			if(operation <= 0 || operation > diarys.size()){
				System.out.println("输入不对,请重新输入");
				exit = true;
			}
			else{
				exit = false;
			}
		}while(exit);
		System.out.println(diarys.get(operation-1).toString());
	}
	
	
	//找回密码
	public void  recovers(){
		Scanner input = new Scanner(System.in);
		boolean exit=true;
		System.out.println("请输入要找回密码的用户名");
		do{
			boolean success=false;		
			String username = input.nextLine();
			for(User user:users){
				if(user.getUsername().equals(username)){
					success=true;
					break;
				}
			}
			if(success){
				System.out.println("从下面5个问题中选择其中一个进行回答");
				boolean exit1=true;
				String answer="";
				int question=0;
				do{
					System.out.println("1.您的大学名称");
					System.out.println("2.您最喜欢的体育项目");
					System.out.println("3.您的爱好");
					System.out.println("4.您的专业");
					System.out.println("5.您最喜爱的科目");
					question=judg();
					switch (question){
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
						System.out.println("请输入您的答案：");
						answer=input.nextLine();
						while(answer.isEmpty()){
							answer=input.nextLine();
							System.out.println("答案不能为空，请重新输入您的答案�?");
						}
						exit1=false;
						break;
					default:
						System.out.println("输入不对，请重新选择�?");
					}
				}while(exit1);
				//匹配用户信息
				boolean pipei=false;
				for(User user:users){
					if(user.getUsername().equals(username)&&user.getAnswer().equals(answer)&&user.getQuestion()==question){
						System.out.println("答案和用户注册时填写的不一样");
						System.out.println("请输入密码：(密码必须包含字母数字和特殊符号，密码最短为 8 位，最长不能超过30)");
						String password = input.nextLine();
						while(!password.matches("^(?![A-Za-z0-9]+$)(?![A-Za-z\\W]+$)[a-zA-Z0-9\\W]{8,30}$")){
							//排除只有字母或数字与特殊符号和只有字母和数字和只有字母和特殊符号和只有字母和数字的组�?
							System.out.println("输入不对，请重新输入：");
							password = input.nextLine();
						}
						System.out.println("请确认密码");
						String querenpassword = input.nextLine();
						while(!querenpassword.equals(password)){
							System.out.println("确认密码不对，请重新输入");
							querenpassword = input.nextLine();
						}
						user.setPassword(password);
						System.out.println("用户"+user.getUsername()+"的新密码："+user.getPassword());
						pipei=true;
						break;
					}
				}
				if(!pipei){
					System.out.println("密码错误，不能修改密");
				}
				
				exit=false;
			}
			else{
				System.out.println("该用户名不存在，请重新输入用户名");
				exit=true;
			}			
		}while(exit);
	}
}
	

	





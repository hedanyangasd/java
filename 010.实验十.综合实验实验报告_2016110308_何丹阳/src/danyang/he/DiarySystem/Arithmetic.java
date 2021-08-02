/**
 * Author:何丹阳
 * Data: 2018-10-20
 * Version:1.0
 * Function:四则运算
 **/
package danyang.he.DiarySystem;
import java.util.Random;

public class Arithmetic {
	/**
	* 	生成四则算术验证码
	* 	int 生成的四则运算验证码的结果	
	*/
	
	public static int result = 0;

	
	public static String getResult() {
		String Result = Integer.toString(result);
		return Result;
	}



	public static String getArith() {
		//生成三个随机操作数
		Random random = new Random();			
		int a = random.nextInt(10)+1;		
		int b = random.nextInt(10)+1;
		int c = random.nextInt(10)+1;
		
		//从'+', '-', '*', '/'随机选择两个运算符
		String[] OperatorArray  = {"+", "-", "*", "/"};
		int opIndex1 = random.nextInt(4);
		int opIindx2 = random.nextInt(4);
		String op1 = OperatorArray[opIndex1];
		String op2 = OperatorArray[opIindx2];
		
		String yunsuan = a + op1+ b + op2 + c + " 的答案: ";	//提示用户输入验证码的答案
		
		if(comparisonOpPriority(op1, op2)) {
			result = calculate(a, b, op1);
			result = calculate(result, c, op2);
		}else {
			result = calculate(b, c, op2);
			result = calculate(a, result, op1);
		}
		
		return yunsuan;			
	}
	
	
	//	二元一则运算
	 //	a 第一个操作数、b 第二个操作数、op 操作符
	 //	返回运算结果
	
	public static int calculate(int a, int b, String op) {
		int calResult = 0;
		switch(op)
		{
		case "+":
			calResult = a+b;
			break;
		case "-":
			calResult = a-b;
			break;
		case "*":
			calResult = a*b;
			break;
		case "/":
			calResult = a/b;
			break;
		}
		return calResult;
	}
	
	/**
	* 	比较操作符的优先级
	* 	op1 第一个操作符、op2 第二个操作符
	* 	返回boolean 
	*/
	public static boolean comparisonOpPriority(String op1, String op2)
	{
		boolean op1HasHighPriority = true;
		switch(op1)						//若是op1和op2为/或者*时，默认op1的优先级高
		{
		case "-":	
		case "+":
			if(op2=="*" || op2=="/")
				op1HasHighPriority = false;
			break;
		}
		return op1HasHighPriority;
	}
	
}

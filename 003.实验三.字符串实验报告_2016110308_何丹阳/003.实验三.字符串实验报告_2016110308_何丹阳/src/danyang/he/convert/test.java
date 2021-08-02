/**
 * Author:何丹阳
 * Date:2018-9-25
 * Version:1.0
 * function:测试类，对转化大小写的类进行测试
**/
package danyang.he.convert;
import java.util.Scanner;

public class test {
	public static void main(String[] args){
		CaseConverter converter=new CaseConverter();
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个句子");
		String sentence = input.nextLine();
		System.out.println("输出结果：\n"+converter.convert(sentence));
		input.close();
	}
}

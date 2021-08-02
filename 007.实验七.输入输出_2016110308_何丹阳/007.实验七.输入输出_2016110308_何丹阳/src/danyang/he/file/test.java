/*
 *Author:何丹阳
 *Date:2018-11-24
 *version:1.0
 *Description:测试类
 */
package danyang.he.file;

import java.io.File;

public class test {
	public static void main(String[] args){
		File file = new File("F:"+File.separator+"demo.text");
		LetterFrequencyCounter t = new LetterFrequencyCounter();
		t.loadFile(file);
		t.printFrequencies();

	}
}

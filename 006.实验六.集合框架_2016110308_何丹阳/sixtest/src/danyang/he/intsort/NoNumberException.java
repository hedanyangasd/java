/*
 *Author:何丹阳
 *Date:2018-11-10
 *version:1.0
 *Description:抛出异常
 */
package danyang.he.intsort;

public class NoNumberException extends RuntimeException{
	/*
	 * serialVersionUID作用：相当于java类的身份证。主要用于版本控制。
	 * serialVersionUID作用是序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
	 * 一个是默认的1L，比如：private static final long serialVersionUID = 1L;
	 * 一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段，比如：private static final long serialVersionUID = xxxxL;
	*/
	private static final long serialVersionUID = 1L;
	
	public NoNumberException(){
	}

	public NoNumberException(String message){
		super(message);
	}

}
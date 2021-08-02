/*
 *Author:何丹阳
 *Date:2018-11-23
 *version:1.0
 *Description:文件关闭
 */
package danyang.he.file;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	public static void close(Closeable resource) {
		try {
			if (resource != null) {
				resource.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
}

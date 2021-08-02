package danyang.he.eaxm02;

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
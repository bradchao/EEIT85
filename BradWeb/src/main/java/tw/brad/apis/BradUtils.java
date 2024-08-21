package tw.brad.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BradUtils {
	public static String loadView() throws Exception {
		String source = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\views\\view1.html";
		File viewFile = new File(source);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));
		bin.read(buf);
		bin.close();
		
		return new String(buf);
		
	}
}

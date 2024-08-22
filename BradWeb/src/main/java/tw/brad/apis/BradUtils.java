package tw.brad.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BradUtils {
	// view => view1, view2, ....
	public static String loadView(String view) throws Exception {
		String source = String.format(
			"C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\views\\%s.html", view);
		File viewFile = new File(source);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));
		bin.read(buf);
		bin.close();
		
		return new String(buf);
		
	}
	
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return intX + intY + "";
		}catch(Exception e) {
			return "";
		}
	}
}

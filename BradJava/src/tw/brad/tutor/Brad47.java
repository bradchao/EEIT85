package tw.brad.tutor;

import java.io.*;

public class Brad47 {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("./dir1/file2.txt")) {
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
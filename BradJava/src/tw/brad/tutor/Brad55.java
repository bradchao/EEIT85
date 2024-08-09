package tw.brad.tutor;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad55 {

	public static void main(String[] args) {
		try (Socket client = new Socket(InetAddress.getByName("10.0.100.157"), 9999);
				BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream())) {

			String mesg = "Hello, World\nabcdefg\n1234567\n";
			bout.write(mesg.getBytes());
			
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}

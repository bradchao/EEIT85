package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Brad56 {

	public static void main(String[] args) {
		while(true) {
			try (ServerSocket server = new ServerSocket(9999);
				Socket socket = server.accept();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()))) {
	
				String urIp = socket.getInetAddress().getHostAddress();
				System.out.print(urIp + " => ");
				
				String line; StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				String mesg = sb.toString();
				System.out.println(mesg);
				if (mesg.trim().equals("exit")) {
					break;
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}

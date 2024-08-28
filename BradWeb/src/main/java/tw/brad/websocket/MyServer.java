package tw.brad.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {

	public MyServer() {
		System.out.println("MyServer");
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
	}

	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("onMessage");
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		
	}
	
	@OnError
	public void onError(Session session) {
		System.out.println("onError");
		
	}
	
	
}

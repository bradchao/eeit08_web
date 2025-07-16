package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	private static boolean isExistTeacher = false;
	private static Session teacherSession;
	
	public MyCenter() {
		System.out.println("MyCenter()");
		if (sessions == null) {
			sessions = new HashSet<Session>();
			users = new HashMap<String, Session>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
		
		if (sessions.add(session)) {
			users.put(session.getId(), session);
			System.out.println("count:" + sessions.size());
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("OnMessage:" + mesg);
		
		if (!isExistTeacher && mesg.contains("isTeacher")) {
			isExistTeacher = true;
			teacherSession = session;
		}
		
		if (isExistTeacher && session == teacherSession) {
			for(Session userSession : sessions) {
				try {
					userSession.getBasicRemote().sendText(mesg);
				} catch (IOException e) {
					System.err.println(e);
				}
			}
			
		}
		
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("OnClose");
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("count:" + sessions.size());
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("OnError:" + t.toString());
	}
}

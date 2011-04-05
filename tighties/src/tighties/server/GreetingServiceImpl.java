package tighties.server;

import tighties.client.GreetingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	private static final long serialVersionUID = 6803736245591814628L;

	public String greetServer(String input) {
		return "23";
	}
}

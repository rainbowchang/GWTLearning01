package me.zch.gwt.server;

import me.zch.gwt.client.GreetingService;
import me.zch.gwt.shared.FieldVerifier;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
//		Date date = new Date();
//		String s = input + "," + date.toString();
//		double d = Math.random() * 10;
//		double i = Math.ceil(d);
//		if(i<3.0)
//			throw new IllegalArgumentException("Less than 3.0 .");
//		s = Double.toString(i) + "  " + s;
//		return escapeHtml(s);
		
		String ss ="[{ \"FirstName\" : \"Jimmy\", \"LastName\" : \"Webber\" },{ \"FirstName\" : \"Alan\",  \"LastName\" : \"Dayal\" },{ \"FirstName\" : \"Keanu\", \"LastName\" : \"Spoon\" },{ \"FirstName\" : \"Emily\", \"LastName\" : \"Rudnick\" }]";
		return escapeHtml(ss);
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

}

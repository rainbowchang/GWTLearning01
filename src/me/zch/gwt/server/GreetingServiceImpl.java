package me.zch.gwt.server;

import me.zch.gwt.client.GreetingService;
import java.io.IOException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(int commandId, String input) throws IllegalArgumentException {

		switch (commandId) {
		case 0:  //读取说明文档
			try {
				return command0();
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		case 1: //json演示
			return command1();
		default:
			throw new IllegalArgumentException("unknown command id.");
		}
	}
	
	private String command0() throws IOException {
		return Tools.loadTextFileToHtml("Description.txt");
	}
	
	private String command1(){
		String ss = "{ \"FirstName\" : \"Jimmy\", \"LastName\" : \"Webber\", \"List\" : [{\"Name\":\"book\",\"Sammer\": 1},{\"Name\":\"wine\",\"Sammer\": 2},{\"Name\":\"lightening\",\"Sammer\": 4}]}";
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

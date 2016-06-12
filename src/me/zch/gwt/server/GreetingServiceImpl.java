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
		case 0:  
			try {
				return command0();
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		case 1: //json
			return command1();
			
		case 2: 
			try {
				return command2();
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		default:
			throw new IllegalArgumentException("unknown command id.");
		}
	}
	
	private String command0() throws IOException {
		return Tools.loadTextFileToHtml("Description.txt");
	}
	
	private String command2() throws IOException {
		return Tools.loadTextFile("books.xml");
	}
	
	private String command1(){
		String ss = "{ \"FirstName\" : \"Jimmy\", \"LastName\" : \"Webber\", \"List\" : [{\"Name\":\"book\",\"Sammer\": 1},{\"Name\":\"wine\",\"Sammer\": 2},{\"Name\":\"lightening\",\"Sammer\": 4}]}";
		return Tools.escapeHtml(ss);
	}
	

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */


}

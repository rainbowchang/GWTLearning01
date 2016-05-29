package me.zch.gwt.server;

import me.zch.gwt.client.GreetingService;
import me.zch.gwt.shared.FieldVerifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

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
		BufferedReader br = null;
		try {
			File file = new File("Description.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
			String result = "";
			String t;
			while ((t = br.readLine()) != null) {
				t += "<br>";
				result += t;
			}
			return result;
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
			}
		}
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

package me.zch.gwt.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

	public static String loadTextFileToHtml(String filename) throws IOException {

		BufferedReader br = null;
		try {
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String result = "";
			String t;
			while ((t = br.readLine()) != null) {
				t = t.replace(" ", "&nbsp;");
				t += "<br/>";
				result += t;
			}
			return result;
		} catch (IOException ex) {
			throw ex;
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
			}
		}
	}
	
	public static String loadTextFile(String filename) throws IOException {

		BufferedReader br = null;
		try {
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String result = "";
			String t;
			while ((t = br.readLine()) != null) {
				result += t + System.getProperty("line.separator");
			}
			return result;
		} catch (IOException ex) {
			throw ex;
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
			}
		}
	}
	
	public static void createPicture(){
		
	}
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	public static String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}

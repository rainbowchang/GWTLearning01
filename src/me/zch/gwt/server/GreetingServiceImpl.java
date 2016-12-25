package me.zch.gwt.server;

import me.zch.gwt.client.GreetingService;
import java.io.IOException;
import java.util.Random;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	private static Random random = new Random();

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
		case 3:
			return commandGetArithmetic();
		default:
			throw new IllegalArgumentException("unknown command id.");
		}
	}
	
	private String command0() throws IOException {
		return Tools.loadTextFileToHtml("Text/Description.txt");
	}
	
	private String command2() throws IOException {
		return Tools.loadTextFile("Text/books.xml");
	}
	
	private String command1(){
		String ss = "{ \"FirstName\" : \"Jimmy\", \"LastName\" : \"Webber\", \"List\" : [{\"Name\":\"book\",\"Sammer\": 1},{\"Name\":\"wine\",\"Sammer\": 2},{\"Name\":\"lightening\",\"Sammer\": 4}]}";
		return Tools.escapeHtml(ss);
	}
	
	
	private String commandGetArithmetic(){
		int N1, N2, R;
		boolean Operators;//true == +; false == -

		Operators = random.nextBoolean();
		if(Operators){
			N1 = random.nextInt(300);
			N2 = random.nextInt(300);
			R = N1 + N2;
		}else{
			N1 = random.nextInt(500);
			N2 = random.nextInt(N1);
			R = N1 - N2;
		}
		String result = String.format("{\"topic\": \"%d %s %d = \", \"answer\":%d}", N1, (Operators)?"+":"-", N2, R);
		return result;
	}
	
	// n*n
	private String commandGetArithmeticMultiple01() {
		int N1, N2, R;
		N1 = random.nextInt(10);
		N2 = random.nextInt(10);
		R = N1 * N2;
		String result = String.format("{\"topic\": \"%d %s %d = \", \"answer\":%d}", N1, "X", N2, R);
		return result;
	}

	// n0*n
	private String commandGetArithmeticMultiple02() {
		int N1, N2, R;
		N1 = random.nextInt(10) * 10;
		N2 = random.nextInt(10);
		R = N1 * N2;
		String result = String.format("{\"topic\": \"%d %s %d = \", \"answer\":%d}", N1, "X", N2, R);
		return result;
	}
	
	// n00*n
	private String commandGetArithmeticMultiple03() {
		int N1, N2, R;
		N1 = random.nextInt(10) * 100;
		N2 = random.nextInt(10);
		R = N1 * N2;
		String result = String.format("{\"topic\": \"%d %s %d = \", \"answer\":%d}", N1, "X", N2, R);
		return result;
	}
	
	// nml*n
	private String commandGetArithmeticMultiple04() {
		int N1, N2, R;
		N1 = random.nextInt(999);
		N2 = random.nextInt(10);
		R = N1 * N2;
		String result = String.format("{\"topic\": \"%d %s %d = \", \"answer\":%d}", N1, "X", N2, R);
		return result;
	}
	
}

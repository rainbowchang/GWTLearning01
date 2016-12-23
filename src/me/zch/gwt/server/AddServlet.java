package me.zch.gwt.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		int a = Integer.valueOf(req.getParameter("a"));
		int b = Integer.valueOf(req.getParameter("b"));
		try{
			resp.getWriter().print(Integer.toString(a+b));
		}catch(IOException e){}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpGet response = new HttpGet("http://hq.sinajs.cn/list=s_sh000001");
		ResponseHandler<String> handler = new BasicResponseHandler();
		String body = client.execute(response, handler);
		System.out.print(body);
	}
}

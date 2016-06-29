package me.zch.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;

import me.zch.gwt.client.json.StockInfoStructure.StockInfoData;

public class HttpRequest {
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	public HttpRequest(){}
	private TextArea ta;
	
	public Panel createPanel() {
		FlowPanel vp = new FlowPanel();
		Button btn = new Button();
		btn.setText("Request");
		btn.addClickHandler(new BtnClick());
		vp.add(btn);
	    ta = new TextArea();
		ta.setReadOnly(true);
		vp.add(ta);
		return vp;
	}
	
	private class BtnClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			String url ="http://apis.baidu.com/apistore/stockservice/stock" + "?" + "stockid=sz002230&list=1";
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
			builder.setHeader("apikey", "873c770acf1ce7ed92d7d912750e76fc");
			builder.setCallback(new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {
					// TODO Auto-generated method stub
					if(Response.SC_OK == response.getStatusCode()){  
//						ta.setText(response.getText());  
						StockInfoData sid = JsonUtils.safeEval(response.getText());
						ta.setText(sid.getErrMsg());
					}
				}

				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub
					
				}
				
			});
			try {
				builder.send();
			} catch (RequestException e) {
				e.printStackTrace();
			}  
		}
		
	}
}

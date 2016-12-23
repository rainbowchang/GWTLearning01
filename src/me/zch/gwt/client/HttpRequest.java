package me.zch.gwt.client;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.text.client.DoubleRenderer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;

import me.zch.gwt.client.StockInfoStructure.StockInfoData;

public class HttpRequest {
	
	public HttpRequest(){}
	private TextArea ta;
	private Grid grid;
	public Panel createPanel() {
		FlowPanel vp = new FlowPanel();
		Button btn = new Button();
		btn.setText("Request");
		btn.addClickHandler(new BtnClick());
		vp.add(btn);
	    ta = new TextArea();
		ta.setReadOnly(true);
		vp.add(ta);
		grid = new Grid(5,2);
		grid.setWidth("200px");
		grid.setText(0, 0, "名称");
		grid.setText(1, 0, "现价");
		grid.setText(2, 0, "最高");
		grid.setText(3, 0, "最低");
		grid.setText(4, 0, "开盘");
		vp.add(grid);
		
		return vp;
	}
	
	private class BtnClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
//			String url ="http://apis.baidu.com/apistore/stockservice/stock" + "?" + "stockid=sz002230&list=1";
//			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
//			builder.setHeader("apikey", "873c770acf1ce7ed92d7d912750e76fc");
//			builder.setCallback(new RequestCallback() {
//
//				@Override
//				public void onResponseReceived(Request request, Response response) {
//					// TODO Auto-generated method stub
//					if(Response.SC_OK == response.getStatusCode()){  
////						ta.setText(response.getText());  
//						StockInfoData sid = JsonUtils.safeEval(response.getText());
//						ta.setText(response.getText());
//						
//						grid.setText(0, 1, sid.getRetData().getStockinfo()[0].getName());
//						//DoubleRenderer dr = DoubleRenderer.instance(sid.getRetData().getStockinfo()[0].getCurrentPrice());
//						
//						grid.setText(1, 1, Float.toString(sid.getRetData().getStockinfo()[0].getCurrentPrice()));
//						grid.setText(2, 1, Float.toString(sid.getRetData().getStockinfo()[0].getHPrice()));
//						grid.setText(3, 1, Float.toString(sid.getRetData().getStockinfo()[0].getLPrice()));
//						grid.setText(4, 1, Float.toString(sid.getRetData().getStockinfo()[0].getClosingPrice()));
//						
//						
//					}
//				}
//
//				@Override
//				public void onError(Request request, Throwable exception) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//			});
//			try {
//				builder.send();
//			} catch (RequestException e) {
//				e.printStackTrace();
//			}  
			String url = "http://apis.baidu.com/apistore/stockservice/stock" + "?" + "stockid=sz002230&list=1";
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
			try {
				builder.sendRequest(null, new RequestCallback(){

					@Override
					public void onResponseReceived(Request request, Response response) {
						if (Response.SC_OK == response.getStatusCode())
							ta.setText(response.getText());
						else
							ta.setText(Integer.toString(response.getStatusCode()));
					}

					@Override
					public void onError(Request request, Throwable exception) {
						ta.setText(exception.getMessage());
					}
					
				});
			} catch (RequestException e) {
				e.printStackTrace();
			}
		}
	}
	
}

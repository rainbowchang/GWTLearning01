package me.zch.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
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

//import me.zch.gwt.client.json.StockInfoStructure.MarketsInfo;
//import me.zch.gwt.client.json.StockInfoStructure.RetData;
//import me.zch.gwt.client.json.StockInfoStructure.StockInfo;
//import me.zch.gwt.client.json.StockInfoStructure.StockInfoData;
//import me.zch.gwt.client.json.StockInfoStructure.StockMarketInfo;

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
						ta.setText(sid.getErrNum());
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
	

	public static class StockInfoData extends JavaScriptObject{
		protected StockInfoData(){}
		public final native String getErrNum() /*-{ return this.errNum; }-*/;
		public final native String getErrMsg() /*-{ return this.errMsg; }-*/;
		public final native RetData getRetData() /*-{ return this.RetData; }-*/;
	}
	
	public static class RetData extends JavaScriptObject{
		protected RetData(){}
		public final native StockInfo[] getStockinfo() /*-{ return this.stockinfo; }-*/;
		public final native MarketsInfo getMarket() /*-{ return this.market; }-*/;
	}
	
	public static class StockInfo extends JavaScriptObject{
		protected StockInfo(){}
		
		public final native String getName() /*-{ return this.name; }-*/;
		public final native String getCode() /*-{ return this.code; }-*/;
		public final native String getDate() /*-{ return this.date; }-*/;
		public final native String getTime() /*-{ return this.time; }-*/;
		public final native String getOpenningPrice() /*-{ return this.OpenningPrice; }-*/;
		public final native String getClosingPrice() /*-{ return this.closingPrice; }-*/;
		public final native String getCurrentPrice() /*-{ return this.currentPrice; }-*/;
		public final native String getHPrice() /*-{ return this.hPrice; }-*/;
		public final native String getLPrice() /*-{ return this.lPrice; }-*/;
		public final native String getCompetitivePrice() /*-{ return this.competitivePrice; }-*/;
		public final native String getAuctionPrice() /*-{ return this.auctionPrice; }-*/;
		public final native String getTotalNumber() /*-{ return this.totalNumbe; }-*/;
		public final native String getIncrease() /*-{ return this.increase; }-*/;
		public final native String getBuyOne() /*-{ return this.buyOne; }-*/;
		public final native String getBuyOnePrice() /*-{ return this.buyOnePrice; }-*/;
		public final native String getBuyTwo() /*-{ return this.buyTwo; }-*/;
		public final native String getBuyTwoPrice() /*-{ return this.buyTwoPrice; }-*/;
		public final native String getBuyThree() /*-{ return this.buyThree; }-*/;
		public final native String getBuyThreePrice() /*-{ return this.buyThreePrice; }-*/;
		public final native String getBuyFour() /*-{ return this.buyFour; }-*/;
		public final native String getBuyFourPrice() /*-{ return this.buyFourPrice; }-*/;
		public final native String getBuyFive() /*-{ return this.buyFive; }-*/;
		public final native String getBuyFivePrice() /*-{ return this.buyFivePrice; }-*/;
		public final native String getSellOne() /*-{ return this.sellOne; }-*/;
		public final native String getSellOnePrice() /*-{ return this.sellOnePrice; }-*/;
		public final native String getSellTwo() /*-{ return this.sellTwo; }-*/;
		public final native String getSellTwoPrice() /*-{ return this.sellTwoPrice; }-*/;
		public final native String getSellThree() /*-{ return this.sellThree; }-*/;
		public final native String getSellThreePrice() /*-{ return this.sellThreePrice; }-*/;
		public final native String getSellFour() /*-{ return this.sellFour; }-*/;
		public final native String getSellFourPrice() /*-{ return this.sellFourPrice; }-*/;
		public final native String getSellFive() /*-{ return this.sellFive; }-*/;
		public final native String getSellFivePrice() /*-{ return this.sellFivePrice; }-*/;
		public final native String getMinurl() /*-{ return this.minurl; }-*/;
		public final native String getDayurl() /*-{ return this.dayurl; }-*/;
		public final native String getWeekurl() /*-{ return this.weekurl; }-*/;
		public final native String getMonthurl() /*-{ return this.monthurl; }-*/;
	}
	
	public static class MarketsInfo extends JavaScriptObject{
		protected MarketsInfo(){}
		public final native StockMarketInfo getShanghai() /*-{ return this.shanghai; }-*/;
		public final native StockMarketInfo getShenzhen() /*-{ return this.shenzhen; }-*/;
	}
	
	public static class StockMarketInfo extends JavaScriptObject{
		protected StockMarketInfo(){}
		public final native String getName() /*-{ return this.name; }-*/;
		public final native String getCurdot() /*-{ return this.curdot; }-*/;
		public final native String getCurprice() /*-{ return this.curprice; }-*/;
		public final native String getRate() /*-{ return this.rate; }-*/;
		public final native String getDealnumber() /*-{ return this.rate; }-*/;
		public final native String getTurnover() /*-{ return this.turnover; }-*/;
	}
}

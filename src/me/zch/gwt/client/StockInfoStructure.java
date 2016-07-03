package me.zch.gwt.client;

import com.google.gwt.core.client.JavaScriptObject;

public class StockInfoStructure {

	public static class StockInfoData extends JavaScriptObject{
		protected StockInfoData(){}
		public final native String getErrNum() /*-{ return this.errNum; }-*/;
		public final native String getErrMsg() /*-{ return this.errMsg; }-*/;
		public final native RetData getRetData() /*-{ return this.retData; }-*/;
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
		public final native float getOpenningPrice() /*-{ return this.OpenningPrice; }-*/;
		public final native float getClosingPrice() /*-{ return this.closingPrice; }-*/;
		public final native float getCurrentPrice() /*-{ return this.currentPrice; }-*/;
		public final native float getHPrice() /*-{ return this.hPrice; }-*/;
		public final native float getLPrice() /*-{ return this.lPrice; }-*/;
		public final native float getCompetitivePrice() /*-{ return this.competitivePrice; }-*/;
		public final native float getAuctionPrice() /*-{ return this.auctionPrice; }-*/;
		public final native int getTotalNumber() /*-{ return this.totalNumbe; }-*/;
		public final native float getIncrease() /*-{ return this.increase; }-*/;
		public final native int getBuyOne() /*-{ return this.buyOne; }-*/;
		public final native float getBuyOnePrice() /*-{ return this.buyOnePrice; }-*/;
		public final native int getBuyTwo() /*-{ return this.buyTwo; }-*/;
		public final native float getBuyTwoPrice() /*-{ return this.buyTwoPrice; }-*/;
		public final native int getBuyThree() /*-{ return this.buyThree; }-*/;
		public final native float getBuyThreePrice() /*-{ return this.buyThreePrice; }-*/;
		public final native int getBuyFour() /*-{ return this.buyFour; }-*/;
		public final native float getBuyFourPrice() /*-{ return this.buyFourPrice; }-*/;
		public final native int getBuyFive() /*-{ return this.buyFive; }-*/;
		public final native float getBuyFivePrice() /*-{ return this.buyFivePrice; }-*/;
		public final native int getSellOne() /*-{ return this.sellOne; }-*/;
		public final native float getSellOnePrice() /*-{ return this.sellOnePrice; }-*/;
		public final native int getSellTwo() /*-{ return this.sellTwo; }-*/;
		public final native float getSellTwoPrice() /*-{ return this.sellTwoPrice; }-*/;
		public final native int getSellThree() /*-{ return this.sellThree; }-*/;
		public final native float getSellThreePrice() /*-{ return this.sellThreePrice; }-*/;
		public final native int getSellFour() /*-{ return this.sellFour; }-*/;
		public final native float getSellFourPrice() /*-{ return this.sellFourPrice; }-*/;
		public final native int getSellFive() /*-{ return this.sellFive; }-*/;
		public final native float getSellFivePrice() /*-{ return this.sellFivePrice; }-*/;
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
		public final native float getCurdot() /*-{ return this.curdot; }-*/;
		public final native float getCurprice() /*-{ return this.curprice; }-*/;
		public final native float getRate() /*-{ return this.rate; }-*/;
		public final native int getDealnumber() /*-{ return this.rate; }-*/;
		public final native int getTurnover() /*-{ return this.turnover; }-*/;
	}
}

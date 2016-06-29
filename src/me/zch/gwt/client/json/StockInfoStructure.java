package me.zch.gwt.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class StockInfoStructure {

	public static class StockInfoData extends JavaScriptObject{
		protected StockInfoData(){}
		public final native int getErrNum() /*-{ return this.errNum; }-*/;
		public final native String getErrMsg() /*-{ return this.errMsg; }-*/;
		public final native RetData getRetData() /*-{ return this.RetData; }-*/;
	}
	
	public static class RetData extends JavaScriptObject{
		public final native StockInfo getStockinfo() /*-{ return this.stockinfo; }-*/;
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

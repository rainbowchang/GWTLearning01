package me.zch.gwt.client;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import me.zch.gwt.client.HttpRequest.MarketsInfo;
import me.zch.gwt.client.HttpRequest.RetData;
import me.zch.gwt.client.HttpRequest.StockInfo;

public class JsonLearningPanel {

	public JsonLearningPanel(){}
	
	TextArea ta;
	public Panel createJsonPanel(){
		
		FlowPanel flow1 = new FlowPanel();
		Label labelDescription = new Label();
		labelDescription.setText("JSON 的处理方式:");
		flow1.add(labelDescription);
		Button button01 = new Button();
		button01.setText("JavaScriptObject Test");
		flow1.add(button01);
		button01.addClickHandler(new btnClick());
		ta = new TextArea();
		ta.setWidth("300px");
		ta.setHeight("200px");
		flow1.add(ta);
		return flow1;
	}
	
	final String src = "{\"errNum\":0, \"errMsg\":\"success\", \"retData\":{\"stockinfo\":[{\"name\":\"kk\", \"code\":\"sz002234\"},{\"name\":\"mm\", \"code\":\"sz002230\"}]}}";
	
	class btnClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			StockInfoData sid = JsonUtils.safeEval(src);
			ta.setText(sid.getRetData().getStockinfo()[1].getName());
		}
		
	}
	
	public static class StockInfoData extends JavaScriptObject{
		protected StockInfoData(){}
		public final native String getErrNum() /*-{ return this.errNum; }-*/;
		public final native String getErrMsg() /*-{ return this.errMsg; }-*/;
		public final native RetData getRetData() /*-{ return this.retData; }-*/;
	}
	
	public static class RetData extends JavaScriptObject{
		protected RetData(){}
		public final native StockInfo[] getStockinfo() /*-{ return this.stockinfo; }-*/;
		//public final native MarketsInfo getMarket() /*-{ return this.market; }-*/;
	}
	
	public static class StockInfo extends JavaScriptObject{
		protected StockInfo(){}
		
		public final native String getName() /*-{ return this.name; }-*/;
		public final native String getCode() /*-{ return this.code; }-*/;
		
	}
}

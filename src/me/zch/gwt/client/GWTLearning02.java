package me.zch.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import me.zch.gwt.client.panels.LeftPanel;
import me.zch.gwt.client.panels.RightPanel;

public class GWTLearning02 implements EntryPoint {

	Label label01 = new Label();
	TextArea t = new TextArea();
	HTML labelDescription = new HTML();
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	LeftPanel lp = null;
	@Override
	public void onModuleLoad() {

		t.addStyleDependentName("readonly");
		SplitLayoutPanel slp = new SplitLayoutPanel();
		RootLayoutPanel.get().add(slp);
		lp = new LeftPanel();
		slp.addWest(lp.createPanel(), 200);
		lp.getVp().addClickHandler(new MyClickHandler());
		RightPanel rp = new RightPanel();
		slp.add(rp.createPenal());
		rp.getSp().add(labelDescription);

		greetingService.greetServer(0, "hello", new AsyncCallback<String>() { // 页面加载的时候调用说明文档

			@Override
			public void onFailure(Throwable caught) {
				labelDescription.setHTML(caught.getMessage());
				labelDescription.addStyleName("server-error");
			}

			@Override
			public void onSuccess(String result) {
				labelDescription.removeStyleName("server-error");
				labelDescription.setHTML(result);
			}
		});
	}
	
	class MyClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Window.alert("event: " + lp.getOutputString());
		}
		
	}
}

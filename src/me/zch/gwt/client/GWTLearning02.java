package me.zch.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

import me.zch.gwt.client.panels.LeftPanel;
import me.zch.gwt.client.panels.RightPanel;

public class GWTLearning02 implements EntryPoint {

	Label label01 = new Label();
	TextArea t = new TextArea();
	HTML htmlArea = new HTML();
	Panel rightPanel;
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
		rightPanel = rp.getSp();
		rightPanel.add(htmlArea);

		greetingService.greetServer(0, "hello", new AsyncCallback<String>() { // ҳ����ص�ʱ�����˵���ĵ�

			@Override
			public void onFailure(Throwable caught) {
				htmlArea.setHTML(caught.getMessage());
				htmlArea.addStyleName("server-error");
			}

			@Override
			public void onSuccess(String result) {
				htmlArea.removeStyleName("server-error");
				htmlArea.setHTML(result);
			}
		});
	}
	
	class MyClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			switch (lp.getOutputString()) {
			case "Description":
				rightPanel.clear();
				htmlArea = new HTML();
				rightPanel.add(htmlArea);
				greetingService.greetServer(0, "hello", new AsyncCallback<String>() { // ҳ����ص�ʱ�����˵���ĵ�

					@Override
					public void onFailure(Throwable caught) {
						htmlArea.setHTML(caught.getMessage());
						htmlArea.addStyleName("server-error");
					}

					@Override
					public void onSuccess(String result) {
						htmlArea.removeStyleName("server-error");
						htmlArea.setHTML(result);
					}
				});
				break;
			case "Xml":
				rightPanel.clear();
				FlowPanel flow = new FlowPanel();
				rightPanel.add(flow);
				Label label = new Label();
				label.setText("前台处理 xml");
				flow.add(label);
				Button buttonxml01 = new Button();
				buttonxml01.setText("前台处理");
				flow.add(buttonxml01);
				Label label02 = new Label();
				label02.setText("后台处理 xml");
				flow.add(label02);
				Button buttonxml02 = new Button();
				buttonxml02.setText("后台处理");
				flow.add(buttonxml02);
				break;
			case "Json":
				
			case "Label":
			default:
				rightPanel.clear();
			}
		}
	}
}

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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

import me.zch.gwt.client.panels.LeftPanel;
import me.zch.gwt.client.panels.RightPanel;

public class GWTLearning02 implements EntryPoint {

	Label label01 = new Label();
	TextArea t = new TextArea();
	HTML htmlArea = new HTML();
	Panel rightPanel;
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	private final DataStoreServiceAsync datastoreService = GWT.create(DataStoreService.class);
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

		greetingService.greetServer(0, "hello", new AsyncCallback<String>() {

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
				greetingService.greetServer(0, "hello", new AsyncCallback<String>() { 

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
				final HTML htmlarea = new HTML();
				flow.add(htmlarea);
				greetingService.greetServer(2, "hello", new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable caught) {
						htmlarea.setText(caught.getMessage());
					}

					@Override
					public void onSuccess(String result) {
						htmlarea.setText(result);
					}
				});
				buttonxml01.addClickHandler(new ClickHandler(){

					@Override
					public void onClick(ClickEvent event) {
						greetingService.greetServer(2, "hello", new AsyncCallback<String>() {
							@Override
							public void onFailure(Throwable caught) {
								htmlarea.setText(caught.getMessage());
							}

							@Override
							public void onSuccess(String result) {
								Document doc = XMLParser.parse(result);
								Element root = doc.getDocumentElement();
								NodeList nl = root.getElementsByTagName("book");
								String s = "";
								for(int i = 0; i<nl.getLength();i++){
									Element element = (Element)nl.item(i);
									s += element.getAttribute("name") + ":";
									NodeList nl02 = element.getChildNodes();
									String s0 = "";
									for(int j = 0; j < nl02.getLength(); j++){
										if(nl02.item(j).getNodeType() == Node.TEXT_NODE){
											s0 = nl02.item(j).getNodeValue();
										}
									}
									s += s0 + "; ";
								}
								htmlarea.setText(s);
							}
						});
					}
				});
				
				buttonxml02.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						datastoreService.dataStoreServer(1, "", new AsyncCallback<String>(){
							@Override
							public void onFailure(Throwable caught) {
								htmlarea.setText(caught.getMessage());
							}
							@Override
							public void onSuccess(String result) {
								htmlarea.setText(result);
							}
						});
					}
				});
				break;
			case "Json":
				rightPanel.clear();
				FlowPanel flow1 = new FlowPanel();
				rightPanel.add(flow1);
				Label labelDescription = new Label();
				labelDescription.setText("JSON 的处理方式:");
				flow1.add(labelDescription);
				Button button01 = new Button();
				button01.setText("JavaScriptObject Test");
				flow1.add(button01);
				//button01.addClickHandler();
				break;
			case "口算":
				rightPanel.clear();
				MentalArithmetic ma = new MentalArithmetic();
				rightPanel.add(ma.createPanel());
				break;
			case "数据库":
				rightPanel.clear();
				
				
				break;
			case "HTTP Request":
				rightPanel.clear();
				HttpRequest hr = new HttpRequest();
				rightPanel.add(hr.createPanel());
				
				break;
			default:
				rightPanel.clear();
			}
		}
	}
}

package me.zch.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;


public class XMLHTTPRequest {
/*
	private TextArea ta;
	
	public Panel createPanel() {
		FlowPanel vp = new FlowPanel();
		Button btn = new Button();
		btn.setText("Invoke js outside");
		btn.addClickHandler(new BtnClick());
		vp.add(btn);
	    ta = new TextArea();
		ta.setReadOnly(true);
		vp.add(ta);
		
		return vp;
	}
	
	class BtnClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			RequestBuilder request = new RequestBuilder(RequestBuilder.GET, GWT.getHostPageBaseURL() + "data.txt");
			request.setCallback(new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					// TODO Auto-generated method stub
					if(response.getStatusCode() == 200){
						Window.alert(response.getText());
					}
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub
					
				}
			});
			try{
				request.send();
			}catch(RequestException ex){
				
			}
		}
	}
	*/
	private final AddServiceAsync add = GWT.create(AddService.class);
	
	public Panel createPanel() {
		final TextBox data1 = new TextBox();
		final TextBox data2 = new TextBox();
		final Label result = new Label();
		Button queryButton = new Button("=");
		
		HorizontalPanel panel = new HorizontalPanel();
		panel.add(data1);
		panel.add(new Label("+"));
		panel.add(data2);
		panel.add(queryButton);
		panel.add(result);
		
		queryButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				add.add(Integer.valueOf(data1.getValue()), Integer.valueOf(data2.getValue()), 
						new AsyncCallback<Integer>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Integer value) {
								result.setText(value.toString());
							}
					
				});
			}
		});
		return panel;
	}
	
}

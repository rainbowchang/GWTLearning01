package me.zch.gwt.client.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyVerticalPanel extends VerticalPanel {
	public MyVerticalPanel(){
		super();
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler){
		return addDomHandler(handler, ClickEvent.getType());
	}
}

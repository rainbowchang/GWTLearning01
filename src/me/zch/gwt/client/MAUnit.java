package me.zch.gwt.client;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public class MAUnit {
	public MAUnit() {
	}

	public Panel createMAUnitPanel(int i) {
		HorizontalPanel lp = new HorizontalPanel();
		lp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		lp.setHeight("40px");
		Label lb = new Label();
		lb.setWidth("150px");
		
		lb.addStyleName("text-align-right");
		lb.addStyleName("font-for-topic");
		lb.getElement().setId("labelid" + i);
		lp.add(lb);
		
		TextBox tb = new TextBox();
		tb.setStyleName("font-for-topic");
		tb.setWidth("100px");
		tb.addStyleName("text-margin-left");
		
		tb.getElement().setAttribute("id", "input" + i);
		lp.add(tb);
		
		Image img = new Image("Image/question.png");
		lp.add(img);
		
		lp.addStyleName("green-background");
		lp.getElement().setId("mau" + i);
		lp.getElement().setPropertyObject("textbox", tb);
		lp.getElement().setPropertyObject("image", img);
		lp.getElement().setId("hp_" + i);

		return lp;
	}

}

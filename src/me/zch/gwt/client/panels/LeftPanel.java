package me.zch.gwt.client.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import me.zch.gwt.shared.Constants;

public class LeftPanel {

	private String outputString = "";
	public String getOutputString() {
		return outputString;
	}

	private MyVerticalPanel vp = new MyVerticalPanel();
	public MyVerticalPanel getVp() {
		return vp;
	}

	public LeftPanel() {
	}

	public Widget createPanel() {
		ScrollPanel sp = new ScrollPanel();
		sp.addStyleName("blue-backgroud");
		sp.addStyleName("fill-container");
		vp.addStyleName("fill-container");
		vp.addStyleName("item-vertical-margin");
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		for (String s : Constants.Items) {
			final Anchor anchor = new Anchor();
			FormPanel fp = new FormPanel();
			fp.setStyleName("item-vertical-margin");
			
			anchor.setText(s);
			anchor.addStyleName("yellow-backgroud");
			anchor.addStyleName("fill-container");
			fp.add(anchor);
			vp.add(fp);
			anchor.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					outputString = anchor.getText();
					event.preventDefault();
				}
				
			});
		}
		sp.add(vp);
		return sp;
	}
}

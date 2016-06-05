package me.zch.gwt.client.panels;

import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class RightPanel {

	public RightPanel() {
	}

	public Widget createPenal() {
		FormPanel fp = new FormPanel();
		fp.addStyleName("fill-container");
		fp.addStyleName("item-vertical-margin");
		fp.addStyleName("yellow-backgroud");
		sp = new ScrollPanel();
		sp.addStyleName("fill-container");
		sp.addStyleName("item-vertical-margin");
		sp.addStyleName("yellow-backgroud");
		fp.add(sp);
		return fp;
	}

	private ScrollPanel sp;

	public ScrollPanel getSp() {
		return sp;
	}
}

package me.zch.gwt.client.panels;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import me.zch.gwt.shared.ToolsTimer;

public class RightPanel {

	public RightPanel() {
	}

	public Widget createPenal() {
		FlowPanel fp = new FlowPanel();
		fp.addStyleName("fill-container");
		fp.addStyleName("item-vertical-margin");
		fp.addStyleName("yellow-backgroud");

		final Label timeLabel = new Label();
		timeLabel.setStyleName("float-right");timeLabel.setWidth("250px");
		timeLabel.setText(ToolsTimer.getCurrentTime());
		Timer elapsedTimer = new Timer() {
			public void run() {
				timeLabel.setText(ToolsTimer.getCurrentTime());
			}
		};
		elapsedTimer.scheduleRepeating(500);
		topPanel.add(timeLabel);
		topPanel.setHeight("40px");
		fp.add(topPanel);

		//----------
		sp = new ScrollPanel();
		sp.addStyleName("fill-container");
		sp.addStyleName("item-vertical-margin");
		sp.addStyleName("yellow-backgroud");
		fp.add(sp);

		return fp;
	}

	private LayoutPanel topPanel = new LayoutPanel();
	private ScrollPanel sp;

	public ScrollPanel getSp() {
		return sp;
	}
}

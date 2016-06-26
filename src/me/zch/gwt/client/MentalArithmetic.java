package me.zch.gwt.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import me.zch.gwt.shared.ToolsTimer;

public class MentalArithmetic {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public MentalArithmetic() {
	}

	public Panel createPanel() {

		FlowPanel vp = new FlowPanel();
		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.setSpacing(20);
		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setSpacing(20);
		FlowPanel vp01 = new FlowPanel();
		vp01.setStyleName("MAU-padding");
		FlowPanel vp02 = new FlowPanel();
		vp02.setStyleName("MAU-padding");
		vp.setHeight("240px");
		MAUnit mu = new MAUnit();
		for (int i = 0; i < 10; i++) {
			Panel p = mu.createMAUnitPanel(i);
			vp01.add(p);
		}
		hp1.add(vp01);
		for (int i = 10; i < 20; i++) {
			Panel p = mu.createMAUnitPanel(i);
			vp02.add(p);
		}
		hp1.add(vp02);
		final Label labelTimer = new Label("计时:     秒");
		labelTimer.addStyleName("font-for-topic");
		final Button btn_start = new Button();
		btn_start.getElement().setAttribute("style", "font-size: large");
		final Button btn_stop = new Button();
		btn_stop.getElement().setAttribute("style", "font-size: large");
		final Label labelScore = new Label("得分:");
		labelScore.addStyleName("font-for-topic");
		final Date startTime = new Date();
		final Timer elapsedTimer = new Timer() {
			public void run() {
				Date dt = new Date();
				long l = dt.getTime() - startTime.getTime();
				long k = l / 1000;
				labelTimer.setText("用时:" + Long.toString(k) + "秒");
			}
		};
		btn_start.setText("开始");
		btn_start.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				startTime.setTime(new Date().getTime());

				for (int i = 0; i < 20; i++) {

					final int J = i;
					greetingService.greetServer(3, " ", new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {

						}

						@Override
						public void onSuccess(String result) {
							ArithmaticJson aj = JsonUtils.safeEval(result);
							DOM.getElementById("labelid" + J).setInnerHTML(aj.getTopic());
							DOM.getElementById("input" + J).setAttribute("result", aj.getAnswer());
							TextBox tb = (TextBox) DOM.getElementById("hp_" + J).getPropertyObject("textbox");
							tb.setText("");
							Image img = (Image) DOM.getElementById("hp_" + J).getPropertyObject("image");
							img.setUrl("Image/question.png");
						}
					});
				}

				elapsedTimer.scheduleRepeating(500);
				btn_stop.setEnabled(true);
				btn_start.setEnabled(false);
			}

		});
		btn_stop.setText("结束");
		btn_stop.setEnabled(false);
		btn_stop.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				elapsedTimer.cancel();

				int score = 0;
				for (int i = 0; i < 20; i++) {
					final int J = i;
					TextBox tb = (TextBox) DOM.getElementById("hp_" + J).getPropertyObject("textbox");
					Image img = (Image) DOM.getElementById("hp_" + J).getPropertyObject("image");

					try {
						if (tb.getElement().getAttribute("result").equals(tb.getValue())) {
							img.setUrl("Image/check.png");
							score += 5;
						} else {
							img.setUrl("Image/cross.png");
						}
					} catch (Exception ex) {
						img.setUrl("Image/cross.png");
					}
				}
				labelScore.setText(Integer.toString(score));
				btn_stop.setEnabled(false);
				btn_start.setEnabled(true);
			}

		});
		hp2.add(labelTimer);
		hp2.add(btn_start);
		hp2.add(btn_stop);
		hp2.add(labelScore);

		vp.add(hp1);
		vp.add(hp2);
		return vp;
	}

	static class ArithmaticJson extends JavaScriptObject {
		protected ArithmaticJson() {
		};

		public final native String getTopic() /*-{
			return this.topic;
		}-*/;

		public final native String getAnswer() /*-{
			return this.answer;
		}-*/;
	}
}

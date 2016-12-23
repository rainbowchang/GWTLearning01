package me.zch.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;


public class OutJs {

	public OutJs(){}
	
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
			int hash = Math.add(2, 3);
			ta.setText(Integer.toString(hash));
		}
	}
	
	
	public static class Math {
		public native static int add(int a, int b) /*-{
			return $wnd.Add(a, b);
		}-*/;
	}
}

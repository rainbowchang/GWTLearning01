package me.zch.gwt.client;

import me.zch.gwt.shared.FieldVerifier;

import java.util.Calendar;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import com.google.gwt.i18n.client.DateTimeFormat;
/**
 * Entry point classes define <code>onModuleLoad()</code>.//add 201605232116
 */
public class GWTLearning01 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	MyFactory factory = GWT.create(MyFactory.class);
	final Button button01 = new Button();
	final Label jsonLabel = new Label();
	final HTML labelDescription = new HTML();
	//-------------------------
	final Button button02 = new Button();
	private Timer elapsedTimer;
	private Label elapsedLabel = new Label();
	private long startTime;
	//-------------------------
	Tree tree = new Tree();
	Label treeLabel = new Label();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get("container01").add(labelDescription);
		
		button01.setText("JavaScriptObject Test");
		button01.addStyleName("sendButton");
		RootPanel.get("container02").add(jsonLabel);
		RootPanel.get("container02").add(button01);
		button01.addClickHandler(new JavaScriptObjectHandler());
		
		button02.setText("AutoBean Test");
		button02.addStyleName("sendButton");
		RootPanel.get("container02").add(button02);
		button02.addClickHandler(new AutoBeanHandler());
        final TInterface test = makeTest();
        test.setName("achu");
        jsonLabel.setText(deserializeFromJson(serializeToJson(test)).getName());
        
        greetingService.greetServer(0, "hello", new AsyncCallback<String>() { //页面加载的时候调用说明文档

			@Override
			public void onFailure(Throwable caught) {
				labelDescription.setHTML(caught.getMessage());
				labelDescription.addStyleName("server-error");
			}

			@Override
			public void onSuccess(String result) {
				labelDescription.removeStyleName("server-error");
				labelDescription.setHTML(result);
			}
        });
        
        RootPanel.get("container02").add(elapsedLabel);
		// ... Add elapsedLabel to a Panel ...
		// Create a new timer
		elapsedTimer = new Timer() {
			public void run() {
				showElapsed();
			}
		};
		startTime = System.currentTimeMillis();
		// Schedule the timer for every 1/2 second (500 milliseconds)
		elapsedTimer.scheduleRepeating(500);
		// ... The elapsed timer has started ...
        
        //---------------------------------
        RootPanel.get("container03").add(treeLabel);
        TreeItem root = new TreeItem(); 
        root.setText("Root");
        root.addTextItem("item0"); 
        TreeItem item = new TreeItem(new CheckBox("item3")); 
        root.addItem(item);
        tree.addItem(root);
        RootPanel.get("container03").add(tree);
        tree.addSelectionHandler(new TreeSelectHendler());
        //----------------------------------
        
        Widget child0 = new HTML("child0"), child1 = new HTML("child1"), child2 = new HTML("child2");
        LayoutPanel p = new LayoutPanel();
        p.add(child0); p.add(child1); p.add(child2);
        p.setWidgetLeftWidth(child0, 0, Unit.PCT, 50, Unit.PCT);  // Left panel
        p.setWidgetRightWidth(child1, 0, Unit.PCT, 50, Unit.PCT); // Right panel
        p.setWidgetLeftRight(child2, 5, Unit.EM, 5, Unit.EM);     // Center panel
        p.setWidgetTopBottom(child2, 5, Unit.EM, 5, Unit.EM);
        child0.setStyleName("left");
        child1.setStyleName("right");
        //RootLayoutPanel.get().add(p);
        RootPanel.get("container04").add(p);
        
        //

        
	}

	class JavaScriptObjectHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			sendNameToServer();
		}

		private void sendNameToServer() {
			greetingService.greetServer(1, "hello", new AsyncCallback<String>() {
				@Override
				public void onFailure(Throwable caught) {
					jsonLabel.setText(caught.getMessage());
				}

				@Override
				public void onSuccess(String result) {
					Customer c = JsonUtils.safeEval(result);
					jsonLabel.setText(Integer.toString(c.getList()[2].getSammer()));
				}
			});
		}
	}
	
	class AutoBeanHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			TInterface dto = makeTest();
			dto.setName("miu miu");
			String s = serializeToJson(dto);
			TInterface dto2 = deserializeFromJson(s);
			String s2 = dto2.getName();
			jsonLabel.setText(s2);
		}
	}

	public interface TInterface {
		public String getName();
		public void setName(String name);
	}
	
	public interface MyFactory extends AutoBeanFactory {
		AutoBean<TInterface> test();
	}
	
	
	TInterface makeTest() {
        // Construct the AutoBean
        AutoBean<TInterface> test = factory.test();
        // Return the Person interface shim
        return test.as();
    }
	
	TInterface deserializeFromJson(String json) {
        AutoBean<TInterface> bean = AutoBeanCodex.decode(factory, TInterface.class, json);
        return bean.as();
    }

    String serializeToJson(TInterface test) {
        // Retrieve the AutoBean controller
        AutoBean<TInterface> bean = AutoBeanUtils.getAutoBean(test);
        return AutoBeanCodex.encode(bean).getPayload();
    }
    
	private void showElapsed() {
		//double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
		//NumberFormat n = NumberFormat.getFormat("#,##0.000");
		Date date = new Date();
		DateTimeFormat format = DateTimeFormat.getFormat("yyyy-MM-dd hh:mi:ss zzz dow mon");
		format.format(date);
		elapsedLabel.setText(format.format(date));
	}

	static class Customer extends JavaScriptObject {
		// Overlay types always have protected, zero-arg ctors
		protected Customer() { }
		public final native String getFirstName() /*-{ return this.FirstName; }-*/;
		public final native String getLastName() /*-{ return this.LastName; }-*/;
		public final native MDetail[] getList() /*-{ return this.List; }-*/;
		public final String getFullName() {
			return getFirstName() + " " + getLastName();
		}
	}
	
	static class MDetail extends JavaScriptObject {
		protected MDetail(){ }
		public final native String getName()/*-{ return this.Name; }-*/;
		public final native int getSammer()/*-{ return this.Sammer; }-*/;
	}
	
	class TreeSelectHendler implements SelectionHandler<TreeItem> {

		@Override
		public void onSelection(SelectionEvent<TreeItem> event) {
			treeLabel.setText(event.getSelectedItem().getText());
			if (event.getSelectedItem().getWidget() instanceof CheckBox) {

				final SelectionEvent<TreeItem> event0 = event;
				Timer timer = new Timer() {
					public void run() {
						CheckBox cb = (CheckBox) event0.getSelectedItem().getWidget();
						if (cb.getValue()) {
							treeLabel.setText(event0.getSelectedItem().getText() + " checked");
						} else {
							treeLabel.setText(event0.getSelectedItem().getText() + " unchecked");
						}
					}
				}; // Execute the timer to expire 2 seconds in the future
				timer.schedule(50);
			}
		}
	}
}

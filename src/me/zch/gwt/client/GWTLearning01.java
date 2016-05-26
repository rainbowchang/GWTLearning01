package me.zch.gwt.client;

import me.zch.gwt.shared.FieldVerifier;
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
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

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
	final Label timeLabel = new Label();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		button01.setText("Get Time");
		button01.addStyleName("sendButton");
		//timeLabel.setText("Press to get current time...");
		RootPanel.get("container01").add(timeLabel);
		RootPanel.get("container01").add(button01);
		button01.addClickHandler(new MyHandler());
        final TInterface test = makeTest();
        test.setName("achu");
        timeLabel.setText(deserializeFromJson(serializeToJson(test)).getName());
        
	}

	
	class MyHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			sendNameToServer();
		}

		private void sendNameToServer() {
			
			//AutoBean<Customer> bean = AutoBeanFactory.create(Customer.class, null);

			greetingService.greetServer("hello", new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					timeLabel.setText(caught.getMessage());
				}

				@Override
				public void onSuccess(String result) {
					Customer c = JsonUtils.safeEval(result);
					timeLabel.setText(Integer.toString(c.getList()[2].getSammer()));
					//timeLabel.setText(c.getFullName());
				}

			});
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
}

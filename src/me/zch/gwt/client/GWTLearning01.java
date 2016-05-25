package me.zch.gwt.client;

import me.zch.gwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
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

	final Button button01 = new Button();
	final Label timeLabel = new Label();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		button01.setText("Get Time");
		button01.addStyleName("sendButton");
		timeLabel.setText("Press to get current time...");
		RootPanel.get("container01").add(timeLabel);
		RootPanel.get("container01").add(button01);
		button01.addClickHandler(new MyHandler());
	}
	
	class MyHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			sendNameToServer();
		}
		
		private void sendNameToServer() {
			
			greetingService.greetServer("hello", new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					timeLabel.setText(caught.getMessage());
				}

				@Override
				public void onSuccess(String result) {
					
					timeLabel.setText(result);
				}
				
			});
		}
	}

	class Customer extends JavaScriptObject {

		  // Overlay types always have protected, zero-arg ctors
		  protected Customer() { }

		  // Typically, methods on overlay types are JSNI
		  public final native String getFirstName() ;
		  public final native String getLastName()  ;

		  // Note, though, that methods aren't required to be JSNI
		  public final String getFullName() {
		    return getFirstName() + " " + getLastName();
		  }
		}
}

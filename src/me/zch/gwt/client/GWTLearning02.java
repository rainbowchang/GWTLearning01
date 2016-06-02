package me.zch.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class GWTLearning02 implements EntryPoint{

	private final DataStoreServiceAsync dataStoreService = GWT.create(DataStoreService.class);
	
	Tree tree = new Tree();
	Label label01 = new Label();
	@Override
	public void onModuleLoad() {

		SplitLayoutPanel  p = new SplitLayoutPanel();
		RootLayoutPanel.get().add(p);
        TreeItem root = new TreeItem(); 
        root.setText("Root");
        root.addTextItem("item0"); 
        TreeItem item = new TreeItem(); 
        item.setText("item2");
        root.addItem(item);
        tree.addItem(root);
        p.addWest(tree, 200);
        tree.addStyleName("blue-backgroud");
        
        FlowPanel fp = new FlowPanel();
        p.add(fp);
        fp.addStyleName("yellow-backgroud");

        label01.setText("press to do something with google datastore...");
        fp.add(label01);
        
        Button button01 = new Button();
        button01.setText("Run DataStore...");
        button01.addClickHandler(new DataStoreButtonHandler());
        fp.add(button01);

	}
	
	class DataStoreButtonHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			dataStoreService.dataStoreServer(1, "", new AsyncCallback<String>(){

				@Override
				public void onFailure(Throwable caught) {
					label01.setText(caught.getMessage());
				}

				@Override
				public void onSuccess(String result) {
					label01.setText(result);
				}
				
			});
		}
		
	}

}

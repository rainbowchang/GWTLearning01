package me.zch.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class GWTLearning02 implements EntryPoint{

	Tree tree = new Tree();
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
        
        FormPanel fp = new FormPanel();
        p.add(fp);
        fp.addStyleName("yellow-backgroud");

        
	}

}

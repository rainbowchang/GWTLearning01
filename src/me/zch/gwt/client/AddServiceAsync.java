package me.zch.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddServiceAsync {
	void add(int a, int b, AsyncCallback<Integer> callback);
}

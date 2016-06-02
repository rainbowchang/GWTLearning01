package me.zch.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataStoreServiceAsync {
	void dataStoreServer(int commandId, String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}

package me.zch.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dataStore")
public interface DataStoreService extends RemoteService{
	String dataStoreServer(int commandId, String input) throws IllegalArgumentException;
}

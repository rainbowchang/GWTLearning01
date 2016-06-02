package me.zch.gwt.server;

import java.util.Arrays;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import me.zch.gwt.client.DataStoreService;


@SuppressWarnings("serial")
public class DataStoreServiceImpl extends RemoteServiceServlet implements DataStoreService {

	@Override
	public String dataStoreServer(int commandId, String input) throws IllegalArgumentException {

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		Key key = KeyFactory.createKey("Person", 1);
		
//		Entity e = new Entity(key);
//		e.setProperty("Person_id", 1);
//		e.setProperty("Firstname", "Tom");
//		e.setProperty("Lastname", "Kissinger");
//		e.setProperty("age", 44);
//		key = ds.put(e);
//		
//		Entity user = new Entity("User", key);
//		user.setProperty("email", "Tom@mail.com");
//		user.setProperty("address", "117, lunie avenue.");	
//		ds.put(user);
		
		String s = "";
//		try {
//			Entity e = ds.get(key);
//			s = (String)e.getProperty("Firstname");
//		} catch (EntityNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//Query q
		return s;
	}
}

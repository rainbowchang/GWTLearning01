package me.zch.gwt.server;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import me.zch.gwt.client.DataStoreService;

@SuppressWarnings("serial")
public class DataStoreServiceImpl extends RemoteServiceServlet implements DataStoreService {

	@Override
	public String dataStoreServer(int commandId, String input) throws IllegalArgumentException {
		String s = "";
		switch (commandId) {

		case 0:

			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

			Key key = KeyFactory.createKey("Person", 1);

			// Entity e = new Entity(key);
			// e.setProperty("Person_id", 1);
			// e.setProperty("Firstname", "Jerry");
			// e.setProperty("Lastname", "Moa");
			// e.setProperty("age", 2);
			// key = ds.put(e);
			//
			// Entity user = new Entity("User", key);
			// user.setProperty("email", "Jerry@mail.com");
			// user.setProperty("address", "117, lunie avenue.");
			// ds.put(user);

			// try {
			// Entity e1 = ds.get(key);
			// s = (String)e1.getProperty("Firstname");
			// } catch (EntityNotFoundException ex) {
			// ex.printStackTrace();
			// }

			// Query q = new Query("Person");
			// Filter filter = new FilterPredicate("Firstname",
			// FilterOperator.EQUAL, "Jerry");
			// q.setFilter(filter);
			// PreparedQuery pq = ds.prepare(q);
			// for(Entity el : pq.asIterable()){
			// s += el.getProperty("Firstname") + "." +
			// el.getProperty("Lastname") + " ";
			// }

			// try {
			// s = Tools.loadTextFile("Books.xml");
			// } catch (IOException e) {
			// throw new IllegalArgumentException(e.getMessage());
			// }
			break;
		case 1: //后台处理xml
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse("Books.xml");
				NodeList nl = doc.getElementsByTagName("book");
				for (int i = 0; i < nl.getLength(); i++) {
					s += nl.item(i).getAttributes().getNamedItem("name").getNodeValue() + ":";
					s += nl.item(i).getTextContent() + ";";
				}
			} catch (ParserConfigurationException | SAXException | IOException ex) {
				throw new IllegalArgumentException(ex.getMessage());
			} finally {

			}
			break;
		}
		return s;

	}
}

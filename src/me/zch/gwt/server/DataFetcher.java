package me.zch.gwt.server;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import me.zch.gwt.server.DataStore.StockInfoDto;

public class DataFetcher {

	public DataFetcher(){}
	
	public void fetchData(){
		
	}
	
	public static StockInfoDto getDataFromInternet(String code){
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		
		return null;
	}
}

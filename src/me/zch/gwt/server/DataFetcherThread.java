package me.zch.gwt.server;

public class DataFetcherThread {

	static{

		threadProcess();
	}
	
	public static void threadProcess(){
		DataFetcher df = new DataFetcher();
		while(true){
			df.fetchData();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

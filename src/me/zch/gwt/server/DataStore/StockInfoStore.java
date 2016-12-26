package me.zch.gwt.server.DataStore;

import java.util.Map;

import me.zch.gwt.server.DataFetcher;
import me.zch.gwt.server.Tool.RecentMap;

public class StockInfoStore {
	private Map<String, StockInfoDto> map = new RecentMap<String, StockInfoDto>(10);

	private void createDto(String code) {
		map.put(code, DataFetcher.getDataFromInternet(code));
	}

	public StockInfoDto getStockInfoDto(String code) {
		if (!map.containsKey(code)) {
			createDto(code);
		}
		return map.get(code);
	}
}

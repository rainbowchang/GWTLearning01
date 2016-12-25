package me.zch.gwt.server.DataStore;

import java.util.HashMap;
import java.util.Map;

import me.zch.gwt.server.DataFetcher;

public class StockInfoStore {
	private Map<String, StockInfoDto> map = new HashMap<String, StockInfoDto>();

	private void createDto(String code) {
		// StockInfoDto sid = new StockInfoDto();
		map.put(code, DataFetcher.getDataFromInternet(code));
	}

	public StockInfoDto getStockInfoDto(String code) {
		if (!map.containsKey(code)) {
			createDto(code);
		}
		return map.get(code);
	}
}

package me.zch.gwt.shared;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class ToolsTimer {
	public static String getCurrentTime() {
		Date date = new Date();
		DateTimeFormat format = DateTimeFormat.getFormat("yyyy-MM-dd hh:mi:ss zzz dow mon");
		return format.format(date);
	}

}

package com.stockie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static String MYSQL_DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

	private static String UI_DATEFORMAT = "dd-MMM-yyyy HH:mm:ss";

	public static String getCurrentDate() {
		Date dt = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(MYSQL_DATEFORMAT);

		String currentTime = sdf.format(dt);

		return currentTime;
	}

	public static String getFormattedDate(String date) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(MYSQL_DATEFORMAT);

		SimpleDateFormat formatter = new SimpleDateFormat(UI_DATEFORMAT);
		Date dateStr = sdf.parse(date);
		return formatter.format(dateStr);
	}
}

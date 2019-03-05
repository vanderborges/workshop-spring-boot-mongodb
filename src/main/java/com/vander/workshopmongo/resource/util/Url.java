package com.vander.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Url {
	
	public static String urlDeconding(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate (String date, Date defaultDate) {
		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
		stf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return stf.parse(date);
		} catch (ParseException e) {
			return defaultDate;
		}
		
	}

}

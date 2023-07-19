package com.marvinsilva.workshop.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;



public class URL {
	
	public static String decodeParm (String text) { 
		try {
			return URLDecoder.decode(text, "UFT-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static Date convertDate(String textDate, Date dafaultValue){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));	//HORARIO Greenwich
		try{
			return sdf.parse(textDate);
		}catch(ParseException e){
			return dafaultValue;
		}
	}

}

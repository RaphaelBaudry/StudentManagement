package com.management.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils extends MainUtils {
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
	public static String daysBetween(String day1, String day2) {
		  String daysBetween = "";
		  SimpleDateFormat myFormat = new SimpleDateFormat(DATE_FORMAT);

		  try {
			  Date date1 = myFormat.parse(day1);
			  Date date2 = myFormat.parse(day2);
			  long diff = date2.getTime() - date1.getTime();
			  daysBetween += TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }
		  
		  return daysBetween;
	}
	
	public static long daysBetween(Calendar startDate, Calendar endDate) {  
		Calendar date = (Calendar) startDate.clone();  
		long daysBetween = 0;  
		
		while (date.before(endDate)) {  
			date.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}  
		
		return daysBetween;  
	}  
}

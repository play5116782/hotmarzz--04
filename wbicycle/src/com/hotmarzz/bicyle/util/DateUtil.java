package com.hotmarzz.bicyle.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	//初始化时间 得到yyyyMMdd
	public static final String SIMPLE_STRING = "yyyyMMdd";
	public static String getDateString1(){
		Date date= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_STRING);
		return sdf.format(date);
	}

	
	public static final String S_STRING = "yyyy/MM/dd/HH:mm:ss";
	public static String getDateString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(S_STRING);
		return sdf.format(date);
	}

	
	
}

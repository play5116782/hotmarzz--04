package com.hotmarzz.bicycle.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	//��ʼ��ʱ�� �õ�yyyyMMdd
	public static final String SIMPLE_STRING1 = "yyyyMMdd";
	
	public static String getDateString1(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.SIMPLE_STRING1);
		return sdf.format(date);
	}
}

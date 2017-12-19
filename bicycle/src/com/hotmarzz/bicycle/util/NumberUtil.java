package com.hotmarzz.bicycle.util;

import java.text.NumberFormat;

import com.hotmarzz.bicycle.main.DataInit;

public class NumberUtil {
	
	//自动生成单车编号
	public static String getBicycleNo(){
		//获取8位时间
		String dateString = DateUtil.getDateString1();
		//4==>0004
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(4);
		nf.setMinimumIntegerDigits(4);
		//通过NumberFormat类 转化的数字格式 最终是一个字符串
		nf.setGroupingUsed(false);
		String s = nf.format(DataInit.BICYCLENO++);
		return dateString+DataInit.CITY+s;
	}
	
	//自动生成单车坐标  整数最大位数2位  小数最大位数3位  用Math.random
	public static double getCoor(){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(2);
		nf.setMaximumFractionDigits(3);
		nf.setGroupingUsed(false);
		return Double.parseDouble(nf.format(Math.random()*100));
	}
}

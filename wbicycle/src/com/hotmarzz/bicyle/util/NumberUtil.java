package com.hotmarzz.bicyle.util;

import java.nio.charset.MalformedInputException;
import java.text.NumberFormat;

import com.hotmarzz.bicycle.main.DataInit;

public class NumberUtil {
	
	//自动生成单车编号
	public static String getBicyleNo(){
		//获取8位时间
		String dateString =DateUtil.getDateString1();
		//4==>0004
		//NumberFormat是被protected 修饰ide无法构造对象就调用  方法。
		NumberFormat nf = NumberFormat.getInstance();
		//整数格式最大位数是4位
		nf.setMaximumIntegerDigits(4);
		//整数格式最小位数是4位
		nf.setMinimumIntegerDigits(4);
	
		//通过NumberFormat类 转化的数字格式 最终是一个字符串
		nf.setGroupingUsed(false);//分组开关
		String s = nf.format(DataInit.BICYLENO++);
		return dateString +DataInit.CITY+s;
		
		
	}
	public static void main(String[] args) {
		String dateString =DateUtil.getDateString1();
		System.out.println(dateString);
	}
	
	
	//自动生成单车坐标  整数最大位数：两位； 小数最大位数：三位  用Math.random
	
	public static double getCoor(){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(2);
		//小数最大位数
		nf.setMaximumFractionDigits(3);
		nf.setGroupingUsed(false);
		return Double.parseDouble(nf.format(Math.random()*100));
	}
	
	
	public static double getCoor2(){
		
	
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setMaximumIntegerDigits(2);
		//小数最大位数
		nf2.setMaximumFractionDigits(3);
		nf2.setGroupingUsed(false);
		return Double.parseDouble(nf2.format(Math.random()*100));
	
	
	
	}
}

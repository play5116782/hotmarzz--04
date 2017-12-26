package com.hotmarzz.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
	public static void main(String[] args) {
		// 单行注释
		/*
		 * 多行注释 1.快捷键使用 alt+/ main syso 2.方法的调用 .
		 */
		// String数据类型 a变量名称(自定义 不能以数字开头 不能是汉字 不能重复)
		String a = "HelloWorld";
		// String a = "张三";
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println("HelloWorld的长度为:" + "HelloWorld!!!".length());
		// 此时的+号 不是加法运算 代表的是字符串连接符
		System.out.println("字符串a的长度为:" + a.length());
		System.out.println("圆周率:" + Math.PI);
		System.out.println("绝对值:" + Math.abs(-100));
		System.out.println("幂次方:" + Math.pow(4, 8));
		// 创建一个时间对象
		/*
		 * 导包问题 java.lang包下的类 是不足要导包 直接拿来用 除了java.lang 其他的包下类 要使用 则必须要导包
		 * 33:通过new关键字调用构造方法创建了一个Date类的对象叫date
		 * 
		 * 快速导包 ctrl+shift+o 同时导入多个类 
		 * 格式化  ctrl+shift+f 
		 */
		Date date = new Date();
		System.out.println("当前时间:" + date);

		SimpleDateFormat sf = new SimpleDateFormat("yy年MM月dd日WW周ZZ时区 hh:mm:ss:SSS");
		String newdate = sf.format(date);
		System.out.println(newdate);
	}
}

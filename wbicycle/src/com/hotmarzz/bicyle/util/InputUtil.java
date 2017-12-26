package com.hotmarzz.bicyle.util;

import java.util.Scanner;

/**
	 * 键盘输入
	 * @author Administrator
	 *
	 */
public class InputUtil {
	//获取键盘输入的字符串
	public static String getString(){
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	//获取键盘输入的数字
	public static int getInt(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static long getLong(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLong();
	}
	
	public static double getDouble(){
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	
}

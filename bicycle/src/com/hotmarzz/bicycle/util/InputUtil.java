package com.hotmarzz.bicycle.util;

import java.util.Scanner;

/**
 * ��������
 * @author Administrator
 *
 */
public class InputUtil {
	//��ȡ����������ַ���
	public static String getString(){
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	//��ȡ���������int
	public static int getInt(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//��ȡ���������double
	public static double getDouble(){
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	//��ȡ���������long
	public static long getLong(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLong();
	}	
}

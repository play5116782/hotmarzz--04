package com.hotmarzz.bicyle.util;

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
	
	//��ȡ�������������
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

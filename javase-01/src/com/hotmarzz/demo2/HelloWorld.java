package com.hotmarzz.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
	public static void main(String[] args) {
		// ����ע��
		/*
		 * ����ע�� 1.��ݼ�ʹ�� alt+/ main syso 2.�����ĵ��� .
		 */
		// String�������� a��������(�Զ��� ���������ֿ�ͷ �����Ǻ��� �����ظ�)
		String a = "HelloWorld";
		// String a = "����";
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println("HelloWorld�ĳ���Ϊ:" + "HelloWorld!!!".length());
		// ��ʱ��+�� ���Ǽӷ����� ��������ַ������ӷ�
		System.out.println("�ַ���a�ĳ���Ϊ:" + a.length());
		System.out.println("Բ����:" + Math.PI);
		System.out.println("����ֵ:" + Math.abs(-100));
		System.out.println("�ݴη�:" + Math.pow(4, 8));
		// ����һ��ʱ�����
		/*
		 * �������� java.lang���µ��� �ǲ���Ҫ���� ֱ�������� ����java.lang �����İ����� Ҫʹ�� �����Ҫ����
		 * 33:ͨ��new�ؼ��ֵ��ù��췽��������һ��Date��Ķ����date
		 * 
		 * ���ٵ��� ctrl+shift+o ͬʱ�������� 
		 * ��ʽ��  ctrl+shift+f 
		 */
		Date date = new Date();
		System.out.println("��ǰʱ��:" + date);

		SimpleDateFormat sf = new SimpleDateFormat("yy��MM��dd��WW��ZZʱ�� hh:mm:ss:SSS");
		String newdate = sf.format(date);
		System.out.println(newdate);
	}
}

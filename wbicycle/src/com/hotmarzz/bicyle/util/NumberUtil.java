package com.hotmarzz.bicyle.util;

import java.nio.charset.MalformedInputException;
import java.text.NumberFormat;

import com.hotmarzz.bicycle.main.DataInit;

public class NumberUtil {
	
	//�Զ����ɵ������
	public static String getBicyleNo(){
		//��ȡ8λʱ��
		String dateString =DateUtil.getDateString1();
		//4==>0004
		//NumberFormat�Ǳ�protected ����ide�޷��������͵���  ������
		NumberFormat nf = NumberFormat.getInstance();
		//������ʽ���λ����4λ
		nf.setMaximumIntegerDigits(4);
		//������ʽ��Сλ����4λ
		nf.setMinimumIntegerDigits(4);
	
		//ͨ��NumberFormat�� ת�������ָ�ʽ ������һ���ַ���
		nf.setGroupingUsed(false);//���鿪��
		String s = nf.format(DataInit.BICYLENO++);
		return dateString +DataInit.CITY+s;
		
		
	}
	public static void main(String[] args) {
		String dateString =DateUtil.getDateString1();
		System.out.println(dateString);
	}
	
	
	//�Զ����ɵ�������  �������λ������λ�� С�����λ������λ  ��Math.random
	
	public static double getCoor(){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(2);
		//С�����λ��
		nf.setMaximumFractionDigits(3);
		nf.setGroupingUsed(false);
		return Double.parseDouble(nf.format(Math.random()*100));
	}
	
	
	public static double getCoor2(){
		
	
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setMaximumIntegerDigits(2);
		//С�����λ��
		nf2.setMaximumFractionDigits(3);
		nf2.setGroupingUsed(false);
		return Double.parseDouble(nf2.format(Math.random()*100));
	
	
	
	}
}

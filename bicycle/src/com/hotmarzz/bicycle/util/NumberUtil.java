package com.hotmarzz.bicycle.util;

import java.text.NumberFormat;

import com.hotmarzz.bicycle.main.DataInit;

public class NumberUtil {
	
	//�Զ����ɵ������
	public static String getBicycleNo(){
		//��ȡ8λʱ��
		String dateString = DateUtil.getDateString1();
		//4==>0004
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(4);
		nf.setMinimumIntegerDigits(4);
		//ͨ��NumberFormat�� ת�������ָ�ʽ ������һ���ַ���
		nf.setGroupingUsed(false);
		String s = nf.format(DataInit.BICYCLENO++);
		return dateString+DataInit.CITY+s;
	}
	
	//�Զ����ɵ�������  �������λ��2λ  С�����λ��3λ  ��Math.random
	public static double getCoor(){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(2);
		nf.setMaximumFractionDigits(3);
		nf.setGroupingUsed(false);
		return Double.parseDouble(nf.format(Math.random()*100));
	}
}

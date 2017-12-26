package com.hotmarzz.bicycle.util;

public class RegexUtil {
	
	//�ֻ���
	public static final String PHONE_REGEX = "^[1][3|4|5|7|8]\\d{9}$";
	public static final String PHONE_DISPLAY = "Ҫ�󳤶�Ϊ11λ";
	//����
	public static final String NAME_REGEX = "^[\u4e00-\u9fa5]{2,4}$";
	public static final String NAME_DISPLAY = "Ҫ�������λ����";
	//�Ա�
	public static final String SEX_REGEX = "^[��|Ů]$";
	public static final String SEX_DISPLAY = "Ҫ�������л�Ů";
	//����
	public static final String AGE_REGEX = "^[1][6-9]|[2][0-9]|[3][0-2]$";
	public static final String AGE_DISPLAY = "Ҫ������16��32";
	
	public static String getStringRegex(String Regex,String display){
		while(true){
			//��ȡ����̨����������ַ���
			String s = InputUtil.getString();
			if(s.matches(Regex)){
				return s;
			}else{
				System.out.println("��������:["+display+"]");
			}
		}
	}
}

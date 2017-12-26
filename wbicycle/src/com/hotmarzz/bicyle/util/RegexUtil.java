package com.hotmarzz.bicyle.util;

public class RegexUtil {
	//�ֻ���
	public static final String PHONE_REGEX="^[1][3|4|5|7|8]\\d{9}$";
	public static final String PHONE_DISPLAY="��������ȷ���ֻ�����:11λ����,1��ͷ,�ڶ���λΪ3��4��5��7��8";
	//����
	public static final String NAME_REGEX="[\u4e00-\u9fa5]{2,4}";
	public static final String NAME_DISPLAY="��������ȷ������:2-4������";
	//�Ա�
	public static final String SEX_REGEX="^[��|Ů]$";
	public static final String SEX_DISPLAY="��������ȷ���Ա�:�л�Ů";
	//����
	public static final String AGE_REGEX="[1][6-9]|[2][0-9]|[3][0-2]";
	public static final String AGE_DISPLAY="��������ȷ������:16~32";

	public static String getStringRegex(String Regex,String display){
		while(true){
			//��ȡ����̨����������ַ���
			String s=InputUtil.getString();
			if(s.matches(Regex)){
				return s;
			}else{
				System.out.println("��������:["+display+"]");
			}
			
		}
	}

}

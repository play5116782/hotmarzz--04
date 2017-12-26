package com.hotmarzz.bicyle.util;

public class RegexUtil {
	//手机号
	public static final String PHONE_REGEX="^[1][3|4|5|7|8]\\d{9}$";
	public static final String PHONE_DISPLAY="请输入正确的手机号码:11位数字,1开头,第二数位为3、4、5、7、8";
	//姓名
	public static final String NAME_REGEX="[\u4e00-\u9fa5]{2,4}";
	public static final String NAME_DISPLAY="请输入正确的姓名:2-4个汉字";
	//性别
	public static final String SEX_REGEX="^[男|女]$";
	public static final String SEX_DISPLAY="请输入正确的性别:男或女";
	//年龄
	public static final String AGE_REGEX="[1][6-9]|[2][0-9]|[3][0-2]";
	public static final String AGE_DISPLAY="请输入正确的年龄:16~32";

	public static String getStringRegex(String Regex,String display){
		while(true){
			//获取控制台键盘输入的字符串
			String s=InputUtil.getString();
			if(s.matches(Regex)){
				return s;
			}else{
				System.out.println("输入有误:["+display+"]");
			}
			
		}
	}

}

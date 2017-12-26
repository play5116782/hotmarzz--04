package com.hotmarzz.bicycle.util;

public class RegexUtil {
	
	//手机号
	public static final String PHONE_REGEX = "^[1][3|4|5|7|8]\\d{9}$";
	public static final String PHONE_DISPLAY = "要求长度为11位";
	//姓名
	public static final String NAME_REGEX = "^[\u4e00-\u9fa5]{2,4}$";
	public static final String NAME_DISPLAY = "要求二到四位汉字";
	//性别
	public static final String SEX_REGEX = "^[男|女]$";
	public static final String SEX_DISPLAY = "要求输入男或女";
	//年龄
	public static final String AGE_REGEX = "^[1][6-9]|[2][0-9]|[3][0-2]$";
	public static final String AGE_DISPLAY = "要求输入16到32";
	
	public static String getStringRegex(String Regex,String display){
		while(true){
			//获取控制台键盘输入的字符串
			String s = InputUtil.getString();
			if(s.matches(Regex)){
				return s;
			}else{
				System.out.println("输入有误:["+display+"]");
			}
		}
	}
}

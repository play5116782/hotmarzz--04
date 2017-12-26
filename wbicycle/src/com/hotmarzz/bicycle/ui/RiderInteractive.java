package com.hotmarzz.bicycle.ui;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicyle.util.RegexUtil;

/**
 * 骑行用户信息交互类
 * 
 * @author Administrator
 *
 */
public class RiderInteractive {
	public static Rider addRider() {
		System.out.println("请输入用户的手机号:(在系统中唯一)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		System.out.println("请输入用户的姓名:(二到四个字)");
		String name = RegexUtil.getStringRegex(RegexUtil.NAME_REGEX, RegexUtil.NAME_DISPLAY);
		System.out.println("请输入用户的性别:(只可输入男或女)");
		String sex = RegexUtil.getStringRegex(RegexUtil.SEX_REGEX, RegexUtil.SEX_DISPLAY);
		System.out.println("请输入用户的年龄:(14~32)");
		int age = Integer.parseInt(RegexUtil.getStringRegex(RegexUtil.AGE_REGEX, RegexUtil.AGE_DISPLAY));

		Rider rider = new Rider();
		rider.setPhone(phone);
		rider.setName(name);
		rider.setSex(sex);
		rider.setAge(age);
		return rider;
	}

}

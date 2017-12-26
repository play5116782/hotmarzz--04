package com.hotmarzz.bicycle.ui;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicyle.util.RegexUtil;

/**
 * �����û���Ϣ������
 * 
 * @author Administrator
 *
 */
public class RiderInteractive {
	public static Rider addRider() {
		System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		System.out.println("�������û�������:(�����ĸ���)");
		String name = RegexUtil.getStringRegex(RegexUtil.NAME_REGEX, RegexUtil.NAME_DISPLAY);
		System.out.println("�������û����Ա�:(ֻ�������л�Ů)");
		String sex = RegexUtil.getStringRegex(RegexUtil.SEX_REGEX, RegexUtil.SEX_DISPLAY);
		System.out.println("�������û�������:(14~32)");
		int age = Integer.parseInt(RegexUtil.getStringRegex(RegexUtil.AGE_REGEX, RegexUtil.AGE_DISPLAY));

		Rider rider = new Rider();
		rider.setPhone(phone);
		rider.setName(name);
		rider.setSex(sex);
		rider.setAge(age);
		return rider;
	}

}

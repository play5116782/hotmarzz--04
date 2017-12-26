package com.hotmarzz.bicycle.ui;

/**
 * ������Ϣ������
 */
import java.util.Scanner;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicyle.util.NumberUtil;

public class BicycleInteractive {
	public static Bicycle addBicycle() {
		Scanner sc = new Scanner(System.in);
		String no = NumberUtil.getBicyleNo();

		long utilitySecond = 0;
		System.out.println("�����뵥������(����)");
		String name = sc.next();
		System.out.println("�����뵥��(����)(�԰�Сʱ�Ʒ�)");
		double cost = sc.nextDouble();
		double longitude = NumberUtil.getCoor();
		double latitude = NumberUtil.getCoor2();
		Bicycle bicyle = new Bicycle();
		bicyle.setNo(no);
		bicyle.setUtilitySecond(utilitySecond);
		bicyle.setBt(new BicycleType(name, cost));
		bicyle.setCd(new Coordinate(longitude, latitude));
		return bicyle;

	}
}

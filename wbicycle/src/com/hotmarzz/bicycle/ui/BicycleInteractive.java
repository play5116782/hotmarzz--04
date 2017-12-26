package com.hotmarzz.bicycle.ui;

/**
 * 单车信息交互类
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
		System.out.println("请输入单车名称(类型)");
		String name = sc.next();
		System.out.println("请输入单价(类型)(以半小时计费)");
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

package com.hotmarzz.bicycle.ui;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.util.InputUtil;
import com.hotmarzz.bicycle.util.NumberUtil;
import com.hotmarzz.bicycle.util.RegexUtil;

/**
 * 单车信息交互类
 * @author Administrator
 *
 */
public class BicycleInteractive {
	
	//封装添加的单车信息
	public static Bicycle addBicycle(){
		//系统自动生成单车编号
		String no = NumberUtil.getBicycleNo();
		//骑行时间为0
		long time = 0l;
		System.out.println("请输入单车名称:");
		String name = InputUtil.getString();
		System.out.println("请输入单车单价:");
		double cost = InputUtil.getDouble();
		//系统随机生成的单车坐标
		double longitude = NumberUtil.getCoor();
		double latitude = NumberUtil.getCoor();
		//创建单车对象 将数据封装进去
		Bicycle b = new Bicycle(); 
		b.setNo(no);
		b.setUtilitySecond(time);
		b.setBt(new BicycleType(name, cost));
		b.setCd(new Coordinate(longitude, latitude));
		return b;
	}
}

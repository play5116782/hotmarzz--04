package com.hotmarzz.bicycle.main;

import java.util.ArrayList;
import java.util.List;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;

public class DataInit {
	
	//定义静态骑行用户集合
	public static List<Rider> rs = new ArrayList<Rider>();
	//定义静态单车数组
	public static List<Bicycle> bs = new ArrayList<Bicycle>();
	//定义城市编码
	public static final String CITY = "nj";
	//定义单车开始编号
	public static int BICYCLENO = 4;
	//定义骑行记录静态集合
	public static List<RidingRecord> rr = new ArrayList<RidingRecord>();
	//使用静态代码块初始化数组前三个rider对象
	static{
		Rider r1 = new Rider("张三","男",25,"13800123489");
		Rider r2 = new Rider("李四","男",38,"18604619688");
		Rider r3 = new Rider("小王","女",18,"18644028291");
		
		rs.add(r1);
		rs.add(r2);
		rs.add(r3);
		
		Bicycle b1 = new Bicycle("20171201nj0001", 1234221l, new BicycleType("摩拜", 1), new Coordinate(12.111, 12.342));
		Bicycle b2 = new Bicycle("20171201nj0002", 1434221l, new BicycleType("摩拜", 1), new Coordinate(12.112, 12.123));
		Bicycle b3 = new Bicycle("20171201nj0003", 1034221l, new BicycleType("摩拜", 1), new Coordinate(12.113, 12.321));
		
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
	}
}

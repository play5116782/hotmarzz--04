package com.hotmarzz.bicycle.main;

import java.util.ArrayList;
import java.util.List;
import com.hotmarzz.bicycle.bean.RidingRecord;
public class DataInit {

	// //定义静态骑行用户数组
	// public static Map<String,Rider> map= new HashMap<String,Rider>();
	// static Rider rider1 = new Rider("张三","男",30,"15134659267");
	// static Rider rider2 = new Rider("李四","男",35,"18578592687");
	// static Rider rider3 = new Rider("小花","女",20,"18735024783");
	//
	// //使用静态代码块初始化数组前三个rider对象
	// static{
	// map.put("15134659267", rider1);
	// map.put("18578592687", rider2);
	// map.put("18735024783", rider3);
	// }
	//
	//
	// //定义静态单车数组
	// public static List<Bicyle> list = new ArrayList<Bicyle>();
	//
	// public static Bicyle[] be = new Bicyle[5];

	// //使用静态代码块初始化数组前三个Bicyle对象
	// static{
	// Bicyle b1 = new Bicyle(NumberUtil.getBicyleNo(),122443l,new
	// BicyleType("ofo",0.5), new Coordinate(
	// NumberUtil.getCoor(),NumberUtil.getCoor2()));
	// Bicyle b2 = new Bicyle(NumberUtil.getBicyleNo(),153343l,new
	// BicyleType("摩拜",1.0),new Coordinate(
	// NumberUtil.getCoor(),NumberUtil.getCoor2()));
	// Bicyle b3 = new Bicyle(NumberUtil.getBicyleNo(),3650000l, new
	// BicyleType("酷奇",0.5),new Coordinate(
	// NumberUtil.getCoor(),NumberUtil.getCoor2()));
	// list.add(b1);
	// list.add(b2);
	// list.add(b3);
	// }
	//
	//
	// 定义城市编码
	public static final String CITY = "nj";
	// 定义单车编号
	public static int BICYLENO = 1;

	// 定义骑行记录静态集合
	public static List<RidingRecord> rr = new ArrayList<RidingRecord>();
}

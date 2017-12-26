package com.hotmarzz.bicycle.buzz.impl;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.buzz.BicycleBuzz;
import com.hotmarzz.bicycle.main.DataInit;
import com.hotmarzz.bicycle.ui.BicycleInteractive;
import com.hotmarzz.bicycle.util.InputUtil;

public class BicycleBuzzImpl implements BicycleBuzz{

	@Override
	public void getAll() {
		System.out.println("单车编号\t\t骑行时长\t单车名称\t单价\t经度\t纬度");
		for (Bicycle b : DataInit.bs) {
			System.out.println(b.getNo()+"\t"+b.getUtilitySecond()+"\t"+
					b.getBt().getName()+"\t"+b.getBt().getCost()+"\t"+
					b.getCd().getLongitude()+"\t"+b.getCd().getLatitude());
		}
	}

	@Override
	public void add() {
		Bicycle b = BicycleInteractive.addBicycle();
		//将单车对象b添加进集合中
		DataInit.bs.add(b);
	}
	/*
	 * 单车删除
	 * 需要参数:单车编号
	 * 根据单车编号 来删除对应的单车
	 * (non-Javadoc)
	 * @see com.hotmarzz.bicycle.buzz.BicycleBuzz#delete()
	 */
	@Override
	public void delete() {
		System.out.println("请输入要删除的单车编号:");
		String no = InputUtil.getString();
		Bicycle b = this.getBicycleByNo(no);
		DataInit.bs.remove(b);
	}
	/**
	 * 根据单车编号查询指定单车
	 */
	@Override
	public Bicycle getBicycleByNo(String no) {
		// 遍历单车集合 找到对应单车编号
		for (Bicycle b : DataInit.bs) {
			// 当对应单车存在时 返回单车对象
			if (b.getNo().equals(no)) {
				return b;
			}
			// 如果不存在这辆单车 则返回null
		}
		return null;
	}
	//修改
	@Override
	public void update() {
		System.out.println("请输入修改单车编号:");
		String no = InputUtil.getString();
		Bicycle b = this.getBicycleByNo(no);
		System.out.println("请选择修改内容:1、价格   2、时长");
		int a = InputUtil.getInt();
		switch (a) {
		case 1:
			//修改价格
			System.out.println("请输入修改后的价格:");
			double cost = InputUtil.getDouble();
			b.setBt(new BicycleType(b.getBt().getName(), cost));
			break;
		case 2:
			//修改时长
			System.out.println("请输入修改后的时长:");
			long time = InputUtil.getLong();
			b.setUtilitySecond(time);
			break;
		default:
			break;
		}
	}
}

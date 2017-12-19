package com.hotmarzz.bicycle.buzz.impl;

import java.util.Date;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.buzz.RentaBuzz;
import com.hotmarzz.bicycle.main.DataInit;
import com.hotmarzz.bicycle.util.NumberUtil;

public class RentaBuzzImpl implements RentaBuzz {

	@Override
	public RidingRecord startRenta(Rider rider, Bicycle bicycle) {
		//创建骑行记录对象
		RidingRecord rr = new RidingRecord();
		//确定了骑行记录中的骑行用户
		rr.setRider(rider);
		//确定了骑行记录中的单车
		rr.setBicycle(bicycle);
		//确定了骑行记录中的开始时间
		rr.setStartTime(new Date());
		//确定了骑行记录中的开始坐标
		rr.setStartCoord(new Coordinate(NumberUtil.getCoor(), NumberUtil.getCoor()));
		return rr;
	}

	@Override
	public void endRenta(RidingRecord rr) {
		//确定了骑行记录中的结束时间
		rr.setEndTime(new Date());
		//确定了骑行记录中的结束坐标
		rr.setEndCoord(new Coordinate(NumberUtil.getCoor(), NumberUtil.getCoor()));
		//总费用
		rr.setCost(this.getCost(rr.getStartTime(), rr.getEndTime(), rr.getBicycle()));
		//将产生的骑行记录添加到集合中
		DataInit.rr.add(rr);
		System.out.println("车辆上锁,用车结束...");
		//添加线程的睡眠方法  自带异常 需要处理
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("扣除用户"+rr.getRider().getPhone()+" 金额:"+rr.getCost());
	}

	//费用计算 结束时间-开始时间 * 单价
	@Override
	public double getCost(Date startTime,Date endTime,Bicycle b) {
		//将得到的毫秒数转换成半小时
		double dou = (double)(endTime.getTime()-startTime.getTime())/1000/60/30;
		return Math.ceil(dou)*b.getBt().getCost();
	}
	
}

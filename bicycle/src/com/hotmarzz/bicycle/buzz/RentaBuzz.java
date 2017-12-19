package com.hotmarzz.bicycle.buzz;

import java.util.Date;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;

/**
 * 租车接口
 * @author Administrator
 * 从开始租车 到结束租车 会产生一条骑行记录
 * 开始租车方法 会返回一条骑行记录 该条骑行记录会一直记录到租车结束
 * 
 */
public interface RentaBuzz {
	
	//开始租车  人和车
	RidingRecord startRenta(Rider rider,Bicycle bicycle);
	//结束租车
	void endRenta(RidingRecord rr);
	//租车费用计算
	double getCost(Date startTime,Date endTime,Bicycle b);
}

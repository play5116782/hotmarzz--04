package com.hotmarzz.bicyle.buzz;

import java.util.Date;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicyle.exception.BicyleException;

/**
 * 租车接口
 * @author Administrator
 *
 */
public interface RentaBuzz {
//开始租车 人和车，
	RidingRecord startRenta(Rider rider ,Bicycle bicyle);
	//结束租车
	void endRenta(RidingRecord rr);
	//花费
	Double getCost(Date startTime,Date endTime,Bicycle bicyle );
	//查询全部记录。
	void getAllRidingRecord();
	//根据手机号查询
	void getPhoneRidingRecord() throws BicyleException;
	//根据单车编号查询
	void getnoRidingRecord();
}

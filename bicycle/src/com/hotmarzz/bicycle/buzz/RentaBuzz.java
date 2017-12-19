package com.hotmarzz.bicycle.buzz;

import java.util.Date;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;

/**
 * �⳵�ӿ�
 * @author Administrator
 * �ӿ�ʼ�⳵ �������⳵ �����һ�����м�¼
 * ��ʼ�⳵���� �᷵��һ�����м�¼ �������м�¼��һֱ��¼���⳵����
 * 
 */
public interface RentaBuzz {
	
	//��ʼ�⳵  �˺ͳ�
	RidingRecord startRenta(Rider rider,Bicycle bicycle);
	//�����⳵
	void endRenta(RidingRecord rr);
	//�⳵���ü���
	double getCost(Date startTime,Date endTime,Bicycle b);
}

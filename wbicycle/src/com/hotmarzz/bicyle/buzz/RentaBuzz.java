package com.hotmarzz.bicyle.buzz;

import java.util.Date;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicyle.exception.BicyleException;

/**
 * �⳵�ӿ�
 * @author Administrator
 *
 */
public interface RentaBuzz {
//��ʼ�⳵ �˺ͳ���
	RidingRecord startRenta(Rider rider ,Bicycle bicyle);
	//�����⳵
	void endRenta(RidingRecord rr);
	//����
	Double getCost(Date startTime,Date endTime,Bicycle bicyle );
	//��ѯȫ����¼��
	void getAllRidingRecord();
	//�����ֻ��Ų�ѯ
	void getPhoneRidingRecord() throws BicyleException;
	//���ݵ�����Ų�ѯ
	void getnoRidingRecord();
}

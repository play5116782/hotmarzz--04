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
		//�������м�¼����
		RidingRecord rr = new RidingRecord();
		//ȷ�������м�¼�е������û�
		rr.setRider(rider);
		//ȷ�������м�¼�еĵ���
		rr.setBicycle(bicycle);
		//ȷ�������м�¼�еĿ�ʼʱ��
		rr.setStartTime(new Date());
		//ȷ�������м�¼�еĿ�ʼ����
		rr.setStartCoord(new Coordinate(NumberUtil.getCoor(), NumberUtil.getCoor()));
		return rr;
	}

	@Override
	public void endRenta(RidingRecord rr) {
		//ȷ�������м�¼�еĽ���ʱ��
		rr.setEndTime(new Date());
		//ȷ�������м�¼�еĽ�������
		rr.setEndCoord(new Coordinate(NumberUtil.getCoor(), NumberUtil.getCoor()));
		//�ܷ���
		rr.setCost(this.getCost(rr.getStartTime(), rr.getEndTime(), rr.getBicycle()));
		//�����������м�¼��ӵ�������
		DataInit.rr.add(rr);
		System.out.println("��������,�ó�����...");
		//����̵߳�˯�߷���  �Դ��쳣 ��Ҫ����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�۳��û�"+rr.getRider().getPhone()+" ���:"+rr.getCost());
	}

	//���ü��� ����ʱ��-��ʼʱ�� * ����
	@Override
	public double getCost(Date startTime,Date endTime,Bicycle b) {
		//���õ��ĺ�����ת���ɰ�Сʱ
		double dou = (double)(endTime.getTime()-startTime.getTime())/1000/60/30;
		return Math.ceil(dou)*b.getBt().getCost();
	}
	
}

package com.hotmarzz.bicycle.ui;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.util.InputUtil;
import com.hotmarzz.bicycle.util.NumberUtil;
import com.hotmarzz.bicycle.util.RegexUtil;

/**
 * ������Ϣ������
 * @author Administrator
 *
 */
public class BicycleInteractive {
	
	//��װ��ӵĵ�����Ϣ
	public static Bicycle addBicycle(){
		//ϵͳ�Զ����ɵ������
		String no = NumberUtil.getBicycleNo();
		//����ʱ��Ϊ0
		long time = 0l;
		System.out.println("�����뵥������:");
		String name = InputUtil.getString();
		System.out.println("�����뵥������:");
		double cost = InputUtil.getDouble();
		//ϵͳ������ɵĵ�������
		double longitude = NumberUtil.getCoor();
		double latitude = NumberUtil.getCoor();
		//������������ �����ݷ�װ��ȥ
		Bicycle b = new Bicycle(); 
		b.setNo(no);
		b.setUtilitySecond(time);
		b.setBt(new BicycleType(name, cost));
		b.setCd(new Coordinate(longitude, latitude));
		return b;
	}
}

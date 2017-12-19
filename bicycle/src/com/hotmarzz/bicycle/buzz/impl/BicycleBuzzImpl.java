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
		System.out.println("�������\t\t����ʱ��\t��������\t����\t����\tγ��");
		for (Bicycle b : DataInit.bs) {
			System.out.println(b.getNo()+"\t"+b.getUtilitySecond()+"\t"+
					b.getBt().getName()+"\t"+b.getBt().getCost()+"\t"+
					b.getCd().getLongitude()+"\t"+b.getCd().getLatitude());
		}
	}

	@Override
	public void add() {
		Bicycle b = BicycleInteractive.addBicycle();
		//����������b��ӽ�������
		DataInit.bs.add(b);
	}
	/*
	 * ����ɾ��
	 * ��Ҫ����:�������
	 * ���ݵ������ ��ɾ����Ӧ�ĵ���
	 * (non-Javadoc)
	 * @see com.hotmarzz.bicycle.buzz.BicycleBuzz#delete()
	 */
	@Override
	public void delete() {
		System.out.println("������Ҫɾ���ĵ������:");
		String no = InputUtil.getString();
		Bicycle b = this.getBicycleByNo(no);
		DataInit.bs.remove(b);
	}
	/**
	 * ���ݵ�����Ų�ѯָ������
	 */
	@Override
	public Bicycle getBicycleByNo(String no) {
		// ������������ �ҵ���Ӧ�������
		for (Bicycle b : DataInit.bs) {
			// ����Ӧ��������ʱ ���ص�������
			if (b.getNo().equals(no)) {
				return b;
			}
			// ����������������� �򷵻�null
		}
		return null;
	}
	//�޸�
	@Override
	public void update() {
		System.out.println("�������޸ĵ������:");
		String no = InputUtil.getString();
		Bicycle b = this.getBicycleByNo(no);
		System.out.println("��ѡ���޸�����:1���۸�   2��ʱ��");
		int a = InputUtil.getInt();
		switch (a) {
		case 1:
			//�޸ļ۸�
			System.out.println("�������޸ĺ�ļ۸�:");
			double cost = InputUtil.getDouble();
			b.setBt(new BicycleType(b.getBt().getName(), cost));
			break;
		case 2:
			//�޸�ʱ��
			System.out.println("�������޸ĺ��ʱ��:");
			long time = InputUtil.getLong();
			b.setUtilitySecond(time);
			break;
		default:
			break;
		}
	}
}

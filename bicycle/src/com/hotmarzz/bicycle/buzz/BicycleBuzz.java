package com.hotmarzz.bicycle.buzz;

import com.hotmarzz.bicycle.bean.Bicycle;

public interface BicycleBuzz {
	
	void getAll();
	void add();
	//����ɾ��
	void delete();
	//���ݵ�����Ų�ѯ����
	Bicycle getBicycleByNo(String no);
	//�����޸� �۸� ʱ��
	void update();
}

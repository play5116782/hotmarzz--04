package com.hotmarzz.bicyle.buzz;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.RidingRecord;

public interface Bicyclebuzz {
	//ȫ����ѯ
	void getAll() ;
	//�������
	Bicycle add();
	//���ݵ�����Ż�õ�������
	Bicycle bicyleNo(String s);
	//����ɾ��
	void delete();
	//�����޸�
	void updata();

}

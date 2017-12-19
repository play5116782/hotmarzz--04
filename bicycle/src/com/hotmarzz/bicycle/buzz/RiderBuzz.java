package com.hotmarzz.bicycle.buzz;

import java.util.List;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.exception.RiderException;

/**
 * �����û��ӿ�
 * @author Administrator
 *
 */
public interface RiderBuzz {
	
	//��ѯ
	void getAll();
	//���
	Rider add() throws RiderException;
	//�����ֻ��Ų�ѯ�û�
	Rider getRiderByPhone(String phone);
	//ɾ��
	void delete(List<Rider> list);
	//���ݶ���ֻ��Ų�ѯ����û�
	List<Rider> getList(String[] phones);
}

package com.hotmarzz.bicyle.buzz;

import java.util.List;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicyle.exception.RiderException;

/**
 * �����û��ӿ�
 * @author Administrator
 *
 */
public interface Riderbuzz  {
	//ȫ����ѯ
	void getAll();
	//�����ֻ������ѯ
	void getphone3();
	//���
	void add() throws RiderException; 
	void updata() throws RiderException;
	//������ɾ���û���Ϣ��
	void delete();
	//���ݲ������ֻ����뷵�����ݿ��������û��Ķ���
	Rider getRiderByPhone(String phone);
	//�������ֻ����� ���ض�Ӧ������û�����
	List<Rider> getriderphones(String phones);
}

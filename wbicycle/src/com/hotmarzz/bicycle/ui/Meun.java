package com.hotmarzz.bicycle.ui;

/**
 * �˵�
 */
import java.util.Scanner;

import com.hotmarzz.bicycle.bean.User;

public class Meun {
	Scanner sc = new Scanner(System.in);

	// ��ʼ���� getMainInput
	public int getMainInput() {
		System.out.println("**********************");
		System.out.println();
		System.out.println("     ��ӭ��������ϵͳ");
		System.out.println();
		System.out.println(" 1ģ���⳵    2����Ա��¼   0�˳�");
		System.out.println();
		System.out.println("**********************");
		int i = sc.nextInt();
		return i;
	}

	// ��¼����
	public User getLoginInput() {
		System.out.println();
		System.out.println("******��¼����*****");
		System.out.println();
		System.out.println("�����������û���:");
		System.out.println();
		String userName = sc.next();
		System.out.println();
		System.out.println("��������������:");
		System.out.println();
		String password = sc.next();
		User user = new User();
		user.setuserName(userName);
		user.setpassword(password);
		return user;
	}

	// ��̨��������
	public int getAdminInput() {
		System.out.println("************");
		System.out.println();
		System.out.println("������̨����");
		System.out.println("1.�����û�����");
		System.out.println("2.��������");
		System.out.println("3.���м�¼����");
		System.out.println("4.��������");
		System.out.println("0.����������");
		System.out.println();
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// �������ý���
	// ��̨��������
	public int updateAdmin2() {
		System.out.println("************");
		System.out.println();
		System.out.println("����Ա��¼�������ù���");
		System.out.println("1.����Ա��¼�û�����");
		System.out.println("2.����Ա��¼��������");
		System.out.println("3.����Ա��¼����¼��������");
		System.out.println("0.������һ��");
		System.out.println();
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// �����û�����
	public int getRiderInput() {
		System.out.println("************");
		System.out.println("�ɹ���¼�û�����");
		System.out.println("1.�û����");
		System.out.println("2.�û�ɾ��");
		System.out.println("3.�û��޸�");
		System.out.println("4.�û���ѯ");
		System.out.println("0.������һ��");
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// �����������
	public int getBicyleInput() {
		System.out.println("************");
		System.out.println("��ӭ������������ҳ��");
		System.out.println("1.�������");
		System.out.println("2.����ɾ��");
		System.out.println("3.�����޸�");
		System.out.println("4.������ѯ");
		System.out.println("5.�����ϼ�");
		System.out.println("************");
		int i = sc.nextInt();
		return i;

	}

	// ���м�¼����
	public int getRidingRecordInput() {
		System.out.println("************");
		System.out.println("��ӭ�������м�¼����ҳ��");
		System.out.println("1.��ѯȫ�����м�¼");
		System.out.println("2.�����ֻ��Ų�ѯ���м�¼");
		System.out.println("3.���ݵ�����Ų�ѯ�����û�");
		System.out.println("0.�˳�");
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}
}
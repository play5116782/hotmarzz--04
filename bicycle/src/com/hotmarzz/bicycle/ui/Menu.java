package com.hotmarzz.bicycle.ui;

import java.util.Scanner;

import com.hotmarzz.bicycle.bean.User;

/**
 * �˵���
 */
public class Menu {
	
	//��ҳ
	public static int getMainInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("����ϵͳ");
		System.out.println();
		System.out.println("��ѡ���¼��ʽ:1��ģ���⳵ 2������Ա��¼ 0���˳�");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//��¼����
	public static User getLoginInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println();
		System.out.println("�������û���:");
		String userName = sc.next();
		System.out.println();
		System.out.println("����������:");
		String password = sc.next();
		System.out.println();
		System.out.println("************************************");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
	//��̨�������
	public static int getAdminInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("������̨����");
		System.out.println();
		System.out.println("1�������û�����");
		System.out.println("2����������");
		System.out.println("3�����м�¼����");
		System.out.println("4����������");
		System.out.println("0��������һ��");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//�����û�����
	public static int getRiderInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("�����û�����");
		System.out.println();
		System.out.println("1���û���ѯ");
		System.out.println("2���û����");
		System.out.println("3���û��޸�");
		System.out.println("4���û�ɾ��");
		System.out.println("5�������ϼ�");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//�����������
	public static int getBicycleInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("�����������");
		System.out.println();
		System.out.println("1��������ѯ");
		System.out.println("2���������");
		System.out.println("3�������޸�");
		System.out.println("4������ɾ��");
		System.out.println("5�������ϼ�");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//���м�¼����
	public static int getRidingInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("���м�¼����");
		System.out.println();
		System.out.println("1����ѯȫ����¼");
		System.out.println("2�������ֻ��Ų�ѯ��¼");
		System.out.println("3�����ݵ�����Ų�ѯ��¼");
		System.out.println("0�������ϼ�");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//���м�¼����
		public static int updateAdmin(){
			System.out.println("************************************");
			System.out.println();
			System.out.println("��������");
			System.out.println();
			System.out.println("1���޸Ĺ���Ա��¼����");
			System.out.println("2���޸Ĺ���Ա��¼����");
			System.out.println("3���޸Ĺ���Ա����¼����");
			System.out.println("0�������ϼ�");
			System.out.println();
			System.out.println("************************************");
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		}	
}

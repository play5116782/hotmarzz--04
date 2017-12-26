package com.hotmarzz.bicycle.main;

import java.util.Scanner;
import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.bean.User;
import com.hotmarzz.bicycle.ui.Meun;
import com.hotmarzz.bicyle.buzz.Bicyclebuzz;
import com.hotmarzz.bicyle.buzz.RentaBuzz;
import com.hotmarzz.bicyle.buzz.Riderbuzz;
import com.hotmarzz.bicyle.buzz.implments.BicycleBuzzimplments;
import com.hotmarzz.bicyle.buzz.implments.RentaBuzzimplments;
import com.hotmarzz.bicyle.buzz.implments.RiderBuzzimplments;
import com.hotmarzz.bicyle.exception.BicyleException;
import com.hotmarzz.bicyle.exception.RiderException;
import com.hotmarzz.bicyle.util.InputUtil;
import com.hotmarzz.bicyle.util.RegexUtil;
import com.hotmarzz.bicyle.util.XmlUtil;

public class Run {
	// ��̬ ����RierBuzzimplments����ָ��Riderbuzz��
	RentaBuzz rt = new RentaBuzzimplments();
	Riderbuzz rb = new RiderBuzzimplments();
	Bicyclebuzz by = new BicycleBuzzimplments();
	boolean bool = true;

	Meun meun = new Meun();
	int index = 3;

	public void star() throws RiderException, BicyleException {
		while (bool) {

			int i2 = meun.getMainInput();
			switch (i2) {
			case 1:
				// ģ���⳵
				this.RentaOp();
				this.star();
				break;
			case 2:
				// ����Ա��¼
				this.adminOp();
				break;
			case 0:
				// �˳�
				bool = false;
				break;
			default:
				System.out.println("������������������");
				this.star();
				break;
			}
		}
	}

	// �⳵
	public void RentaOp() {
		// �����ֻ��Ų�ѯ�û�
		System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider r = rb.getRiderByPhone(phone);
		if (r == null) {
			System.out.println("������ĺ��벻���ڣ�");
			return;
		}
		// ���ݵ�����Ų�ѯ����
		System.out.println("�����뵥�����");
		String str = InputUtil.getString();
		Bicycle b = by.bicyleNo(str);
		if (b == null) {
			System.out.println("������ĵ���������!!!");
			return;
		}
		// �����⳵������ʼ�⳵
		RidingRecord rr = rt.startRenta(r, b);
		// ���÷��������⳵
		rt.endRenta(rr);
		

	}

	// ����Ա��¼

	public void adminOp() throws RiderException, BicyleException {
		for (int a = 1; a <= XmlUtil.getXmlAdmin().getMaxlogin(); a++) {
			User user = meun.getLoginInput();
			if (XmlUtil.getXmlAdmin().getuserName().equals(user.getuserName())
					&& XmlUtil.getXmlAdmin().getpassword().equals(user.getpassword())) {
				this.adminOp2();
				break;
			}
			if (a == XmlUtil.getXmlAdmin().getMaxlogin()) {
				System.out.println("��������ﵽ" + XmlUtil.getXmlAdmin().getMaxlogin() + "�Σ������˳�");
				this.star();
				bool = false;

			} else {
				System.out.println("�û���������������������뻹ʣ" + (XmlUtil.getXmlAdmin().getMaxlogin() - a) + "��");
			}
		}
	}

	// ����Ա��¼�ɹ�����
	public void adminOp2() throws RiderException, BicyleException {
		int a1 = meun.getAdminInput();
		switch (a1) {
		case 1:
			// �����û�����
			this.riderOp();
			break;
		case 2:
			// ��������
			this.BicyleOp();
			break;
		case 3:
			// ���м�¼����
			this.ridingRecordOp();
			this.adminOp2();

			break;
		case 4:
			// ��������
			this.update();
			break;
		case 0:
			// ����������
			this.star();
			break;
		default:
			System.out.println("������������������");
			this.adminOp2();
			break;
		}

	}

	// �����û�����
	public void riderOp() throws RiderException {
		int a = meun.getRiderInput();
		switch (a) {
		case 1:
			Boolean b = true;
			while (b) {

				// �û����
				Scanner sc = new Scanner(System.in);
				try {
					rb.add();
				} catch (RiderException e) {
					// TODO: handle exception
					System.err.println("�쳣��Ϣ:" + e.getMessage() + " �쳣����:" + e.getCodeId());

				}
				System.out.println("�Ƿ������ӣ�(N�����أ����������)");
				if ("n".equalsIgnoreCase(sc.next())) {
					System.out.println("��������");
					b = false;
				}
			}

			this.riderOp();
			break;
		case 2:
			// �û�ɾ��

			rb.delete();
			this.riderOp();
			break;
		case 3:
			// �û��޸�
			rb.updata();

			this.riderOp();
			break;
		case 4:
			// �û���ѯ
			this.selectRider();
			break;
		case 0:
			// ������һ��
			try {
				this.adminOp2();
			} catch (BicyleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("������������������");
			this.riderOp();
			break;
		}

	}

	// �û���ѯ
	public void selectRider() throws RiderException {
		System.out.println("1.�����ֻ������ѯ      2.ȫ����ѯ");
		int i = InputUtil.getInt();
		switch (i) {
		case 1:
			// �����ֻ������ѯ
			rb.getphone3();
			this.riderOp();
			break;
		case 2:

			// ���ýӿ�ʵ�ֵķ���
			rb.getAll();
			this.riderOp();
			break;

		default:
			System.out.println("������������������");
			this.selectRider();
			break;
		}
	}

	// ��������
	public void BicyleOp() throws RiderException, BicyleException {
		// ���õ������淽��
		int a = meun.getBicyleInput();
		Scanner sc = new Scanner(System.in);
		switch (a) {
		case 1:
			// �������
			boolean b = true;
			while (b) {
				by.add();// �ӿ�ʵ�ֵķ�����
				System.out.println("�Ƿ������ӣ�(N�����أ����������)");
				String s = sc.next();
				if ("n".equalsIgnoreCase(s)) {
					System.out.println("��������");
					b = false;
				}
			}
			this.BicyleOp();
			break;
		case 2:
			// ����ɾ��
			by.delete();
			this.BicyleOp();

			break;
		case 3:
			// �����޸�
			by.updata();
			this.BicyleOp();
			break;
		case 4:
			// ������ѯ

			// ���ýӿ�ʵ�ֵķ���
			by.getAll();

			this.BicyleOp();
			break;
		case 5:
			// �����ϼ�
			this.adminOp2();
			break;

		default:
			System.out.println("������������������");
			this.BicyleOp();
			break;
		}

	}

	// ���м�¼����
	public void ridingRecordOp() throws BicyleException {
		// ���м�¼ҳ��
		int i = meun.getRidingRecordInput();
		switch (i) {
		case 1:
			// ȫ����ѯ
			rt.getAllRidingRecord();
			this.ridingRecordOp();
			break;
		case 2:
			// �����ֻ��Ų�ѯ
			try {

				rt.getPhoneRidingRecord();
			} catch (BicyleException e) {
				// TODO: handle exception
				System.err.println("���:" + e.getCodeId() + ", " + e.getMsg());
			}
			this.ridingRecordOp();
			break;
		case 3:
			rt.getnoRidingRecord();
			this.ridingRecordOp();
			// ���ݵ�����Ų�ѯ
			break;
		case 0:
			// ������һ��

			break;

		default:
			break;
		}
	}

	// �������÷���
	public void update() {
		int i = meun.updateAdmin2();
		switch (i) {
		case 1:
			// �����û���
			System.out.println("�������޸ĺ���û���");
			String str1 = InputUtil.getString();
			XmlUtil.updateAdmin("loginame", str1);
			this.update();
			break;
		case 2:
			// ��������
			System.out.println("�������޸ĺ������");
			String str2 = InputUtil.getString();
			XmlUtil.updateAdmin("password", str2);
			this.update();
			break;
		case 3:
			// ��������¼����
			System.out.println("�������޸ĺ������¼����");
			String str3 = InputUtil.getString();
			XmlUtil.updateAdmin("maxlogin", str3);
			this.update();
			break;
		case 0:
			// ������һ��
			try {
				this.adminOp2();
			} catch (RiderException | BicyleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	// ��������ڡ�
	public static void main(String[] args) throws RiderException, BicyleException {
		Run run = new Run();
		run.star();
	}

}

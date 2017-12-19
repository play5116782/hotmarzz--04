package com.hotmarzz.bicycle.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.bean.User;
import com.hotmarzz.bicycle.buzz.BicycleBuzz;
import com.hotmarzz.bicycle.buzz.RentaBuzz;
import com.hotmarzz.bicycle.buzz.RiderBuzz;
import com.hotmarzz.bicycle.buzz.impl.BicycleBuzzImpl;
import com.hotmarzz.bicycle.buzz.impl.RentaBuzzImpl;
import com.hotmarzz.bicycle.buzz.impl.RiderBuzzImpl;
import com.hotmarzz.bicycle.exception.RiderException;
import com.hotmarzz.bicycle.ui.Menu;
import com.hotmarzz.bicycle.util.InputUtil;
import com.hotmarzz.bicycle.util.XmlUtil;

public class Run {
	//��̬  ����RiderBuzzImpl���� ָ��RiderBuzz����
	RiderBuzz rb = new RiderBuzzImpl();
	BicycleBuzz bb = new BicycleBuzzImpl();
	//�����⳵�ӿڶ���
	RentaBuzz renb = new RentaBuzzImpl();
	boolean b1 = true;
	int index = 3;
	
	public void star() throws InterruptedException{
		while(b1){
			int a = Menu.getMainInput();
			switch (a) {
			case 1:
				//ģ���⳵
				this.RentaOp();
				break;
			case 2:
				//����Ա��¼
				this.adminOp();
				break;
			case 0:
				//�˳�
				b1 = false;
				System.out.println("�����˳�.");
				break;
			default:
				System.out.println("��������....");
				break;
			}
		}
	}
	
	//�⳵
	public void RentaOp() throws InterruptedException{
		System.out.println("��ȡ�⳵���ֻ�����:");
		String phone = InputUtil.getString();
		//�����ֻ��Ų�ѯ�û�
		Rider r = rb.getRiderByPhone(phone);
		//�ж��ֻ����Ƿ����
		if(r==null){
			System.out.println("���û�������...");
			return;
		}
		System.out.println("��ȡ�������:");
		String no = InputUtil.getString();
		//���ݵ�����Ų�ѯ����
		Bicycle b = bb.getBicycleByNo(no);
		//�жϵ����Ƿ����
		if(b==null){
			System.out.println("������Ŵ���...");
			return;
		}
		//��ʼ�⳵ ������һ�����м�¼
		RidingRecord rr = renb.startRenta(r, b);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("�����ɹ�,������ʼʹ��...");
		System.out.println("����1,�����ó�...");
		String s = InputUtil.getString();
		if("1".equals(s)){
			//�����⳵
			renb.endRenta(rr);
		}
	}
	
	
	//����Ա��¼
	public void adminOp(){
		//�ֽ׶� ����Ա�û�������д��
		for(int i=1;i<=XmlUtil.getXmlAdmin().getMaxLogin();i++){
			User user = Menu.getLoginInput();
			if(XmlUtil.getXmlAdmin().getUserName().equals(user.getUserName())&&XmlUtil.getXmlAdmin().getPassword().equals(user.getPassword())){
				break;
			}else{
				System.out.println("�û�����������.��ʣ"+(XmlUtil.getXmlAdmin().getMaxLogin()-i)+"�Ρ�");
				if(i == XmlUtil.getXmlAdmin().getMaxLogin()){
					System.out.println("����ﵽ"+XmlUtil.getXmlAdmin().getMaxLogin()+"��,�����˳�...");
					System.exit(0);
				}
			}
		}
		this.adminOp2();
	}
	
	public void adminOp2(){
		int a = Menu.getAdminInput();
		switch (a) {
		case 1:
			//�����û�����
			this.riderOp();//map
			break;
		case 2:
			//��������
			this.bicycleOp();//list
			break;
		case 3:
			//���м�¼����
			this.RidingOp();
			break;
		case 4:
			//��������
			this.update();
			break;
		case 0:
			//������һ��
			break;
		default:
			break;
		}
	}
	//�������÷���
	public void update(){
		int a = Menu.updateAdmin();
		switch (a) {
		case 1:
			//��ȡ���������µĹ���Ա��¼����
			System.out.println("�������µĹ���Ա�û���:");
			String newName = InputUtil.getString();
			//��newName������xml�ļ���
			XmlUtil.updateXmlAdmin(newName, "loginname");
			this.update();
			break;
		case 2:
			//��ȡ���������µĹ���Ա��¼����
			System.out.println("�������µĹ���Ա����:");
			String newPwd = InputUtil.getString();
			//��newName������xml�ļ���
			XmlUtil.updateXmlAdmin(newPwd, "password");
			this.update();
			break;
		case 3:
			//��ȡ���������µĹ���Ա��¼����
			System.out.println("�������µĹ���Ա����¼����:");
			String newMax = InputUtil.getString();
			//��newName������xml�ļ���
			XmlUtil.updateXmlAdmin(newMax, "maxlogin");
			this.update();
			break;
		case 0:
			this.adminOp2();
			break;
		default:
			break;
		}
	}
	
	//���м�¼����
	public void RidingOp(){
		int a = Menu.getRidingInput();
		switch (a) {
		case 1:
			System.out.println("���м�¼����:"+DataInit.rr.size());
			break;

		default:
			break;
		}
	}
	
	//����������
	public void bicycleOp(){
		//���õ������淽��
		int a = Menu.getBicycleInput();
		switch (a) {
		case 1:
			//������ѯ
			bb.getAll();
			this.bicycleOp();
			break;
		case 2:
			//�������
			bb.add();
			this.bicycleOp();
			break;
		case 3:
			//�����޸�(�۸�,ʱ��)
			bb.update();
			this.bicycleOp();
			break;
		case 4:
			//����ɾ��
			bb.delete();
			this.bicycleOp();
			break;
		case 0:
			this.adminOp2();
			break;
		default:
			break;
		}
	}
	
	//�����û�������
	public void riderOp(){
		int a = Menu.getRiderInput();
		switch (a) {
		case 1:
			//��ѯ
			rb.getAll();
			this.riderOp();
			break;
		case 2:
			//���
			try {
				rb.add();
			} catch (RiderException e) {
				System.err.println("�쳣��Ϣ:"+e.getMessage()+" �쳣����:"+e.getCodeId());
//				e.printStackTrace();
			}
			this.riderOp();
			break;
		case 3:
			break;
		case 4:
			//ɾ��
			System.out.println("����Ҫɾ���û����ֻ���,����û�֮���ö��ŷָ�...");
			String str = InputUtil.getString();
			String[] phones = str.split(",");
			System.out.println(Arrays.toString(phones));
			List<Rider> list = rb.getList(phones);
			rb.delete(list);
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		Run run = new Run();
		try {
			run.star();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

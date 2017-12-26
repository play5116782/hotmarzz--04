package com.hotmarzz.bicyle.buzz.implments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.main.DataInit;
import com.hotmarzz.bicyle.buzz.Bicyclebuzz;
import com.hotmarzz.bicyle.buzz.RentaBuzz;
import com.hotmarzz.bicyle.buzz.Riderbuzz;
import com.hotmarzz.bicyle.exception.BicyleException;
import com.hotmarzz.bicyle.util.InputUtil;
import com.hotmarzz.bicyle.util.NumberUtil;
import com.hotmarzz.bicyle.util.RegexUtil;
import com.hotmarzz.bicyle.util.SqlUtil;

public class RentaBuzzimplments implements RentaBuzz {

		Riderbuzz rb = new RiderBuzzimplments();
		Bicyclebuzz be = new BicycleBuzzimplments();
	@Override
	public RidingRecord startRenta(Rider rider, Bicycle bicyle) {
		// TODO Auto-generated method stub
		System.out.println("�����ɹ�����ʼ�ó�");
		//�⳵�û�
		Rider r = rider;
		//��ĵ���
		Bicycle b = bicyle;
		//�⳵��ʼʱ��
		Date startTime = new Date();
		//�⳵��ʼ����
		Coordinate  startCoord=  new Coordinate (NumberUtil.getCoor(),NumberUtil.getCoor());
		RidingRecord rr = new RidingRecord();
		rr.setRider(r);
		rr.setBicyle(b);
		rr.setStartTime(startTime);
		rr.setStartCoord(startCoord);
		return rr;
	
}

	@Override
	public void endRenta(RidingRecord rr) {
		// TODO Auto-generated method stub
		//��1�����⳵!
		System.out.println("����ʹ����,��1�����⳵!");
		int a =  InputUtil.getInt();
		if(a==1){
			//�⳵������
			//����̵߳�˯�߷���  �Դ��쳣 ��Ҫ����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("3");
			//����̵߳�˯�߷���  �Դ��쳣 ��Ҫ����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2");
			//����̵߳�˯�߷���  �Դ��쳣 ��Ҫ����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1");
			//����̵߳�˯�߷���  �Դ��쳣 ��Ҫ����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//����ʱ��ʱ��
			Date endTime = new Date();
			//����ʱ������
			Coordinate  endCoord=  new Coordinate (NumberUtil.getCoor(),NumberUtil.getCoor());
			//�����ݷŵ���¼����
			rr.setEndTime(endTime);
			rr.setEndCoord(endCoord);
			this.cs(rr);
	
			//�ܻ���	
			Double cost=this.getCost(rr.getStartTime(), rr.getEndTime(), rr.getBicyle());
			rr.setCost(cost);
			//�Ѽ�¼��ӽ����ϡ�
			DataInit.rr.add(rr);
			System.out.println("�����������ó�����,��лʹ��!");
			System.out.println("�û�:"+rr.getRider().getPhone()+"     ���л����ܽ�� :��" +rr.getCost());
			
		}
		
	}

	@Override
	public Double getCost(Date startTime,Date endTime,Bicycle bicyle ) {
		//getTime() --��ʱ��ת����long�͵ĺ�����
		//��ʱ�任�ɰ�Сʱ��
		
		double dou = (double)(endTime.getTime()-startTime.getTime())/1000/60/30;
		//�����ܷ���
		double getCost = Math.ceil(dou)*bicyle.getBt().getCost();
		
		
		return getCost;
	}
//��ѯȫ����¼
	@Override
	public void getAllRidingRecord() {
		// TODO Auto-generated method stub
		if(DataInit.rr.size()==0){
			System.out.println("Ŀǰ��û�м�¼����");
		}else{
			
		System.out.println("�û�\t\t�⳵���\t\t�⳵��ʼʱ��\t\t�⳵��ʼ����\t\t�⳵����ʱ��\t\t�⳵��������\t�ܷ���(Ԫ)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(ridingrecord==null)
				System.out.println("Ŀǰ��û�м�¼����");
			System.out.println(ridingrecord);
		}
		
	}
	}
//�����ֻ�������в�ѯ
	@Override
	public void getPhoneRidingRecord() throws BicyleException {
		// TODO Auto-generated method stub
		System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider r= rb.getRiderByPhone(phone);
		if(r==null){
			System.out.println("���û�������");
			return ;
		}
		if(DataInit.rr.size()==0){
			System.out.println("Ŀǰ��û�м�¼����");
		}else{
		System.out.println("�û�\t\t�⳵���\t\t�⳵��ʼʱ��\t\t�⳵��ʼ����\t\t�⳵����ʱ��\t\t�⳵��������\t�ܷ���(Ԫ)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(r.getPhone().equals(ridingrecord.getRider().getPhone())){
			double d  =	ridingrecord.riderTime(ridingrecord.getStartTime(), ridingrecord.getEndTime());
					d=0+d;
				
				System.out.println(ridingrecord);
				if(d>3000){
					throw new BicyleException(2, "��ӭ�����Ͽͻ�");
				}
				if(d==0){
					System.out.println("���û���û�м�¼����");
				}
			}
			
		}
		
		}
	}
//���ݵ�����Ų�ѯ
	@Override
	public void getnoRidingRecord() {
		// TODO Auto-generated method stub
		System.out.println("�����뵥�����");
		String str = InputUtil.getString();
		Bicycle b = be.bicyleNo(str);
		if(b==null){
			System.out.println("Ŀǰ��û�иñ�ŵĵ�����¼����");
			return;
		}
		if(DataInit.rr.size()==0){
			System.out.println("Ŀǰ��û�м�¼����");
		}else{
		System.out.println("�û�\t\t�⳵���\t\t�⳵��ʼʱ��\t\t�⳵��ʼ����\t\t�⳵����ʱ��\t\t�⳵��������\t�ܷ���(Ԫ)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(b.getNo().equals(ridingrecord.getBicyle().getNo())){	
			System.out.println(ridingrecord);
			}
			
		}
		}	
		
	}
	//�������ⵥ��������ʱ��
	public void cs(RidingRecord rr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		long a = rr.getEndTime().getTime()-rr.getStartTime().getTime();
		conn = SqlUtil.getConn();
		try {
			ps = conn.prepareStatement("update tb_bicycle set utilitySecond=? where id=?");
			ps.setLong(1, a+rr.getBicyle().getUtilitySecond());
			ps.setInt(2, rr.getBicyle().getId());
			int i = ps.executeUpdate();
			if(i==1){
				System.out.println("ʱ�����³ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlUtil.close(conn, ps, null);
		}
	}

	

}

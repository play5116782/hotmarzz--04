package com.hotmarzz.bicycle.buzz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.buzz.RiderBuzz;
import com.hotmarzz.bicycle.exception.RiderException;
import com.hotmarzz.bicycle.main.DataInit;
import com.hotmarzz.bicycle.ui.RiderInteractive;
import com.hotmarzz.bicycle.util.DBUtil;

public class RiderBuzzImpl implements RiderBuzz{

	//��ѯ
	@Override
	public void getAll() {
		System.out.println("����\t�Ա�\t����\t�ֻ�����");
		for (Rider rider : DataInit.rs) {
			if(rider!=null){
				System.out.println(rider.getName()+"\t"+rider.getSex()
				+"\t"+rider.getAge()+"\t"+rider.getPhone());
			}
		}
	}

	/*
	 * ���  (non-Javadoc)
	 * @see com.hotmarzz.bicycle.buzz.RiderBuzz#add()
	 * �����ж�  �����ֻ����� ���ж�
	 */
	@Override
	public Rider add() throws RiderException  {
		Rider rider = RiderInteractive.addRider();
		Rider r = getRiderByPhone(rider.getPhone());
		Connection conn = null;
		PreparedStatement ps = null;
		int a = 0;
		if(r == null){
			//�����û������� �����
			try {
				conn = DBUtil.getConn();
				ps = conn.prepareStatement("insert into tb_rider values(null,?,?,?,?)");
				ps.setString(1, rider.getName());
				ps.setString(2, rider.getSex());
				ps.setInt(3, rider.getAge());
				ps.setString(4, rider.getPhone());
				a = ps.executeUpdate();
				if(a == 1){
					System.out.println("��ӳɹ�");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//�û����� ���쳣
			throw new RiderException(110, "�û��Ѵ���...");
		}
		return rider;
	}

	
	@Override
	public Rider getRiderByPhone(String phone) {
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rider rider = null;
		try {
			ps = conn.prepareStatement("select * from tb_rider where phone=?");
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while(rs.next()){
				rider = new Rider();
				rider.setId(rs.getInt(1));
				rider.setName(rs.getString(2));
				rider.setSex(rs.getString(3));
				rider.setAge(rs.getInt(4));
				rider.setPhone(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return rider;
	}

	@Override
	public void delete(List<Rider> list) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//����һ������
			conn = DBUtil.getConn();
			//����һ��delete���
			ps = conn.prepareStatement("delete from tb_rider where id=?");
			//ѭ����ֵ
			for (Rider r : list) {
				ps.setInt(1, r.getId());
				//sqlû��ֱ��ִ�� ���Ƿ��뵽��������
				ps.addBatch();
			}
			//��������ͳһִ��
			ps.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, null);
		}
		
	}

	@Override
	public List<Rider> getList(String[] phones) {
		List<Rider> list = new ArrayList<Rider>();
		for (String phone : phones) {
			Rider r = this.getRiderByPhone(phone.trim());
			list.add(r);
		}
		return list;
	}

}

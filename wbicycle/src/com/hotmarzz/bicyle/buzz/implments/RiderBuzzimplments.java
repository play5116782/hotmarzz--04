package com.hotmarzz.bicyle.buzz.implments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.ui.RiderInteractive;
import com.hotmarzz.bicyle.buzz.Riderbuzz;
import com.hotmarzz.bicyle.exception.RiderException;
import com.hotmarzz.bicyle.util.InputUtil;
import com.hotmarzz.bicyle.util.RegexUtil;
import com.hotmarzz.bicyle.util.SqlUtil;

public class RiderBuzzimplments implements Riderbuzz {
	// �����ֻ������ѯ
	@Override
	public void getphone3() {
		// TODO Auto-generated method stub
		System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
		String phone2 = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider rider = this.getRiderByPhone(phone2);
		if (rider == null) {
			System.out.println("��������ֻ��û������ڣ�");
		} else {
			System.out.println("****�û���ѯ****");
			System.out.println("����\t�Ա�\t����\t�ֻ�����");
			Connection conn = SqlUtil.getConn();
			String sql = "select * from tb_rider where id = ?";
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			try {
				ps1 = conn.prepareStatement(sql);
				ps1.setInt(1, rider.getId());
				rs1 = ps1.executeQuery();
				while (rs1.next()) {
					System.out.println(rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
							+ rs1.getString(4) + "\t" + rs1.getString(5) + "\t");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	// ȫ����ѯ
	public void getAll() {
		// TODO Auto-generated method stub
		Connection conn = SqlUtil.getConn();
		String sql = "select * from tb_rider";
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		try {
			ps1 = conn.prepareStatement(sql);
			rs1 = ps1.executeQuery();
				System.out.println("****�û���ѯ****");
				System.out.println("����\t�Ա�\t����\t�ֻ�����");
				while (rs1.next()) {
				System.out.println(rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
						+ rs1.getString(4) + "\t" + rs1.getString(5) + "\t");
			}	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps1, rs1);
		}
	}

	@Override
	// ���
	public void add() throws RiderException {
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		int a = 0;
		// �ж��ֻ�����ͬʱ�����
		Rider rider = RiderInteractive.addRider();
		Rider r = this.getRiderByPhone(rider.getPhone());
		try {
			if (r == null) {
				String sql2 = "insert into tb_rider values(null,?,?,?,?)";
				ps = conn.prepareStatement(sql2);
				ps.setString(1, rider.getName());
				ps.setString(2, rider.getSex());
				ps.setInt(3, rider.getAge());
				ps.setString(4, rider.getPhone());
				a = ps.executeUpdate();
				if (a == 0) {
					System.out.println("���ʧ��");
				} else {
					System.out.println("��ӳɹ�");
				}
			} else {
				throw new RiderException(110, "�ú����ѱ�ע��!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, null);
		}
	}

	// �û��޸�
	@Override
	public void updata() throws RiderException {
		System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider rider = this.getRiderByPhone(phone);
		if (rider == null) {
			System.out.println("���������е��û��ֻ��ţ�");
		} else {

			Connection conn = null;
			PreparedStatement ps = null;
			int i = 0;
			try {
				System.out.println("��������º����Ϣ");
				System.out.println("�������û����ֻ���:(��ϵͳ��Ψһ)");
				String phone2 = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
				System.out.println("�������û�������:(�����ĸ���)");
				String name = RegexUtil.getStringRegex(RegexUtil.NAME_REGEX, RegexUtil.NAME_DISPLAY);
				System.out.println("�������û�������:(14~32)");
				int age = Integer.parseInt(RegexUtil.getStringRegex(RegexUtil.AGE_REGEX, RegexUtil.AGE_DISPLAY));
				conn = SqlUtil.getConn();
				ps = conn.prepareStatement("update tb_rider set name=?,age=?,phone=? where id = ?");

				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, phone2);
				ps.setInt(4, rider.getId());
				i = ps.executeUpdate();
				if (i == 1) {
					System.out.println("�޸ĳɹ�");
				}

				if (i == 0) {
					// System.out.println("���û��Ѵ����޸�ʧ��");
					// throw new RiderException(111, "���û��Ѵ����޸�ʧ��");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("���û��Ѵ����޸�ʧ��");
			} finally {
				SqlUtil.close(conn, ps, null);
			}

		}

	}

	@Override
	// ɾ��(����)
	public void delete() {
		System.out.println("������Ҫɾ���û����ֻ�����,��������ö��Ÿ���");
		String phones = InputUtil.getString();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = SqlUtil.getConn();
			ps = conn.prepareStatement("delete from tb_rider where id =?");
			// ������ݿ����û�����
			List<Rider> list = this.getriderphones(phones);

			for (int index = 0; index < list.size(); index++) {
				if (list.get(index) == null) {
					System.out.println("������ĵ�" + (index + 1) + "���ֻ�������ϵͳ�в�����,ɾ��ʧ��");
				} else {
					ps.setInt(1, list.get(index).getId());
					System.out.println("������ĵ�" + (index + 1) + "���ֻ�����ɾ���ɹ�");
					// ��ӵ���������
					ps.addBatch();
				}
			}
			// ��������
			ps.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, null);
		}
	}

	// �����ֻ��ŷ������ݿ��������û��Ķ���
	@Override
	public Rider getRiderByPhone(String phone) {
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rider rider = null;
		try {
			ps = conn.prepareStatement("select * from tb_rider where phone=?");
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				rider = new Rider();
				rider.setId(rs.getInt(1));
				rider.setName(rs.getString(2));
				rider.setSex(rs.getString(3));
				rider.setPhone(rs.getString(5));
				rider.setAge(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, rs);
		}

		return rider;
	}

	@Override
	public List<Rider> getriderphones(String phones) {
		// TODO Auto-generated method stub
		List<Rider> list = new ArrayList<Rider>();
		String[] phone = phones.split(",");
		Rider rider = null;
		for (String p : phone) {
			rider = new Rider();
			// ���ض�Ӧ��������ݿ��е��û�
			rider = this.getRiderByPhone(p.trim());
			list.add(rider);
		}

		return list;
	}

}
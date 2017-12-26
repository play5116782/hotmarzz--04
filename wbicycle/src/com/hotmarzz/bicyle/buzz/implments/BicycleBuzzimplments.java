package com.hotmarzz.bicyle.buzz.implments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.BicycleType;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.ui.BicycleInteractive;
import com.hotmarzz.bicyle.buzz.Bicyclebuzz;
import com.hotmarzz.bicyle.util.InputUtil;
import com.hotmarzz.bicyle.util.SqlUtil;

public class BicycleBuzzimplments implements Bicyclebuzz {

	@Override
	public void getAll() {
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("****������ѯ****");
		System.out.println("���\t\t����ʱ��(����)\t����(����)\t����(����)\t����(λ��)\tγ��(λ��)");
		Bicycle bicyle = null;
		try {
			ps = conn.prepareStatement("select  * from tb_bicycle");
			rs = ps.executeQuery();
			while (rs.next()) {
				bicyle = new Bicycle();
				bicyle.setId(rs.getInt(1));
				bicyle.setNo(rs.getString(2));
				bicyle.setUtilitySecond(rs.getLong(3));
				bicyle.setBt(new BicycleType(rs.getString(4), rs.getDouble(5)));
				bicyle.setCd(new Coordinate(rs.getDouble(6), rs.getDouble(7)));
				if (bicyle != null) {
					System.out.println(bicyle);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Ŀǰ��û�е�������ӣ�����");
		} finally {
			SqlUtil.close(conn, ps, rs);
		}

	}

	// �������
	@Override
	public Bicycle add() {
		// TODO Auto-generated method stub
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		Bicycle bicyle = BicycleInteractive.addBicycle();
		Bicycle b = this.bicyleNo(bicyle.getNo());
		int i;
		if (b == null) {
			try {
				ps = conn.prepareStatement("insert into tb_bicycle values(null,?,?,?,?,?,?)");
				ps.setString(1, bicyle.getNo());
				ps.setLong(2, bicyle.getUtilitySecond());
				ps.setString(3, bicyle.getBt().getName());
				ps.setDouble(4, bicyle.getBt().getCost());
				ps.setDouble(5, bicyle.getCd().getLongitude());
				ps.setDouble(6, bicyle.getCd().getLatitude());
				i = ps.executeUpdate();
				if (i == 1) {
					System.out.println("������ӳɹ�");
				} else {
					System.out.println("�������ʧ��");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				SqlUtil.close(conn, ps, null);
			}
			return bicyle;
		} else {
			System.out.println("�õ����Ѵ��ڣ��벻Ҫ�ظ����!!!");
			return null;
		}

	}

	@Override
	public Bicycle bicyleNo(String s) {
		// TODO Auto-generated method stub
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bicycle bicyle = null;
		try {
			ps = conn.prepareStatement("select  * from tb_bicycle where no=?");
			ps.setString(1, s);
			rs = ps.executeQuery();
			while (rs.next()) {
				bicyle = new Bicycle();
				bicyle.setId(rs.getInt(1));
				bicyle.setNo(rs.getString(2));
				bicyle.setUtilitySecond(rs.getLong(3));
				bicyle.setBt(new BicycleType(rs.getString(4), rs.getDouble(5)));
				bicyle.setCd(new Coordinate(rs.getDouble(6), rs.getDouble(7)));
			}
			return bicyle;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, rs);
		}
		return null;

	}

	@Override
	public void delete() {
		System.out.println("�����뵥�����");
		String str = InputUtil.getString();
		Bicycle bicyle2 = this.bicyleNo(str);
		if (bicyle2 != null) {
			Connection conn = SqlUtil.getConn();
			PreparedStatement ps = null;
			int i = 0;
			try {
				ps = conn.prepareStatement("delete from tb_bicycle where id =?");
				ps.setInt(1, bicyle2.getId());
				i = ps.executeUpdate();
				if (i == 1) {
					System.out.println("ɾ���ɹ�");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				SqlUtil.close(conn, ps, null);
			}
		} else {
			System.out.println("������ĵ���������!!!");
		}
	}

	@Override
	public void updata() {
		System.out.println("�����뵥�����");
		String str = InputUtil.getString();
		Bicycle bicyle2 = this.bicyleNo(str);
		if (bicyle2 != null) {
			Connection conn = null;
			PreparedStatement ps = null;
			System.out.println("��������Ҫ�޸ĵ�����: 1.����  2.����ʱ��");
			int a = InputUtil.getInt();
			switch (a) {
			case 1:
				System.out.println("�����������޸ĺ�ĵ���");
				double cost = InputUtil.getDouble();
				try {
					conn = SqlUtil.getConn();
					ps = conn.prepareStatement("update tb_bicycle set cost=? where id=?");
					ps.setDouble(1, cost);
					ps.setInt(2, bicyle2.getId());
					int i = ps.executeUpdate();
					if (i == 1) {
						System.out.println("�޸ĳɹ�");
					}else{
						System.out.println("�޸�ʧ��");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					SqlUtil.close(conn, ps, null);
				}
				break;
			case 2:
				System.out.println("�������µ�����ʱ��");
				long l = InputUtil.getLong();
				try {
					conn = SqlUtil.getConn();
					ps = conn.prepareStatement("update tb_bicycle set utilitySecond=? where id=?");
					ps.setLong(1, l);
					ps.setInt(2, bicyle2.getId());
					int i = ps.executeUpdate();
					if (i == 1) {
						System.out.println("�޸ĳɹ�");
					}else{
						System.out.println("�޸�ʧ��");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					SqlUtil.close(conn, ps, null);
				}

				break;

			default:
				break;
			}
		} else {
			System.out.println("������ı�Ų�����!!!");
		}
	}	
}

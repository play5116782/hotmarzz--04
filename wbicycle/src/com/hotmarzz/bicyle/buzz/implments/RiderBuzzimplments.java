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
	// 根据手机号码查询
	@Override
	public void getphone3() {
		// TODO Auto-generated method stub
		System.out.println("请输入用户的手机号:(在系统中唯一)");
		String phone2 = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider rider = this.getRiderByPhone(phone2);
		if (rider == null) {
			System.out.println("您输入的手机用户不存在！");
		} else {
			System.out.println("****用户查询****");
			System.out.println("姓名\t性别\t年龄\t手机号码");
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
	// 全部查询
	public void getAll() {
		// TODO Auto-generated method stub
		Connection conn = SqlUtil.getConn();
		String sql = "select * from tb_rider";
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		try {
			ps1 = conn.prepareStatement(sql);
			rs1 = ps1.executeQuery();
				System.out.println("****用户查询****");
				System.out.println("姓名\t性别\t年龄\t手机号码");
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
	// 添加
	public void add() throws RiderException {
		Connection conn = SqlUtil.getConn();
		PreparedStatement ps = null;
		int a = 0;
		// 判断手机号相同时的情况
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
					System.out.println("添加失败");
				} else {
					System.out.println("添加成功");
				}
			} else {
				throw new RiderException(110, "该号码已被注册!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, null);
		}
	}

	// 用户修改
	@Override
	public void updata() throws RiderException {
		System.out.println("请输入用户的手机号:(在系统中唯一)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider rider = this.getRiderByPhone(phone);
		if (rider == null) {
			System.out.println("请输入已有的用户手机号！");
		} else {

			Connection conn = null;
			PreparedStatement ps = null;
			int i = 0;
			try {
				System.out.println("请输入更新后的信息");
				System.out.println("请输入用户的手机号:(在系统中唯一)");
				String phone2 = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
				System.out.println("请输入用户的姓名:(二到四个字)");
				String name = RegexUtil.getStringRegex(RegexUtil.NAME_REGEX, RegexUtil.NAME_DISPLAY);
				System.out.println("请输入用户的年龄:(14~32)");
				int age = Integer.parseInt(RegexUtil.getStringRegex(RegexUtil.AGE_REGEX, RegexUtil.AGE_DISPLAY));
				conn = SqlUtil.getConn();
				ps = conn.prepareStatement("update tb_rider set name=?,age=?,phone=? where id = ?");

				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, phone2);
				ps.setInt(4, rider.getId());
				i = ps.executeUpdate();
				if (i == 1) {
					System.out.println("修改成功");
				}

				if (i == 0) {
					// System.out.println("该用户已存在修改失败");
					// throw new RiderException(111, "该用户已存在修改失败");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("该用户已存在修改失败");
			} finally {
				SqlUtil.close(conn, ps, null);
			}

		}

	}

	@Override
	// 删除(批量)
	public void delete() {
		System.out.println("请输入要删除用户的手机号码,多个号码用逗号隔开");
		String phones = InputUtil.getString();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = SqlUtil.getConn();
			ps = conn.prepareStatement("delete from tb_rider where id =?");
			// 获得数据库中用户集合
			List<Rider> list = this.getriderphones(phones);

			for (int index = 0; index < list.size(); index++) {
				if (list.get(index) == null) {
					System.out.println("您输入的第" + (index + 1) + "个手机号码在系统中不存在,删除失败");
				} else {
					ps.setInt(1, list.get(index).getId());
					System.out.println("您输入的第" + (index + 1) + "个手机号码删除成功");
					// 添加到批量处理
					ps.addBatch();
				}
			}
			// 批量处理
			ps.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtil.close(conn, ps, null);
		}
	}

	// 根据手机号返回数据库中骑行用户的对象
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
			// 返回对应号码的数据库中的用户
			rider = this.getRiderByPhone(p.trim());
			list.add(rider);
		}

		return list;
	}

}
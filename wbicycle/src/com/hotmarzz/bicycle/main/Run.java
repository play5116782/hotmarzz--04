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
	// 多态 创建RierBuzzimplments对象指向Riderbuzz；
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
				// 模拟租车
				this.RentaOp();
				this.star();
				break;
			case 2:
				// 管理员登录
				this.adminOp();
				break;
			case 0:
				// 退出
				bool = false;
				break;
			default:
				System.out.println("输入有误，请重新输入");
				this.star();
				break;
			}
		}
	}

	// 租车
	public void RentaOp() {
		// 根据手机号查询用户
		System.out.println("请输入用户的手机号:(在系统中唯一)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider r = rb.getRiderByPhone(phone);
		if (r == null) {
			System.out.println("您输入的号码不存在！");
			return;
		}
		// 根据单车编号查询单车
		System.out.println("请输入单车编号");
		String str = InputUtil.getString();
		Bicycle b = by.bicyleNo(str);
		if (b == null) {
			System.out.println("您输入的单车不存在!!!");
			return;
		}
		// 调用租车方法开始租车
		RidingRecord rr = rt.startRenta(r, b);
		// 调用方法结束租车
		rt.endRenta(rr);
		

	}

	// 管理员登录

	public void adminOp() throws RiderException, BicyleException {
		for (int a = 1; a <= XmlUtil.getXmlAdmin().getMaxlogin(); a++) {
			User user = meun.getLoginInput();
			if (XmlUtil.getXmlAdmin().getuserName().equals(user.getuserName())
					&& XmlUtil.getXmlAdmin().getpassword().equals(user.getpassword())) {
				this.adminOp2();
				break;
			}
			if (a == XmlUtil.getXmlAdmin().getMaxlogin()) {
				System.out.println("错误次数达到" + XmlUtil.getXmlAdmin().getMaxlogin() + "次，程序退出");
				this.star();
				bool = false;

			} else {
				System.out.println("用户名或密码错误，请重新输入还剩" + (XmlUtil.getXmlAdmin().getMaxlogin() - a) + "次");
			}
		}
	}

	// 管理员登录成功界面
	public void adminOp2() throws RiderException, BicyleException {
		int a1 = meun.getAdminInput();
		switch (a1) {
		case 1:
			// 骑行用户管理
			this.riderOp();
			break;
		case 2:
			// 单车管理
			this.BicyleOp();
			break;
		case 3:
			// 骑行记录管理
			this.ridingRecordOp();
			this.adminOp2();

			break;
		case 4:
			// 参数设置
			this.update();
			break;
		case 0:
			// 返回主界面
			this.star();
			break;
		default:
			System.out.println("输入有误，请重新输入");
			this.adminOp2();
			break;
		}

	}

	// 骑行用户管理
	public void riderOp() throws RiderException {
		int a = meun.getRiderInput();
		switch (a) {
		case 1:
			Boolean b = true;
			while (b) {

				// 用户添加
				Scanner sc = new Scanner(System.in);
				try {
					rb.add();
				} catch (RiderException e) {
					// TODO: handle exception
					System.err.println("异常信息:" + e.getMessage() + " 异常编码:" + e.getCodeId());

				}
				System.out.println("是否继续添加？(N键返回，任意键继续)");
				if ("n".equalsIgnoreCase(sc.next())) {
					System.out.println("新增结束");
					b = false;
				}
			}

			this.riderOp();
			break;
		case 2:
			// 用户删除

			rb.delete();
			this.riderOp();
			break;
		case 3:
			// 用户修改
			rb.updata();

			this.riderOp();
			break;
		case 4:
			// 用户查询
			this.selectRider();
			break;
		case 0:
			// 返回上一级
			try {
				this.adminOp2();
			} catch (BicyleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("输入有误，请重新输入");
			this.riderOp();
			break;
		}

	}

	// 用户查询
	public void selectRider() throws RiderException {
		System.out.println("1.根据手机号码查询      2.全部查询");
		int i = InputUtil.getInt();
		switch (i) {
		case 1:
			// 根据手机号码查询
			rb.getphone3();
			this.riderOp();
			break;
		case 2:

			// 调用接口实现的方法
			rb.getAll();
			this.riderOp();
			break;

		default:
			System.out.println("输入有误，请重新输入");
			this.selectRider();
			break;
		}
	}

	// 单车管理
	public void BicyleOp() throws RiderException, BicyleException {
		// 调用单车界面方法
		int a = meun.getBicyleInput();
		Scanner sc = new Scanner(System.in);
		switch (a) {
		case 1:
			// 单车添加
			boolean b = true;
			while (b) {
				by.add();// 接口实现的方法；
				System.out.println("是否继续添加？(N键返回，任意键继续)");
				String s = sc.next();
				if ("n".equalsIgnoreCase(s)) {
					System.out.println("新增结束");
					b = false;
				}
			}
			this.BicyleOp();
			break;
		case 2:
			// 单车删除
			by.delete();
			this.BicyleOp();

			break;
		case 3:
			// 单车修改
			by.updata();
			this.BicyleOp();
			break;
		case 4:
			// 单车查询

			// 调用接口实现的方法
			by.getAll();

			this.BicyleOp();
			break;
		case 5:
			// 返回上级
			this.adminOp2();
			break;

		default:
			System.out.println("输入有误，请重新输入");
			this.BicyleOp();
			break;
		}

	}

	// 骑行记录管理
	public void ridingRecordOp() throws BicyleException {
		// 骑行记录页面
		int i = meun.getRidingRecordInput();
		switch (i) {
		case 1:
			// 全部查询
			rt.getAllRidingRecord();
			this.ridingRecordOp();
			break;
		case 2:
			// 根据手机号查询
			try {

				rt.getPhoneRidingRecord();
			} catch (BicyleException e) {
				// TODO: handle exception
				System.err.println("编号:" + e.getCodeId() + ", " + e.getMsg());
			}
			this.ridingRecordOp();
			break;
		case 3:
			rt.getnoRidingRecord();
			this.ridingRecordOp();
			// 根据单车编号查询
			break;
		case 0:
			// 返回上一级

			break;

		default:
			break;
		}
	}

	// 参数设置方法
	public void update() {
		int i = meun.updateAdmin2();
		switch (i) {
		case 1:
			// 设置用户名
			System.out.println("请输入修改后的用户名");
			String str1 = InputUtil.getString();
			XmlUtil.updateAdmin("loginame", str1);
			this.update();
			break;
		case 2:
			// 设置密码
			System.out.println("请输入修改后的密码");
			String str2 = InputUtil.getString();
			XmlUtil.updateAdmin("password", str2);
			this.update();
			break;
		case 3:
			// 设置最大登录次数
			System.out.println("请输入修改后的最大登录次数");
			String str3 = InputUtil.getString();
			XmlUtil.updateAdmin("maxlogin", str3);
			this.update();
			break;
		case 0:
			// 返回上一级
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

	// 程序主入口。
	public static void main(String[] args) throws RiderException, BicyleException {
		Run run = new Run();
		run.star();
	}

}

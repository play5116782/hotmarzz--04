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
	//多态  创建RiderBuzzImpl对象 指向RiderBuzz类型
	RiderBuzz rb = new RiderBuzzImpl();
	BicycleBuzz bb = new BicycleBuzzImpl();
	//创建租车接口对象
	RentaBuzz renb = new RentaBuzzImpl();
	boolean b1 = true;
	int index = 3;
	
	public void star() throws InterruptedException{
		while(b1){
			int a = Menu.getMainInput();
			switch (a) {
			case 1:
				//模拟租车
				this.RentaOp();
				break;
			case 2:
				//管理员登录
				this.adminOp();
				break;
			case 0:
				//退出
				b1 = false;
				System.out.println("程序退出.");
				break;
			default:
				System.out.println("输入有误....");
				break;
			}
		}
	}
	
	//租车
	public void RentaOp() throws InterruptedException{
		System.out.println("获取租车人手机号码:");
		String phone = InputUtil.getString();
		//根据手机号查询用户
		Rider r = rb.getRiderByPhone(phone);
		//判断手机号是否存在
		if(r==null){
			System.out.println("该用户不存在...");
			return;
		}
		System.out.println("获取单车编号:");
		String no = InputUtil.getString();
		//根据单车编号查询单车
		Bicycle b = bb.getBicycleByNo(no);
		//判断单车是否存在
		if(b==null){
			System.out.println("单车编号错误...");
			return;
		}
		//开始租车 并返回一条骑行记录
		RidingRecord rr = renb.startRenta(r, b);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("开锁成功,车辆开始使用...");
		System.out.println("输入1,结束用车...");
		String s = InputUtil.getString();
		if("1".equals(s)){
			//结束租车
			renb.endRenta(rr);
		}
	}
	
	
	//管理员登录
	public void adminOp(){
		//现阶段 管理员用户名密码写死
		for(int i=1;i<=XmlUtil.getXmlAdmin().getMaxLogin();i++){
			User user = Menu.getLoginInput();
			if(XmlUtil.getXmlAdmin().getUserName().equals(user.getUserName())&&XmlUtil.getXmlAdmin().getPassword().equals(user.getPassword())){
				break;
			}else{
				System.out.println("用户名密码有误.还剩"+(XmlUtil.getXmlAdmin().getMaxLogin()-i)+"次。");
				if(i == XmlUtil.getXmlAdmin().getMaxLogin()){
					System.out.println("错误达到"+XmlUtil.getXmlAdmin().getMaxLogin()+"次,程序退出...");
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
			//骑行用户管理
			this.riderOp();//map
			break;
		case 2:
			//单车管理
			this.bicycleOp();//list
			break;
		case 3:
			//骑行记录管理
			this.RidingOp();
			break;
		case 4:
			//参数设置
			this.update();
			break;
		case 0:
			//返回上一级
			break;
		default:
			break;
		}
	}
	//参数设置方法
	public void update(){
		int a = Menu.updateAdmin();
		switch (a) {
		case 1:
			//获取键盘输入新的管理员登录名称
			System.out.println("请输入新的管理员用户名:");
			String newName = InputUtil.getString();
			//将newName方法到xml文件中
			XmlUtil.updateXmlAdmin(newName, "loginname");
			this.update();
			break;
		case 2:
			//获取键盘输入新的管理员登录名称
			System.out.println("请输入新的管理员密码:");
			String newPwd = InputUtil.getString();
			//将newName方法到xml文件中
			XmlUtil.updateXmlAdmin(newPwd, "password");
			this.update();
			break;
		case 3:
			//获取键盘输入新的管理员登录名称
			System.out.println("请输入新的管理员最大登录次数:");
			String newMax = InputUtil.getString();
			//将newName方法到xml文件中
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
	
	//骑行记录管理
	public void RidingOp(){
		int a = Menu.getRidingInput();
		switch (a) {
		case 1:
			System.out.println("骑行记录长度:"+DataInit.rr.size());
			break;

		default:
			break;
		}
	}
	
	//单车管理方法
	public void bicycleOp(){
		//调用单车界面方法
		int a = Menu.getBicycleInput();
		switch (a) {
		case 1:
			//单车查询
			bb.getAll();
			this.bicycleOp();
			break;
		case 2:
			//单车添加
			bb.add();
			this.bicycleOp();
			break;
		case 3:
			//单车修改(价格,时长)
			bb.update();
			this.bicycleOp();
			break;
		case 4:
			//单车删除
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
	
	//骑行用户管理方法
	public void riderOp(){
		int a = Menu.getRiderInput();
		switch (a) {
		case 1:
			//查询
			rb.getAll();
			this.riderOp();
			break;
		case 2:
			//添加
			try {
				rb.add();
			} catch (RiderException e) {
				System.err.println("异常信息:"+e.getMessage()+" 异常编码:"+e.getCodeId());
//				e.printStackTrace();
			}
			this.riderOp();
			break;
		case 3:
			break;
		case 4:
			//删除
			System.out.println("输入要删除用户的手机号,多个用户之间用逗号分隔...");
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

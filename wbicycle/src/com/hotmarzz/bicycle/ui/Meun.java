package com.hotmarzz.bicycle.ui;

/**
 * 菜单
 */
import java.util.Scanner;

import com.hotmarzz.bicycle.bean.User;

public class Meun {
	Scanner sc = new Scanner(System.in);

	// 开始界面 getMainInput
	public int getMainInput() {
		System.out.println("**********************");
		System.out.println();
		System.out.println("     欢迎来到单车系统");
		System.out.println();
		System.out.println(" 1模拟租车    2管理员登录   0退出");
		System.out.println();
		System.out.println("**********************");
		int i = sc.nextInt();
		return i;
	}

	// 登录界面
	public User getLoginInput() {
		System.out.println();
		System.out.println("******登录界面*****");
		System.out.println();
		System.out.println("请输入您的用户名:");
		System.out.println();
		String userName = sc.next();
		System.out.println();
		System.out.println("请输入您的密码:");
		System.out.println();
		String password = sc.next();
		User user = new User();
		user.setuserName(userName);
		user.setpassword(password);
		return user;
	}

	// 后台单车管理
	public int getAdminInput() {
		System.out.println("************");
		System.out.println();
		System.out.println("单车后台管理");
		System.out.println("1.骑行用户管理");
		System.out.println("2.单车管理");
		System.out.println("3.骑行记录管理");
		System.out.println("4.参数设置");
		System.out.println("0.返回主界面");
		System.out.println();
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// 参数设置界面
	// 后台单车管理
	public int updateAdmin2() {
		System.out.println("************");
		System.out.println();
		System.out.println("管理员登录参数设置管理");
		System.out.println("1.管理员登录用户设置");
		System.out.println("2.管理员登录密码设置");
		System.out.println("3.管理员登录最大登录次数设置");
		System.out.println("0.返回上一级");
		System.out.println();
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// 骑行用户界面
	public int getRiderInput() {
		System.out.println("************");
		System.out.println("成功登录用户管理");
		System.out.println("1.用户添加");
		System.out.println("2.用户删除");
		System.out.println("3.用户修改");
		System.out.println("4.用户查询");
		System.out.println("0.返回上一级");
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}

	// 单车管理界面
	public int getBicyleInput() {
		System.out.println("************");
		System.out.println("欢迎来到单车管理页面");
		System.out.println("1.单车添加");
		System.out.println("2.单车删除");
		System.out.println("3.单车修改");
		System.out.println("4.单车查询");
		System.out.println("5.返回上级");
		System.out.println("************");
		int i = sc.nextInt();
		return i;

	}

	// 骑行记录界面
	public int getRidingRecordInput() {
		System.out.println("************");
		System.out.println("欢迎来到骑行记录管理页面");
		System.out.println("1.查询全部骑行记录");
		System.out.println("2.根据手机号查询骑行记录");
		System.out.println("3.根据单车编号查询骑行用户");
		System.out.println("0.退出");
		System.out.println("************");
		int i = sc.nextInt();
		return i;
	}
}
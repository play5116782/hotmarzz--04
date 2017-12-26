package com.hotmarzz.bicycle.ui;

import java.util.Scanner;

import com.hotmarzz.bicycle.bean.User;

/**
 * 菜单类
 */
public class Menu {
	
	//首页
	public static int getMainInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("单车系统");
		System.out.println();
		System.out.println("请选择登录方式:1、模拟租车 2、管理员登录 0、退出");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//登录界面
	public static User getLoginInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println();
		System.out.println("请输入用户名:");
		String userName = sc.next();
		System.out.println();
		System.out.println("请输入密码:");
		String password = sc.next();
		System.out.println();
		System.out.println("************************************");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
	//后台管理界面
	public static int getAdminInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("单车后台管理");
		System.out.println();
		System.out.println("1、骑行用户管理");
		System.out.println("2、单车管理");
		System.out.println("3、骑行记录管理");
		System.out.println("4、参数设置");
		System.out.println("0、返回上一级");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//骑行用户界面
	public static int getRiderInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("骑行用户管理");
		System.out.println();
		System.out.println("1、用户查询");
		System.out.println("2、用户添加");
		System.out.println("3、用户修改");
		System.out.println("4、用户删除");
		System.out.println("5、返回上级");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//单车管理界面
	public static int getBicycleInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("单车管理管理");
		System.out.println();
		System.out.println("1、单车查询");
		System.out.println("2、单车添加");
		System.out.println("3、单车修改");
		System.out.println("4、单车删除");
		System.out.println("5、返回上级");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//骑行记录界面
	public static int getRidingInput(){
		System.out.println("************************************");
		System.out.println();
		System.out.println("骑行记录管理");
		System.out.println();
		System.out.println("1、查询全部记录");
		System.out.println("2、根据手机号查询记录");
		System.out.println("3、根据单车编号查询记录");
		System.out.println("0、返回上级");
		System.out.println();
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	//骑行记录界面
		public static int updateAdmin(){
			System.out.println("************************************");
			System.out.println();
			System.out.println("参数设置");
			System.out.println();
			System.out.println("1、修改管理员登录名称");
			System.out.println("2、修改管理员登录密码");
			System.out.println("3、修改管理员最大登录次数");
			System.out.println("0、返回上级");
			System.out.println();
			System.out.println("************************************");
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		}	
}

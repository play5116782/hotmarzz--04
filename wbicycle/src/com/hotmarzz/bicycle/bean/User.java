package com.hotmarzz.bicycle.bean;

/**
 * 管理员信息封装类
 * 
 * @author Administrator
 *
 */
public class User {
	// 管理员 的用户名
	private String userName;
	// 管理员的密码
	private String password;
	private int maxlogin;

	public int getMaxlogin() {
		return maxlogin;
	}

	public void setMaxlogin(int maxlogin) {
		this.maxlogin = maxlogin;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}

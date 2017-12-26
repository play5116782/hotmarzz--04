package com.hotmarzz.bicycle.bean;


/**
 * 管理员信息类
 * @author Administrator
 *
 */
public class User {
	//管理员的用户名
	private String userName;
	//管理员密码
	private String password;
	//最大登录次数
	private int maxLogin;
	
	
	public int getMaxLogin() {
		return maxLogin;
	}
	public void setMaxLogin(int maxLogin) {
		this.maxLogin = maxLogin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

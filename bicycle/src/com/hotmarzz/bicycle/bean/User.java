package com.hotmarzz.bicycle.bean;


/**
 * ����Ա��Ϣ��
 * @author Administrator
 *
 */
public class User {
	//����Ա���û���
	private String userName;
	//����Ա����
	private String password;
	//����¼����
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

package com.hotmarzz.bicycle.bean;

/**
 * ����Ա��Ϣ��װ��
 * 
 * @author Administrator
 *
 */
public class User {
	// ����Ա ���û���
	private String userName;
	// ����Ա������
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

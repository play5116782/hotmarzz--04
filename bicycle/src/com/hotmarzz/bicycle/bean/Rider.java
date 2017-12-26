package com.hotmarzz.bicycle.bean;


/**
 * �����û���װ��
 * @author Administrator
 *
 */
public class Rider {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String phone;
	
	//�����вι��췽��  �����������ж������Եĳ�ʼ��
	public Rider(String name,String sex,int age,String phone){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}
	
	public Rider(){
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//��дequals
	@Override
	public boolean equals(Object obj) {
		//�жϲ����Ƿ�Ϊnull
		if(obj==null){
			return false;
		}
		//�ж��Ƿ�Ϊһ������
		if(this==obj){
			return true;
		}
		//�ж��Ƿ���ͬ���µ���
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		if(obj instanceof Rider){
			//����ת��
			Rider rider = (Rider) obj;
			if(phone.equals(rider.getPhone())){
				return true;
			}
		}
		return false;
	}
}

package com.hotmarzz.bicycle.bean;

//骑行封装类
public class Rider {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String phone;

	public Rider(String name, String sex, int age, String phone) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}

	public Rider() {

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

	@Override
	public String toString() {
		return name + "\t" + sex + "\t" + age + "\t" + phone;

	}

	// 重写equals
	@Override
	public boolean equals(Object obj) {
		// 判断参数是否为null
		if (obj == null) {
			return false;
		}
		// 判断是否为一个引用
		if (this == obj) {
			return true;
		}
		// 判断是否是同包下的类
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof Rider) {
			// 向下转型
			Rider rider = (Rider) obj;
			if (phone.equals(rider.getPhone())) {
				return true;
			}
		}
		return false;
	}
}

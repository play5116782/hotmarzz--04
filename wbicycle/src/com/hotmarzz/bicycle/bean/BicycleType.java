package com.hotmarzz.bicycle.bean;

/**
 * ��������
 * 
 * @author Administrator
 *
 */
public class BicycleType {
	// ��������
	private String name;
	// �������ۣ��԰�Сʱ���㣩
	private double cost;

	public BicycleType(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public BicycleType() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}

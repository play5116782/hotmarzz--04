package com.hotmarzz.bicycle.bean;

/**
 * 单车类型
 * 
 * @author Administrator
 *
 */
public class BicycleType {
	// 单车名称
	private String name;
	// 单车单价（以半小时计算）
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

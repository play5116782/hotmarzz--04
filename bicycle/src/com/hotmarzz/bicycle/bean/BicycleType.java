package com.hotmarzz.bicycle.bean;


/*
 * 单车类型
 */
public class BicycleType {
	//单车名称
	private String name;
	//单车单价(半小时为单位)
	private double cost;
	
	public BicycleType(){
		
	}
	
	public BicycleType(String name,double cost){
		this.name = name;
		this.cost = cost;
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

package com.hotmarzz.bicycle.bean;


/*
 * ��������
 */
public class BicycleType {
	//��������
	private String name;
	//��������(��СʱΪ��λ)
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

package com.hotmarzz.bicycle.bean;

import java.util.Date;

/**
 * 骑行记录
 * @author Administrator
 *
 */
public class RidingRecord {
	
	//骑行用户
	private Rider rider;
	//单车用户
	private Bicycle bicycle;
	//开始坐标
	private Coordinate startCoord;
	//结束坐标
	private Coordinate endCoord;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//总花费
	private double cost;
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public Coordinate getStartCoord() {
		return startCoord;
	}
	public void setStartCoord(Coordinate startCoord) {
		this.startCoord = startCoord;
	}
	public Coordinate getEndCoord() {
		return endCoord;
	}
	public void setEndCoord(Coordinate endCoord) {
		this.endCoord = endCoord;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}

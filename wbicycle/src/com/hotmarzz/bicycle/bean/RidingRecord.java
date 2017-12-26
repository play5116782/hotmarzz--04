package com.hotmarzz.bicycle.bean;

import java.util.Date;

import com.hotmarzz.bicyle.util.DateUtil;

public class RidingRecord {
	// 骑行用户
	private Rider rider;
	// 单车用户
	private Bicycle bicyle;
	// 开始坐标
	private Coordinate startCoord;
	// 结束坐标
	private Coordinate endCoord;
	// 开始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	// 总花费
	private double cost;

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Bicycle getBicyle() {
		return bicyle;
	}

	public void setBicyle(Bicycle bicyle) {
		this.bicyle = bicyle;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rider.getPhone() + "\t" + bicyle.getNo() + "\t" + DateUtil.getDateString(startTime) + "\t" + "("
				+ startCoord.getLongitude() + "," + startCoord.getLatitude() + ")" + "\t" + "\t"
				+ DateUtil.getDateString(endTime) + "\t" + "(" + endCoord.getLongitude() + "," + endCoord.getLatitude()
				+ ")" + "\t" + cost;

	}

	// 定义一个计算骑行时长的方法
	public double riderTime(Date startTime, Date endTime) {
		// 返回一个骑行时间的毫秒数。
		return endTime.getTime() - startTime.getTime();
	}

}

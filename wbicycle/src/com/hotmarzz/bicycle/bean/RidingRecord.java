package com.hotmarzz.bicycle.bean;

import java.util.Date;

import com.hotmarzz.bicyle.util.DateUtil;

public class RidingRecord {
	// �����û�
	private Rider rider;
	// �����û�
	private Bicycle bicyle;
	// ��ʼ����
	private Coordinate startCoord;
	// ��������
	private Coordinate endCoord;
	// ��ʼʱ��
	private Date startTime;
	// ����ʱ��
	private Date endTime;
	// �ܻ���
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

	// ����һ����������ʱ���ķ���
	public double riderTime(Date startTime, Date endTime) {
		// ����һ������ʱ��ĺ�������
		return endTime.getTime() - startTime.getTime();
	}

}

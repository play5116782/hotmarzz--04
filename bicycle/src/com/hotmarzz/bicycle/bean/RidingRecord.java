package com.hotmarzz.bicycle.bean;

import java.util.Date;

/**
 * ���м�¼
 * @author Administrator
 *
 */
public class RidingRecord {
	
	//�����û�
	private Rider rider;
	//�����û�
	private Bicycle bicycle;
	//��ʼ����
	private Coordinate startCoord;
	//��������
	private Coordinate endCoord;
	//��ʼʱ��
	private Date startTime;
	//����ʱ��
	private Date endTime;
	//�ܻ���
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

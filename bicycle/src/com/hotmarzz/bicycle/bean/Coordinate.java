package com.hotmarzz.bicycle.bean;


/**
 * ��������
 * @author Administrator
 *
 */
public class Coordinate {
	//����
	private double longitude;
	//γ��
	private double latitude;
	
	public Coordinate (){
		
	}
	
	public Coordinate (double lg,double lt){
		this.longitude = lg;
		this.latitude = lt;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}

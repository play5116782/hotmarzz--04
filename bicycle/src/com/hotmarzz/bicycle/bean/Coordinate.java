package com.hotmarzz.bicycle.bean;


/**
 * 单车坐标
 * @author Administrator
 *
 */
public class Coordinate {
	//经度
	private double longitude;
	//纬度
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

package com.hotmarzz.bicycle.bean;
	
/**
 * 单车坐标
 * @author Administrator
 *
 */
public class Coordinate {
	//单车经度
	private double longitude;
	//单车纬度
	private double latitude;
	public Coordinate(){
		
	}
	public Coordinate(double longitude,double latitude){
		this.longitude=longitude;
		this.latitude=latitude;
		
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

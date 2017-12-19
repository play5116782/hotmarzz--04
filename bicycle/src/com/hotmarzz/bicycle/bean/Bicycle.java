package com.hotmarzz.bicycle.bean;

public class Bicycle {
	//单车编号
	private String no;
	//使用时长
	private long utilitySecond;
	//单车类型
	private BicycleType bt;
	//单车坐标
	private Coordinate cd;
	
	public Bicycle(){
		
	}
	//定义有参构造方法 来进行属性的初始化
	public Bicycle(String no,long us,BicycleType bt,Coordinate cd){
		this.no = no;
		this.utilitySecond = us;
		this.bt = bt;
		this.cd = cd;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public long getUtilitySecond() {
		return utilitySecond;
	}
	public void setUtilitySecond(long utilitySecond) {
		this.utilitySecond = utilitySecond;
	}
	public BicycleType getBt() {
		return bt;
	}
	public void setBt(BicycleType bt) {
		this.bt = bt;
	}
	public Coordinate getCd() {
		return cd;
	}
	public void setCd(Coordinate cd) {
		this.cd = cd;
	}
}

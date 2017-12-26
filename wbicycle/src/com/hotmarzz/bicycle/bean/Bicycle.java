package com.hotmarzz.bicycle.bean;

public class Bicycle {
	//单车ID
	private int id;
	// 单车编号
	private String no;
	// 骑行时长
	private long utilitySecond;
	// 单车类型
	private BicycleType bt;

	// 单车的位置
	private Coordinate cd;

	public Bicycle() {

	}

	public Bicycle(String no, long utilitySecond, BicycleType bt, Coordinate cd) {
		this.no = no;
		this.utilitySecond = utilitySecond;
		this.bt = bt;
		this.cd = cd;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no + "\t" + utilitySecond + "\t" + bt.getName() + "\t" + bt.getCost() + "\t" + cd.getLongitude() + "\t"
				+ cd.getLatitude();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

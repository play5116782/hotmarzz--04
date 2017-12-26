package com.hotmarzz.bicycle.bean;

public class Bicycle {
	//����ID
	private int id;
	// �������
	private String no;
	// ����ʱ��
	private long utilitySecond;
	// ��������
	private BicycleType bt;

	// ������λ��
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

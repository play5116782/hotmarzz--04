package com.hotmarzz.bicycle.bean;

public class Bicycle {
	//�������
	private String no;
	//ʹ��ʱ��
	private long utilitySecond;
	//��������
	private BicycleType bt;
	//��������
	private Coordinate cd;
	
	public Bicycle(){
		
	}
	//�����вι��췽�� ���������Եĳ�ʼ��
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

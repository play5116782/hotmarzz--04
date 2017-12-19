package com.hotmarzz.bicycle.exception;

public class RiderException extends Exception{
	
	//异常编号
	private int codeId;
	//异常信息
	private String msg;
	
	public int getCodeId() {
		return codeId;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public RiderException(int codeId,String msg){
		super(msg);
		this.codeId = codeId;
		this.msg = msg;
	}
	
}

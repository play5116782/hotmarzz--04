package com.hotmarzz.bicycle.exception;

public class RiderException extends Exception{
	
	//�쳣���
	private int codeId;
	//�쳣��Ϣ
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

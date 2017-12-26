package com.hotmarzz.bicyle.exception;



public class RiderException extends Exception{

	private int codeId;
	private String msg;
	public int getCodeId() {
		return codeId;
	}
	
	public String getMsg() {
		return msg;
	}
	public RiderException(int codeId,String msg){
		super(msg);
		this.codeId=codeId;
		this.msg=msg;
				
	}
	public RiderException(){
		
	}
	
	
}

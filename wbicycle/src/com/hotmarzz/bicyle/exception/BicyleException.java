package com.hotmarzz.bicyle.exception;

public class BicyleException extends Exception{
	private int codeId;
	private String msg;
	public int getCodeId(){
		return codeId;
	}
	public String getMsg(){
		return msg;
	}
	public BicyleException(int codeId,String msg){
		super(msg);
		this.codeId=codeId;
		this.msg=msg;
				
	}
	public BicyleException(){
		
	}
}

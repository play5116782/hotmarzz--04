package com.hotmarzz.bicyle.buzz;

import java.util.List;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicyle.exception.RiderException;

/**
 * 骑行用户接口
 * @author Administrator
 *
 */
public interface Riderbuzz  {
	//全部查询
	void getAll();
	//根据手机号码查询
	void getphone3();
	//添加
	void add() throws RiderException; 
	void updata() throws RiderException;
	//可批量删除用户信息。
	void delete();
	//根据参数的手机号码返回数据库中骑行用户的对象
	Rider getRiderByPhone(String phone);
	//放入多个手机号码 返回对应号码的用户集合
	List<Rider> getriderphones(String phones);
}

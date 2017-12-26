package com.hotmarzz.bicycle.buzz;

import java.util.List;

import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.exception.RiderException;

/**
 * 骑行用户接口
 * @author Administrator
 *
 */
public interface RiderBuzz {
	
	//查询
	void getAll();
	//添加
	Rider add() throws RiderException;
	//根据手机号查询用户
	Rider getRiderByPhone(String phone);
	//删除
	void delete(List<Rider> list);
	//根据多个手机号查询多个用户
	List<Rider> getList(String[] phones);
}

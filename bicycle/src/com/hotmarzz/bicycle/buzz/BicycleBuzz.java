package com.hotmarzz.bicycle.buzz;

import com.hotmarzz.bicycle.bean.Bicycle;

public interface BicycleBuzz {
	
	void getAll();
	void add();
	//单车删除
	void delete();
	//根据单车编号查询单车
	Bicycle getBicycleByNo(String no);
	//单车修改 价格 时长
	void update();
}

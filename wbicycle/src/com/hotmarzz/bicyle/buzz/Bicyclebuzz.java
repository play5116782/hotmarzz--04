package com.hotmarzz.bicyle.buzz;

import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.RidingRecord;

public interface Bicyclebuzz {
	//全部查询
	void getAll() ;
	//单车添加
	Bicycle add();
	//根据单车编号获得单车对象
	Bicycle bicyleNo(String s);
	//单车删除
	void delete();
	//单车修改
	void updata();

}

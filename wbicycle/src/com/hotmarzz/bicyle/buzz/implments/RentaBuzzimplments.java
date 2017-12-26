package com.hotmarzz.bicyle.buzz.implments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import com.hotmarzz.bicycle.bean.Bicycle;
import com.hotmarzz.bicycle.bean.Coordinate;
import com.hotmarzz.bicycle.bean.Rider;
import com.hotmarzz.bicycle.bean.RidingRecord;
import com.hotmarzz.bicycle.main.DataInit;
import com.hotmarzz.bicyle.buzz.Bicyclebuzz;
import com.hotmarzz.bicyle.buzz.RentaBuzz;
import com.hotmarzz.bicyle.buzz.Riderbuzz;
import com.hotmarzz.bicyle.exception.BicyleException;
import com.hotmarzz.bicyle.util.InputUtil;
import com.hotmarzz.bicyle.util.NumberUtil;
import com.hotmarzz.bicyle.util.RegexUtil;
import com.hotmarzz.bicyle.util.SqlUtil;

public class RentaBuzzimplments implements RentaBuzz {

		Riderbuzz rb = new RiderBuzzimplments();
		Bicyclebuzz be = new BicycleBuzzimplments();
	@Override
	public RidingRecord startRenta(Rider rider, Bicycle bicyle) {
		// TODO Auto-generated method stub
		System.out.println("开锁成功，开始用车");
		//租车用户
		Rider r = rider;
		//租的单车
		Bicycle b = bicyle;
		//租车开始时间
		Date startTime = new Date();
		//租车开始坐标
		Coordinate  startCoord=  new Coordinate (NumberUtil.getCoor(),NumberUtil.getCoor());
		RidingRecord rr = new RidingRecord();
		rr.setRider(r);
		rr.setBicyle(b);
		rr.setStartTime(startTime);
		rr.setStartCoord(startCoord);
		return rr;
	
}

	@Override
	public void endRenta(RidingRecord rr) {
		// TODO Auto-generated method stub
		//按1结束租车!
		System.out.println("车辆使用中,按1结束租车!");
		int a =  InputUtil.getInt();
		if(a==1){
			//租车结束。
			//添加线程的睡眠方法  自带异常 需要处理
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("3");
			//添加线程的睡眠方法  自带异常 需要处理
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2");
			//添加线程的睡眠方法  自带异常 需要处理
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1");
			//添加线程的睡眠方法  自带异常 需要处理
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//结束时的时间
			Date endTime = new Date();
			//结束时的坐标
			Coordinate  endCoord=  new Coordinate (NumberUtil.getCoor(),NumberUtil.getCoor());
			//把数据放到记录里面
			rr.setEndTime(endTime);
			rr.setEndCoord(endCoord);
			this.cs(rr);
	
			//总花费	
			Double cost=this.getCost(rr.getStartTime(), rr.getEndTime(), rr.getBicyle());
			rr.setCost(cost);
			//把记录添加进集合。
			DataInit.rr.add(rr);
			System.out.println("车辆上锁，用车结束,感谢使用!");
			System.out.println("用户:"+rr.getRider().getPhone()+"     骑行花费总金额 :￥" +rr.getCost());
			
		}
		
	}

	@Override
	public Double getCost(Date startTime,Date endTime,Bicycle bicyle ) {
		//getTime() --把时间转换成long型的毫秒数
		//把时间换成半小时。
		
		double dou = (double)(endTime.getTime()-startTime.getTime())/1000/60/30;
		//计算总费用
		double getCost = Math.ceil(dou)*bicyle.getBt().getCost();
		
		
		return getCost;
	}
//查询全部记录
	@Override
	public void getAllRidingRecord() {
		// TODO Auto-generated method stub
		if(DataInit.rr.size()==0){
			System.out.println("目前还没有记录产生");
		}else{
			
		System.out.println("用户\t\t租车编号\t\t租车开始时间\t\t租车开始坐标\t\t租车结束时间\t\t租车结束坐标\t总费用(元)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(ridingrecord==null)
				System.out.println("目前还没有记录产生");
			System.out.println(ridingrecord);
		}
		
	}
	}
//根据手机号码进行查询
	@Override
	public void getPhoneRidingRecord() throws BicyleException {
		// TODO Auto-generated method stub
		System.out.println("请输入用户的手机号:(在系统中唯一)");
		String phone = RegexUtil.getStringRegex(RegexUtil.PHONE_REGEX, RegexUtil.PHONE_DISPLAY);
		Rider r= rb.getRiderByPhone(phone);
		if(r==null){
			System.out.println("该用户不存在");
			return ;
		}
		if(DataInit.rr.size()==0){
			System.out.println("目前还没有记录产生");
		}else{
		System.out.println("用户\t\t租车编号\t\t租车开始时间\t\t租车开始坐标\t\t租车结束时间\t\t租车结束坐标\t总费用(元)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(r.getPhone().equals(ridingrecord.getRider().getPhone())){
			double d  =	ridingrecord.riderTime(ridingrecord.getStartTime(), ridingrecord.getEndTime());
					d=0+d;
				
				System.out.println(ridingrecord);
				if(d>3000){
					throw new BicyleException(2, "欢迎黑玛老客户");
				}
				if(d==0){
					System.out.println("该用户还没有记录产生");
				}
			}
			
		}
		
		}
	}
//根据单车编号查询
	@Override
	public void getnoRidingRecord() {
		// TODO Auto-generated method stub
		System.out.println("请输入单车编号");
		String str = InputUtil.getString();
		Bicycle b = be.bicyleNo(str);
		if(b==null){
			System.out.println("目前还没有该编号的单车记录产生");
			return;
		}
		if(DataInit.rr.size()==0){
			System.out.println("目前还没有记录产生");
		}else{
		System.out.println("用户\t\t租车编号\t\t租车开始时间\t\t租车开始坐标\t\t租车结束时间\t\t租车结束坐标\t总费用(元)");
		for (RidingRecord ridingrecord : DataInit.rr) {
			if(b.getNo().equals(ridingrecord.getBicyle().getNo())){	
			System.out.println(ridingrecord);
			}
			
		}
		}	
		
	}
	//更新所租单车的骑行时间
	public void cs(RidingRecord rr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		long a = rr.getEndTime().getTime()-rr.getStartTime().getTime();
		conn = SqlUtil.getConn();
		try {
			ps = conn.prepareStatement("update tb_bicycle set utilitySecond=? where id=?");
			ps.setLong(1, a+rr.getBicyle().getUtilitySecond());
			ps.setInt(2, rr.getBicyle().getId());
			int i = ps.executeUpdate();
			if(i==1){
				System.out.println("时长更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlUtil.close(conn, ps, null);
		}
	}

	

}

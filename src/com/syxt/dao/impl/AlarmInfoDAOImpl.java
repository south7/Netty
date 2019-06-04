package com.syxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import com.syxt.dao.IAlarmInfoDAO;
import com.syxt.vo.AlarmInfo;

public class AlarmInfoDAOImpl implements IAlarmInfoDAO {

	    private Connection conn;
	    private PreparedStatement pstmt;
	   
	    public AlarmInfoDAOImpl(Connection conn){
	    	this.conn=conn;
	    }
		@Override
		public boolean doCreate(AlarmInfo vo) throws Exception {
			String sql="INSERT INTO structalgresw(ip,dspstate,alarm_probability,coor_top,coor_left,coor_bottom,coor_right,alarm_type,is_alarm,ch_num,alarm_date)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getIp());
			this.pstmt.setInt(2, vo.getDspstate());
			this.pstmt.setFloat(3, vo.getAlarm_probability());
			this.pstmt.setInt(4, vo.getTop());
			this.pstmt.setInt(5, vo.getLeft());
			this.pstmt.setInt(6, vo.getBottom());
			this.pstmt.setInt(7, vo.getRight());
			this.pstmt.setInt(8, vo.getAlarm_type());
			this.pstmt.setInt(9, vo.getIs_alarm());
			this.pstmt.setInt(10, vo.getCh_num());
			this.pstmt.setString(11, vo.getAlarm_date());
			return this.pstmt.executeUpdate()>0;
		}

		@Override
		public boolean doUpdate(AlarmInfo vo) throws Exception {
			String sql="UPDATE structalgresw SET dspstate=?,alarm_probability=?,coor_top=?,coor_left=?,coor_bottom=?,coor_right=?,alarm_type=?,is_alarm=?,ch_num=?,alarm_date=? WHERE ip=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, vo.getDspstate());
			this.pstmt.setFloat(2, vo.getAlarm_probability());
			this.pstmt.setInt(3, vo.getTop());
			this.pstmt.setInt(4, vo.getLeft());
			this.pstmt.setInt(5, vo.getBottom());
			this.pstmt.setInt(6, vo.getRight());
			this.pstmt.setInt(7, vo.getAlarm_type());
			this.pstmt.setInt(8, vo.getIs_alarm());
			this.pstmt.setInt(9, vo.getCh_num());
			this.pstmt.setString(10, vo.getAlarm_date());
			this.pstmt.setString(11, vo.getIp());
			return this.pstmt.executeUpdate()>0;
		}
		
		@Override
		public boolean doRemoveBatch(Set<String> ids) throws Exception {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public AlarmInfo findById(String ip) throws Exception {
			AlarmInfo vo=null;
			String sql="SELECT ip FROM structalgresw WHERE ip=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, ip);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){
				vo=new AlarmInfo();
				vo.setIp(rs.getString(1));
			}
			return vo;
		}
		@Override
		public List<AlarmInfo> findAll() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<AlarmInfo> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
				throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Integer findAllCount(String column, String keyWord) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean doUpdate() throws Exception {
			// TODO Auto-generated method stub
			return false;
		}


	

}

package com.syxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Set;

import com.syxt.dao.IDeviceDAO;
import com.syxt.vo.Device;

public class DeviceDAOImpl implements IDeviceDAO {
	    private Connection conn;
	    private PreparedStatement pstmt;
	   
	    public DeviceDAOImpl(Connection conn){
	    	this.conn=conn;
	    }
	@Override
	public boolean doCreate(Device vo) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(Device vo) throws Exception {
		String sql="UPDATE device SET is_online=? WHERE ip=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getIs_onLine());
		this.pstmt.setString(2, vo.getClientIP());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws Exception {
		return false;
	}

	@Override
	public Device findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package com.syxt.factory;

import java.sql.Connection;

import com.syxt.dao.IDeviceDAO;
import com.syxt.dao.IAlarmInfoDAO;
import com.syxt.dao.impl.DeviceDAOImpl;
import com.syxt.dao.impl.AlarmInfoDAOImpl;


public class DAOFactory {

	public static IAlarmInfoDAO getIAlarmInfoDAOInstance(Connection conn){
		return new AlarmInfoDAOImpl(conn);
	}

	public static IDeviceDAO getIDeviceDAOInstance(Connection conn) {
		return new DeviceDAOImpl(conn);
	}
	
}

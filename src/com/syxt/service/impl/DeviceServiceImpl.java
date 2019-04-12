package com.syxt.service.impl;

import com.syxt.dbc.DatabaseConnection;
import com.syxt.factory.DAOFactory;
import com.syxt.service.IDeviceService;
import com.syxt.vo.Device;

public class DeviceServiceImpl implements IDeviceService {
    private DatabaseConnection dbc=new DatabaseConnection();

	@Override
	public boolean update(Device vo) throws Exception {
		try {
			 return DAOFactory.getIDeviceDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	
	

}

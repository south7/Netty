package com.syxt.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.syxt.dbc.DatabaseConnection;
import com.syxt.factory.DAOFactory;
import com.syxt.service.IAlarmInfoService;
import com.syxt.vo.AlarmInfo;

public class AlarmInfoServiceImpl implements IAlarmInfoService {
    private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean insert(AlarmInfo vo) throws Exception {
		try {
			if(null==DAOFactory.getIAlarmInfoDAOInstance(this.dbc.getConnection()).findById(vo.getIp())){
				return DAOFactory.getIAlarmInfoDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public boolean update(AlarmInfo vo) throws Exception {
		try {
			 return DAOFactory.getIAlarmInfoDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}


	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AlarmInfo get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlarmInfo> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.syxt.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.syxt.dbc.DatabaseConnection;
import com.syxt.factory.DAOFactory;
import com.syxt.service.IStructAlgResWService;
import com.syxt.vo.StructAlgResW;

public class StructAlgResWServiceImpl implements IStructAlgResWService {
    private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean insert(StructAlgResW vo) throws Exception {
		try {
			if(null==DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findById(vo.getIp())){
				return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public boolean update(StructAlgResW vo) throws Exception {
		try {
			 return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doUpdate(vo);
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
	public StructAlgResW get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StructAlgResW> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

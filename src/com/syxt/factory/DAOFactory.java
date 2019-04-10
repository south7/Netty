package com.syxt.factory;

import java.sql.Connection;

import com.syxt.dao.IStructAlgResWDAO;
import com.syxt.dao.impl.StructAlgResWDAOImpl;


public class DAOFactory {

	public static IStructAlgResWDAO getIEmpDAOInstance(Connection conn){
		return new StructAlgResWDAOImpl(conn);
	}
	
}

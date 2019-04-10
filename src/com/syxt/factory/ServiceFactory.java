package com.syxt.factory;

import com.syxt.service.IStructAlgResWService;
import com.syxt.service.impl.StructAlgResWServiceImpl;


public class ServiceFactory {
	public static IStructAlgResWService getIEmpServiceInstance(){
		return new StructAlgResWServiceImpl();
	}
	
}

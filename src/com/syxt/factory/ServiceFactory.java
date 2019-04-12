package com.syxt.factory;

import com.syxt.service.IDeviceService;
import com.syxt.service.IAlarmInfoService;
import com.syxt.service.impl.DeviceServiceImpl;
import com.syxt.service.impl.AlarmInfoServiceImpl;


public class ServiceFactory {
	public static IAlarmInfoService getIAlarmInfoServiceInstance(){
		return new AlarmInfoServiceImpl();
	}
	public static IDeviceService getIDeviceServiceInstance(){
		return new DeviceServiceImpl();
	}
}

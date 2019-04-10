package com.syxt.test.junit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syxt.factory.ServiceFactory;
import com.syxt.service.impl.StructAlgResWServiceImpl;
import com.syxt.vo.StructAlgResW;

import junit.framework.TestCase;

public class IStructAlgResWServiceTest {
    private static final Logger logger=LoggerFactory.getLogger(StructAlgResWServiceImpl.class);
	@Test
	public void testInsert() {
		StructAlgResW vo=new StructAlgResW();
		vo.setIp("192.168.0.1");
		vo.setDspstate(1);
		vo.setAlarm_probability(0.1f);
		vo.setTop(10);
		vo.setLeft(20);
		vo.setBottom(30);
		vo.setRight(40);
		vo.setAlarm_type(1);
		vo.setIs_alarm(1);
		vo.setCh_num(100);
		vo.setAlarm_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
		} catch (Exception e) {
			logger.error("插入数据测试异常",e);
		}
	}

	@Test
	public void testUpdate() {
		StructAlgResW vo=new StructAlgResW();
		vo.setIp("192.168.0.1");
		vo.setDspstate(1);
		vo.setAlarm_probability(1.1f);
		vo.setTop(10);
		vo.setLeft(20);
		vo.setBottom(30);
		vo.setRight(40);
		vo.setAlarm_type(1);
		vo.setIs_alarm(0);
		vo.setCh_num(100);
		vo.setAlarm_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
			logger.debug("修改数据测试");
		} catch (Exception e) {
			logger.error("修改数据测试异常",e);
		}
	}
}

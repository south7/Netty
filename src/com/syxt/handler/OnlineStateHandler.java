package com.syxt.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syxt.factory.ServiceFactory;
import com.syxt.vo.Device;

/**
 * 摄像机在线，离线转态判断 
 * NettyServerHandler channelActive设置为在线 
 * NettyServerHandler channelInactive设置为离线
 * @author wangfan
 *
 */
public class OnlineStateHandler {
	private static final Logger logger = LoggerFactory.getLogger(OnlineStateHandler.class);

	public void setOnline(String ip) {
		try {
			Device vo = new Device();
			vo.setClientIP(ip);
			vo.setIs_onLine(1);
			vo.setStateChange_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			if (ServiceFactory.getIDeviceServiceInstance().update(vo)) {
				logger.info("摄像机ip: " + ip + " 设置为在线状态成功");
			} else {
				logger.error("摄像机ip: " + ip + " 设置为在线状态失败");
			}
		} catch (Exception e) {
			logger.error("摄像机设置为在线状态异常", e);
		}
	}

	public void setOffline(String ip) {
		try {
			Device vo = new Device();
			vo.setClientIP(ip);
			vo.setIs_onLine(0);
			vo.setStateChange_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			if (ServiceFactory.getIDeviceServiceInstance().update(vo)) {
				logger.info("摄像机ip: " + ip + " 设置为离线状态成功");
			} else {
				logger.error("摄像机ip: " + ip + " 设置为离线状态失败");
			}
		} catch (Exception e) {
			logger.error("摄像机设置为离线状态异常", e);
		}

	}
	public void setOffline() {
		try {
			if (ServiceFactory.getIDeviceServiceInstance().update()) {
				logger.info("服务启动后设置所有相机为离线状态成功");
			} else {
				logger.error("服务启动后设置所有相机为离线状态失败");
			}
		} catch (Exception e) {
			logger.error("服务启动后设置所有相机为离线状态异常", e);
		}

	}
}

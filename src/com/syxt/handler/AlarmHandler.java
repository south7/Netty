package com.syxt.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syxt.factory.ServiceFactory;
import com.syxt.vo.AlarmInfo;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

/**
 * 处理设备发送过来的报警消息
 * @author wangfan
 *
 */
public class AlarmHandler {
    private static final Logger logger=LoggerFactory.getLogger(AlarmHandler.class);

	public static void handle(ByteBuf data,String clientIP){
	    try {
			long dspstate = data.readUnsignedIntLE();
			float alarm_probability = data.readFloatLE();
			ByteBuf readBytes = data.readSlice(8);
			long top_left_x = readBytes.readUnsignedIntLE();
			long top_left_y = readBytes.readUnsignedIntLE();
			ByteBuf readBytes2 = data.readSlice(8);
			long bottom_right_x = readBytes2.readUnsignedIntLE();
			long bottom_right_y = readBytes2.readUnsignedIntLE();
			int alarm_type = data.readIntLE();
			int is_alarm = data.readIntLE();
			int ch_num = data.readIntLE();
			AlarmInfo vo=new AlarmInfo();
			vo.setIp(clientIP);
			vo.setDspstate((int)dspstate);
			vo.setAlarm_probability(alarm_probability);
			vo.setTop((int)top_left_x);
			vo.setLeft((int)top_left_y);
			vo.setBottom((int)bottom_right_x);
			vo.setRight((int)bottom_right_y);
			vo.setAlarm_type(alarm_type);
			vo.setIs_alarm(is_alarm);
			vo.setCh_num(ch_num);
			vo.setAlarm_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			if(ServiceFactory.getIAlarmInfoServiceInstance().insert(vo)){
				if(is_alarm==1)
				logger.warn("收到设备IP"+clientIP+"报警");
			}else{
				if(ServiceFactory.getIAlarmInfoServiceInstance().update(vo)){
					if(is_alarm==1)
					logger.warn("收到设备IP"+clientIP+"报警");
				}else{
					logger.error("修改设备IP"+clientIP+"报警报文失败,is_alarm:"+is_alarm+"");
				}
			}
		} catch (Exception e) {
			logger.error("处理设备发送过来的报警消息异常",e);
		}finally{
			ReferenceCountUtil.release(data);
		}
	}
}

package com.syxt.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.syxt.vo.AlarmInfo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf>{
    private static final Logger logger=LoggerFactory.getLogger(NettyClientHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		logger.info("NettyClientHandler channelRead0: "+msg.toString(CharsetUtil.UTF_8));		
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyClientHandler channelActive");
		//ctx.writeAndFlush(Unpooled.copiedBuffer(getTransportObject(),CharsetUtil.UTF_8));
		ctx.writeAndFlush(getTransportObject());
		
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyClientHandler channelReadComplete");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("NettyClientHandler异常",cause);
	}
	
	private AlarmInfo getTransportObject() {
		AlarmInfo sa=new AlarmInfo();
		sa.setIs_alarm(1);
		sa.setAlarm_probability(0.0f);
		sa.setAlarm_type(1);
		sa.setCh_num(22);
		sa.setTop(10);
		sa.setLeft(20);
		sa.setBottom(30);
		sa.setRight(30);
		sa.setDspstate(3);
		return sa;
	}
}

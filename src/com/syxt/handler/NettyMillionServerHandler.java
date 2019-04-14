package com.syxt.handler;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyMillionServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger logger=LoggerFactory.getLogger(NettyMillionServerHandler.class);
    private static final AtomicInteger atomicInteger=new AtomicInteger();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		atomicInteger.incrementAndGet();
		logger.debug(atomicInteger.get()+" , 客户端ip: "+ctx.channel().remoteAddress());
	}



}

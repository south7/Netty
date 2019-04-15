package com.syxt.handler;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger logger=LoggerFactory.getLogger(NettyServerHandler.class);
    private static final AtomicInteger atomicInteger=new AtomicInteger();
    //private int counter;
    static{
    	logger.info("统计客户端连接数线程启动");
    	Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				logger.info("当前客户端连接数为: "+atomicInteger.get());
			}
		}, 0, 30, TimeUnit.SECONDS);
    }

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		 logger.debug("NettyServerHandler handlerRemoved调用"+" , 客户端ip: "+getClientIP(ctx));
		 atomicInteger.decrementAndGet();
		 new OnlineStateHandler().setOffline(getClientIP(ctx));
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyServerHandler channelActive调用"+" , 客户端ip: "+getClientIP(ctx));
		atomicInteger.incrementAndGet();
		new OnlineStateHandler().setOnline(getClientIP(ctx));
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		 logger.debug("NettyServerHandler channelInactive调用"+" , 客户端ip: "+getClientIP(ctx));
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyServerHandler channelUnregistered调用"+" , 客户端ip: "+getClientIP(ctx));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf data=(ByteBuf)msg;
		logger.info("服务端收到数据 "+",客户端ip: "+getClientIP(ctx));
		AlarmHandler.handle(data, getClientIP(ctx));
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyServerHandler channelReadComplete调用"+" , 客户端ip: "+getClientIP(ctx));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("NettyServerHandler异常"+" , 客户端ip: "+getClientIP(ctx)  ,   cause);
	}
	
	public String getClientIP(ChannelHandlerContext ctx){
		InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
		return clientIP;
	}
}

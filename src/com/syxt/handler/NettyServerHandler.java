package com.syxt.handler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.syxt.service.impl.StructAlgResWServiceImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger logger=LoggerFactory.getLogger(StructAlgResWServiceImpl.class);
    private AtomicInteger atomicInteger=new AtomicInteger();
    private int counter;
    public NettyServerHandler(){
    	Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				logger.info("当前客户端连接数为: "+atomicInteger.get());
			}
		}, 10, 60, TimeUnit.SECONDS);
    }

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		atomicInteger.incrementAndGet();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		atomicInteger.decrementAndGet();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf data=(ByteBuf)msg;
		logger.info("服务端收到数据： "+data.toString(CharsetUtil.UTF_8)+" ,收到消息次数: "+ ++counter);
		ctx.writeAndFlush(data);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyServerHandler channelReadComplete调用");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("NettyServerHandler异常",cause);
	}
}

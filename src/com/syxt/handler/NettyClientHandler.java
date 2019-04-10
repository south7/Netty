package com.syxt.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		String req="hello,";
		for (int i = 0; i < 20; i++) {
			ctx.writeAndFlush(Unpooled.copiedBuffer(req,CharsetUtil.UTF_8));
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("NettyClientHandler channelReadComplete");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("NettyClientHandler异常",cause);
	}

}

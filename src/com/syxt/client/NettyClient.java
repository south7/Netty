package com.syxt.client;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syxt.handler.NettyClientHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    private static final Logger logger=LoggerFactory.getLogger(NettyClient.class);
	private String host;
	private int port;
	public NettyClient(String host, int port) {
		this.host = host;
		this.port = port;
	}
	public void run(){
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap=new Bootstrap();
		try {
			bootstrap.group(group).channel(NioSocketChannel.class).
			remoteAddress(new InetSocketAddress(host,port)).
			handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					//ch.pipeline().addLast(new FixedLengthFrameDecoder(36));
					ch.pipeline().addLast(new NettyClientHandler());
				}
			});
			ChannelFuture channelFuture = bootstrap.connect().sync();
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("客户端启动，连接服务端异常",e);
		}finally{
			group.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		new NettyClient("127.0.0.1",7009).run();
	}
	
	
}

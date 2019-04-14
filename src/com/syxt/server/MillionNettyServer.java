package com.syxt.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syxt.handler.NettyMillionServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * 服务端测试最大连接数
 * @author wangfan
 *
 */
public class MillionNettyServer {
    private static final Logger logger=LoggerFactory.getLogger(MillionNettyServer.class);
	private int port;// 10.151.31.42

	public MillionNettyServer(int port) {
		this.port = port;
	}
	/**
	 * 启动流程
	 */
	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup).
			channel(NioServerSocketChannel.class).
			option(ChannelOption.SO_REUSEADDR, true).
			option(ChannelOption.SO_BACKLOG, 1024).
			childOption(ChannelOption.TCP_NODELAY, true).
			childOption(ChannelOption.SO_KEEPALIVE, true).
			childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new NettyMillionServerHandler());
				}
			});
			logger.info("NettyServer服务启动中...");
			//绑定端口，同步等待成功
			ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
			//等待服务端监听端口关闭
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("NettyServer服务异常",e);
		}finally {
			//优雅关闭，释放线程池
			workGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		int port=7009;
		if(args.length>0){
			port=Integer.parseInt(args[0]);
		}
		new MillionNettyServer(port).run();
	}
}

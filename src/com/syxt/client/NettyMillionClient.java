package com.syxt.client;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
/**
 * 客户端测试最大连接数
 * @author wangfan
 *
 */
public class NettyMillionClient {
	private String host;
	private int port;
	public NettyMillionClient(String host, int port) {
		this.host = host;
		this.port = port;
	}
	public void run(){
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap=new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class)
			.option(ChannelOption.SO_REUSEADDR, true).
			remoteAddress(new InetSocketAddress(host,port)).
			handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline();
				}
			});
			for (int i = 0; i < 60000; i++) {
				bootstrap.connect();
			}
	}
	public static void main(String[] args) {
		new NettyMillionClient("127.0.0.1",7009).run();
	}
	
	
}

package com.dxfx.netty.client;

import com.dxfx.netty.handler.SimpleClientHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;

import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

public class NettyClient {
	
	
	public static void main(String[] args) throws InterruptedException {
			String host = "localhost";
			int port = 8080;
			EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
		Bootstrap boot = new Bootstrap();
		boot.group(workerGroup)
			.channel(NioSocketChannel.class)
			.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
							ch.pipeline().addLast(new StringDecoder());//字符串解码器
							ch.pipeline().addLast(new StringEncoder());//字符串编码器
							ch.pipeline().addLast(new SimpleClientHandler());//业务逻辑处理处
						}
			});
		
			// Start the client.
			ChannelFuture f = boot.connect(host, port).sync();
			f.channel().writeAndFlush("hello server");
			f.channel().writeAndFlush("\r\n");
			f.channel().closeFuture().sync();//获取结果之前必须进行关闭通道
			Object result = f.channel().attr(AttributeKey.valueOf("sssss")).get();
			System.out.println("获取到服务器返回的数据==="+result.toString());
			
		} finally {
			workerGroup.shutdownGracefully();
		}
		
	}
	
}
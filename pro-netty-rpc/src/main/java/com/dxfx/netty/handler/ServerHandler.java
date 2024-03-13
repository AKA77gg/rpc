package com.dxfx.netty.handler;

import org.jboss.netty.handler.timeout.IdleStateEvent;

import com.alibaba.fastjson.JSONObject;
import com.dxfx.netty.handler.param.ServerRequest;
import com.dxfx.netty.medium.Medium;
import com.dxfx.netty.util.Response;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//ctx.channel().writeAndFlush("is OK\r\n");
		ServerRequest request = JSONObject.parseObject(msg.toString(),ServerRequest.class);	
		Medium medium = Medium.newInstance();
		Response result = medium.process(request);	
		ctx.channel().writeAndFlush(JSONObject.toJSONString(result));
		ctx.channel().writeAndFlush("\r\n");
		
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent)evt;
			if(event.getState().equals(IdleState.READER_IDLE)) {
				System.out.println("读空闲===");
				ctx.channel().close();
			}else if(event.getState().equals(IdleState.WRITER_IDLE)) {
				System.out.println("写空闲===");
			}else if(event.getState().equals(IdleState.ALL_IDLE)) {
				System.out.println("读写空闲===");
				ctx.channel().writeAndFlush("ping\r\n");
			}
		}
	}
}

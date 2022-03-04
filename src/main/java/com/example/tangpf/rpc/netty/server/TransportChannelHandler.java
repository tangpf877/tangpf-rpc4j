package com.example.tangpf.rpc.netty.server;

import com.example.tangpf.rpc.netty.protocal.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author tangpf
 * @Date 2022/2/15 13:31
 * @Version 1.0
 */
public class TransportChannelHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

    }
}

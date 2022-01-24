package com.example.tangpf.rpc.netty.server;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.RpcHandler;
import com.example.tangpf.rpc.netty.TransportContext;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.apache.spark.network.util.NettyUtils;

import java.io.Closeable;

/**
 * @Author tangpf
 * @Date 2022/1/7 15:23
 * @Version 1.0
 */
public class TransportServer implements Closeable {
    private int port = -1;
    private final TransportContext context;
    private final RpcConf conf;
    private final RpcHandler rpcHandler;
    private ServerBootstrap bootstrap;
    private final PooledByteBufAllocator pooledAllocator;

    public TransportServer(TransportContext context, String hostToBind, int portToBind,
                           RpcHandler rpcHandler) {
        this.context = context;
        this.conf = context.getConf();
        this.rpcHandler = rpcHandler;
        if (conf.sharedByteBufAllocators()) {
            this.pooledAllocator = NettyUtils.getSharedPooledByteBufAllocator(
                    conf.preferDirectBufs(), true);
        } else {
            this.pooledAllocator = NettyUtils.createPooledByteBufAllocator(
                    conf.preferDirectBufs(), true, conf.serverThreads());
        }
        boolean shouldClose = true;
        try {
            init(hostToBind, portToBind);
            shouldClose = false;

        } finally {
            if (shouldClose) {
                this.close();
            }
        }

    }


    private void init(String hostToBind, int portToBind) {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1,
                new DefaultThreadFactory("RPC-boss", true));
        EventLoopGroup workerGroup = new NioEventLoopGroup(conf.serverThreads(),
                new DefaultThreadFactory("RPC-server", true));
        bootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.ALLOCATOR,this.pooledAllocator)
                .childOption(ChannelOption.ALLOCATOR,this.pooledAllocator);
        if(conf.backLog()>0){
            bootstrap.option(ChannelOption.SO_BACKLOG, conf.backLog());
        }
        if (conf.receiveBuffer() > 0) {
            bootstrap.childOption(ChannelOption.SO_RCVBUF, conf.receiveBuffer());
        }

        if (conf.sendBuffer() > 0) {
            bootstrap.childOption(ChannelOption.SO_SNDBUF, conf.sendBuffer());
        }

        if (conf.enableTcpKeepAlive()) {
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        }


    }

    @Override
    public void close() {

    }


    public int getPort() {
        if (port == -1) {
            throw new IllegalStateException("Server not initialized");
        }
        return port;
    }
}

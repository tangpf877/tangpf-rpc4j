package com.example.tangpf.rpc.netty.server;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.RpcHandler;
import com.example.tangpf.rpc.netty.TransportContext;
import io.netty.buffer.PooledByteBufAllocator;
import org.apache.spark.network.util.NettyUtils;

import java.util.List;

/**
 * @Author tangpf
 * @Date 2022/1/7 15:23
 * @Version 1.0
 */
public class TransportServer {
    private int port = -1;
    TransportContext context;
    RpcConf conf;
    RpcHandler rpcHandler;
    private final PooledByteBufAllocator pooledAllocator;

    public TransportServer(TransportContext context, String hostToBind, int portToBind,
                           RpcHandler rpcHandler) {
        this.context = context;
        this.conf = context.getConf();
        this.rpcHandler = rpcHandler;
        if (conf.isSharedByteBufAllocators()) {
            this.pooledAllocator = NettyUtils.getSharedPooledByteBufAllocator(
                    conf.isPreferDirectBufs(), true);
        }
        else {
            this.pooledAllocator = NettyUtils.createPooledByteBufAllocator(
                    conf.isPreferDirectBufs(),true,conf.getServerThreads());
        }
    }

    public int getPort() {
        if (port == -1) {
            throw new IllegalStateException("Server not initialized");
        }
        return port;
    }
}

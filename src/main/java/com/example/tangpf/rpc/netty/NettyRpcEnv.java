package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcEnv;


/**
 * @Author tangpf
 * @Date 2022/1/7 10:50
 * @Version 1.0
 */
public class NettyRpcEnv extends RpcEnv {

    private NettyServer server;
    private NettyContext nettyContext;


    public NettyRpcEnv startServer(String bindAddress, int port) {
        server = nettyContext.createServer();
        return this;
    }

    public void shutdown() {

    }
}

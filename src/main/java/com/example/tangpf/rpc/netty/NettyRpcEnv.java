package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.RpcEnv;
import com.example.tangpf.rpc.RpcHandler;
import com.example.tangpf.rpc.netty.server.TransportServer;

import java.util.Collections;
import java.util.List;


/**
 * @Author tangpf
 * @Date 2022/1/7 10:50
 * @Version 1.0
 */
public class NettyRpcEnv extends RpcEnv {



    private TransportServer server;
    private TransportContext transportContext;
    private Dispatcher dispatcher;

    public NettyRpcEnv(RpcConf conf) {
        this.dispatcher = new Dispatcher(this);
        this.transportContext = new TransportContext(conf,new NettyRpcHandler());
    }

    public NettyRpcEnv startServer(String bindAddress, int port) {
        this.server = this.transportContext.createServer(bindAddress, port);
        dispatcher.registerRpcEndpoint(RpcEndpointVerifier.NAME, new RpcEndpointVerifier(this, this.dispatcher));
        return this;
    }

    public void shutdown() {

    }
}

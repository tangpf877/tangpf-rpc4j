package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.RpcHandler;
import com.example.tangpf.rpc.netty.server.TransportServer;
import lombok.Getter;

import java.util.List;

/**
 * @Author tangpf
 * @Date 2022/1/7 16:10
 * @Version 1.0
 */
public class TransportContext {
    private final RpcHandler rpcHandler;
    @Getter
    private final RpcConf conf;

    public TransportContext(RpcConf conf, RpcHandler rpcHandler) {
        this.conf = conf;
        this.rpcHandler = rpcHandler;
    }

    public TransportServer createServer(String host, int port) {
        return new TransportServer(this, host, port, rpcHandler);
    }
}

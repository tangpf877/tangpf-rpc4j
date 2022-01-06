package com.example.tangpf.rpc;

import com.example.tangpf.rpc.netty.NettyRpcEnvFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcEnv {


    public static RpcEnv create(String name, String bindAddress, int port, boolean clientMode, RpcConf conf) {
        RpcEnvConfig config = new RpcEnvConfig(conf, name, bindAddress, port, clientMode);
        return new NettyRpcEnvFactory().create(config);
    }

}

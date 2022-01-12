package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.RpcEnv;
import com.example.tangpf.rpc.RpcEnvConfig;
import com.example.tangpf.util.Utils;

/**
 * @Author tangpf
 * @Date 2022/1/6 15:43
 * @Version 1.0
 */
public class NettyRpcEnvFactory {

    public RpcEnv create(RpcEnvConfig config) {
        RpcConf conf = config.getConf();
        NettyRpcEnv nettyEnv = new NettyRpcEnv(conf);

        if (!config.isClientMode()) {
            try {
                Utils.startServiceOnPort(config.getBindAddress(),config.getPort(),nettyEnv,conf, config.getName());
            } catch (Exception e) {
                nettyEnv.shutdown();
                e.printStackTrace();
                throw e;
            }
        }
        return nettyEnv;
    }

}

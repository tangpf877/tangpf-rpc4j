package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcEndpoint;
import com.example.tangpf.rpc.RpcEndpointRef;
import com.example.tangpf.rpc.RpcEnv;

/**
 * @Author tangpf
 * @Date 2022/1/11 14:31
 * @Version 1.0
 */
public class Dispatcher {
    public Dispatcher(RpcEnv rpcEnv) {
    }

    /**
     * @param name the name of the endpoint
     * @param endpoint the endpoint to be registered in an rpc environment
     * @return com.example.tangpf.rpc.RpcEndpointRef
     * @author tangpf
     * @date 2022/1/11 14:38
     */
    public RpcEndpointRef registerRpcEndpoint(String name, RpcEndpoint endpoint) {
        return null;
    }
}

package com.example.tangpf.rpc.netty;

import com.example.tangpf.rpc.RpcEndpoint;
import com.example.tangpf.rpc.RpcEnv;

/**
 * @Author tangpf
 * @Date 2022/1/11 14:30
 * @Version 1.0
 */
public class RpcEndpointVerifier implements RpcEndpoint {

    public static final String NAME = "endpoint-verifier";

    private RpcEnv rpcEnv;
    private Dispatcher dispatcher;

    public RpcEndpointVerifier(RpcEnv rpcEnv, Dispatcher dispatcher) {
        this.rpcEnv = rpcEnv;
        this.dispatcher = dispatcher;
    }
}

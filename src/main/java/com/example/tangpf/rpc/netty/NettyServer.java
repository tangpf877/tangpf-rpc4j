package com.example.tangpf.rpc.netty;

/**
 * @Author tangpf
 * @Date 2022/1/7 15:23
 * @Version 1.0
 */
public class NettyServer {
    private int port = -1;

    public int getPort() {
        if (port == -1) {
            throw new IllegalStateException("Server not initialized");
        }
        return port;
    }
}

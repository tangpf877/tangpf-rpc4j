package com.example.tangpf.rpc;

import lombok.Getter;
import lombok.NonNull;

public class RpcEnvConfig {


    private RpcConf conf;

    private String name;

    private String bindAddress;

    private int port;

    private boolean clientMode;

    public RpcConf getConf() {
        return conf;
    }

    public String getName() {
        return name;
    }

    public String getBindAddress() {
        return bindAddress;
    }

    public int getPort() {
        return port;
    }

    public boolean isClientMode() {
        return clientMode;
    }

    public RpcEnvConfig(@NonNull RpcConf conf, @NonNull String host, @NonNull int port, @NonNull boolean clientMode) {
        this(conf, "", host, port, clientMode);
    }

    public RpcEnvConfig(@NonNull RpcConf conf, @NonNull String name, @NonNull String host, @NonNull int port, @NonNull boolean clientMode) {
        this.conf = conf;
        this.name = name;
        this.bindAddress = host;
        this.port = port;
        this.clientMode = clientMode;
    }
}

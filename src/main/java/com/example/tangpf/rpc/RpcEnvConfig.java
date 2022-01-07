package com.example.tangpf.rpc;

import lombok.Getter;
import lombok.NonNull;

public class RpcEnvConfig {

    @Getter
    private RpcConf conf;
    @Getter
    private String name;
    @Getter
    private String bindAddress;
    @Getter
    private int port;
    @Getter
    private boolean clientMode;

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

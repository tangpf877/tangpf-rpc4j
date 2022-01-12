package com.example.tangpf.rpc;

import com.example.tangpf.util.ConfigReader;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * @Author tangpf
 */
public class RpcConf {



    private static final String RPC_PORT_MAX_RETRIES_KEY = "portMaxRetries";
    private static final String SHARED_BYTE_BUF_ALLOCATORS_KEY = "sharedByteBufAllocators.enable";
    private static final String PREFER_DIRECT_BUFS_KEY = "preferDirectBufs";
    private static final String SERVER_THREADS_KEY = "preferDirectBufs";

    private ConfigReader conf;

    @Getter
    @Setter
    private int portMaxRetries;
    @Getter
    @Setter
    private boolean sharedByteBufAllocators;
    @Getter
    @Setter
    private boolean preferDirectBufs;
    @Getter
    @Setter
    private int serverThreads;

    public RpcConf() {
        this("rpc4j.properties");
    }

    public RpcConf(String fileName) {
//        this.portMaxRetries = Integer.parseInt(p.getProperty(RPC_PORT_MAX_RETRIES_KEY, "16"));
//        if (this.portMaxRetries < 0) {
//            throw new InvalidParameterException("Parameter port_max_reties should not be smaller than 0");
//        }
//        this.sharedByteBufAllocators = Boolean.parseBoolean(p.getProperty(SHARED_BYTE_BUF_ALLOCATORS_KEY, "true"));
//        this.preferDirectBufs = Boolean.parseBoolean(p.getProperty(PREFER_DIRECT_BUFS_KEY, "true"));
//        this.serverThreads = Integer.parseInt(p.getProperty(SERVER_THREADS_KEY,"0"));
    }

}

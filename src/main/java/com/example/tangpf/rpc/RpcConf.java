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


    private static final String PORT_MAX_RETRIES_KEY = "portMaxRetries";
    private static final String SHARED_BYTE_BUF_ALLOCATORS_KEY = "enableSharedByteBufAllocators";
    private static final String PREFER_DIRECT_BUFS_KEY = "preferDirectBufs";
    private static final String SERVER_THREADS_KEY = "serverThreads";
    private static final String BACKLOG_KEY = "backLog";
    private static final String RECEIVE_BUFFER_KEY = "receiveBuffer";
    private static final String SEND_BUFFER_KEY = "sendBuffer";
    private static final String ENABLE_TCP_KEEP_ALIVE_KEY = "enableTcpKeepAlive";

    private final ConfigReader conf;

    private int portMaxRetries;
    private boolean sharedByteBufAllocators;
    private boolean preferDirectBufs;
    private int serverThreads;
    private int backLog;
    private int sendBuffer;
    private int receiveBuffer;
    private boolean enableTcpKeepAlive;

    public boolean enableTcpKeepAlive() {
        return enableTcpKeepAlive;
    }

    public void enableTcpKeepAlive(boolean enableTcpKeepAlive) {
        this.enableTcpKeepAlive = enableTcpKeepAlive;
    }

    public int sendBuffer() {
        return sendBuffer;
    }

    public void setSendBuffer(int sendBuffer) {
        this.sendBuffer = sendBuffer;
    }

    public int receiveBuffer() {
        return receiveBuffer;
    }

    public void setReceiveBuffer(int receiveBuffer) {
        this.receiveBuffer = receiveBuffer;
    }

    public int portMaxRetries() {
        return portMaxRetries;
    }

    public void setPortMaxRetries(int portMaxRetries) {
        this.portMaxRetries = portMaxRetries;
    }

    public boolean sharedByteBufAllocators() {
        return sharedByteBufAllocators;
    }

    public void sharedByteBufAllocators(boolean sharedByteBufAllocators) {
        this.sharedByteBufAllocators = sharedByteBufAllocators;
    }

    public boolean preferDirectBufs() {
        return preferDirectBufs;
    }

    public void preferDirectBufs(boolean preferDirectBufs) {
        this.preferDirectBufs = preferDirectBufs;
    }

    public int serverThreads() {
        return serverThreads;
    }

    public void setServerThreads(int serverThreads) {
        this.serverThreads = serverThreads;
    }

    public int backLog() {
        return backLog;
    }

    public void setBackLog(int backLog) {
        this.backLog = backLog;
    }

    public RpcConf() {
        this("rpc4j.properties");
    }

    public RpcConf(String fileName) {
        conf = new ConfigReader(fileName);
        portMaxRetries = conf.getInt(PORT_MAX_RETRIES_KEY, "16");
        if (portMaxRetries < 0) {
            portMaxRetries = 0;
        }
        sharedByteBufAllocators = conf.getBoolean(SHARED_BYTE_BUF_ALLOCATORS_KEY, "true");
        preferDirectBufs = conf.getBoolean(PREFER_DIRECT_BUFS_KEY, "true");
        serverThreads = conf.getInt(SERVER_THREADS_KEY, "0");
        if (serverThreads < 0) {
            serverThreads = 0;
        }
        backLog = conf.getInt(BACKLOG_KEY, "-1");
        receiveBuffer = conf.getInt(RECEIVE_BUFFER_KEY,"-1");
        sendBuffer = conf.getInt(SEND_BUFFER_KEY,"-1");
        enableTcpKeepAlive = conf.getBoolean(ENABLE_TCP_KEEP_ALIVE_KEY,"false");
    }

}

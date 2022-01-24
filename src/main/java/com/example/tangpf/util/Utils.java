package com.example.tangpf.util;

import com.example.tangpf.rpc.RpcConf;
import com.example.tangpf.rpc.netty.NettyRpcEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author tangpf
 * @Date 2022/1/7 10:57
 * @Version 1.0
 */
public class Utils {
    private static Logger log = LoggerFactory.getLogger(Utils.class);

    /**
     * Attempt to start a service on the given port, or fail after a number of attempts.
     * Each subsequent attempt uses 1 + the port used in the previous attempt (unless the port is 0).
     *
     * @param startPort   The port to start a Rpc server
     * @param nettyEnv    The Rpc environment
     * @param conf        RpcConf
     * @param serviceName Name of the service
     * @return void
     * @author tangpf
     * @date 2022/1/7 11:11
     */
    public static void startServiceOnPort(String bindAddress, int startPort, NettyRpcEnv nettyEnv, RpcConf conf, String serviceName) {
        if (0 < startPort && startPort < 1024) {
            log.warn("It is recommended that port should be between 1024 and 65535(inclusive), or 0 for a random free port.");
        }
        int maxTries = conf.portMaxRetries();
        for (int offset = 0; offset < maxTries + 1; offset++) {
            int tryPort = startPort == 0 ? startPort : userPort(startPort, offset);
            try {
                nettyEnv.startServer(bindAddress, tryPort);
            } catch (Exception e) {
                if (offset >= maxTries) {
                    if (startPort == 0) {
                        log.error("Service {} failed after {} retries (on a random free port)!", serviceName, maxTries);

                    } else {
                        log.error("Service {} failed after {} retries (starting from {})!", serviceName, maxTries, startPort);
                    }
                    throw e;
                }
                if (startPort == 0) {
                    log.warn("Service {} could not bind on a random free port. " +
                            "You may check whether configuring an appropriate binding address.", serviceName);
                } else {
                    log.warn("Service {} could not bind on port {}. Attempting port: {}", serviceName, tryPort, tryPort + 1);
                }


            }
        }
    }


    public static int userPort(int base, int offset) {
        return (base + offset - 1024) % (65536 - 1024) + 1024;
    }

}

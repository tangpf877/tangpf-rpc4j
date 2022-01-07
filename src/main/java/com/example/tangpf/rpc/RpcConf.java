package com.example.tangpf.rpc;

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

    private static Properties p = new Properties();

    /**
     * 读取properties配置文件信息
     */
    static{
        try {
            p.load(RpcConf.class.getClassLoader().getResourceAsStream("rpc4j.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Getter @Setter
    private int portMaxRetries;

    public RpcConf(){
        this.portMaxRetries = Integer.parseInt(p.getProperty("port_max_retries","16"));
        if(this.portMaxRetries<0){
            throw new InvalidParameterException("Parameter port_max_reties should not be smaller than 0");
        }
    }

}

package com.example.tangpf.util;

/**
 * @Author tangpf
 * @Date 2022/1/11 17:35
 * @Version 1.0
 */

import com.example.tangpf.rpc.RpcConf;

import java.io.IOException;
import java.util.Properties;

/**
 * A util class to read and parse configuration file
 */
public class ConfigReader {

    private final Properties p = new Properties();

    public ConfigReader(String fileName) {
        /**
         * read configuration file
         */
        try {
            p.load(RpcConf.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getString(String key, String defaultValue) {
        return p.getProperty(key, defaultValue);
    }

    public int getInt(String key,String defaultValue){
        return Integer.parseInt(p.getProperty(key, defaultValue));
    }

    public boolean getBoolean(String key,String defaultValue){
        return Boolean.parseBoolean(p.getProperty(key,defaultValue));
    }

}

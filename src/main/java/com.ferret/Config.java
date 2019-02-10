package com.ferret;

import java.util.*;
import java.io.FileInputStream;
import java.io.File;
import java.net.*;
import java.util.Properties;
 
public class Config {
    Properties configFile;
    public Config() {
        configFile = new Properties();
        try {
            configFile.load(new FileInputStream("ferret.conf"));
        } catch(Exception eta){
            System.out.println(eta.toString());
        }
    }
    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
}
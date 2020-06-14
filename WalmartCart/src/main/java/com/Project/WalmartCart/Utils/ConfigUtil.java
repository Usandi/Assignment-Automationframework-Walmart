package com.Project.WalmartCart.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    //to read the data from config file, Properties class used to read data from utils
    public static final Properties props = new Properties();

    public ConfigUtil(String filename) {//constructor
        try {
            props.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}

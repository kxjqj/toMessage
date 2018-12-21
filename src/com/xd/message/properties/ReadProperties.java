package com.xd.message.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName ReadProperties
 * @Description
 * @Author QiJi
 * @Date 2018/12/2016:52
 * Version 1.0
 */
public class ReadProperties {

    /**
     * 读取配置文件的第一种方法
     * 非静态和静态方法中都可使用
     */
    public static Map<String,Object> readPropertiesAliyun(){
        //获取输入流		注意要有/
        InputStream is = ReadProperties.class.getResourceAsStream("config.properties");
        Properties ppt = new Properties();
        Map map = new HashMap();
        try {
            //可以解决中文乱码问题
            ppt.load(new InputStreamReader(is, "UTF-8"));
            map.put("AccessKeyId",ppt.getProperty("AccessKeyId"));
            map.put("AccessKeySecret",ppt.getProperty("AccessKeySecret"));
            map.put("signName",ppt.getProperty("signName"));
            map.put("templateCode",ppt.getProperty("templateCode"));
            map.put("msgname",ppt.getProperty("msgname"));
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static void main(String[] args) {
        readPropertiesAliyun();
    }
}

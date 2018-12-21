package com.xd.message.aliyun;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.xd.message.properties.formetAliyunMsg;

/**
 * @ClassName toaliyun
 * @Description
 * @Author QiJi
 * @Date 2018/12/2018:05
 * Version 1.0
 */
public class toMessage {

    /**
     * @return void
     * @Author QiJi
     * @Description //阿里云短信
     * @Date 18:12 2018/12/20
     * @Param [yys,number, ccode]
     **/
    public static String toMessage(String yys, String number, int ccode) {
        String code = "";
        if (yys.equals("ali")) { //阿里
            try {
                SendSmsResponse  sendSmsResponse = formetAliyunMsg.sendSms(number, ccode);
                if (sendSmsResponse.getCode().equals("OK")){
                    code = "ok";
                }
            } catch (ClientException ce) {
                ce.printStackTrace();
            }
        }else if (yys.equals("tence")){ //腾讯 目前没用腾讯

        }
        return code;
    }
}

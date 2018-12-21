package com.xd.message.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.xd.message.properties.formetAliyunMsg;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Description: 阿里云 短信接口
 * * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * * 工程依赖了2个jar包(存放在工程的libs目录下)
 * * 1:aliyun-java-sdk-core.jar
 * * 2:aliyun-java-sdk-dysmsapi.jar
 * *
 * * 备注:Demo工程编码采用UTF-8
 * * 国际短信发送请勿参照此DEMO
 * @author: QiJi
 * @createDate: 2018/12/20 17:03
 * @updateDate: 2018/12/20 17:03
 * @version: V1.0
 */

public class toaliyun_Service extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, Object> mapRe = new HashMap<>();
        String number = request.getParameter("number");
        if (StringUtils.isNotBlank(number)){
            //try {
                //短信 手机号 加 四位验证码 发送
                int ccode = (int)((Math.random()*9+1)*1000);
                String ok = toMessage.toMessage("ali",number,ccode);
                if (ok.equals("ok")){
                    mapRe.put("code",0);
                    mapRe.put("message","ok");
                }else {
                    mapRe.put("code",101);
                mapRe.put("message","短信发送失败,请重试");
                }
//                SendSmsResponse sendSmsResponse = formetAliyunMsg.sendSms(number,ccode);
//                if (sendSmsResponse.getCode().equals("OK")){
//                    request.getSession().setAttribute(number,ccode);
//                    mapRe.put("code",0);
//                    mapRe.put("message","ok");
//                }
//            }catch (ClientException ce ){
//                ce.printStackTrace();
//                mapRe.put("code",101);
//                mapRe.put("message","短信发送失败,请重试");
//            }
        }
        JSONObject jsonObject = JSONObject.fromObject(mapRe);
        System.out.println(this.getClass().getName() + " " + jsonObject + "  " + new Date() + "\n");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

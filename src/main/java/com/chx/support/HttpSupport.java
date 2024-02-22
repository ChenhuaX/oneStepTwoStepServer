package com.chx.support;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chx.config.ConditionException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpSupport {
    private static final String  WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private static final String  APP_ID = "wx0b9ee0bc0fe7ee8c";
    private static final String APP_SECRET = "1f0765439365a4abb5bebf3c4bfbc02d";

    public String getUserInfo(String code){
        String url = String.format(WX_URL, APP_ID, APP_SECRET, code);
        String result = null;
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // 创建 HttpGet 请求
            HttpGet httpGet = new HttpGet(url);

            // 执行请求
            CloseableHttpResponse response = httpClient.execute(httpGet);

            // 读取响应内容
            String responseBody = EntityUtils.toString(response.getEntity());

            //解析相应内容
            JSONObject jsonObject = JSON.parseObject(responseBody);

            // 输出响应内容
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Response Body: " + responseBody);


            result = responseBody;
            // 关闭响应
            response.close();

            // 关闭 HttpClient
            httpClient.close();

        }catch (IOException e){

            throw new ConditionException("错误：使用微信接口服务请求openId出错");
        }
        return result;
    }
}

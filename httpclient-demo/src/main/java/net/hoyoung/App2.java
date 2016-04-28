package net.hoyoung;

import net.hoyoung.util.MD5Util;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        String loginUrl = "http://rs.xidian.edu.cn/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username","银灵子"));
        params.add(new BasicNameValuePair("password", MD5Util.string2MD5("105225ruisi")));
        params.add(new BasicNameValuePair("quickforward","yes"));
        params.add(new BasicNameValuePair("handlekey","ls"));

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(loginUrl);
        /**
         * Host:rs.xidian.edu.cn
         Origin:http://rs.xidian.edu.cn
         Referer:http://rs.xidian.edu.cn/forum.php
         Upgrade-Insecure-Requests:1
         User-Agent:Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36
         */

        httpPost.addHeader("Host","rs.xidian.edu.cn");
        httpPost.addHeader("Origin","http://rs.xidian.edu.cn");
        httpPost.addHeader("Referer","http://rs.xidian.edu.cn/forum.php");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        httpPost.setEntity(formEntity);

        HttpClientContext context = HttpClientContext.create();


        try {
            CloseableHttpResponse response = client.execute(httpPost,context);
            System.out.println(response.getStatusLine());
            System.out.println(context.getCookieStore().toString());
//            context.getCookieStore().
            HttpEntity resEntity = response.getEntity();



            InputStream in = resEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tmp = null;
            while ((tmp = reader.readLine())!=null){
                System.out.println(tmp);
            }

            //读取Cookie
//            HeaderElementIterator headerElementIterator = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
//            System.out.println("=========Cookie==========");
//            while (headerElementIterator.hasNext()){
//                HeaderElement elem = headerElementIterator.nextElement();
//                System.out.println(elem.getName());
//            }

            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

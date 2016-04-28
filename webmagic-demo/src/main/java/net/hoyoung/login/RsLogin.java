package net.hoyoung.login;

import net.hoyoung.util.MD5Util;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.Spider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoyoung on 16-3-31.
 */
public class RsLogin implements ILogin{
    private final static String LOGIN_URL = "http://rs.xidian.edu.cn/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1";
    public List<Cookie> doLogin(String username,String password) throws IOException {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username",username));
        params.add(new BasicNameValuePair("password", MD5Util.string2MD5("105225ruisi")));
        params.add(new BasicNameValuePair("quickforward","yes"));
        params.add(new BasicNameValuePair("handlekey","ls"));

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(LOGIN_URL);
        httpPost.addHeader("Host","rs.xidian.edu.cn");
        httpPost.addHeader("Origin","http://rs.xidian.edu.cn");
        httpPost.addHeader("Referer","http://rs.xidian.edu.cn/portal.php");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        HttpClientContext context = HttpClientContext.create();


        CloseableHttpResponse response = client.execute(httpPost, context);
//        System.out.println(response.getStatusLine().getStatusCode());

        if(response.getStatusLine().getStatusCode()== 200){
            /*InputStream in = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tmp = null;
            while ((tmp = reader.readLine())!=null){
                System.out.println(tmp);
            }*/

            List<Cookie> cookies = context.getCookieStore().getCookies();
            return cookies;
        }else {
            throw new IOException();
        }
//        return null;
    }

    public static void main(String[] args) {
        try {
            List<Cookie> cookies = new RsLogin().doLogin("银灵子", "105225rusi");
            for (Cookie cookie : cookies){
                System.out.println(cookie.toString());
//                System.out.println("====================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

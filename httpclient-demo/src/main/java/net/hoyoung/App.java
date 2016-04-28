package net.hoyoung;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            System.out.println(response.getStatusLine());
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

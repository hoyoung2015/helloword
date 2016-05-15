package net.hoyoung;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * Created by hoyoung on 16-5-3.
 */
public class MysqlBlobTest {
    @Test
    public void test(){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://192.168.56.101:3306/nutch?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&autoReconnect=true";
            conn = DriverManager.getConnection(jdbcUrl, "root", "123456");
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM webpage limit 10");
            while (rs.next()){
                Blob contentBlob = rs.getBlob("content");
                if(contentBlob!=null){
                    byte[] data = contentBlob.getBytes(1, (int) contentBlob.length());
                    String content = new String(data,"GBK");
//                    System.out.println(content);
                }

                Blob outLinksBlob = rs.getBlob("outlinks");
                if(outLinksBlob!=null){
                    byte[] data = outLinksBlob.getBytes(1, (int) outLinksBlob.length());
                    String outlinks = new String(data);
                    System.out.println(outlinks);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stat!=null){
                    stat.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

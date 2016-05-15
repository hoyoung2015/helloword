package weihao;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by hoyoung on 16-5-9.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("TRD_Week.csv","r");
        byte[] buffer = new byte[1024];
        int len = 0;
        file.seek(16);
        len = file.read(buffer);
        System.out.println(len);
        System.out.println(new String(buffer));
        file.close();
    }

}


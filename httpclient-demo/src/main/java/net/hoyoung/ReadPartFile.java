package net.hoyoung;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by hoyoung on 16-5-3.
 */
public class ReadPartFile {
    public static void main(String[] args) {
        File file = new File("/home/hoyoung/tmp/wh/股权/whfj40k5/TMT_FigureInfo.csv");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.csv")));
            for (int i = 0; i < 50; i++) {

                String s = new String(reader.readLine().getBytes(),"UTF-8");

                writer.write(s);
            }
//            System.out.println(reader.readLine());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package net.hoyoung.util;

/**
 * Created by hoyoung on 16-3-3.
 */
public class Printer {
    public static void printArray(Object[] data){
        for (Object i: data){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

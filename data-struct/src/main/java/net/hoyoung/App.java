package net.hoyoung;

import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));

        Long l1 = 2L;
        System.out.println(l1.equals(i1+i2));
        System.out.println(l1==(i1+i2));
    }
}

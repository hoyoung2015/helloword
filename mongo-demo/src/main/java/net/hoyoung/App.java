package net.hoyoung;


import java.io.File;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException {
        Properties properties = System.getProperties();
        System.out.println(properties.propertyNames());

        Enumeration<?> a = properties.propertyNames();
        while (a.hasMoreElements()){
            System.out.println(a.nextElement());
        }
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));

        File file = new File(System.getProperty("java.util.prefs.userRoot",
                System.getProperty("user.home")), ".java/.userPrefs");
        System.out.println(file.getPath());
        System.out.println( "Hello World!" );
    }
}

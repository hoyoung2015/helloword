package net.hoyoung;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by hoyoung on 16-3-31.
 */
public class SeleniumPhantomJs {
    public static void main(String[] args) {
//        SeleniumPhantomJs driver = new SeleniumPhantomJs();
        System.setProperty("phantomjs.binary.path","");
        WebDriver driver = new PhantomJSDriver();
    }
}

package net.hoyoung;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by hoyoung on 16-3-20.
 */
public class SeleniumHelloWord {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/hoyoung/local/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        driver.manage().window().maximize();
        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.sendKeys("Glen");
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
//        driver.close();
    }
}

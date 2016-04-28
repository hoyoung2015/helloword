package net.hoyoung;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by hoyoung on 16-3-20.
 */
public class SeleniumLoginTaobao {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/hoyoung/local/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://login.taobao.com/member/login.jhtml?redirectURL=https%3A%2F%2Fwww.taobao.com%2F");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("TPL_username_1"));
        WebElement password = driver.findElement(By.id("TPL_password_1"));
        username.sendKeys("1052251022hy");
        password.sendKeys("105225jpx336");
        WebElement btn = driver.findElement(By.id("J_SubmitStatic"));
        btn.click();

//        driver.get("https://buyertrade.taobao.com/trade/itemlist/list_bought_items.htm?spm=a21bo.7724922.1997525045.2.5vg60d");


//        driver.close();
    }
}

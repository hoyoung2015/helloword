package net.hoyoung;

import net.hoyoung.login.ILogin;
import net.hoyoung.login.RsLogin;
import org.apache.http.cookie.Cookie;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App implements PageProcessor
{
    public App(Site site) {
        this.site = site;
        site.setSleepTime(500);
        site.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");

    }

    public static void main( String[] args )
    {

        //模拟登陆
        ILogin login = new RsLogin();
        try {
            List<Cookie> cookies = login.doLogin("银灵子", "105225ruisi");
            System.out.println("登陆成功");
//            Thread.sleep(2000);
            Site site = Site.me();
            for (Cookie cookie : cookies){
                site.addCookie(cookie.getDomain(),cookie.getName(),cookie.getValue());
            }
            site.addHeader("Cookie","safedog-flow-item=B1CBCE51F8; Q8qA_2132_saltkey=pJ3YPYjc; Q8qA_2132_lastvisit=1459411021; Q8qA_2132_ulastactivity=6ff25ZsfShdOCIJ0JwHDUzj3jpEcYQzncR0Hf%2Ff6mBQqqNRl54Tc; Q8qA_2132_lastcheckfeed=75872%7C1459414651; Q8qA_2132_myrepeat_rr=R0; Q8qA_2132_auth=2b16Oc6tP3Hvlcm9S9mWhNpITySbmOSUdBo0g8mY%2FZ7amU5GIwH1dyfQ0%2BM765EW6EXMT1F0dn%2FITLreMB0pEgWwwg; Q8qA_2132_nofavfid=1; Q8qA_2132_st_t=75872%7C1459417782%7Cdc4b4ba65ce2758916051c294375ae97; Q8qA_2132_forum_lastvisit=D_554_1459417782; Q8qA_2132_visitedfid=554; Q8qA_2132_smile=1D1; Q8qA_2132_lip=10.170.32.226%2C1459418401; Q8qA_2132_sid=aXv4OD; Q8qA_2132_lastact=1459423633%09misc.php%09patch");
            Spider.create(new App(site))
                    .addUrl("http://rs.xidian.edu.cn/bt.php?mod=browse&t=all")
                    .thread(1)
                    .run();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("登陆失败");
        }


    }

    public void process(Page page) {
        Selectable selectable = page.getHtml().xpath("//*[@id=\"um\"]/p[1]/strong/a");
        System.out.println(selectable);
        System.out.println("======================================================");
//        System.out.println(page.getHtml());
    }
    private Site site;
    public Site getSite() {
        return site;
    }
}

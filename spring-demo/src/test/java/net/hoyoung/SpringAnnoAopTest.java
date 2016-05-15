package net.hoyoung;

import net.hoyoung.aspect.introductions.IFit;
import net.hoyoung.service.AnnoService;
import net.hoyoung.service.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hoyoung on 16-4-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SpringAnnoAopTest {
    @Autowired
    ApplicationContext context;
    @Test
    public void test(){
        AnnoService service = context.getBean(AnnoService.class);
        service.doService();
    }
}

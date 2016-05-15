package net.hoyoung;

import net.hoyoung.aspect.introductions.IFit;
import net.hoyoung.service.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hoyoung on 16-4-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SpringTest {
//    @Autowired
//    ApplicationContext context;
    @Autowired
    Student student;
    @Test
    public void test(){
        student.study();
    }
    @Test
    public void test2(){
        student.testThrowing();
    }
    @Test
    public void test3(){
        student.init("haha", 3);
    }
    @Test
    public void test4(){
        IFit fit = (IFit) student;
        fit.filter();
    }
}

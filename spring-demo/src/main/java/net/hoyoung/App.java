package net.hoyoung;

import net.hoyoung.service.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
        Student student = context.getBean(Student.class);
        System.out.println(student);
//        student.study();


    }
}

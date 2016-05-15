package net.hoyoung.aspect.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by hoyoung on 16-5-1.
 */
@Aspect
@Component//除了要有Aspect注解,也要有Component注入到容器中
public class AnnoAspect {
    @Pointcut("execution(* net.hoyoung.service.AnnoService.doService())")
    public void test(){

    }
    @Before("test()")
    public void before(){
        System.out.println(this.getClass().getName()+" before");
    }
}

package net.hoyoung.helloword.springboot.web;

import javafx.scene.Parent;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PreDestroy;
import java.util.Set;

/**
 * Created by hoyoung on 16-1-15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements ApplicationRunner,ExitCodeGenerator{


    /**
     * 来自ApplicationRunner接口，用户获取运行参数
     * @param applicationArguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Set<String> argNames = applicationArguments.getOptionNames();
        for (String name : argNames){
            System.out.println(name);
        }
    }

    /**
     * 应用退出的时候触发，不限于启动的主类，比如Controller中也可以用
     * 或者实现
     *
     */
    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy");
    }

    public static void main(String[] args) {
        //第一种启动方式
        /*
        SpringApplication.run(Application.class, args);
        */

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);

        app.addListeners(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                if(applicationEvent instanceof ApplicationStartedEvent){
                    System.out.println("1. ApplicationStartedEvent");
                }else if(applicationEvent instanceof ApplicationEnvironmentPreparedEvent){
                    System.out.println("2. ApplicationEnvironmentPreparedEvent");
                }else if(applicationEvent instanceof ApplicationPreparedEvent){
                    System.out.println("3. ApplicationPreparedEvent");
                }else if(applicationEvent instanceof ContextRefreshedEvent){
                    System.out.println("4. ContextRefreshedEvent");
                }else if(applicationEvent instanceof EmbeddedServletContainerInitializedEvent){
                    System.out.println("5. EmbeddedServletContainerInitializedEvent");
                }else if(applicationEvent instanceof ApplicationReadyEvent){
                    System.out.println("6. ApplicationReadyEvent");
                }
            }
        });

        app.run(args);
        /*
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(Parent.class)
                .child(Application.class)
                .run(args);
        */
    }


    @Override
    public int getExitCode() {
        return 100;
    }
}

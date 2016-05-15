package net.hoyoung.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by hoyoung on 16-4-28.
 */
public class StudentLog {
    public void before(){
        System.out.println(this.getClass().getName()+" before");
    }
    public void after(){
        System.out.println(this.getClass().getName()+" after");
    }
    public void afterReturning(){
        System.out.println(this.getClass().getName()+" afterReturning");
    }
    public void afterThrowing(){
        System.out.println(this.getClass().getName()+" afterThrowing");
    }

    /**
     * 第一个参数必须为ProceedingJoinPoint
     * @param proceedingJoinPoint
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object obj = null;
        try {
            System.out.println(this.getClass().getName()+" around1");
            obj = proceedingJoinPoint.proceed();
            System.out.println(this.getClass().getName()+" around2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
    public Object aroundInit(ProceedingJoinPoint proceedingJoinPoint,String bizName,int bizTime){
        Object obj = null;
        System.out.println("bizName="+bizName+",bizTime="+bizTime);
        try {
            System.out.println(this.getClass().getName()+" around3");
            obj = proceedingJoinPoint.proceed();
            System.out.println(this.getClass().getName()+" around4");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}

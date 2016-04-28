package net.hoyoung.proxy.jdk;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hoyoung on 16-3-8.
 */
public class TimeInvokeHandler implements InvocationHandler {
    private Object target;

    public TimeInvokeHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理方法
     * @param args 方法的参数
     * @return 方法返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("计时开始");
        method.invoke(target);
        System.out.println("计时结束");
        return null;
    }
}

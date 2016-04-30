package net.hoyoung.hello;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * Created by hoyoung on 16-4-30.
 */
public class JedisTest {
    Jedis jedis;
    @Before
    public void before(){
        jedis = new Jedis();
    }
    @After
    public void after(){
        jedis.close();
    }

    @Test
    public void testSet(){

        //测试是否连通
        System.out.println(jedis.ping());

        jedis.set("name", "hoyoung");
        System.out.println(jedis.get("name"));


    }
    @Test
    public void testList(){
        jedis.lpush("nblist", "a");
        jedis.lpush("nblist", "b");
        jedis.lpush("nblist", "c");
        /**
         * 内部存储顺序:
         * c b a
         * 类似于栈
         */
        List<String> list = jedis.lrange("nblist", 0, -1);
        for (String s : list){
            System.out.println(s);
        }
        /**
         * 输出
         * c
         * b
         * a
         */
    }

    /**
     * 获取所有key的值
     */
    @Test
    public void getAllKey(){
        Set<String> set = jedis.keys("*");
        for (String s : set){
            System.out.println(s);
        }
    }

    @Test
    public void getShutdown(){
        /**
         * redis会关闭
         */
        jedis.shutdown();
    }
    @Test
    public void getkeyOpt(){
        /**
         * 删除key,返回值:
         * 1:成功
         * 0:失败,不存在key
         */
        System.out.println(jedis.del("name"));
        System.out.println(jedis.exists("name"));
        /**
         * 不存在返回字符串"none"
         */
        System.out.println(jedis.type("name"));
        System.out.println(jedis.type("nblist"));

        /**
         * 删除当前选择数据库的所有key
         */
//        jedis.flushDB();
        /**
         * 删除所有数据库中的所有key
         */
//        jedis.flushAll();

    }
    @Test
    public void testWatch(){


        Transaction tx = jedis.multi();
        tx.set("age","18");
        tx.set("height","180");
        List<Object> list = tx.exec();
        for (Object object : list){
            System.out.println(object);
        }
    }

    /**
     * 我们调用jedis.watch(…)方法来监控key，如果调用后key值发生变化，则整个事务会执行失败。
     * 事务中某个操作失败，并不会回滚其他操作。这一点需要注意。
     * 我们可以使用discard()方法来取消事务。
     */
    @Test
    public void testMultiTransaction(){


        Transaction tx = jedis.multi();
        tx.set("age","18");
        tx.set("height","180");
        List<Object> list = tx.exec();
        for (Object object : list){
            System.out.println(object);
        }
    }
}

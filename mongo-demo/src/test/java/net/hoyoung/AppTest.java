package net.hoyoung;

import com.mongodb.*;
import com.mongodb.util.JSON;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    static Mongo mongo;
    static {
        try {
            mongo = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    /**
     * Rigourous Test :-)
     */
    public void testAdd()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        DBObject user = new BasicDBObject();
        user.put("name","hoyoung1");
        user.put("age", 22);
        System.out.println(users.insert(user).getN());
        this.testQuery1();
    }

    /**
     * 插入集合
     */
    public void testAddList()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");

        List<DBObject> list = new ArrayList<DBObject>();
        for (int i = 0; i < 5; i++) {
            DBObject user = new BasicDBObject();
            user.put("name","hoyoung"+i);
            user.put("age", 22+i);
            list.add(user);
        }
        System.out.println(users.insert(list).getN());
    }
    public void testQuery1()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        System.out.println(users.count());
        DBCursor cursors = users.find();
        while (cursors.hasNext()){
            System.out.println(cursors.next());
        }
    }
    public void testQuery2()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        DBCursor cursors = users.find(new BasicDBObject("age",22));
        while (cursors.hasNext()){
            System.out.println(cursors.next());
        }
        System.out.println("单个查询");
        DBObject user = users.findOne(new BasicDBObject("age", 22));
        System.out.println(user);
    }

    /**
     * 根据ID删除
     */
    public void testRemoveByID()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        users.remove(new BasicDBObject("_id",new ObjectId("56d97f10e4e2b0bd8863722c")));
        this.testQuery1();
    }
    /**
     * 删除年龄大于某个值
     */
    public void testRemoveGte()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        //大于等于24
        users.remove(new BasicDBObject("age",new BasicDBObject("$gte",24)));
        this.testQuery1();
    }
    /**
     * 全部删除
     */
    public void testRemoveAll()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        //大于等于24
        users.remove(new BasicDBObject());
        this.testQuery1();
    }
    public void testModify1()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        //注意，这种修改会覆盖原有的
        users.update(
                new BasicDBObject("_id",new ObjectId("56d98117e4e2950d42d7581b")),
                new BasicDBObject("age",20));
        this.testQuery1();
    }
    public void testModify2()
    {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("users");
        //注意，这种修改会覆盖原有的
        users.update(
                new BasicDBObject("name","hoyoung1"),
                new BasicDBObject("age",20),
                true,//如果数据库不存在，是否添加
                false//false只修改第一条，true如果有多条就不修改
        );
        this.testQuery1();
    }
    public void testOthers() {
        DB db = mongo.getDB("test");

        DBObject user = new BasicDBObject();
        user.put("name","hoyoung1");
        user.put("age", 22);
        //转换为json字符串
        System.out.println(JSON.serialize(user));
        //反序列化
        System.out.println("parse: " + JSON.parse("{ \"name\" : \"hoojo\" , \"age\" : 24}"));

        System.out.println("判断temp Collection是否存在: " + db.collectionExists("temp"));

        //如果不存在就创建
        if (!db.collectionExists("temp")) {
            DBObject options = new BasicDBObject();
            options.put("size", 20);
            options.put("capped", 20);
            options.put("max", 20);
            System.out.println(db.createCollection("account", options));
        }

        //设置db为只读
        db.setReadOnly(true);

        //只读不能写入数据
        db.getCollection("test").save(user);
    }
    @Override
    protected void tearDown() throws Exception {
        if(mongo!=null){
            mongo.close();
        }
    }
}

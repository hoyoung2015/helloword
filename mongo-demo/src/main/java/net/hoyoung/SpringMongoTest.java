package net.hoyoung;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by hoyoung on 16-3-4.
 * Spring结合mongo
 */
public class SpringMongoTest {
    private static String[] config = { "classpath:applicationContext.xml" };
    public static ApplicationContext APP_CONTEXT;
    static{
        APP_CONTEXT = new FileSystemXmlApplicationContext(config);
    }

    public static void main(String[] args) {
        new SpringMongoTest();
        MongoTemplate mongoTemplate = APP_CONTEXT.getBean(MongoTemplate.class);
        DB db = mongoTemplate.getDb();
        DBCollection users = db.getCollection("users");
        System.out.println(users.count());
        DBCursor cursors = users.find();
        while (cursors.hasNext()){
            System.out.println(cursors.next());
        }
    }
}

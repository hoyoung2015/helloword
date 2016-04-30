package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hoyoung on 16-4-30.
 */
public class AccessPrivateVar {
    static class Person{
        private String p1;
        protected String p2;
        public String p3;
    }
    public static class Student extends Person{
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        private void play(String friend){
            System.out.println(this.name+" is playing with "+friend);
        }
    }

    public static void main(String[] args) {
        /**
         * 使用getFields()只能获取public类型的字段包括父类的
         */
        Field[] fields = Student.class.getFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
        System.out.println("---------华丽丽的分割线----------");
        /**
         * 使用getDeclaredFields()只能获得本类的所有字段,不包括父类的任何字段
         * 但是可以通过getSuperclass()获取父类得到
         */
        fields = Student.class.getDeclaredFields();
        System.out.println(Student.class.getSuperclass().getName());
        for (Field field : fields){
            System.out.println(field.getName());
        }

        System.out.println("---------华丽丽的分割线----------");
        Student student = new Student(10,"hoyoung");
        Field field = null;
        try {
            /**
             * 此处注意内部类要用$
             */
            field = Class.forName("reflect.AccessPrivateVar$Student").getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        /**
         * 这里是关键
         */
        field.setAccessible(true);

        try {
            /**
             * 获取变量值
             */
            Object obj = field.get(student);
            System.out.println(obj);
            /**
             *设置变量值
             */
            field.set(student,"niuniu");
            System.out.println(student);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }


        try {
            Method method = Student.class.getDeclaredMethod("play", String.class);
            /**
             * 这里也是关键
             */
            method.setAccessible(true);
            method.invoke(student,"xiaoming");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

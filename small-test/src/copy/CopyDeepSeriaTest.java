package copy;

import java.io.*;

/**
 * Created by hoyoung on 16-4-28.
 */
public class CopyDeepSeriaTest {
    /**
     * 由于使用序列化机制实现复制,所以复制对象要实现Serializable接口
     * 成员引用变量也要实现Serializable接口
     */
    static class Student implements Serializable{
        private String name;
        private int age;
        Professor professor;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", professor=" + professor +
                    '}';
        }
        public Object deepClone() throws IOException, ClassNotFoundException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
    }
    static class Professor implements Serializable{
        private String name;
        private String sex;

        public Professor(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Professor{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.age = 10;
        student.name = "hoyoung";
        student.professor = new Professor("Tom","man");
        System.out.println(student);
        try {
            Student studentCopy = (Student) student.deepClone();
            System.out.println(studentCopy);
            System.out.println(student==studentCopy);//false
            System.out.println(student.professor==studentCopy.professor);//false
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

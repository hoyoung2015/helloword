package copy;

/**
 * Created by hoyoung on 16-4-28.
 */
public class CopyTest {




    /**
     * 必须实现Cloneable,这个接口仅是个标志
     */
    static class Student implements Cloneable{
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

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Student student = null;

            student = (Student) super.clone();
            return student;
        }
    }
    static class Professor{
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
            Student studentCopy = (Student) student.clone();
            System.out.println(studentCopy);
            System.out.println(studentCopy==student);//false 不是同一个对象了
            System.out.println(studentCopy.professor==student.professor);//true 浅复制指向同一个对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}

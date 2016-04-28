package copy;

/**
 * Created by hoyoung on 16-4-28.
 */
public class CopyDeepTest {




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
            Student student = (Student) super.clone();
            //调用引用对象的克隆方法
            student.professor = (Professor) this.professor.clone();
            return student;
        }
    }
    static class Professor implements Cloneable{
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

        /**
         * 要在需要深复制的对象中实现引用对象的克隆方法
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
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
            System.out.println(studentCopy.professor==student.professor);//false 深复制指向不同的对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}

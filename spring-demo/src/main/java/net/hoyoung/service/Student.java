package net.hoyoung.service;

/**
 * Created by hoyoung on 16-4-28.
 */
public class Student {
    private int sno;
    private String name;
    private int age;

    public void start(){
        System.out.println(this.getClass().getName()+"初始化");
    }
    public void stop(){
        System.out.println(this.getClass().getName()+"销毁");
    }
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void study(){
        System.out.println(name+"正在学习");
    }
    public int testThrowing(){
        System.out.println(this.getClass().getName()+" testThrowing");
        return  1/0;
    }
    public void init(String name,int time){
        System.out.println(this.getClass().getName()+":name="+name+",time="+time);
    }
    public void testDeclareParents(){
        System.out.println(this.getClass().getName()+" testDeclareParents");
    }
}

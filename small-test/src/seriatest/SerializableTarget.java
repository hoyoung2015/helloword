package seriatest;

import java.io.*;

/**
 * Created by hoyoung on 16-4-27.
 */
public class SerializableTarget implements Serializable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerializableTarget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SerializableTarget target = new SerializableTarget();
        target.setId(10);
        target.setName("hoyoung");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.dat"));
            oos.writeObject(target);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.dat"));
            SerializableTarget readTarget = (SerializableTarget) ois.readObject();
            ois.close();
            System.out.println(readTarget);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

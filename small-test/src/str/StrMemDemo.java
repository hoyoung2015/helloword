package str;

/**
 * Created by hoyoung on 16-4-28.
 * String的值相同,那么计算出的hashCode相同
 * 通过显示声明的两个相同内容的String在同一个地址,是同一个对象
 */

public class StrMemDemo {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a==b);
        String c = new String("hello");
        System.out.println(a==c);
    }
}

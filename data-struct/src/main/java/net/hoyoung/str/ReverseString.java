package net.hoyoung.str;

/**
 * Created by hoyoung on 16-4-13.
 * 三翻转法
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("abcdef",2));
    }
    public static String reverse(String s,int pos){
        char[] cs = s.toCharArray();
        reversePart(cs,0,pos);
        reversePart(cs,pos+1,cs.length-1);
        reversePart(cs,0,cs.length-1);
        return new String(cs);
    }
    private static void reversePart(char[] cs,int from,int to){

        while (from<to){
            char temp = cs[from];
            cs[from++] = cs[to];
            cs[to--] = temp;
        }
    }
}

package net.hoyoung.bag;

/**
 * Created by hoyoung on 16-4-20.
 * 字符数组全排列
 */
public class AllCharArraySort {
    public static void main(String[] args) {
        solve(new char[]{'a','b','c'},0,2);
    }
    static void solve(char[] cs,int from ,int to){
        if(from==to){
            for (char c : cs){
                System.out.print(c + " ");
            }
            System.out.println();
        }else {
            for (int i = from; i <= to; i++) {
                char temp = cs[from];
                cs[from] = cs[i];
                cs[i] = temp;
                solve(cs,from+1,to);

                //恢复过来用于下一个循环
                temp = cs[from];
                cs[from] = cs[i];
                cs[i] = temp;
            }
        }
    }
}

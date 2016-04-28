package net.hoyoung.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hoyoung on 16-4-13.
 * 输入两个数n和sum,要求从数列1,2,3,...,n中随意取出几个数,使得他们的和等于sum
 */
public class SumOfkNumber {
    List<Integer> list = new LinkedList<Integer>();
    public void solve(int sum,int n){
        if(n<=0 || sum<=0){
            return;
        }
        if(sum==n){
            Collections.reverse(list);
//            System.out.println("输出");
            for (Integer i: list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        list.add(n);
        this.solve(sum-n,n-1);//包含n
        list.remove(0);
        this.solve(sum,n-1);//不包含n

    }

    public static void main(String[] args) {
        new SumOfkNumber().solve(20,18);
    }
}

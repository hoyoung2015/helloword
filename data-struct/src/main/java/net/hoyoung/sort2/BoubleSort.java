package net.hoyoung.sort2;

import net.hoyoung.sort.*;
import net.hoyoung.util.Printer;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by hoyoung on 16-3-21.
 * 通用冒泡排序
 * 复杂度分析：
 * 最好情况，即有序状态，需要n-1次比较，没有数据交换。
 * 最坏情况，逆序，比较1+2+3+...+(n-1)=n(n-1)/2也就是O(n^2)
 */
public class BoubleSort{
    public static <T extends Comparable> void sort(T[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j].compareTo(array[j+1])<0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;//标记出现了数据交换
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(100);
        }
        Printer.printArray(data);
        BoubleSort.sort(data);
        Printer.printArray(data);
    }
}

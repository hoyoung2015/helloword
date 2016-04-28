package net.hoyoung.sort2;

import net.hoyoung.util.Printer;

import java.util.Random;

/**
 * Created by hoyoung on 16-3-21.
 * 直接插入排序
 * 最好情况，有序，比较n-1次
 * 最坏情况，逆序，比较2+3+...+n=(n+2)(n-1)/2，移动3+4+...+(n+1)=(n+4)(n-1)/2
 */
public class InsertSort {
    public static <T extends Comparable> void sort(T[] array){
        for (int i = 1; i < array.length; i++) {
            if(array[i-1].compareTo(array[i])>0){//i的前一个比i大
                T temp = array[i];
                int j = i - 1;
                for (; j >= 0 && array[j].compareTo(temp) > 0; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
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
        InsertSort.sort(data);
        Printer.printArray(data);
    }
}

package net.hoyoung.sort2;

import net.hoyoung.util.Printer;

import java.util.Random;

/**
 * Created by hoyoung on 16-3-21.
 *简单选择排序
 * 最大特点，交换移动次数少
 *无论最好最差，比较次数一样多
 * 比较(n-1)+...+3+2+1=n(n-1)/2也就是O(n^2)
 * 虽然和冒泡的时间复杂度相同，但是还是优于冒泡
 */
public class SelectSort {
    public static <T extends Comparable> void sort(T[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[min].compareTo(array[j]) > 0){
                    min = j;
                }
            }
            if(min > i){
                T temp = array[i];
                array[i] = array[min];
                array[min] = temp;
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
        SelectSort.sort(data);
        Printer.printArray(data);
    }
}

package net.hoyoung.sort;

import net.hoyoung.util.Printer;

import java.util.Random;

/**
 * Created by hoyoung on 16-3-3.
 */
public class InsertSort implements ISort{
    public void sort(Integer[] data){
        for (int i = 0; i < data.length-1; i++) {
            if(data[i+1] < data[i]){
                int temp = data[i+1];
                int j;
                for (j = i+1; j > 0 && data[j-1] > temp ; j--) {
                    data[j] = data[j-1];
                }
                data[j] = temp;
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
        new InsertSort().sort(data);
        Printer.printArray(data);
    }
}

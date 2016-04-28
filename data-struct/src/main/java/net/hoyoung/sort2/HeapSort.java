package net.hoyoung.sort2;

import net.hoyoung.util.Printer;

/**
 * Created by hoyoung on 16-3-21.
 */
public class HeapSort {
    public static <T extends Comparable> void sort(T[] array){
        int mid = array.length/2;
        for (int i = mid; i > 0; i--) {
            headAdjust(array,i,array.length);
        }
        Printer.printArray(array);
        for (int i = array.length; i > 1; i--) {
            T temp = array[(i-1)];
            array[(i-1)] = array[1-1];
            array[1-1] = temp;
            headAdjust(array, 1, i - 1);
        }
    }
    public static <T extends Comparable> void headAdjust(T[] array,int s,int m){
        int j;
        T temp = array[(s-1)];
        for (j=2*s;j<=m;j*=2){//父亲和儿子中的较大者交换后，如果该孩子还有孩子，则继续循环交换，j*=2与j=2*s是一个目的
            if(j<m && array[(j-1)].compareTo(array[(j-1)+1]) < 0){//左孩子比有孩子小,j<m-1防止j+1越界
                j++;//指向大的索引
            }
            if(temp.compareTo(array[(j-1)]) >= 0){//和孩子中的较大者比较
                break;//父节点大，直接退出
            }
            array[(s-1)] = array[(j-1)];//父节点和孩子中的较大者交换
            s = j;//s指向交换后的孩子，如果还有孩子进入下一层
        }
        array[(s-1)] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {50,10,90,30,70,40,80,60,20};
        HeapSort.sort(array);
        Printer.printArray(array);
    }
}

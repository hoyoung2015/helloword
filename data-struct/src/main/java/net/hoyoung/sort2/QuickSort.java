package net.hoyoung.sort2;

/**
 * Created by hoyoung on 16-3-21.
 */
public class QuickSort {
    public static <T extends Comparable> void sort(T[] array){


    }
    private static <T extends Comparable> void qSort(T[] array,int s,int t){

        if(s==t){
            return;
        }

        T target = array[s];
        int i=s+1,j=t;
        while (i < j){
            while (i<j && array[i].compareTo(target) < 0){
                i++;
            }
            while (i<j && array[j].compareTo(target) > 0){
                j--;
            }
            if(i != j){
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

    }
}

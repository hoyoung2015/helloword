package net.hoyoung.sort2;

import net.hoyoung.util.Printer;

/**
 * Created by hoyoung on 16-3-21.
 */
public class MergeSort {
    public static <T extends Comparable> void sort(T[] array){
//        T[] out = new T[array.length];

    }
    private static <T extends Comparable> void mSort(T[] array,T[] out,int s,int t){
        Integer[] a = new Integer[10];
        if(s==t){
            out[s] = array[s];
        }else{
            int m = (s+t)/2;
            mSort(array,out,s,m);
            mSort(array,out,m+1,t);
            int i = s,j = m+1;
            int k = s;
            while (i<m && j<t){
                if(array[i].compareTo(array[j]) <= 0){
                    out[k++] = array[i++];
                }else {
                    out[k++] = array[j++];
                }
            }
            while (i < m){
                out[k++] = array[i++];
            }
            while (j < t){
                out[k++] = array[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5,1,9,3,7,4,8,6,2};

    }
}

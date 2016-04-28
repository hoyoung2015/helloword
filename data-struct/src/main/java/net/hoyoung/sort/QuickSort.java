package net.hoyoung.sort;

import net.hoyoung.util.Printer;

import java.util.Random;

/**
 * Created by hoyoung on 16-3-3.
 * 快速排序算法
 * 不稳定的排序
 * 时间复杂度O(nlogn)
 */
public class QuickSort {
    public static void main(String[] args) {
//        int unsortedArray[] = new int[]{6, 5, 3,6, 1, 8, 7, 2, 4};
        int unsortedArray[] = new int[]{6, 1,2,3,4,5,6,9,7,6,8};
        quickSort(unsortedArray);
        System.out.println("After	sort:	");
        for (int item : unsortedArray) {
            System.out.print(item + "	");
        }
    }

    public static void quickSort2(int[] array, int l, int u) {
        for (int item : array) {
            System.out.print(item + "	");
        }
        System.out.println();
        if (l >= u) return;
        int pivot = array[l];
        int left = l + 1;
        int right = u;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] >= pivot) {
                right--;
            }
            if (left > right) break;
            //	swap	array[left]	with	array[right]	while	left	<=	right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
                                 /*	swap	the	smaller	with	pivot	*/
        int temp = array[right];
        array[right] = array[l];
        array[l] = temp;
        quickSort2(array, l, right - 1);
        quickSort2(array, right + 1, u);
    }

    public static void quickSort(int[] array) {
        quickSort2(array, 0, array.length - 1);
    }

}

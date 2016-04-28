package net.hoyoung;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchNoExist {

    public static Integer lostNum(int arr[], int len, int maxBits) {

        List lostNumList = new ArrayList();

        int lostNum = 0;

        int MASK = 0;

        int locZero = 0;

        int locOne = 0;

        int[] arrZero = new int[len];

        int[] arrOne = new int[len];

        for (int bit = maxBits - 1; bit >= 0; bit--) {

            locOne = 0;
            locZero = 0;

            MASK = 1 << bit;
            for (int i = 0; i < len; i++) {
                if ((arr[i] & MASK) == MASK) {
                    arrOne[locOne++] = arr[i];
                } else {
                    arrZero[locZero++] = arr[i];
                }
            }

            if ((locOne == MASK) && (locZero == MASK)) {

            } else {
                if (locOne > locZero) {
                    arr = arrZero;
                    len = locZero;
                } else {
                    lostNum += MASK;
                    arr = arrOne;
                    len = locOne;
                }
            }
        }

        return lostNum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 7, 10, 9, 11, 12, 14};
        System.out.println(lostNum(arr, arr.length, 4));
    }

}
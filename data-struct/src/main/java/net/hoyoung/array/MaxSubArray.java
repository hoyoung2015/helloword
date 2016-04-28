package net.hoyoung.array;

/**
 * Created by hoyoung on 16-4-20.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,-2,3,10,-4,7,2,-5}));
    }

    /**
     * 蛮力穷举
     * @param arr
     * @return
     */
    static int solve(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(max<sum){
                    max = sum;
                }
            }
        }
        return max;
    }
}

package net.hoyoung.bag;

/**
 * Created by hoyoung on 16-4-20.
 */
public class BagTest {
    public static void main(String[] args) {
        System.out.println(solve(10,new int[]{5,4,6,3},new int[]{10,40,30,50}));
    }
    static int solve(int W,int[] w,int[] v){
        int N = w.length;
        int[][] dp = new int[N+1][W+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                if(w[i]>j){
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        return dp[N][W];
    }
}

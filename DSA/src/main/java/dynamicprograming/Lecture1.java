package dynamicprograming;

import java.util.Arrays;

public class Lecture1 {

    static int recursiveCode(int n){
        if (n<=1){
            return n;
        }
        return recursiveCode(n-1) + recursiveCode(n-2);
    }

    static int memoization(int n, int[] dp){
        if (dp[n]!=-1) return dp[n];
        if (n<=1){
            return dp[n] = n;
        }

        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
    }

    static int tabulation(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }

        return dp[n];
    }

    static int spaceOptimization(int n){
        int prev = 1;
        int prev2 = 0;

        for (int i=2;i<=n;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
//        System.out.println(recursiveCode(n));
//        System.out.println(memoization(n, dp));
//        System.out.println(tabulation(n, dp));
        System.out.println(spaceOptimization(n));
    }
}

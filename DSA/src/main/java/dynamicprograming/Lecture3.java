package dynamicprograming;

import java.util.Arrays;

public class Lecture3 {

    static int recursive(int n, int[] heights){
        if (n == 0) return 0;
        if (n==1) return Math.abs(heights[1] - heights[0]);

        int jumpOne = recursive(n-1, heights) + Math.abs(heights[n]-heights[n-1]);
        int jumpTwo = recursive(n-2, heights) + Math.abs(heights[n]-heights[n-2]);
        return Math.min(jumpOne, jumpTwo);
    }
    static int memoization(int n, int[] numbers, int[] dp){
        if (dp[n]!=-1)return dp[n];

        if (n==0) return dp[n] = 0;
        if(n==1) return dp[n] = Math.abs(numbers[1]-numbers[0]);

        int left = memoization(n-1, numbers, dp) + Math.abs(numbers[n]-numbers[n-1]);
        int right = memoization(n-2, numbers, dp) + Math.abs(numbers[n]-numbers[n-2]);

        return dp[n] = Math.min(left, right);
    }

    static int tabulation(int n, int[] numbers, int[] dp){
        dp[0] = 0;
        dp[1] = Math.abs(numbers[1]-numbers[0]);

        for (int i=2;i<n;i++) {
            int first = dp[i-1] + Math.abs(numbers[i]- numbers[i-1]);
            int second = dp[i-2] + Math.abs(numbers[i] - numbers[i-2]);
            dp[i] = Math.min(first,second);
        }

        return dp[n-1];
    }

    static int spaceOptimization(int n, int[] numbers){
        int prev2 = 0;
        int prev = Math.abs(numbers[1]- numbers[0]);

        for (int i =2;i<n;i++){
            int jumpOne = prev + Math.abs(numbers[i]-numbers[i-1]);
            int jumpTwo = prev2 + Math.abs(numbers[i] - numbers[i-2]);
            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] numbers = {30,10,60,10,60,50};
        int[] dp = new int[numbers.length];
        Arrays.fill(dp, -1);
//        System.out.println(solution1(6, numbers, dp));
//        System.out.println(recursive(5, numbers));
//        System.out.println(memoization(5, numbers, dp));
//        System.out.println(tabulation(6, numbers, dp));
        System.out.println(spaceOptimization(6, numbers));

    }
}

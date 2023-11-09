package dynamicprograming;

import java.util.Arrays;

public class Lecture4 {

    static int recursive(int n, int k, int[] numbers){
        if (n==0) return 0;

        int min = Integer.MAX_VALUE;
        for (int j=1;j<=k;j++){
            if (n-j>=0){
                int jump = recursive(n-j, k, numbers) + Math.abs(numbers[n]-numbers[n-j]);
                min = Math.min(min, jump);
            }
        }
        return min;
    }

    static int memoization(int n, int k, int[] numbers, int[] dp){
        if (n==0) return 0;

        if (dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int j=1;j<=k;j++){
            if (n-j>=0){
                int jump = recursive(n-j, k, numbers) + Math.abs(numbers[n]-numbers[n-j]);
                min = Math.min(min, jump);
            }
        }
        return dp[n] = min;
    }

    static int tabulation(int n, int k, int[] numbers, int[] dp){
        dp[0] = 0;

        for (int i=1;i<n;i++){
            int min =Integer.MAX_VALUE;
            for (int j=1;j<=k;j++){
                if (i-j>=0){
                    int jump = dp[i-j] + Math.abs(numbers[i]-numbers[i-j]);
                    min = Math.min(jump,min);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
    static int solution1(int n, int k, int[] numbers){
        if (n==0) return 0;
//        if (n==1) return numbers[1]-numbers[0];
        int min = Integer.MAX_VALUE;
        for (int j=1;j<=k;j++){
            if (n-j>=0){
                int jump = solution1(n-j, k, numbers) + Math.abs(numbers[n]-numbers[n-j]);
                min = Math.min(min, jump);
            }
        }

        return min;
    }
    static int solution2(int n, int k, int[] numbers, int[] dp){
        int[] prev = new int[k];

        for (int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for (int j=1;j<=k;j++){
                if (i-j>=0){
                    int jump = prev[i-j] + Math.abs(numbers[i] - numbers[i-j]);
                    prev[i-j] = Math.min(min, jump);
                }
            }
            prev[0] = min;
        }
        return prev[k-1];
    }
    public static void main(String[] args) {
        int k = 4;
        int[] numbers = {30,10,60 , 10 , 60 , 50};
        int n = numbers.length;
//        System.out.println(recursive(n-1, k, numbers));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
//        System.out.println(memoization(n-1, k, numbers, dp));
//        System.out.println(tabulation(n, k, numbers, dp));
        System.out.println(solution2(n, k, numbers, dp));
    }
}

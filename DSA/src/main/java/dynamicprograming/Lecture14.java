package dynamicprograming;

import java.util.Arrays;

public class Lecture14 {

    static boolean recursion(int index, int target, int arr[], int[][] dp){
        if(target == 0){
            return true;
        }
        if(index<0){
            return false;
        }

        if(dp[index][target]!=-1){
            return dp[index][target] == 1;
        }

        boolean pick = recursion(index-1, target-arr[index], arr, dp);
        if(pick){
            dp[index][target] = 1;
            return true;
        }
        boolean notPick = recursion(index-1, target, arr, dp);
        if(notPick){
            dp[index][target] = 1;
            return true;
        }
        // if(pick || notPick){
        //     return dp[index][target] =  true;
        // }
        dp[index][target] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n=4;
        int k = 5;
        int[] arr = {4, 3, 2, 1};
        int[][] dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.printf(String.valueOf(recursion(n-1, k, arr, dp)));
    }
}

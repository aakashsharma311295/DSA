package dynamicprograming;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i =0;i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i =0;i<=m; i++){
            dp[0][i] = 0;
        }

        for(int i =1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int length = dp[n][m];
        StringBuilder lcs = new StringBuilder();
        lcs.re


        int i = n;
        int j = m;

        while (i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                lcs.append(s1.charAt(i-1));
                i--;
                j--;
            }else if (dp[i][j-1]>=dp[i-1][j]){
                j--;
            }else {
                i--;
            }
        }

        System.out.println(lcs.reverse());
    }
}

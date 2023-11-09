package striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountDistintIslands {
    static class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

    static void dfs(int row, int col, int[][] grid, boolean[][] visited, int n, int m, int baseRow, int baseCol, ArrayList<String> list){
        visited[row][col] = true;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        int r = row-baseRow;
        int c = col-baseCol;
        list.add(Integer.toString(r)+ " " +Integer.toString(c));
        for(int i=0;i<4;i++){
            int nrow = row+di[i];
            int ncol = col+dj[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, visited, n, m, baseRow, baseCol, list);
            }
        }

    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Set<ArrayList<String>> set = new HashSet<ArrayList<String>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ArrayList<String> list = new ArrayList<String>();
                    dfs(i, j, grid, visited, n, m, i, j, list);
                    set.add(list);
                }
            }
        }
    }
}

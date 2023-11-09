package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    static void bfs(char[][] grid, int[][] visited, int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair pair = q.remove();
            int r = pair.row;
            int c = pair.col;
            for(int i =0;i<4;i++){
                int nrow = r+di[i];
                int ncol = c+dj[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0
                        && grid[nrow][ncol]=='1'){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && grid[i][j]=='1'){
                    count++;
                    visited[i][j] = 1;
                    bfs(grid, visited, i, j);
                }
            }
        }
    }
}

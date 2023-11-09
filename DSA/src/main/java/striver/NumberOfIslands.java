package striver;

public class NumberOfIslands {

    static void dfs(char[][] grid, int[][] visited, int row, int col, int n, int m){
        visited[row][col] = 1;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        for(int i=0;i<4;i++){
            int nrow = row+di[i];
            int ncol = col+dj[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(grid,visited,nrow, ncol, n, m);
            }

        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && grid[i][j]=='1'){
                    count++;
                    // visited[i][j] = 1;
                    // bfs(grid, visited, i, j);
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }
        System.out.println(count);
    }
}

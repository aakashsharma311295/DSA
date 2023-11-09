//package graph;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class RottenOranges {
//    public static int orangesRotting(int[][] grid) {
//        Queue<Pair> q = new LinkedList<Pair>();
//        int[][] visited = new int[grid.length][grid[0].length];
//
//        int n = grid.length;
//        int m = grid[0].length;
//        for(int i =0; i<n; i++){
//            for(int j=0; j<m; j++){
//                if(grid[i][j] == 2){
//                    q.add(new Pair(i, j, 0));
//                    visited[i][j] = 2;
//                }else if(grid[i][j] == 0){
//                    visited[i][j] = 0;
//                }
//            }
//        }
//        int[] di = {0,1,0,-1};
//        int[] dj = {1,0,-1,0};
//        int tm = 0;
//        while(!q.isEmpty()){
//            Pair pair = q.remove();
//            int r = pair.row;
//            int c = pair.col;
//            int t = pair.t;
//            tm = Math.max(tm,t);
//            for(int i=0;i<4;i++){
//                int nrow = r+di[i];
//                int ncol = c+dj[i];
//                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
//                    q.add(new Pair(nrow, ncol, t+1));
//                    visited[nrow][ncol] = 2;
//                }
//            }
//        }
//
//        for(int i =0; i<n; i++){
//            for(int j=0; j<m; j++){
//                if(visited[i][j] != 2 && grid[i][j] == 1){
//                    return -1;
//                }
//            }
//        }
//        return tm;
//    }
//    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
//        int time = orangesRotting(grid);
//    }
//}

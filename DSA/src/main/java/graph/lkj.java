package graph;

public class lkj {

    static Boolean isCycleDirected(int[][] edges, boolean[] visited, boolean[] recursionStack, int curr){

        recursionStack[curr] = true;
        visited[curr] = true;

        for(int i=0;i<edges[curr].length;i++){
            int edge = edges[curr][i];
            if(edge == 1){
                if(recursionStack[i] && visited[i]){
                    return true;
                }else if(!visited[i]){
                    return isCycleDirected(edges, visited, recursionStack, i);
                }
            }
        }
        recursionStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[4][4];
        edges[3][3] = 1;
        edges[1][0] = 1;
        edges[1][2] = 1;
        edges[0][2] = 1;
        boolean[] visited = new boolean[4];
        boolean[] recursionStack = new boolean[4];
        for(int i=0;i<4;i++){
            if(!visited[i]){
                Boolean isCycle = isCycleDirected(edges,visited,recursionStack,i);
                if(isCycle){
                    System.out.println("cycle present");
                }
            }
        }

    }
}

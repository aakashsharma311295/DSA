package graph;

public class AdjacencyMatrix2 {

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = new int[4][4];
        createGraph(graph);
    }

    private static void createGraph(int[][] graph) {
        graph[0][2] = 1;
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[2][0] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[3][1] = 1;
        graph[3][2] = 1;

        for (int i =0;i<graph.length;i++){
            for (int j=0;j<graph[0].length;j++){
                System.out.print(graph[i][j] + " | ");
            }
            System.out.println();
        }
    }
}

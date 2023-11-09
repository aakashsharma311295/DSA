package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyList {
    public static void main(String[] args) {
        ArrayList<WeightEdge>[] graph = new ArrayList[4];
        for (int i =0;i<4;i++){
            graph[i] = new ArrayList<WeightEdge>();
        }
        createGraph(graph);
        boolean[] visited = new boolean[graph.length];
        for (int i =0;i<graph.length;i++){
            if (!visited[i]){
                bfs(graph, visited, i);
            }
        }
        System.out.println();

        boolean[] visited2 = new boolean[graph.length];
        dfs(graph,0,visited2);
    }

    private static void bfs(ArrayList<WeightEdge>[] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(start);
        while (!q.isEmpty()){
            int curr = q.remove();
            if (!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i=0;i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    static void dfs(ArrayList<WeightEdge>[] graph, int curr, boolean[] visited){
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i =0;i<graph[curr].size();i++){
            WeightEdge edge = graph[curr].get(i);
            if (!visited[edge.dest]){
                dfs(graph, edge.dest, visited);
            }
        }
    }

    private static void createGraph(ArrayList<WeightEdge>[] graph) {
        graph[0].add(new WeightEdge(0,2,2));
        graph[1].add(new WeightEdge(1,2,10));
        graph[1].add(new WeightEdge(1,3,0));
        graph[2].add(new WeightEdge(2,3,-1));
        graph[2].add(new WeightEdge(2,1,10));
        graph[2].add(new WeightEdge(2,0,2));
        graph[3].add(new WeightEdge(3,1,0));
        graph[3].add(new WeightEdge(3,2,-1));

        for (int i=0; i<graph.length; i++){
            for (int j=0; j<graph[i].size(); j++){
                WeightEdge edge = graph[i].get(j);
                System.out.println("src :: " + edge.src + " dest :: " + edge.dest + " weight :: " + edge.weight);
            }
        }
    }
}

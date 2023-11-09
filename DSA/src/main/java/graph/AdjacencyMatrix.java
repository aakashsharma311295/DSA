package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyMatrix {

    static void createGraph(List<List<Edge>> graph) {
        graph.add(new ArrayList<Edge>() {{
            add(new Edge(0, 2));
        }});
        graph.add(new ArrayList<Edge>() {{
            add(new Edge(1, 2));
            add(new Edge(1, 3));
        }});
        graph.add(new ArrayList<Edge>() {{
            add(new Edge(2, 0));
            add(new Edge(2, 1));
            add(new Edge(2, 3));
        }});
        graph.add(new ArrayList<Edge>() {{
            add(new Edge(3, 1));
            add(new Edge(3, 2));
        }});

    }

    static void createGraph1(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

    }

    static void bfs(List<Edge>[] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).getDest());
                }
            }
        }

    }

    static void dfs(List<Edge>[] graph, boolean[] visited, int curr) {
        if (!visited[curr]) {
            System.out.println(curr);
            visited[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                dfs(graph, visited, graph[curr].get(i).getDest());
            }
        }
    }

    static void printAllPaths(List<Edge>[] graph, boolean[] visited, int curr, int target, String path) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            int dest = graph[curr].get(i).getDest();

            if (!visited[curr]){
                visited[curr] = true;
                printAllPaths(graph, visited, dest, target, path+ dest);
                visited[curr] = false;
            }
        }
    }


    static void printPaths(ArrayList<Edge>[] graph, boolean[] visited, int target, int curr, String path){
        if (curr == target){
            System.out.println(path);
            return;
        }

        visited[curr] = true;
        for (int i =0;i<graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if (!visited[edge.getDest()]){
                printPaths(graph, visited, target, edge.getDest(), path+edge.getDest());
            }
        }
        visited[curr] =false;

    }

    static boolean isCycleUndirected(ArrayList<Edge>[] graph, int parent, int curr, boolean[] visited){
        visited[curr] = true;
        for (int i=0;i<graph[curr].size();i++){
            Edge edge = graph[curr].get(i);
            if (visited[edge.getDest()] && parent!=edge.getDest()){
                return true;
            }else if (!visited[edge.getDest()]){
                return isCycleUndirected(graph, curr, edge.getDest(), visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        List<List<Edge>> graph = new ArrayList<List<Edge>>();
//        createGraph(graph);
//        for (int i=0; i<graph.get(2).size(); i++){
//            System.out.println(graph.get(2).get(i).getDest());
//        }

        ArrayList<Edge>[] graph = new ArrayList[7];
        createGraph1(graph);
        boolean[] visited = new boolean[graph.length];
//        for (int i = 0;i<visited.length;i++){
//            if (!visited[i]){
//                dfs(graph, visited, i);
//            }
//        }

//        printPaths(graph, visited, 5, 0, "0");

//        printAllPaths(graph, visited, 0, 5, "0");

        System.out.println(isCycleUndirected(graph,-1, 0, visited));
    }
}

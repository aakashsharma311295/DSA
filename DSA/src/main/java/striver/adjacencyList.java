package striver;

import java.util.ArrayList;

public class adjacencyList {

    static class Edge{
        int dest;
        int weight;
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
        list.get(0).add(new Edge(1,5));
        list.get(0).add(new Edge(2,10));
//        list.get(1).add(3);

    }
}

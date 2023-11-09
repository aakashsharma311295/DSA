package trees;

import java.util.*;

public class VerticalTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int i=0;

    static Node buildTree(int[] nodes){
        if (nodes[i] == -1){
            i++;
            return null;
        }
        Node node = new Node(nodes[i]);
        i++;
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    static class Pair{
        Node node;
        int vertical;
        int level;
        Pair(Node node, int vertical, int level){
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    static List<List<Integer>> verticalTraversal(Node root){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, List<Integer>>>();
        while (!q.isEmpty()){
            Pair pair = q.remove();
            if (!map.containsKey(pair.vertical)){
                map.put(pair.vertical, new TreeMap<Integer, List<Integer>>());
            }
            if (!map.get(pair.vertical).containsKey(pair.level)){
                map.get(pair.vertical).put(pair.level, new ArrayList<Integer>());
            }
            map.get(pair.vertical).get(pair.level).add(pair.node.data);
            if (pair.node.left!=null){
                q.add(new Pair(pair.node.left,pair.vertical-1,pair.level+1));
            }
            if (pair.node.right!=null){
                q.add(new Pair(pair.node.right,pair.vertical+1,pair.level+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (TreeMap<Integer, List<Integer>> entry : map.values()){
            for (List<Integer> en : entry.values()){
                Collections.sort(en);
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()){
            List<Integer> subAns = new ArrayList<Integer>();
            for (Map.Entry<Integer, List<Integer>> en : entry.getValue().entrySet()){
                List<Integer> res = en.getValue();
                Collections.sort(res);
                subAns.addAll(res);
            }
            ans.add(subAns);
        }

//        for (Map.Entry<TreeMap<Integer, List<Integer>> entry : map.entrySet()){
//            List<Integer> list = entry.getValue();
//            Collections.sort(list);
//            ans.add(list);
//        }
        return ans;
    }
    static class Pair1{
        Node node;
        int level;
        Pair1(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static List<Integer> rightSideView(Node root) {
        Queue<Pair1> q = new LinkedList<Pair1>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        q.add(new Pair1(root, 0));
        while(!q.isEmpty()){
            Pair1 pair = q.remove();
            if(!map.containsKey(pair.level)){
                map.put(pair.level, pair.node.data);
            }
            if(pair.node.right!=null){
                q.add(new Pair1(pair.node.right, pair.level+1));
            }
            if(pair.node.left!=null){
                q.add(new Pair1(pair.node.left, pair.level+1));
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(Integer i : map.values()){
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nodes = {1,2,4,-1,5,-1,6,-1,-1,10,-1,-1,3,9,-1,-1,10,-1,-1};
        int[] nodes = {1,2,-1,5,-1,-1,3,-1,4,-1,-1};
        Node root = buildTree(nodes);
//        verticalTraversal(root);
        List<Integer> ans = rightSideView(root);
        System.out.println(ans);
    }
}

package trees;

import java.util.*;

public class BinaryTrees {

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

    static void preorderTraversal(Node root){
        if (root == null){
            System.out.print("-1" + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void inorderTraversal(Node root){
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if (root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node node = q.remove();
            if (node == null){
                if (!q.isEmpty()){
                    System.out.println();
                    q.add(null);
                }
            }else {
                System.out.print(node.data + " ");
                if (node.left!= null){
                    q.add(node.left);
                }
                if (node.right!= null){
                    q.add(node.right);
                }
            }
        }
    }

    static int sumOfNodesAtKLevel(Node root, int K){
        if (K==1){
            return root.data;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        int i = 0;
        int sum =0;
        while (!q.isEmpty()){

            Node node = q.remove();
            if (node == null){
                if(i==K){
                    while(q.peek()!=null){
                        sum+=q.remove().data;
                    }
                    break;
                }else {
                    if (!q.isEmpty()){
                        q.add(null);
                        i++;
                    }
                }
            }else{
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return sum;
    }

    static int countTotalNodes(Node root){
        if (root == null){
            return 0;
        }
        int leftCount = countTotalNodes(root.left);
        int rightCount = countTotalNodes(root.right);
        int totalNodes = leftCount+rightCount+1;
        return totalNodes;
    }

    static int heightTree(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    static int diameter(Node root){

        if (root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = heightTree(root.left)+heightTree(root.right)+1;

        return Math.max(diam1, Math.max(diam2,diam3));
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    static TreeInfo diameter2(Node root){

        if (root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht)+1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht +right.ht + 1;

        int myDiam = Math.max(diam1, Math.max(diam2,diam3));

        return new TreeInfo(myHeight, myDiam);
    }

    static List<List<Integer>> LevelOrderTraver(Node root){
        Queue<Node> q = new LinkedList<Node>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
//            Node node = q.peek();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i=0 ; i<size;i++){
                if (q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if (q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subList.add(q.remove().data);
            }

            ans.add(subList);
        }
        return ans;
    }

    static void IterativePreorder(Node root){
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left!=null){
                stack.add(node.left);
            }
        }
    }

    static void iterativeInOrderTraversal(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (true){
            if (node!=null){
                stack.add(node);
                node = node.left;
            }else{
                if (stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    static void postOrderUsing2Stacks(Node root){
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.add(node);
            if (node.left!=null){
                stack1.add(node.left);
            }
            if (node.right!=null){
                stack1.add(node.right);
            }
        }
        int size = stack2.size();
        for (int i=0;i<size;i++){
            Node node = stack2.pop();
            System.out.print(node.data + " ");
        }
    }

    static class Pair{
        Node node;
        int num;
        Pair(Node node, int num){
            this.node = node;
            this.num = num;
        }
    }

    static List<List<Integer>> allTraversalInSingle(Node root){
        Stack<Pair> st = new Stack<Pair>();
        st.add(new Pair(root,1));
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();
        while (!st.isEmpty()){
           Pair it = st.pop();
           if (it.num == 1){
               pre.add(it.node.data);
               it.num++;
               st.add(it);
               if (it.node.left!=null){
                   st.add(new Pair(it.node.left, 1));
               }
           }else if (it.num == 2){
               in.add(it.node.data);
               it.num++;
               st.add(it);
               if (it.node.right!=null){
                   st.add(new Pair(it.node.right, 1));
               }
           }else {
               post.add(it.node.data);
           }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        return ans;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node rootNode = buildTree(nodes);
//        System.out.println(rootNode.data);
//        preorderTraversal(rootNode);
//        System.out.println();
//        inorderTraversal(rootNode);
//        System.out.println();
//        postOrderTraversal(rootNode);
//        System.out.println();
//        levelOrderTraversal(rootNode);
//        System.out.println();
//        System.out.println(countTotalNodes(rootNode));
//        System.out.println(heightTree(rootNode));
//        System.out.println(diameter(rootNode));
//        System.out.println(diameter2(rootNode).diam);
//        System.out.println(sumOfNodesAtKLevel(rootNode, 3));
//        List<List<Integer>> ans = LevelOrderTraver(rootNode);
//        for (int i=0;i<ans.size();i++){
//            for (int j=0;j<ans.get(i).size();j++){
//                System.out.print(ans.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//        IterativePreorder(rootNode);
//        iterativeInOrderTraversal(rootNode);
//        postOrderUsing2Stacks(rootNode);
        List<List<Integer>> ans = allTraversalInSingle(rootNode);
    }
}

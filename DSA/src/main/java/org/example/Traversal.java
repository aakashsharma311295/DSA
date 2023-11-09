package org.example;

public class Traversal {

    static void traverse(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }

    }
    static void recursiveTraversal(Node head){
        if (head == null)
            return;
        System.out.print(head.getData() + " ");
        recursiveTraversal(head.getNext());
    }
    public static void main(String[] args) {
        Node head = null;
        recursiveTraversal(head);
        head = new Node(10);
        head.setNext(new Node(20));
        head.getNext().setNext(new Node(30));
        head.getNext().getNext().setNext(new Node(40));
        recursiveTraversal(head);
    }
}

package org.example;

public class CircularLinkedList {

    static Node insertAtHead2(int data, Node head){
        Node temp = new Node(data);
        if (head == null){
            temp.setNext(temp);
        }else {
            Node curr = head;
            while (curr.getNext()!=head)
                curr = curr.getNext();
            curr.setNext(temp);
            temp.setNext(head);
        }

        return temp;
    }
    static Node insertAtHead(int data, Node head){
        Node node = new Node(data);
        if (head == null){
            head = node;
            head.setNext(head);
            return head;
        }
        node.setNext(head.getNext());
        head.setNext(node);
        int t = head.getData();
        head.setData(node.getData());
        node.setData(t);
        return head;
    }
    static Node insertAtTail(Node head, int data){
        Node temp = new Node(data);
//        if (head == null){
//            temp.setNext(temp);
//            return temp;
//        }else{
//            Node curr = head;
//            while (curr.getNext()!=head)
//                curr = curr.getNext();
//            curr.setNext(temp);
//            temp.setNext(head);
//            return head;
//        }

        if (head == null){
            temp.setNext(temp);
        }else {
            temp.setNext(head.getNext());
            head.setNext(temp);
            int t = head.getData();
            head.setData(temp.getData());
            temp.setData(t);
        }
        return temp;

    }

    static Node deleteAtHead(Node head){
        if (head == null || head.getNext()==head)
            return null;
//        Node curr = head;
//        while (curr.getNext()!=head)
//            curr = curr.getNext();
//        curr.setNext(head.getNext());
//        return curr.getNext();
        int t = head.getData();
        head.setData(head.getNext().getData());
        head.getNext().setData(t);
        head.setNext(head.getNext().getNext());
        return head;
    }

    static Node deleteKNode(Node head, int k){
        if (head == null)
            return null;
        if (k == 1)
            return deleteAtHead(head);
        int count = 1;
        Node curr = head;
        while (count<=k-2){
            curr = curr.getNext();
            count++;
        }
        curr.setNext(curr.getNext().getNext());
        return head;
    }

    static void print(Node head){
        Node temp = head;
        do {
            System.out.print(temp.getData()+ " ");
            temp = temp.getNext();
        }while (temp!=head);

        System.out.println();
    }

    static void print2(Node head){
        Node temp = head.getNext();
        System.out.print(head.getData() + " ");
        while (temp!=head){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(10, head);
        print2(head);
        head = insertAtHead(20, head);
        print2(head);
        head = insertAtHead(30, head);
        print2(head);
        head = insertAtHead(40, head);
        print2(head);
        head = insertAtHead(50, head);
        print2(head);
        head = insertAtTail(head,60);
        print(head);
        head = deleteKNode(head, 1);
        print(head);
    }
}

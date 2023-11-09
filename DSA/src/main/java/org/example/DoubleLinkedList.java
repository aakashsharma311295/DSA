package org.example;

public class DoubleLinkedList {

    static int getLength(DoubleNode head){
        DoubleNode temp = head;
        int length = 0;
        while (temp!=null){
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    static void print(DoubleNode head){
        DoubleNode temp = head;
        while (temp!=null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    static DoubleNode insertAtHead(int data, DoubleNode head){
        DoubleNode node = new DoubleNode(data);
        if (head == null){
            head = node;
            return head;
        }
        node.setNext(head);
        head.setPrev(node);
        head = node;
        return head;
    }

    static DoubleNode insertAtTail(int data, DoubleNode head){
        DoubleNode node = new DoubleNode(data);
        if (head == null){
            head = node;
            return node;
        }
        DoubleNode temp = head;
        while (temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);
        return head;
    }

    static DoubleNode insertAtPosition(int data, int position, DoubleNode head){
        if (position == 1){
            return insertAtHead(data, head);
        }
        if (position == getLength(head)+1){
            return insertAtTail(data, head);
        }
        DoubleNode curr = head;
        int count = 1;
        while (count<position-1){
            curr = curr.getNext();
            count++;
        }
        DoubleNode node = new DoubleNode(data);
        node.setNext(curr.getNext());
        curr.getNext().setPrev(node);
        curr.setNext(node);
        node.setPrev(curr);
        return head;
    }

    static DoubleNode deleteNode(int position, DoubleNode head){
        int count = 1;
        DoubleNode curr = head;
        DoubleNode prev = null;
        if (position == 1){
            head = head.getNext();
            curr.setNext(null);
            return head;
        }
        while(count<position){
            prev = curr;
            curr = curr.getNext();
            count++;
        }
        prev.setNext(curr.getNext());
        curr.getNext().setPrev(prev);
        curr.setNext(null);
        curr.setPrev(null);
        return head;
    }

    static DoubleNode reverseLinkedList(DoubleNode head){
        DoubleNode prev = null;
        DoubleNode curr = head;

        while (curr!=null){
            curr.setPrev(curr.getNext());
            curr.setNext(prev);
            prev = curr;
            curr = curr.getPrev();
        }
        return prev;
    }

    public static void main(String[] args) {
        DoubleNode head = null;
        head = insertAtTail(10, head);
        print(head);
//        head = insertAtTail(20, head);
//        print(head);
//        head = insertAtTail(30, head);
//        print(head);
//        head = insertAtTail(40, head);
//        print(head);
//        head = insertAtTail(50, head);
//        print(head);
//        head = insertAtPosition(25, 3, head);
//        print(head);
//        head = deleteNode(6, head);
//        print(head);
        head = reverseLinkedList(head);
        print(head);
        System.out.println(getLength(head));
    }
}

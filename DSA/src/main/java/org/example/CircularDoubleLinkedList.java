package org.example;

public class CircularDoubleLinkedList {

    static DoubleNode insertAtHead(DoubleNode head, int data){
        DoubleNode node = new DoubleNode(data);
        if (head == null){
            node.setNext(node);
            node.setPrev(node);
            return node;
        }
        node.setNext(head);
        node.setPrev(head.getPrev());
        head.getPrev().setNext(node);
        head.setPrev(node);
        return node;
    }

    static DoubleNode insertAtTail(DoubleNode head, int data){
        DoubleNode node = new DoubleNode(data);
        if (head == null){
            node.setNext(node);
            node.setPrev(node);
            return node;
        }
        node.setNext(head);
        node.setPrev(head.getPrev());
        head.getPrev().setNext(node);
        head.setPrev(node);
        return head;
    }

    static void display(DoubleNode head){
        DoubleNode curr = head;
        do {
            System.out.print(curr.getData()+ " ");
            curr = curr.getNext();
        }while (curr!=head);
        System.out.println();
    }

    static DoubleNode sortedInsert(DoubleNode head, int data){

        if (head == null || data<head.getData()){
            return insertAtHead(head,data);
        }
        if (data>head.getPrev().getData()){
            return insertAtTail(head, data);
        }
        DoubleNode temp = head;
        do {
            if (temp.getData()<=data && temp.getNext().getData()>data)
                break;
            temp = temp.getNext();
        }while (temp!=head);
        DoubleNode node = new DoubleNode(data);
        node.setNext(temp.getNext());
        node.setPrev(temp);
        temp.setNext(node);
        node.getNext().setPrev(node);
        return head;
    }
    public static void main(String[] args) {
        DoubleNode head = null;
//        head = insertAtTail(head, 10);
//        display(head);
//        head = insertAtTail(head, 20);
//        display(head);
//        head = insertAtTail(head, 30);
//        display(head);
//        head = insertAtTail(head, 40);
//        display(head);
        head = sortedInsert(head,5);
        display(head);

    }
}

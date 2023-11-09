package org.example;

public class LinkedList {

    static Node insertAtStart(int data, Node head){
        Node tempNode = new Node(data);
        tempNode.setNext(head);
        return tempNode;
    }

    static Node insertAtEnd(int data, Node head){
        Node tempNode = new Node(data);
        if (head == null){
            head = tempNode;
            return head;
        }
        Node curr = head;
        while (curr.getNext()!=null){
            curr = curr.getNext();
        }
        curr.setNext(tempNode);
        return head;
    }

    static Node insertAtMiddle(int data, Node head, int position){

        if (position == 1){
            return insertAtStart(data, head);
        }
        Node curr = head;

        int count = 1;
        while (count< position-1){
            curr = curr.getNext();
            count++;
        }

        if (curr.getNext() == null){
            return insertAtEnd(data, head);
        }

        Node tempNode = new Node(data);
        tempNode.setNext(curr.getNext());
        curr.setNext(tempNode);
        return head;
    }

    static Node deleteNode(int position, Node head){
        Node prev = null;
        Node curr = head;

        if (position == 1){
            head = head.getNext();
            curr.setNext(null);
            return head;
        }
        int count = 1;
        while (count<position){
            prev = curr;
            curr = curr.getNext();
            count++;
        }
        prev.setNext(curr.getNext());
        curr.setNext(null);
        return head;
    }

    static Node deleteFirstNode(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        head = head.getNext();
        curr.setNext(null);
        return head;
    }

    static Node deleteLastNode(Node head){
        if (head == null || head.getNext() == null)
            return null;
        Node temp = head;
        while (temp.getNext().getNext()!= null){
            temp = temp.getNext();
        }
        temp.setNext(null);
        return head;
    }

    static void display(Node head){
        while (head!=null){
            System.out.print(head.getData()+ " ");
            head.data = head.getData()+1;
            head = head.getNext();
        }
        System.out.println();
    }

    static int search(Node head, int item){
        Node temp = head;
        int count = 1;
        while (temp!=null){
            if (temp.getData() == item){
                return count;
            }
            count++;
            temp = temp.getNext();
        }
        return -1;
    }

    static int recursiveSearch(Node head, int data, int pos){
        if (head == null)
            return -1;
        if (data == head.getData())
            return pos;
        return recursiveSearch(head.getNext(),data, pos+1);
    }

    static Node reverseLinkedList(Node head){
        if (head == null || head.getNext()==null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node foward = null;
        while (curr!=null){
            foward = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = foward;

        }
        return prev;
    }


    static void middleNode(Node head){
        if (head == null)
            return;
        Node temp = head;
        int count = 0;
        while (temp!=null){
            count++;
            temp = temp.getNext();
        }
        temp = head;
        int i = count/2;
        while (i>0){
            temp = temp.getNext();
            i--;
        }
        System.out.println(temp.getData());

    }

    static void middleNode2(Node head){
        if (head == null)
            return;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println(slow.getData());
    }

    static void NthNodeFromLast(Node head, int n){
//        if (head == null)
//            return;
//        Node temp = head;
//        int len = 0;
//        while (temp!=null){
//            len++;
//            temp = temp.getNext();
//        }
//        if (len<n)
//            return;
//        temp = head;
//        for (int i=1;i<len-n+1;i++){
//            temp = temp.getNext();
//        }
//        System.out.println(temp.getData());

        Node first = head;
        for (int i =0 ;i<n;i++){
            if (first == null)
                return;
            first = first.getNext();
        }
        Node second = head;
        while (first!=null){
            first = first.getNext();
            second = second.getNext();
        }
        System.out.println(second.getData());
    }

//    static Node recursiveReverse(Node head, Node prev, Node curr){
//
//    }

    static void recursivePrint(Node head){
        if (head == null)
            return;

        System.out.print(head.getData() + " ");
        recursivePrint(head.getNext());
    }
    static Node reverse(Node curr, Node prev){
        if(curr == null){
            return prev;
        }
        Node newHead = reverse(curr.next, curr);
        curr.next = prev;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = null;

//        head = insertAtStart(10, head);
//        display(head);
//        head = insertAtStart(20, head);
//        display(head);
//        head = insertAtStart(30, head);
//        display(head);
//        head = insertAtStart(40, head);
//        display(head);
//        System.out.println(node1.getData());
//        System.out.println(node1.getNext());

        head = insertAtEnd(10,head);
//        display(head);
        head = insertAtEnd(20,head);
//        display(head);
        head = insertAtEnd(30,head);
//        display(head);
        head = insertAtEnd(40,head);
//        display(head);
        head = insertAtEnd(50,head);
//        reverse(head, null);
        display(head);
        display(head);
//        Node sorted = sort(head);
//        recursivePrint(head);
//        Node original = head;
//        Node reverse = reverseLinkedList(head);
//        display(head);
//        middleNode2(head);
//        NthNodeFromLast(head, 2);
//        head = insertAtMiddle(50, head, 1);
//        display(head);
//        head = insertAtMiddle(60, head, 6);
//        display(head);
//        head = deleteNode(6,head);
//        display(head);
//        head = deleteFirstNode(head);
//        display(head);
//        System.out.println(search(head, 80));
//        System.out.println(recursiveSearch(head, 80, 1));
//        head = reverseLinkedList(head);
//        display(head);
//        head = recursiveReverse(head, null, head);
//        middleNode(head);
    }

    private static Node sort(Node head) {

        Node zeroHead = null;
        Node zeroTail = null;
        Node firstHead = null;
        Node firstTail = null;
        Node secondHead = null;
        Node secondTail = null;

        Node temp = head;
        while (temp != null) {
            if (temp.data == Integer.valueOf(0)) {
                zeroTail = insertAtTail(zeroTail, temp);
                if (zeroHead == null) {
                    zeroHead = zeroTail;
                }
            } else if (temp.data == Integer.valueOf(1)) {
                firstTail = insertAtTail(firstTail, temp);
                if (firstHead == null) {
                    firstHead = firstTail;
                }
            } else if (temp.data == Integer.valueOf(2)) {
                secondTail = insertAtTail(secondTail, temp);
                if (secondHead == null) {
                    secondHead = secondTail;
                }
            }
            temp = temp.next;
        }

        zeroTail.next = firstHead;
        firstTail.next = secondHead;
        secondTail.next = null;
        return zeroHead;
    }

    static Node insertAtTail(Node tail, Node insert) {
        if (tail == null) {
            return insert;
        }
        tail.next = insert;
        return insert;
    }
}


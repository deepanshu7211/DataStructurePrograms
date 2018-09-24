package com.deep.linked_list;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        System.out.println("in main");
        CLLNodeOperations cLLNodeOperations = new CLLNodeOperations();
        cLLNodeOperations.add(10);
        cLLNodeOperations.add(20);
        cLLNodeOperations.add(30);
        cLLNodeOperations.add(50);


        cLLNodeOperations.traverse();

    }
}


class CLLNodeOperations {
    CLLNode head;
    CLLNode tail;

    public CLLNode getHead() {
        return head;
    }

    public CLLNode getTail() {
        return tail;
    }


    public void add(int data) {
        CLLNode temp = new CLLNode(data);
        if (head == null) {
            head = temp;
            tail = temp;

        } else {
            tail.setNext(temp);
            tail = temp;
        }
        tail.setNext(head);
    }

    public void traverse() {
        CLLNode current = head;
        while (current != null) {
            System.out.println("data :: " + current.getData());
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
    }
}


class CLLNode {
    private int data;
    private CLLNode next;

    public CLLNode(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }


}

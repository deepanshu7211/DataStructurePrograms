package com.deep.queue;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class Queue {

    public static void main(String[] args) {
        QueueList queueList = new QueueList();
        queueList.adQueue(1);
        queueList.adQueue(2);
        queueList.adQueue(3);
        queueList.adQueue(4);
        queueList.adQueue(5);

        queueList.traverse();

        queueList.deQueue();
        queueList.deQueue();

        System.out.println("after deletion :: " + "\n");

        queueList.traverse();
    }
}


class QueueList {
    private Node head = null;
    private Node tail = null;
    private int length;

    public void adQueue(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
    }

    public void deQueue() {
        Node temp = head;
        head = temp.getNext();
        temp = null;
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println("data :: " + temp.getData());
            temp = temp.getNext();
        }
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}

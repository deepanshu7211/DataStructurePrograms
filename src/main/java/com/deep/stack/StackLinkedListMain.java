package com.deep.stack;

public class StackLinkedListMain {
	public static void main(String[] args) {
		StackLinkedList stackLinkedList = new StackLinkedList();
		stackLinkedList.push(1);
		stackLinkedList.push(2);
		stackLinkedList.push(3);
		stackLinkedList.pop();
		stackLinkedList.pop();

		stackLinkedList.traverse();

	}
}

class StackLinkedList {
	private Node top = null;

	public void push(int data) {
		Node temp = new Node(data);

		if (top == null) {
			System.out.println(" Stack is empty ");
			top = temp;
			return;
		}

		temp.setNext(top);
		top = temp;
	}

	public void pop() {
		if (top == null) {
			return;
		}

		top = top.getNext();

	}

	public void traverse() {
		Node currentNode = top;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}

class Node {
	private int data;
	private Node next;

	public Node() {

	}

	public Node(int data) {
		super();
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
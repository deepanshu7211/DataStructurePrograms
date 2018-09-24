package com.deep.linked_list;

public class LinkedListMain {
	public static void main(String[] args) {
		LinkedListOperation operation = new LinkedListOperation();
		operation.add(2);
		operation.add(3);
		operation.add(4);
		operation.add(6);
		operation.addAtBegning(1);

		operation.addAfter(5, 3);
		// operation.deletAfter(4);

		// operation.traverse(operation.getHead());
		// operation.reverse();
		// operation.traverse(operation.getHead());
		// operation.reverseUsingRecursion(operation.getHead());
		operation.nthNodeFromEnd(2);
		operation.traverseUsingRecursion(operation.getHead());
		// operation.traverseReverseOrderUsingRecursion(operation.getHead());
		System.out.println("Length :: " + operation.length(operation.getHead()));
		operation.search(4);
	}
}

class LinkedListOperation {
	private Node head = null;
	private Node tail = null;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void add(int data) {
		Node temp = new Node(data);

		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.setNext(temp);
			tail = temp;
		}

	}

	public void reverse() {
		Node currentNode = head, previous = null, next = null;
		while (currentNode != null) {
			next = currentNode.getNext();
			currentNode.setNext(previous);
			previous = currentNode;
			currentNode = next;
		}
		head = previous;
	}

	public void reverseUsingRecursion(Node currentNode) {
		if (currentNode.getNext() == null) {
			head = currentNode;
			return;
		}

		reverseUsingRecursion(currentNode.getNext());
		Node next = currentNode.getNext();
		next.setNext(currentNode);
		currentNode.setNext(null);
	}

	public void addAtBegning(int data) {
		Node temp = new Node(data);
		temp.setNext(head);
		head = temp;
	}

	public void addAfter(int data, int position) {
		Node temp = new Node(data);
		int count = 0;
		Node currentNode = head;
		while (count < position) {
			currentNode = currentNode.getNext();
			count++;
		}

		temp.setNext(currentNode.getNext());
		currentNode.setNext(temp);
	}

	public int length(Node head) {
		if (head.getNext() == null) {
			return 1;
		} else {
			return 1 + length(head.getNext());
		}
	}

	public void search(int data) {
		Node currentNode = getHead();
		while (currentNode != null) {
			if (currentNode.getData() == data) {
				System.out.println("Element Found " + data);
			}

			currentNode = currentNode.getNext();
		}
	}

	public void nthNodeFromEnd(int count) {
		Node pnthNode = null, temp;
		temp = head;
		for (int i = 1; i < count; i++) {
			temp = temp.getNext();
		}
		while (temp != null) {
			if (pnthNode == null) {
				pnthNode = head;
			} else {
				pnthNode = pnthNode.getNext();
			}
			temp = temp.getNext();
		}

		if (pnthNode != null) {
			System.out.println("pnthnode data :: " + pnthNode.getData());
		}
	}

	public void deletAfter(int position) {
		int count = 0;
		Node currentNode = head, next;

		while (count < position - 1) {
			currentNode = currentNode.getNext();
			count++;
		}
		next = currentNode.getNext();
		currentNode.setNext(next.getNext());
	}

	public void traverse(Node head) {
		if (head == null) {
			System.out.println("List ie empty ");
		} else {
			Node currentNode = head;
			while (currentNode != null) {
				System.out.println(" Data :: " + currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}
	}

	public void traverseUsingRecursion(Node currentNode) {
		if (currentNode == null) {
			return;
		} else {
			System.out.println(" Reverse Traverse Method " + currentNode.getData());
			traverseUsingRecursion(currentNode.getNext());
		}
	}

	public void traverseReverseOrderUsingRecursion(Node currentNode) {
		if (currentNode == null) {
			return;
		} else {
			traverseReverseOrderUsingRecursion(currentNode.getNext());
			System.out.println("Reverse Order :: " + currentNode.getData());
		}
	}

}

class Node {
	private int data;
	private Node next;

	public Node() {

	}

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
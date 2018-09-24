package com.deep.linked_list;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		DLLOperation dllOperation = new DLLOperation();
		dllOperation.add(5);
		dllOperation.add(10);
		dllOperation.add(15);
		dllOperation.add(20);
		dllOperation.add(25);

		dllOperation.traverse(dllOperation.getHead());
	}
}

class DLLOperation {
	private DLLNode head = null;
	private DLLNode tail = null;

	public void add(int data) {
		DLLNode temp = new DLLNode(data);
		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			temp.setPrevious(tail);
			tail.setNext(temp);
			tail = temp;
		}

	}

	public void traverse(DLLNode currentNode) {
		if (currentNode == null) {
			return;
		}

		System.out.println(currentNode.getData());
		traverse(currentNode.getNext());
	}

	public DLLNode getHead() {
		return head;
	}

	public DLLNode getTail() {
		return tail;
	}

}

class DLLNode {
	private int data;
	private DLLNode next;
	private DLLNode previous;

	public DLLNode() {

	}

	public DLLNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

}
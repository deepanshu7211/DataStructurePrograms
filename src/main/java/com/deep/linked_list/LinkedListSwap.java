package com.deep.linked_list;

/**
 * Created by deepanshu.saxena on 01/07/16.
 */
public class LinkedListSwap {

	// Java program to swap elements of linked list by changing link

	static Node head;

	// Driver program to test above functions
	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5->6->7
		 */
		LinkedListSwap list = new LinkedListSwap();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);

		System.out.println("Linked list before calling pairwiseSwap() ");
		list.printList(head);
		// Node st = list.pairWiseSwap(head);
		Node st = list.pairwiseSwapOther(head);
		System.out.println("");
		System.out.println("Linked list after calling pairwiseSwap() ");
		list.printList(st);
		System.out.println("");

	}

	/* Function to pairwise swap elements of a linked list */
	Node pairWiseSwap(Node node) {

		// If linked list is empty or there is only one node in list
		if (node == null || node.next == null) {
			return null;
		}

		// Initialize previous and current pointers
		Node prev = node;
		Node curr = node.next;

		node = curr; // Change head before proceeeding

		// Traverse the list
		while (true) {
			Node next = curr.next;
			curr.next = prev; // Change next of current as previous node

			// If next NULL or next is the last node
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			// Change next of previous to next next
			prev.next = next.next;

			// Update previous and curr
			prev = next;
			curr = prev.next;
		}
		return node;
	}

	Node pairwiseSwapOther(Node node) {

		Node current, next, prev, next2;
		current = node.next;
		prev = node;
		node = current;
		next = current.next;
		next2 = next.next;
		// System.out.println(current.data + " " + prev.data + " " + next.data +
		// " "+ next2.data + " " + node.data);

		while (current != null && next2 != null) {
			current.next = prev;
			prev.next = next2;
			// System.out.println(current.data + " " + prev.data + " " +
			// next.data + " "+ next2.data);
			// System.out.println("\n");
			current = next2;
			prev = next;
			next = next2.next;
			if (next != null && next.next != null) {
				next2 = next.next;
			} else {
				next2 = next;
				current.next = prev;
				prev.next = next2;
			}
			// System.out.println(current.data + " " + prev.data + " " +
			// next.data + " "+ next2.data);

		}

		return node;
	}

	/* Function to print nodes in a given linked list */
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println(" \n");
	}

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

}

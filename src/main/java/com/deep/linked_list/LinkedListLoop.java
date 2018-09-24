package com.deep.linked_list;

/**
 * Created by deepanshu.saxena on 04/07/16.
 */

public class LinkedListLoop {

    static Node head;

    // Driver program to test above functions
    public static void main(String[] args) {
        LinkedListLoop list = new LinkedListLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next;
        System.out.println(" " + head.next.next.next.next.next.data + "   " + head.next.next.data);
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            System.out.println(" slow " + slow.data + " fast :: " + fast.data);
            slow = slow.next;
            fast = fast.next.next;


            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        System.out.println(" Loop found ..... " + loop.data + "  current   " + curr.data);
        Node ptr1 = null, ptr2 = null;
        System.out.println(curr.data + "  " + loop.data);

        /* Set a pointer to the beging of the Linked List and
         move it one by one to find the first node which is
         part of the Linked List */
        ptr1 = curr;
        while (1 == 1) {

            /* Now start a pointer from loop_node and check if it ever
             reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != ptr1 && ptr2.next != loop) {
                ptr2 = ptr2.next;
            }
            System.out.println(" ptr2 --- " + ptr2.data);
            /* If ptr2 reahced ptr1 then there is a loop. So break the
             loop */
            if (ptr2.next == ptr1) {
                break;
            }

            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }

        /* After the end of loop ptr2 is the last node of the loop. So
         make next of ptr2 as NULL */
        ptr2.next = null;
    }

    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
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

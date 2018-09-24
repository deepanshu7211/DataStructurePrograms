package com.deep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSTMain {
	public static void main(String[] args) {
		BSTOperation bst = new BSTOperation();
		bst.insert(20);
		bst.insert(8);
		bst.insert(22);
		bst.insert(4);
		bst.insert(12);
		bst.insert(10);
		bst.insert(14);
		// bst.traverse(bst.getRoot());
		// bst.min(bst.getRoot());
		// bst.max(bst.getRoot());

		System.out.println("Height of tree :: " + bst.findHeight(bst.getRoot()));

		// Breadth First Traversal or Level Order Traversal
		// bst.levelOrderTraversal(bst.getRoot());

		// Depth First Traversal or PreOrder , InOrder , PostOrder Traversal
		// System.out.println("PreOrder Traversal");
		// bst.preOrder(bst.getRoot());

		// System.out.println("InOrder Traversal");
		// bst.inOrder(bst.getRoot());

		// System.out.println("PostOrder Traversal");
		// bst.postOrder(bst.getRoot());
	}
}

class BSTOperation {
	private TreeNode root = null;
	private Queue<TreeNode> queue = new LinkedList<>();

	public TreeNode getRoot() {
		return root;
	}

	public void levelOrderTraversal(TreeNode currentNode) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(currentNode);

		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			System.out.println("Level Order Data :: " + temp.getData());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
			if (temp.getRight() != null)
				q.add(temp.getRight());
		}

	}

	// Max of height of left subtree and Right Subtree +1 . Leaf node height -1
	public int findHeight(TreeNode currentNode) {
		if (currentNode == null) {
			return -1;
		}

		int left = findHeight(currentNode.getLeft());
		int right = findHeight(currentNode.getRight());

		return Math.max(left, right) + 1;
	}

	// Right Most Node is maximum element in BST
	public void max(TreeNode currentNode) {
		if (currentNode.getRight() == null) {
			System.out.println("max :: " + currentNode.getData());
			return;
		}

		max(currentNode.getRight());
	}

	// Left Most Node is minimum element in BST
	public void min(TreeNode currentNode) {
		if (currentNode.getLeft() == null) {
			System.out.println("Min element :: " + currentNode.getData());
			return;
		}

		min(currentNode.getLeft());
	}

	public void insert(int data) {
		TreeNode node = new TreeNode(data);
		node.setLeft(null);
		node.setRight(null);

		if (root == null) {
			root = node;
			return;
		}

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();

			if (node.getData() <= temp.getData()) {
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				} else {
					temp.setLeft(node);

					break;
				}
			}

			if (node.getData() > temp.getData()) {
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				} else {
					temp.setRight(node);

					break;
				}
			}
		}

		// System.out.println("Outside while loop... ");
		queue.removeAll(queue);
	}

	public void traverse(TreeNode currentNode) {
		Queue<TreeNode> q = new LinkedList<>();

		q.add(currentNode);

		while (!q.isEmpty()) {
			TreeNode temp = q.remove();

			System.out.println(temp.getData());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
			if (temp.getRight() != null)
				q.add(temp.getRight());

		}
	}

	// Parent Left and Right (PLR)
	public void preOrder(TreeNode currentNode) {
		if (currentNode != null) {
			System.out.println(currentNode.getData());
			preOrder(currentNode.getLeft());
			preOrder(currentNode.getRight());
		}
	}

	public void inOrder(TreeNode currentNode) {
		if (currentNode != null) {
			inOrder(currentNode.getLeft());
			System.out.println(currentNode.getData());
			inOrder(currentNode.getRight());
		}
	}

	public void postOrder(TreeNode currentNode) {
		if (currentNode != null) {
			postOrder(currentNode.getLeft());
			postOrder(currentNode.getRight());
			System.out.println(currentNode.getData());
		}
	}
}
package com.deep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeMain {
	public static void main(String[] args) {
		BTreeOperation treeOperation = new BTreeOperation();
		treeOperation.insert(5);
		treeOperation.insert(10);
		treeOperation.insert(15);
		treeOperation.insert(20);
		treeOperation.insert(25);

		treeOperation.traversal();
		treeOperation.preOrder(treeOperation.getRoot());
	}
}

class BTreeOperation {
	private TreeNode root;
	private Queue<TreeNode> queue = new LinkedList<>();

	public TreeNode getRoot() {
		return root;
	}

	public void insert(int data) {
		TreeNode node = new TreeNode(data);
		if (root == null) {
			root = node;
			return;
		}

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			} else {
				temp.setLeft(node);
				break;
			}

			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			} else {
				temp.setRight(node);
				break;
			}
		}

		queue.removeAll(queue);
	}

	public void traversal() {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			System.out.println(" Data :: " + temp.getData());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
			if (temp.getRight() != null)
				q.add(temp.getRight());
		}
	}

	public void preOrder(TreeNode currentNode) {
		if (currentNode != null) {
			System.out.println(currentNode.getData());
			preOrder(currentNode.getLeft());
			preOrder(currentNode.getRight());
		}
	}
}
package com.deep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSTRecursive {

	public static void main(String[] args) {
		TreeNode root=null;
		BSTRecursiveOperation bstRecursiveOperation = new BSTRecursiveOperation();
		root = bstRecursiveOperation.insert(root, 15);
		root = bstRecursiveOperation.insert(root, 10);
		root = bstRecursiveOperation.insert(root, 20);
		root = bstRecursiveOperation.insert(root, 8);
		root = bstRecursiveOperation.insert(root, 12);
		root = bstRecursiveOperation.insert(root, 25);
		
		bstRecursiveOperation.traverse(root);
		boolean result = bstRecursiveOperation.search(root, 12);
		System.out.println("result :: " + result);
		boolean isBST = bstRecursiveOperation.isBstOrNot(root);
		System.out.println( " is BST or not " + isBST);
		TreeNode successornode = bstRecursiveOperation.getSuccessor(root,8);
		System.out.println(" successor data " + successornode.getData());
	}
}


class BSTRecursiveOperation{
		
	public TreeNode insert(TreeNode root, int data)
	{
		if(root==null)
		{
			TreeNode temp = new TreeNode(data);
			temp.setLeft(null);
			temp.setRight(null);
			return temp;
		}
		else if (data<=root.getData()) {
			root.setLeft(insert(root.getLeft(), data));
		}
		else {
			root.setRight(insert(root.getRight(), data));
		}
		
		return root;
	}
	
	public void traverse(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode temp = q.remove();
			System.out.println(temp.getData());
			if(temp.getLeft()!=null){
				q.add(temp.getLeft());
			}
			if(temp.getRight()!=null){
				q.add(temp.getRight());
			}
		}
	}
	
	public boolean search(TreeNode root, int data) {
		if(root==null) return false;
		else if (root.getData()== data) {
			return true;
		}
		else if (data<=root.getData()) {
			return search(root.getLeft(), data);
		}
		else {
			return search(root.getRight(), data);
		}
		
	}
	
	public boolean isBstOrNot(TreeNode root) {
		return isBstUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBstUtil(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(root == null) 
			return true;
		if(root.getData() > minValue && root.getData()<maxValue &&
				isBstUtil(root.getLeft(), minValue, root.getData()) &&
				isBstUtil(root.getRight(), root.getData(), maxValue)) {
			return true;
		}
		else {
			return false;
		}
	}

	public TreeNode getSuccessor(TreeNode root,int data){
		if(root==null) return  null;
		TreeNode currentNode = findNode(root,data);

		// Case 1 Node has right subtree
		if(currentNode.getRight()!=null){
			return findMin(root.getRight());
		}
		else {
			// Case 2 Node has no right subtree
			TreeNode ancestor=root;
			TreeNode successor =null;
			while (ancestor!=currentNode){
				if(currentNode.getData()<ancestor.getData()){
					// so far this is the deepest node for which current node is left
					successor=ancestor;
					ancestor= ancestor.getLeft();
				}
				else {
					ancestor= ancestor.getRight();
				}
			}
			return successor;
		}

	}

	public TreeNode findMin(TreeNode root){
		while (root.getLeft()!=null){
			root=root.getLeft();
		}
		return root;
	}
	public TreeNode findNode(TreeNode root,int data){
		if(root==null) return null;
		if(root.getData()== data){
			return root;
		}
		else if(data < root.getData()){
			return findNode(root.getLeft(),data);
		}
		else {
			return findNode(root.getRight(),data);
		}
	}
}
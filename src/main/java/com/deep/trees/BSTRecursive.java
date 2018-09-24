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
	
}
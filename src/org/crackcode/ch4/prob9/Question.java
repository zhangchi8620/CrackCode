package org.crackcode.ch4.prob9;

import org.crackcode.library.TreeNode;

public class Question {
	public static void findSum(TreeNode node, int value, String path){
		if(node == null)
			return;
		
		value = value - node.data;
		path += Integer.toString(node.data) + "   ";

		if (value == 0){
			System.out.println(path);
		}
		
		findSum(node.left, value, path);
		findSum(node.right, value, path);

	}
	
	public static void findAll(TreeNode root, int value){
		if(root != null){
			findSum(root, value, "");
			findAll(root.left, value);
			findAll(root.right, value);
		}
	}

	public static void main(String[] args){
		int[] array = {1, 2, 5, 9, 2, -2, 1, 8, -5, 2, 1, 4, 10};
		
		TreeNode root = TreeNode.createMinimalBST(array);
		
		root.print();
		findAll(root, 6);
		
	}
}

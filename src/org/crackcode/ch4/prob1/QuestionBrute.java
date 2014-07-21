package org.crackcode.ch4.prob1;

import org.crackcode.library.TreeNode;

public class QuestionBrute {
	public static boolean isBalance(TreeNode root){
		if (root == null)
			return true;
		int heightDiff = getHeight(root.right) - getHeight(root.left);
		if (Math.abs(heightDiff) > 1)
			return false;
		else
			return isBalance(root.left) && isBalance(root.right);
	}
	
	public static int getHeight(TreeNode root){
		if(root == null)
			return 0;
		return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode.deleteAllRight(root);
		root.insertInOrder(-1); // Add 4 to make it unbalanced
		root.print();

		System.out.println("Is balanced? " + isBalance(root));
	}
}

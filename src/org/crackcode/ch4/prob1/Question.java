package org.crackcode.ch4.prob1;

import org.crackcode.library.*;

//TODO How to balance a tree?? P84, 5th edition
public class Question {
	public static boolean isBalance(TreeNode root){
		if (checkHeight(root) == -1)
			return false;
		else
			return true;
	}
	
	public static int checkHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1){
			return -1;
		}	
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1){
			return -1;
		}
		int height = rightHeight - leftHeight;
		if (Math.abs(height) > 1){
			return -1;
		}
		else{
			int value = Math.max(rightHeight, leftHeight) + 1;
			return value;
		}
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

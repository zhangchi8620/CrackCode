package org.crackcode.ch4.prob3;

import org.crackcode.library.TreeNode;

public class Question {
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root =  TreeNode.createMinimalBST(array);
		root.print();
		System.out.println("isBST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}
}

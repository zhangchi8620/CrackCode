package org.crackcode.ch4.prob5;

import org.crackcode.library.TreeNode;


public class Question {
	public static int last_printed = Integer.MIN_VALUE;
	// Method 1: in-order traversal
	public static boolean isBST2(TreeNode n) {
		if (n == null){
//			System.out.println("null");
			return true;
		}
//		System.out.println("data: " + n.data);

		// check / recurse left
		if(!isBST2(n.left)){
			return false;
		}
		
		// check current
//		System.out.println("n.data: " + n.data + " last_printed: " + last_printed);

		if(n.data < last_printed){
			return false;
		}
		last_printed = n.data;
		
		// check / recurse right
		if(!isBST2(n.right)){
			return false;
		}
		
		// All good
		return true;
	}
	
	// Method 2: min-max
	public static boolean checkBST(TreeNode n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST(TreeNode n, int min, int max){
		if (n == null)
			return true;
		if (n.data <= min || n.data > max)
			return false;
		
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
			return false;
		
		return true;
	}
	
	public static void main(String[] args){
		int[] array = {1, 9, 10, 25, 30, 20,28, 29, 31,40,50};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.print();

		// not correct?
//		System.out.println("isBST: " + node.isBST());
		
		System.out.println("isBST2: " + isBST2(node));
		System.out.println("checkBST: " + checkBST(node));

	}


}

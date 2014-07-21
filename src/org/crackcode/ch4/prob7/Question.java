package org.crackcode.ch4.prob7;

import org.crackcode.library.TreeNode;

public class Question {
	// Method 1: up-down. 
	// TODO not correct when tow nodes are parent-child
	// See solution 4.7 QuestionB.java which seems wrong too
	public static boolean covers(TreeNode root, TreeNode p){
		if (root == null)	return false;
		if (root == p)	return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	public static TreeNode commonAncesHelper(TreeNode root, TreeNode p, TreeNode q){
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		
		if(is_p_on_left != is_q_on_left)
			return root;
		
		TreeNode child_side = is_p_on_left ? root.left : root.right;
		return commonAncesHelper(child_side, p, q);
	}
	
	// Important! Error check!
	public static TreeNode commonAnces(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q)){
			System.out.println("Error!");
			return null;
		}
		else
			return commonAncesHelper(root, p, q);
	}
	
	// Method 2: Optimized
	// TODO
//	public static TreeNode commonAncesBad(TreeNode root, TreeNode p, TreeNode q){
//		if(root == null)
//			return null;
//		if(root == p && root == q)
//			return root;
//		
//		TreeNode x = commonAncesBad(root.left, p, q);
//		if (x != null && x != p && x != q)
//			return x;
//		
//		TreeNode y = commonAncesBad(root.right, p, q);
//		if (y != null && y != p && y != q)
//			return y;
//			
//	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();

		TreeNode n1 = root.find(8);
		if (n1 == null) {
			System.out.println("No such n1 node!");
		}
		TreeNode n2 = root.find(1);
		if(n2 == null)
			System.out.println("No such n2 node!");
		
		System.out.println(n1.data + " " + n2.data + " has common ancestor? " +commonAnces(root, n1, n2).data);
	}
}

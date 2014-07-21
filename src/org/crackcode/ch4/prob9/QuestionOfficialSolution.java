package org.crackcode.ch4.prob9;

import org.crackcode.library.TreeNode;

public class QuestionOfficialSolution {
	public static void findSum(TreeNode node, int sum, int[] path, int level){
		if (node == null)
			return;
		
		path[level] = node.data;
		
		int t = 0;
		for (int i = level; i >=0; i--){
			t += path[i];
			if (t == sum){
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		// ?
		path[level] = Integer.MIN_VALUE;

	}
	
	public static void findSum(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		System.out.println("depth: " + depth);
		findSum(node, sum, path, 0);
	}
	
	public static int depth(TreeNode node){
		if (node == null)
			return 0;
		else
			return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	public static void print(int[] path, int start, int end){
		for (int i = start; i <= end; i++)
			System.out.print(path[i] + "  ");
		
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 5, 9, 2, -2, 1, 8, -5, 2, 1, 4, 10};
		
		TreeNode root = TreeNode.createMinimalBST(array);
		
		root.print();
		
		findSum(root, 6);
	}
}

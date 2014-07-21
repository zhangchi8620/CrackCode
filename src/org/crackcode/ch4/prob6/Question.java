package org.crackcode.ch4.prob6;

import org.crackcode.library.TreeNode;

public class Question {
	// TODO rewrite
	public static TreeNode inorderSucc(TreeNode n){
		if(n == null)
			return null;
		
		if(n.right != null)
			return leftMostChild(n.right);
		else{
			TreeNode q = n;
			TreeNode x = q.parent;
			while(x != null && q != x.left){
				q = x;
				x = x.parent;
			}
			
			return x;
		}
	}

	public static TreeNode leftMostChild(TreeNode n){
		if (n == null){
			return null;
		}
		
		while (n.left != null)
			n = n.left;
		
		return n;
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		
		for (int i = 0; i < array.length - 1; i++){
			TreeNode n = root.find(array[i]);
			System.out.println(n.data + " -> " + inorderSucc(n).data);
		}
	}
}

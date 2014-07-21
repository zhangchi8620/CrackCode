package org.crackcode.ch4.prob8;

import org.crackcode.library.TreeNode;


public class Question {
	public static boolean containsTree(TreeNode t1, TreeNode t2){
		if (t2 == null)
			return false;
			
		return subTree(t1, t2);
	}

	public static boolean subTree(TreeNode r1, TreeNode r2){
		if (r1 == null)
			return false;
		if(r1.data == r2.data){
			if(matchTree(r1, r2))
				return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	public static boolean matchTree(TreeNode r1, TreeNode r2){
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		
		if (r1.data != r2.data)
			return false;
		
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}
	
	public static void main(String[] args){
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {8, 10, 12};
		
		TreeNode t1 = TreeNode.createMinimalBST(array1);
		TreeNode t2 = TreeNode.createMinimalBST(array2);
		
		t1.print();
		t2.print();
		
		System.out.println(containsTree(t1, t2));
	}
}

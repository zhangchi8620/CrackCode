package org.crackcode.ch4.prob4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.crackcode.library.TreeNode;

// TODO rewrite BFS by yourself

public class QuestionBFS {
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> running = new LinkedList<TreeNode>();
		if (root != null)
			running.add(root);
		
		while(running.size() > 0){
			list.add(running);
			LinkedList<TreeNode> parents = running;
			running = new LinkedList<TreeNode>();
			for (TreeNode p : parents){
				if (p.left != null)
					running.add(p.left);
				if (p.right != null)
					running.add(p.right);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode root = TreeNode.createMinimalBST(arr);
		root.print();
		ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(root);
		
		System.out.println("height: " + root.height());
		System.out.println("left height: " + root.left.height());
		
		for (int i = 0; i < root.height(); i++) {
			for (int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j).data + " ");
			}
			System.out.println();
		}
	}
	
}

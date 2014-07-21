package org.crackcode.ch4.prob4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.crackcode.library.TreeNode;

//TODO rewrite  DFS by yourself

public class QuestionDFS {
	public static void createLevelLinkedList(TreeNode root, 
			ArrayList<LinkedList<TreeNode>> lists, int level){
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if(lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else{
			list = lists.get(level);
		}
		list.add(root);
		
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode root = TreeNode.createMinimalBST(arr);
		root.print();
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		result = createLevelLinkedList(root);
		
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

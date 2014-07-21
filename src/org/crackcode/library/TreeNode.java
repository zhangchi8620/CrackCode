package org.crackcode.library;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	private int size;
	
	public TreeNode(int value){
		data = value;
		size = 1;
	}
	public int size(){
		return size;
	}
	
	public void setLeftChild(TreeNode left){
		this.left = left;
		if (left != null)
			left.parent = this;
	}
	
	public void setRightChild(TreeNode right){
		this.right = right;
		if (right != null)
			right.parent = this;
	}
	
	public static TreeNode createMinimalBST(int[] array, int start, int end){
		if(end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.setLeftChild(createMinimalBST(array, start, mid - 1));
		node.setRightChild(createMinimalBST(array, mid + 1, end));
		
		return node;
	}
	
	public static TreeNode createMinimalBST(int[] array){
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public void print(){
		BTreePrinter.printNode(this);
	}
	
	// Add by Chi
	public static void deleteAllRight(TreeNode root){
		if (root != null){
			if (root.right != null)
				deleteAllRight(root.right);
			if (root.left != null)
				deleteAllRight(root.left);
		}
		root.right = null;
	}
	
	// Add by Chi, not finished, not really correct
//	public static void deleteNode(TreeNode root, int value){
//		if (root != null){
//			System.out.println("data: " + root.data);
//			if (root.data == value){
//				System.out.println("match!!");
//				root.left = null;
//				root.right = null;
//				root = null;
//			}
//			else{
//				deleteNode(root.left, value);
//				deleteNode(root.right, value);
//			}
//		}
//	}
	
	public  TreeNode find (int value){
		if (data == value)
			return this;
		else if (value <= data){
			if (left != null)
				return left.find(value);
			else
				return null;
		}
		else if(value > data){
			if (right != null)
				return right.find(value);
			else
				return null;
		}
		return null;
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	// TODO not correct? see prob 4.5
	public boolean isBST(){
		if (left != null)
			if (this.left.data > this.data || !left.isBST())
				return false;
		if (right != null)
			if (data >= right.data || !right.isBST())
				return false;
		return true;
	}
	
	public int height() {
		int leftHeight  = (left == null) ? 0 : left.height();
		int rightHeight = (right == null) ? 0 : right.height();
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

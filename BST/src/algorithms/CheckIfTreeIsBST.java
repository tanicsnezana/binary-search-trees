package algorithms;

import BSTNode.BSTNode;

public class CheckIfTreeIsBST {
	
	private static boolean check(BSTNode<Integer> node, BSTNode<Integer> prev) {
		if(node != null) {
			
			if(!check(node.left, prev)) {
				return false;
			}
			
			if(prev != null && prev.value >= node.value) {
				return false;
			}
			
			prev = node;
			
			return check(node.right, prev);
		}
		
		return true;
	}
	
	public static boolean checkIfTreeIsBST(BSTNode<Integer> root) {
		return check(root, null);
	}
}

package algorithms;

import BSTNode.BSTNode;

/*
 * Given a BST, 
 * transform it into greater sum tree where each node 
 * contains sum of all nodes greater than that node.
 * 
 */

public class TransformBSTToGreaterSumTree {
	
	private void transform(BSTNode<Integer> root, Sum sum) {
		if(root == null) {
			return;
		}
		
		transform(root.right, sum);
		
		sum.sum += root.value;
		
		root.value = sum.sum;
		
		transform(root.left, sum);
		
		
	}
	
	public BSTNode<Integer> transformBSTToGreaterSumTree(BSTNode<Integer> root) {
		if(root == null) {
			return null;
		}
		transform(root, new Sum());
		return root;
	}
}

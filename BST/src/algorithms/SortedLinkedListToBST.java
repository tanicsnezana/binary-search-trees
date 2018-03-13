package algorithms;

import java.util.LinkedList;

import BSTNode.BSTNode;

public class SortedLinkedListToBST {
	
	private BSTNode<Integer> createBST(LinkedList<Integer> head, int n) {
		if(n <= 0) {
			return null;
		}
		
		BSTNode<Integer> left = createBST(head, n/2);
		
		BSTNode<Integer> root = new BSTNode<Integer>(head.removeFirst());
		
		root.left = left;
		
		root.right = createBST(head, n - n/2 - 1);
		
		return root;
		
	}
	
	public BSTNode<Integer> sortedLinkedListToBST(LinkedList<Integer> head) {
		return createBST(head, head.size());
	}
	
	public void preOrder(BSTNode<Integer> root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	public void inOrder(BSTNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
}

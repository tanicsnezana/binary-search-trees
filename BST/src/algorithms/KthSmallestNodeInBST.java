package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import BSTNode.BSTNode;

public class KthSmallestNodeInBST {

	public BSTNode<Integer> kthSmallestNodeInBST(BSTNode<Integer> root, int k) {
		if (root == null) {
			return null;
		}
		
		if(k <= 0) {
			return null;
		}
		
		Deque<BSTNode<Integer>> stack = new ArrayDeque<>();
		BSTNode<Integer> tmp = root;
		
		while(tmp.left != null) {
			stack.push(tmp);
			tmp = tmp.left;
		}
		
		while(!stack.isEmpty()) {
			
			if(k == 1) return stack.pop();
            
            k--;
            BSTNode<Integer> curr = stack.pop();
            
            if(curr.right != null) {
                    tmp = curr.right;
                    while(tmp != null){
                            stack.push(tmp);
                            tmp = tmp.left;
                    }
            }
		}
		
		return null;
	}
	
	
	public BSTNode<Integer> kthSmallestUsingMorrisTraversal(BSTNode<Integer> root, int k) {
		if(root == null || k <= 0) {
			return null;
		}
		
		int count = 0;
		BSTNode<Integer> curr = root, kthSmallest = null;
		
		while(curr != null) {
			
			if(curr.left == null) {
				count++;
				
				if(count == k) {
					kthSmallest = curr;
				}
				
				curr = curr.right;
			}
			else {
				BSTNode<Integer> pre = curr.left;
				
				while(pre.right != null && pre != curr) {
					pre = pre.right;
				}
				
				//Making inorder succ
				
				if(pre.right != null) {
					pre.right = curr;
					curr = curr.left;
				}
				else {
					pre.right = null;
					
					count++;
					
					if(count == k) {
						kthSmallest = curr;
					}
					
					curr = curr.right;
				}
			}
		}
		
		return kthSmallest;
	}
}

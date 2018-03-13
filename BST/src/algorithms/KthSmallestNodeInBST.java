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
}

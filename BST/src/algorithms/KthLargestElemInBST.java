package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import BSTNode.BSTNode;

public class KthLargestElemInBST {

	
	public BSTNode<Integer> kthLargestElelemntInBst(BSTNode<Integer> root, int k) {		
		if (root == null) {
			return null;
		}
		
		if(k <= 0) {
			return null;
		}
		
		Deque<BSTNode<Integer>> stack = new ArrayDeque<>();
		BSTNode<Integer> tmp = root;
		
		while(tmp != null) {
			stack.push(tmp);
			tmp = tmp.right;
		}
		
		while(!stack.isEmpty()) {
			
			if(k == 1) return stack.pop();
            
            k--;
            BSTNode<Integer> curr = stack.pop();
            
            if(curr.left != null) {
                    tmp = curr.left;
                    while(tmp != null){
                            stack.push(tmp);
                            tmp = tmp.right;
                    }
            }
		}
		
		return null;
	}

}

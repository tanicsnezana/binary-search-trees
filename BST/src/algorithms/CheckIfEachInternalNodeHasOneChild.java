package algorithms;

/*
 * Given Preorder traversal of a BST, 
 * check if each non-leaf node has only one child. 
 * Assume that the BST contains unique entries.
 */

public class CheckIfEachInternalNodeHasOneChild {

	public boolean hasOnlyOneChild(int pre[]) {
		
		for(int i = 0; i < pre.length - 1; i++) {
			int nextDiff = pre[i] - pre[i + 1];
			int lastDiff = pre[i] - pre[pre.length - 1];
			
			if(nextDiff*lastDiff < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean hasOnlyOneChild2(int pre[]) {
		int size = pre.length;
		
		int min = (pre[size - 1] < pre[size - 2]) ? pre[size - 1] : pre[size - 2];
		int max = (pre[size - 1] >= pre[size - 2]) ? pre[size - 1] : pre[size - 2];
		
		for(int i = size - 3; i >= 0; i--) {
			if(pre[i] < min) {
				min = pre[i];
			}
			else if(pre[i] > max) {
				max = pre[i];
			}
			else {
				return false;
			}
		}
		
		return true;
	}
}

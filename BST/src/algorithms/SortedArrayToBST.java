package algorithms;

import BSTNode.BSTNode;

public class SortedArrayToBST {
		
	private BSTNode<Integer> createBST(int arr[], int begin, int end) {
		if(begin > end) {
			return null;
		}
		
		int mid = (end + begin) / 2;
		BSTNode<Integer> root = new BSTNode<Integer>(arr[mid]);
		
		root.left = createBST(arr, begin, mid - 1);
		root.right = createBST(arr, mid + 1, end);
		
		return root;
	}
	
	public BSTNode<Integer> sortedArrayToBST(int arr[]) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		return createBST(arr, 0, arr.length - 1);
	}
}

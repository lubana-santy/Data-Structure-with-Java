import java.util.Scanner;
 class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

public class Solution {

    public static BinaryTreeNode<Integer> merge(int[] arr,int s,int e)
    {
        int mid = (s+e)/2;
        if(s > e)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        root.left = merge(arr, s, mid - 1);
        root.right = merge(arr, mid + 1, e);
        return root;
    }
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		return merge(arr, 0, arr.length-1);

	}
}	

public class Runner {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> ans = Solution.SortedArrayToBST(arr);
		
		preOrder(ans);
	}
	
	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}

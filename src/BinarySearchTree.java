import java.util.Stack;

public class BinarySearchTree {

	TreeNode search(TreeNode t, int nth) {
		Queue coll = new Queue();
		if (t != null) {
			TreeNode lefty = search(t.left, nth);
			System.out.print(t.data + " ");
			TreeNode righty = search(t.right, nth);
		}
		return (TreeNode) coll.get();
	}

}

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode() {
		data = 0;
		left = null;
		right = null;
	}
}
public class BST {

    public static void main(String args[]) {
        TreeNode root = null;
        BST tree = new BST();
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        tree.trimBST(root, 10, 16);
    }

    public TreeNode trimBST(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }

        // If the current node's value is less than low, trim the right subtree
        if (node.val < low) {
            return trimBST(node.right, low, high);
        }

        // If the current node's value is greater than high, trim the left subtree
        if (node.val > high) {
            return trimBST(node.left, low, high);
        }

        // If the current node's value is within the range, trim both subtrees
        node.left = trimBST(node.left, low, high);
        node.right = trimBST(node.right, low, high);

        return node;
    }


    // Utility method to insert a new node (for testing)
    public TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.val) {
            node.left = insert(node.left, value);
        } else if (value > node.val) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // In-order traversal (for testing)
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
}

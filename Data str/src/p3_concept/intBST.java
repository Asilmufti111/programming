package p3_concept;

public class intBST {

    private BSTnode root;

    // CONSTRUCTORS
    public intBST() {
        root = null;
    }

    /* Below are MANY methods that are used on Binary Search Trees.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, minVal, maxVal, inorder, sumNodes, and many more
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return root == null;
    }

    public BSTnode getRoot() {
        return root;
    }

    public boolean equalTree() {
        return equalTree(root);
    }

    public boolean equalTree(BSTnode p) {
        if (p == null) {
            return true;
        }

        int left = numNodes(p.getLeft());
        int right = numNodes(p.getRight());

        return (left == right);

    }

    public int numNodes(BSTnode p) {
        if (p == null) {
            return 0;
        }
        return numNodes(p.getRight()) + numNodes(p.getLeft()) + 1;
    }

    public void insert(int data) {
        BSTnode newNode = new BSTnode(data);
        root = insert(root, newNode);
    }
    //
    // BSTnode | insert(BSTnode, BSTnode)
    //

    private BSTnode insert(BSTnode p, BSTnode newNode) {
        // IF there is no tree, newNode will be the root, so just return it
        if (p == null) {
            return newNode;
        } // ELSE, we have a tree. Insert to the right or the left
        else {
            // Insert to the RIGHT of root
            if (newNode.getData() > p.getData()) {
                // Recursively insert into the right subtree
                // The result of insertion is an updated root of the right subtree
                BSTnode temp = insert(p.getRight(), newNode);
                // Save this newly updated root of right subtree into p.right
                p.setRight(temp);
            } // Insert to the LEFT of root
            else {
                // Recursively insert into the left subtree
                // The result of insertion is an updated root of the left subtree
                BSTnode temp = insert(p.getLeft(), newNode);
                // Save this newly updated root of left subtree into p.left
                p.setLeft(temp);
            }
        }
        // Return root of updated tree
        return p;
    }

    public void preorder() {
        preorder(root);
    }
    //
    // void | inorder(BSTnode)
    //

    private void preorder(BSTnode p) {
        if (p != null) {
            System.out.print(p.getData() + ", ");
            preorder(p.getLeft());

            preorder(p.getRight());
        }
    }
}

package Trees;

public class BinaryTree {
    TreeNode root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(int rootValue){
        this.root = new TreeNode(rootValue);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // Various tree operations would go here
    public void insert(int value) {
        // Implementation for inserting a new node
    }

    public boolean search(int value) {
        // Implementation for searching a value
        return false;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.println(node.getVal());
            inOrderTraversal(node.getRight());
        }
    }




}

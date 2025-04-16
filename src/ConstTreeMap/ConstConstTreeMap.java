package ConstTreeMap;

/**
 * This data structure maps keys ('IntConst' objects) to values ('IntConst' objects).
 * It is implemented as a binary search tree where keys are ordered according to the order
 * relation of the 'IntConst' class defined by its 'lessThan' and 'isEqual' method.
 * For the keys k1 and k2 of any two mappings in this map the following condition holds:
 * k1.isEqual(k2) == false.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: Complete the methods in 'ConstConstTreeMap'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'ConstConstTreeMap' or any other class.
//
public class ConstConstTreeMap {

    private TreeNode root;

    //TODO: additional variables, constructors and methods must be private.

    /**
     * Initializes 'this' as an empty map.
     */
    public ConstConstTreeMap() {
        this.root = null;
        //TODO: implement constructor.
    }

    /**
     * Initializes this map as a copy of the specified 'map'. This map has the same key-value
     * mappings as 'map'. If 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public ConstConstTreeMap(ConstConstTreeMap map) {
        if (map.root == null) {
            this.root = null;
        } else {
            addElements(root, map.root);
        }
        //TODO: implement constructor.
    }

    private void addElements(TreeNode node, TreeNode otherRoot) {
        if (node == null) {
            return;
        }
        addElements(node.getLeft(), otherRoot.getLeft());
        node.put(otherRoot.getKey(), node.getValue());
        addElements(node.getRight(), otherRoot.getRight());
    }

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     *
     * @param key a variable != null.
     * @param value the constant to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public IntConst put(IntConst key, IntConst value) {

        if (root == null) {
            root = new TreeNode(key, value);
            return null;
        }

        return root.put(key, value);
    }


    /**
     * Returns the value associated with the specified key. Returns 'null' if the key is not
     * contained in this map.
     *
     * @param key a constant != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public IntConst get(IntConst key) {

        //TODO: implement method.
        return root.get(key);
    }

    /**
     * Adds all keys of this map to the specified queue in the key order of this tree
     * (the smallest key is added first to the queue).
     * This method exploits the structure of the binary search tree and traverses only
     * relevant parts of the tree.
     */
    public void addAllKeysTo(IntConstQueue queue) {
            recAddAllKeysTo(root, queue);
        //TODO: implement method.
    }

    private void recAddAllKeysTo(TreeNode node, IntConstQueue q) {
        if (node == null) {
            return;
        }
        recAddAllKeysTo(node.getLeft(), q);
        q.add(node.getKey());
        recAddAllKeysTo(node.getRight(), q);
    };
}

class TreeNode {
    private IntConst key, value;
    private TreeNode left, right;

    public TreeNode (IntConst key, IntConst value) {
        this.key = key;
        this.value = value;
    }

    public IntConst put(IntConst key, IntConst value) {
        if (this.key.isEqual(key)) {
            IntConst oldvalue = this.value;
            this.value = value;
            return oldvalue;
        }

        if (key.lessThan(this.key)) {
            if (left == null) {
                left = new TreeNode(key, value);
            } else {
                left.put(key, value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(key, value);
            } else {
                right.put(key, value);
            }
        }
        return null;
    }

    public IntConst get(IntConst key) {
        if (this.key.isEqual(key)) {
            return value;
        }
        if (key.lessThan(this.key)) {
            if (left != null) {
                return left.get(key);
            } else {
                return null;
            }
        } else {
            if (right != null) {
                return right.get(key);
            } else {
                return null;
            }
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public IntConst getKey() {
        return key;
    }

    public void setKey(IntConst key) {
        this.key = key;
    }

    public void setValue(IntConst value) {
        this.value = value;
    }

    public IntConst getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }
}

// TODO: define further classes, if needed (either here or in a separate file).

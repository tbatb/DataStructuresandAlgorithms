package TreeSetRational;

/**
 * A set of rational numbers implemented as a binary search tree. There are no
 * duplicate entries in this set (no two elements e1 and e2 for which e1.compareTo(e2) == 0). The
 * elements are sorted according to their value (the ordering is given by the method 'compareTo'
 * of class 'Rational').
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//   if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class TreeSetRational {

    // TODO: define missing parts of the class.

    private class TreeNode {
        private TreeNode left = null;
        private TreeNode right = null;
        private Rational value;

        public TreeNode(Rational value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public Rational getValue() {
            return value;
        }
    }

    private TreeNode root;

    /**
     * Initialises 'this' as an empty set.
     */
    public TreeSetRational() {
        root = null;
        // TODO: implement constructor.
    }

    /**
     * Adds the specified rational number to the set.
     * Returns 'true' if the set did not already contain the specified element
     * and 'false' otherwise.
     *
     * @param r the rational number to add to this set, r != null.
     */
    public boolean add(Rational r) {
        if (r == null)
            return false;

        if (root == null) {
            root = new TreeNode(r);
            return true;
        }

        TreeNode current = root;
        while (current != null) {
            int compare = r.compareTo(current.getValue());
            if (compare == 1) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode(r));
                    return true;
                }
                current = current.getRight();
            } else if (compare == -1) {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(r));
                    return true;
                }
                current = current.getLeft();
            } else // value is equal
                return false;
        }
        return false;
    }


    /**
     * Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
     * 'this' and 'other' are not changed by this method.
     * @param other the second operand != null.
     */
    public TreeSetRational union(TreeSetRational other) {
        if (other == null)
            return null;

        TreeSetRational result = new TreeSetRational();
        unionRec(root, result);
        unionRec(other.root, result);
        return result;
    }

    private void unionRec(TreeNode current, TreeSetRational result) {
        if (current == null)
            return;

        result.add(current.getValue());
        unionRec(current.getLeft(), result);
        unionRec(current.getRight(), result);
    }


    /**
     * Returns the number of rational numbers in the set that are within the range defined by
     * the lowest and highest rational number (inclusive). The method exploits the structure of
     * the binary search tree and traverses only relevant parts of the tree.
     * @param highest the upper bound of the range.
     * @param lowest the lower bound of the range.
     * The following preconditions hold for 'highest' and 'lowest':
     *        lowest != null && highest != null && lowest.compareTo(highest) <= 0.
     * @return number of rational numbers in the set that are within the specified range.
     */
    public int countWithinRange(Rational lowest, Rational highest) {

        // TODO: implement method.
        return countWithinRangeRec(root, lowest, highest);
    }

    private int countWithinRangeRec(TreeNode current, Rational lowest, Rational highest) {
        if (current == null)
            return 0;

        boolean inRange = (current.getValue().compareTo(lowest) == 1 &&
              current.getValue().compareTo(highest) == -1) ||
              current.getValue().compareTo(lowest) == 0 ||
              current.getValue().compareTo(highest) == 0;

        int subTreeCount = inRange ? 1 : 0;
        if (current.getLeft() != null)
            subTreeCount += countWithinRangeRec(current.getLeft(), lowest, highest);
        if (current.getRight() != null)
            subTreeCount += countWithinRangeRec(current.getRight(), lowest, highest);
        return subTreeCount;
    }

    /**
     * Removes the lowest rational number from this set. Returns the rational number that was
     * removed from this set or 'null' if this set is empty.
     * (The corresponding node is removed by replacing it with the subtree of the node that
     * contains entries greater than the minimum.)
     * @return the lowest rational number from this set or 'null' if this set is empty.
     */
    public Rational removeMinimum() {
        if (root == null)
            return null;

        TreeNode min = root;
        TreeNode oneBefore = null;

        while (min.getLeft() != null) {
            oneBefore = min;
            min = min.getLeft();
        }

        if (min == root) {
            root = min.getRight();
        } else {
            oneBefore.setLeft(min.getRight());
        }

        return min.getValue();
    }


    /**
     * Returns a string representation of 'this' with all rational objects
     * ordered ascending. The format of the string uses
     * brackets and is as in the following example with a set of four elements:
     * "[-3/4, -2/3, -1/3, 1/2]"
     * Returns "[]" if this set is empty.
     * @return the string representation of 'this'.
     */
    public String toString() {
        return "[" + toStringRec(root) + "]";
    }

    private String toStringRec(TreeNode current) {
        if (current == null)
            return "";

        String left = toStringRec(current.getLeft());
        String right = toStringRec(current.getRight());
        String result = current.getValue().toString();
        if (!left.isEmpty())
            result = left + ", " + result;
        if (!right.isEmpty())
            result = result + ", " + right;
        return result;
    }

}

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pparth on 4/5/16.
 */
public class BinaryTree {
    private Node root;
    private int hLevel;
    private int vLevel;

    int getMinimumumDepth() {
        return getMinimumumDepth(root);
    }

    /**
     * Get minimum depth for the tree
     * @param root
     * @return
     */
    int getMinimumumDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null) {
            return 1 + getMinimumumDepth(root.getRight());
        }
        if (root.getRight() == null) {
            return 1 + getMinimumumDepth(root.getLeft());
        }
        return Math.min(getMinimumumDepth(root.getLeft()), getMinimumumDepth(root.getRight())) + 1;
    }

    void printPreOrderIterate() {
        printPreOrderIterate(root);
    }
    /**
     * print preorder without recursion
     * @param root
     */
    void printPreOrderIterate(Node root) {
        Stack preOrder = new Stack();
        preOrder.push(root);
        while (!preOrder.isEmpty()) {
            Node current = (Node) preOrder.pop();
            System.out.print(current.getValue() + " ");
            if (current.getRight() != null) {
                preOrder.push(current.getRight());
            }
            if (current.getLeft() != null){
                preOrder.push(current.getLeft());
            }
        }
    }

    void printInOrderIterate() {
        printInOrderIterate(root);
    }
    /**
     * Print inorder withour recursion
     * @param root
     */
    void printInOrderIterate(Node root) {
        Stack inOrder = new Stack();
        Node current = root;
        while (current != null) {
            inOrder.push(current);
            current = current.getLeft();
        }
        while (!inOrder.isEmpty()) {
            current = (Node) inOrder.pop();
            System.out.print(current.getValue() + " ");
            if (current.getRight() != null) {
                inOrder.push(current.getRight());
            }
        }
    }

    void postOrderIterate() {
        postOrderIterate(root);
    }
    /**
     * Print postOrder without recursion
     * @param root
     */
    void postOrderIterate(Node root) {
        Stack postOrder = new Stack();
        Node current = root;
        do {
            while (current != null) {
                if (current.getRight() != null) {
                    postOrder.push(current.getRight());
                }
                postOrder.push(current);
                current = current.getLeft();
            }
            current = (Node) postOrder.pop();
            if (!postOrder.isEmpty() && current.getRight() != null && current.getRight().equals(postOrder.peek())) {
                postOrder.pop();
                postOrder.push(current);
                current = current.getRight();
            }
            else {
                System.out.print(current.getValue() + " ");
                current = null;
            }
        } while (!postOrder.isEmpty());
    }

    Integer lowestCommonAncestor(int first, int second) {
        return lowestCommonAncestor(root, first, second);
    }
    /**
     *Returns the lowest common ancestor for the given 2 nodes.
     * @param root
     * @return
     */
    Integer lowestCommonAncestor(Node root, int first, int second) {
        if (root == null)
            return null;
        if (root.getValue() == first || root.getValue() == second) {
            return root.getValue();
        }
        Integer left = lowestCommonAncestor(root.getLeft(), first, second);
        Integer right = lowestCommonAncestor(root.getRight(), first, second);
        if (left != null && right != null)
            return root.getValue();
        return (left != null) ? left : right;
    }

    int extremeNodes() {
        return extremeNodes(root, 0);
    }

    /**
     * Return leftmostNode and rightmostNode of a tree
     * @param root
     * @return
     */
    int extremeNodes(Node root, int horPos) {
        return 0;
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.setLeft(new Node(2));
        tree.root.setRight(new Node(3));
        tree.root.getLeft().setLeft(new Node(4));
        tree.root.getLeft().setRight(new Node(5));
        //System.out.println(tree.getMinimunDepthLevel());
        //tree.printPreOrderIterate();
        //tree.printInOrderIterate();
        //tree.postOrderIterate();
        //System.out.print(tree.lowestCommonAncestor(4, 5));
        System.out.print(tree.extremeNodes());
    }
}

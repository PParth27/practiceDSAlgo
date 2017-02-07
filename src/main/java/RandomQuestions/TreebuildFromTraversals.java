package RandomQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pparth on 9/28/16.
 */
public class TreebuildFromTraversals {

    public static Node root;
    public static int[] post;
    public static int[] inOrder;
    public static int postPoint;
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public static void printPreOrder(Node root1) {
        if(root1 != null) {
            System.out.print(root1.val + " ");
            printPreOrder(root1.left);
            printPreOrder(root1.right);
        }
    }

    public static Node buildTree(int[] inCurr) throws Exception {
        if (inCurr.length <= 0)
            return null;
        Node curr = new Node(post[postPoint], null, null);
        postPoint--;
        int index = -1;
        for(int i=0;i<inCurr.length;i++) {
            if(inCurr[i] == curr.val) {
                index = i;
                break;
            }
        }
        if(index == -1)
            throw  new Exception("Fuck this awesomeness!");

        curr.right = buildTree(Arrays.copyOfRange(inCurr, index+1, inCurr.length));
        curr.left = buildTree(Arrays.copyOfRange(inCurr, 0, index));
        return curr;
    }

    public static void main(String[] ads) throws Exception {
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        while (t>0) {
            int n = in.nextInt();
            post = new int[n];
            inOrder = new int[n];
            for (int i = 0; i < n; i++) {
                inOrder[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                post[i] = in.nextInt();
            }
            postPoint = n - 1;
            root = buildTree(inOrder);
            printPreOrder(root);
            t--;
        }
    }
}

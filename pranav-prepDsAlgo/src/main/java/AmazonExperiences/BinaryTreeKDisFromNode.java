package AmazonExperiences;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 3/3/17.
 */
public class BinaryTreeKDisFromNode {
    public static class Tree {
        int val;
        Tree left;
        Tree right;
        public Tree(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public static List<Tree> path;
    public static List<Integer> leftIsZero;
    public static Tree root;
    public static Tree node;
    public static int k;

    public static void findDis(Tree curr, int left) {
        if(curr==null)
            return;
        if(left<0)
            return;
        if(left == 0) {
            System.out.print(curr.val + " ");
            return;
        }
        if(curr.left!=null)
            findDis(curr.left, left-1);
        if(curr.right!=null)
            findDis(curr.right, left-1);
    }

    public static boolean setAncestors(Tree curr) {
        if(curr == null)
            return false;
        if(curr.val == node.val)
            return true;
        if(setAncestors(curr.left)) {
            path.add(curr);
            leftIsZero.add(1);
            return true;
        }
        if(setAncestors(curr.right)) {
            path.add(curr);
            leftIsZero.add(0);
            return true;
        }
        return false;
    }

    public static void main(String[] uj) {
        root = new Tree(5);
        root.left = new Tree(4);
        root.right = new Tree(3);
        root.left.left = new Tree(22);
        root.left.right = new Tree(21);
        root.right.right = new Tree(1);
        root.left.left.left = new Tree(32);
        root.left.left.left.right = new Tree(221);
        root.left.left.left.left = new Tree(0);
        Scanner in = new Scanner(System.in);
        node = root.left.left.left.right;
        k = in.nextInt();
        path = new ArrayList<Tree>();
        leftIsZero = new ArrayList<Integer>();
        setAncestors(root);
        findDis(node, k);
        for(int i=0;i<path.size();i++) {
            int kk = k;
            Tree parent = path.get(i);
            kk-=i+1;
            if(kk==0)
                System.out.print(parent.val + " ");
            else {
                if(leftIsZero.get(i) == 0) {
                    parent = parent.left;
                    kk-=1;
                } else {
                    parent = parent.right;
                    kk-=1;
                }
                findDis(parent,kk);
            }
        }
    }

}

package ncr;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final long modu = 1000000007;
    long prod = 1;
    public int getResult() {
        //implement this
        return (int)(prod % modu);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED)) {
            int mul = node.getValue();
            prod = (prod * mul) % modu;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) {
            int mul = leaf.getValue();
            prod = (prod * mul) % modu;
        }
    }
}

class FancyVisitor extends TreeVis {
    long sumNonLeafEven = 0;
    long sumGreenLeaf = 0;
    public int getResult() {
        return (int)Math.abs(sumNonLeafEven - sumGreenLeaf);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0) {
            sumNonLeafEven+=node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.GREEN)) {
            sumGreenLeaf+=leaf.getValue();
        }
    }
}

public class TreeVisitor {

    public static class MyTree {

        public int value;
        public Color color;
        public int depth;
        public int index;
        public List<MyTree> children = new ArrayList<>();

        public MyTree(int value, Color color, int depth, int index) {
            this.value = value;
            this.color = color;
            this.depth = depth;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public Color getColor() {
            return color;
        }

        public int getDepth() {
            return depth;
        }

        public void addChild(MyTree myTree) {
            this.children.add(myTree);
        }
    }


    public static boolean[] isLeaf;

    public static void dfsPreProcess(MyTree node) {
        if (node == null)
            return;
        for(MyTree child : node.children) {
            child.children.remove(node);
            dfsPreProcess(child);
        }
    }

    public static void dfs(MyTree node, int depth) {
        if (node == null)
            return;
        else {
            node.depth = depth;
            if(node.children.size() == 0) {
                isLeaf[node.index] = true;
            } else {
                for(MyTree child : node.children) {
                    dfs(child, depth+1);
                }
            }
        }
    }

    public static Tree dfsCreate(MyTree node) {
        Tree val;
        if(isLeaf[node.index]) {
            val = new TreeLeaf(node.getValue(), node.getColor(), node.getDepth());
        } else {
            TreeNode curr = new TreeNode(node.getValue(), node.getColor(), node.getDepth());
            for (MyTree child : node.children) {
                curr.addChild(dfsCreate(child));
            }
            val=curr;
        }
        return val;
    }

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vals = new int[n+1];
        int[] color = new int[n+1];
        for(int i=1;i<=n;i++) {
            vals[i] = in.nextInt();
        }
        for(int i=1;i<=n;i++) {
            color[i] = in.nextInt();
        }
        isLeaf = new boolean[n+1];
        MyTree root = null;
        MyTree[] allTrees = new MyTree[n+1];
        for(int i = 0;i<n-1;i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            MyTree firstNode, secondNode;
            if(allTrees[first] == null) {
                firstNode = new MyTree(vals[first], (color[first] == 0) ? Color.RED : Color.GREEN, 0, first);
            } else {
                firstNode = allTrees[first];
            }
            if(allTrees[second] == null) {
                secondNode = new MyTree(vals[second], (color[second] == 0) ? Color.RED : Color.GREEN, 0, second);
            } else {
                secondNode = allTrees[second];
            }
            if(first == 1) {
                root = firstNode;
            } else if(second == 1) {
                root = secondNode;
            }
            firstNode.addChild(secondNode);
            secondNode.addChild(firstNode);
            allTrees[first] = firstNode;
            allTrees[second] = secondNode;
        }

        dfsPreProcess(root);

        dfs(root, 0);

        Tree finalRoot = dfsCreate(root);


        return finalRoot;
    }
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
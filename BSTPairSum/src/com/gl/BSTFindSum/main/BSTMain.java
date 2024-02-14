package com.gl.BSTFindSum.main;

import com.gl.BSTFindSum.system.BSTNode;
import java.util.Stack;

public class BSTMain {
    public static void main(String[] args) {
        // Construct the tree
        BSTNode root = new BSTNode(40);
        root.setLeft(new BSTNode(20));
        root.setRight(new BSTNode(60));
        root.getLeft().setLeft(new BSTNode(10));
        root.getLeft().setRight(new BSTNode(30));
        root.getRight().setLeft(new BSTNode(50));
        root.getRight().setRight(new BSTNode(70));

        // Find the pair
        int sumToFind = 130;
        int[] pair = findPairWithSum(root, sumToFind);
        if (pair != null)
            System.out.println("Pair found: (" + pair[0] + ", " + pair[1] + ")");
        else
            System.out.println("Nodes are not found.");
    }

    public static int[] findPairWithSum(BSTNode root, int target) {
        Stack<BSTNode> stackLeft = new Stack<>();
        Stack<BSTNode> stackRight = new Stack<>();
        BSTNode currLeft = root;
        BSTNode currRight = root;

        while (true) {
            while (currLeft != null) {
                stackLeft.push(currLeft);
                currLeft = currLeft.getLeft();
            }
            while (currRight != null) {
                stackRight.push(currRight);
                currRight = currRight.getRight();
            }

            if (stackLeft.isEmpty() || stackRight.isEmpty())
                break;

            BSTNode left = stackLeft.peek();
            BSTNode right = stackRight.peek();

            if (left == right)
                break;

            if (left.getVal() + right.getVal() == target)
                return new int[]{left.getVal(), right.getVal()};
            else if (left.getVal() + right.getVal() < target) {
                currLeft = stackLeft.pop().getRight();
            } else {
                currRight = stackRight.pop().getLeft();
            }
        }

        return null;
    }
}
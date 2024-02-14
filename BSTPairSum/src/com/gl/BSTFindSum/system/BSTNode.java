package com.gl.BSTFindSum.system;

public class BSTNode {
    private int val;
    private BSTNode left, right;

    public BSTNode(int value) {
        val = value;
        left = right = null;
    }

    public int getVal() {
        return val;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}

package com.itcr.datos.railspot.dataStructures;

/**
 * Node for the NodeAVLTree
 * @param <T>
 */
public class NodeAVL<T> {
    private T data;
    private int key, height;
    private NodeAVL<T> left;
    private NodeAVL<T> right;

    /**
     * Constructor for the class
     * @param data
     * @param d
     */
    NodeAVL(T data, int d)
    {
        this.data = data;
        key = d;
        height = 1;
    }

    /**
     * Getter for the T data
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for the T data
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter for the key integer
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * Setter for the key integer
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Getter for the height integer
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for the height integer
     * @return
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter for the Left NodeAVL
     * @return
     */
    public NodeAVL<T> getLeft() {
        return left;
    }

    /**
     * Setter for the Left NodeAVL
     * @return
     */
    public void setLeft(NodeAVL<T> left) {
        this.left = left;
    }

    /**
     * Getter for the Right NodeAVL
     * @return
     */
    public NodeAVL<T> getRight() {
        return right;
    }

    /**
     * Setter for the Right NodeAVL
     * @return
     */
    public void setRight(NodeAVL<T> right) {
        this.right = right;
    }
}
